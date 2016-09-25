package springmusic.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.ServletContextAware;

import springmusic.model.Genre;
import springmusic.model.State;
import springmusic.model.UploadTrack;
import springmusic.model.User;
import springmusic.model.dao.AlbumDao;
import springmusic.model.dao.ArtistDao;
import springmusic.model.dao.TrackDao;
import springmusic.model.dao.UploadTrackDao;
import springmusic.model.dao.UserDao;
import springmusic.web.validator.UserValidator;

@Controller
public class HomeController implements ServletContextAware, InitializingBean {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TrackDao trackDao;

    @Autowired
    private ArtistDao artistDao;

    @Autowired
    private AlbumDao albumDao;

    @Autowired
    private UploadTrackDao uploadTrackDao;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private ServletContext servletContext;

    @RequestMapping("/about.html")
    public String about() {
        return "About";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        servletContext.setAttribute("states", State.values());
        servletContext.setAttribute("masterGenreList", Genre.values());
    }

    @RequestMapping(value = "/downloadUploadedTrack.html")
    public String download(@RequestParam int uploadID,
            HttpServletResponse response, HttpSession session)
                    throws IOException {

        UploadTrack uploadTrack = uploadTrackDao.getUploadTrack(uploadID);

        // if you want to use a relative path to context root:
        String relativePath = servletContext
                .getRealPath("/WEB-INF/files/" + uploadTrack.getName());
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

    @RequestMapping(value = { "/home.html", "/index.html" },
            method = RequestMethod.GET)
    public String home(ModelMap models) {
        models.put("genreMap", trackDao.getRandomGenreTracksMap());
        models.put("features", trackDao.getFeatureTracks());
        return "HomePage";
    }

    @RequestMapping(value = { "/home.html", "/index.html" },
            method = RequestMethod.POST)
    public String home(@RequestParam String searchBar, ModelMap models) {
        models.put("searchResultsArtist", artistDao.searchArtist(searchBar));
        models.put("searchResultsTrack", trackDao.searchTrack(searchBar));
        models.put("searchResultsAlbum", albumDao.searchAlbum(searchBar));
        models.put("searchResultsUser", userDao.searchSearch(searchBar));
        models.put("searchBar", searchBar);
        return home(models);
    }

    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String login(ModelMap models, HttpSession session) {
        User user = (User) session.getAttribute("sessionUser");
        if (user == null) {
            models.put("user", new User());
            return "Login";
        } else {
            return "Login";
        }
    }

    @RequestMapping(value = "/login.html", method = RequestMethod.POST)
    public String login(@ModelAttribute User user, HttpSession session,
            SessionStatus status) {
        for (User u : userDao.getUsers()) {
            if (u.getEmail().equals(user.getEmail())
                    && u.getPassword().equals(user.getPassword())) {
                session.setAttribute("sessionUser", u);
                return "redirect:userPage.html";
            }
        }
        status.setComplete();
        return "redirect:login.html";
    }

    @RequestMapping("/loginZoe.html")
    public String loginZoe(HttpSession session) {
        session.setAttribute("sessionUser", userDao.getUser(2));
        return "redirect:userPage.html";
    }
    
    @RequestMapping("/loginHomer.html")
    public String loginHome(HttpSession session) {
        session.setAttribute("sessionUser", userDao.getUser(3));
        return "redirect:userPage.html";
    }

    @RequestMapping("/logout.html")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:home.html";
    }

    @RequestMapping(value = "/profiles.html")
    public String profiles(ModelMap models) {
        models.put("users", userDao.getUsers());
        return "Profiles";
    }

    @RequestMapping(value = "/profileView.html")
    public String profileView(@RequestParam int id, ModelMap models) {
        models.put("user", userDao.getUser(id));
        return "ProfileView";
    }

    @RequestMapping(value = "/register.html", method = RequestMethod.GET)
    public String register(HttpSession session, ModelMap models) {

        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser != null)
            return "redirect:userPage.html";

        models.put("user", new User());
        models.put("states", State.values());
        return "Register";
    }

    @RequestMapping(value = "/register.html", method = RequestMethod.POST)
    public String register(HttpSession session, @ModelAttribute User user,
            BindingResult bindingResult) {

        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors())
            return "Register";

        userDao.save(user);
        return "redirect:login.html";
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
