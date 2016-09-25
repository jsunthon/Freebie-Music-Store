package springmusic.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import springmusic.model.Comment;
import springmusic.model.Track;
import springmusic.model.UploadTrack;
import springmusic.model.User;
import springmusic.model.dao.CommentDao;
import springmusic.model.dao.TrackDao;
import springmusic.model.dao.UploadTrackDao;
import springmusic.model.dao.UserDao;

@Controller
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TrackDao trackDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private UploadTrackDao uploadTrackDao;

    @Autowired
    private ServletContext servletContext;

    @RequestMapping(value = "/commentAdd.html", method = RequestMethod.POST)
    public String addComment(@RequestParam int trackid,
            @RequestParam String reviewTitle, @RequestParam String reviewBody,
            @RequestParam Integer rating, HttpSession session) {

        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null)
            return "redirect:login.html";

        Track track = trackDao.getTrack(trackid);
        User user = userDao.getUser(sessionUser.getId());
        Comment comment = new Comment(reviewTitle, reviewBody, rating, user,
                track);
        commentDao.save(comment);

        return "redirect:SongPage.html?trackid=" + trackid;
    }

    @RequestMapping(value = "playlistAdd.html")
    public String addPlaylist(@RequestParam String trackid,
            HttpSession session) {

        User sessionUser = (User) session.getAttribute("sessionUser");
        Track track = trackDao.getTrack(Integer.parseInt(trackid));
        User user = userDao.getUser(sessionUser.getId());

        if (sessionUser != null) {
            user.addPlaylistTrack(track);
            track.addPlaylistUser(user);
            userDao.save(user);
            trackDao.save(track);
        }

        return "redirect:home.html";
    }

    @RequestMapping(value = "/adminViewUsers.html")
    public String adminViewUser(ModelMap models) {
        models.put("allUsers", userDao.getUsers());
        return "AdminViewUsers";
    }

    @RequestMapping("/comments.html")
    public String comments(HttpSession session, ModelMap models) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null)
            return "redirect:login.html";

        models.put("comments", commentDao.getComments(sessionUser));
        return "Comments";
    }

    @RequestMapping("/commentRemove.html")
    public String removeComment(HttpSession session, @RequestParam Integer id) {

        Comment comment = commentDao.getComment(id);
        commentDao.delete(comment);
        return "redirect:comments.html";
    }

    @RequestMapping("/playlistRemove.html")
    public String removePlaylistTrack(HttpSession session,
            @RequestParam Integer tid, @RequestParam Integer uid) {

        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null)
            return "redirect:login.html";

        Track track = trackDao.getTrack(tid);
        User user = userDao.getUser(uid);

        track.removePlaylistUser(user);
        user.addDownloadTrack(track);

        trackDao.save(track);
        user = userDao.save(user);

        return "redirect:playlist.html";
    }

    @RequestMapping("/downloads.html")
    public String viewDownloads(HttpSession session, ModelMap models) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null)
            return "redirect:login.html";

        models.put("modelUser", userDao.getUser(sessionUser.getId()));
        return "Downloads";
    }

    @RequestMapping(value = "/editProfile.html", method = RequestMethod.POST)
    public String edit(HttpSession session, @ModelAttribute User user,
            SessionStatus status) {

        User u = userDao.save(user);
        session.setAttribute("sessionUser", u);
        status.setComplete();
        return "redirect:userPage.html";
    }

    @RequestMapping(value = "/editProfile.html", method = RequestMethod.GET)
    public String edit(ModelMap models, HttpSession session) {
        User user = (User) session.getAttribute("sessionUser");
        if (user == null)
            return "redirect:login.html";

        models.put("user", userDao.getUser(user.getId()));
        return "LoginProfile";
    }

    @RequestMapping("/playlist.html")
    public String playlist(HttpSession session, ModelMap models) {
        User user = (User) session.getAttribute("sessionUser");
        if (user == null)
            return "redirect:login.html";

        models.put("modelUser", userDao.getUser(user.getId()));
        return "Playlist";
    }
    
    @RequestMapping("userPage.html")
    public String userPage(HttpSession session) {
        User user = (User) session.getAttribute("sessionUser");
        if (user == null)
            return "redirect:login.html";
        else
            return "UserPage";
    }

    @RequestMapping(value = "removeDownloadTrack.html")
    public String removeDownload(@RequestParam int id, HttpSession session) {

        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null)
            return "redirect:login.html";

        Track track = trackDao.getTrack(id);
        User user = userDao.getUser(sessionUser.getId());

        user.removeDownloadTrack(track);
        track.removeDownloadUser(user);

        userDao.save(user);
        trackDao.save(track);

        return "redirect:downloads.html";
    }

    @RequestMapping(value = "upload.html", method = RequestMethod.POST)
    public String upload(@RequestParam MultipartFile file, HttpSession session)
            throws IllegalStateException, IOException {

        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null)
            return "redirect:login.html";

        // save this file under /WEB-INF
        file.transferTo(
                new File(getFileDirectory(), file.getOriginalFilename()));

        // add track to user's list
        User user = userDao.getUser(sessionUser.getId());
        UploadTrack uploadTrack = new UploadTrack(user,
                file.getOriginalFilename());
        uploadTrackDao.save(uploadTrack);

        System.out.println(getFileDirectory() + file.getOriginalFilename());

        return "redirect:userPage.html";
    }

    private File getFileDirectory() {
        String path = servletContext.getRealPath("/WEB-INF/files");
        return new File(path);
    }

    @RequestMapping(value = "/download.html")
    public String download(@RequestParam int trackid,
            HttpServletResponse response, HttpSession session)
                    throws IOException {

        // ensure that there is a session user
        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null)
            return "redirect:login.html";

        // increment track count
        Track track = trackDao.getTrack(trackid);
        track.incrementCount();

        // add track to user download history
        // add user to track download history
        User user = userDao.getUser(sessionUser.getId());
        user.addDownloadTrack(track);
        track.addDownloadUser(user);

        // save updates (also, maintain many to many relationship)
        userDao.save(user);
        trackDao.save(track);

        // if you want to use a relative path to context root:
        String relativePath = servletContext.getRealPath("/WEB-INF/shake.mp3");
        File downloadFile = new File(relativePath);
        FileInputStream inStream = new FileInputStream(downloadFile);

        // gets MIME type of the file
        String mimeType = servletContext.getMimeType(relativePath);
        if (mimeType == null) {
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }

        // modifies response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());

        // forces download
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);

        // obtains response's output stream
        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead = -1;

        while ((bytesRead = inStream.read(buffer)) != -1)
            outStream.write(buffer, 0, bytesRead);

        inStream.close();
        outStream.close();

        response.setContentType("application/octet-stream");

        return null;
    }

    @RequestMapping(value = "/userUploads.html")
    public String viewUploads(ModelMap models, HttpSession session){
        
        User sessionUser = (User) session.getAttribute("sessionUser");
        if(sessionUser == null)
            return "redirect:login.html";
        
        User user = userDao.getUser(sessionUser.getId());
        models.put("user", user);
        
        return "UserUploads";
    }
    
    @RequestMapping(value ="removeUpload.html")
    public String removeUpload(@RequestParam int uploadID, HttpSession session) {
        
        User sessionUser = (User) session.getAttribute("sessionUser");
        if(sessionUser == null)
            return "redirect:login.html";
        
        UploadTrack uploadTrack = uploadTrackDao.getUploadTrack(uploadID);
        User user = userDao.getUser(sessionUser.getId());
        
        // remove uploads from user's field AND from database
        user.removeUploadTrack(uploadTrack);
        uploadTrackDao.remove(uploadTrack);
        userDao.save(user);
        
        return "redirect:userUploads.html";
    }
}
