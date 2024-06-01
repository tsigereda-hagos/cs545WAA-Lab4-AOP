package main.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String author;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name= "post_id")
    private List<Comment> comments;

    //Enable Adding a Comment Associated with its Post
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

}
