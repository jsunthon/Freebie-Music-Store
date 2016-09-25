package springmusic.model.dao;

import java.util.List;

import springmusic.model.Comment;
import springmusic.model.Track;
import springmusic.model.User;

public interface CommentDao {

    List<Comment> getComments();

    Comment getComment(int id);

    List<Comment> getComments(Track track);

    List<Comment> getComments(User user);
    
    Comment save(Comment comment);
    
    void delete(Comment comment);
}
