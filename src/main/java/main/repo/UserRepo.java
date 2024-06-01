package main.repo;

import main.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE SIZE(u.posts) > 1")
    List<User> findUsersWithMoreThanOnePost();

    @Query("SELECT u FROM User u WHERE SIZE(u.posts) > :n")
    List<User> findUsersWithMoreThanNPosts(@Param("n") int n);

    @Query("SELECT DISTINCT u FROM User u JOIN u.posts p WHERE p.title = :title")
    List<User> findUsersByPostTitle(@Param("title") String title);
}
