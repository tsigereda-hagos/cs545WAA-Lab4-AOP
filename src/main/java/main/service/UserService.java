package main.service;

import main.entity.Comment;
import main.entity.Post;
import main.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User save(User user);
    List<Post> findPostsByUserId(Long userId);
    List<User> findUsersWithMoreThanOnePost();

    Comment findCommentByUserIdAndPostIdAndCommentId(long userId, long postId, long commentId);
}
