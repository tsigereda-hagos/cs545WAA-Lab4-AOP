package main.controller;

import main.entity.Comment;
import main.entity.Post;
import main.entity.User;
import main.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findAllById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/{id}/posts")
    public List<Post> findPostsByUserId(@PathVariable Long id) {
        return userService.findPostsByUserId(id);
    }

    @GetMapping("/with-multiple-posts")
    public List<User> findUsersWithMoreThanOnePost() {
        return userService.findUsersWithMoreThanOnePost();
    }

    @GetMapping("/{userId}/posts/{postId}/comments/{commentId}")
    public Comment findCommentById(@PathVariable long userId, @PathVariable long postId, @PathVariable long commentId) {
        return userService.findCommentByUserIdAndPostIdAndCommentId(userId, postId, commentId);
    }
}
