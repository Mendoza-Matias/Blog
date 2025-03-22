package com.mmendoza.blog.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer id;

    private String title;

    private String subtitle;

    private String content;

    private LocalDate datePublished;

    @ManyToMany //creo la tabla intermedia
    @JoinTable(name = "post_tags",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags = new ArrayList<>();

    public void addTag(List<Tag> tags) {
        if (tags == null) {
            throw new IllegalArgumentException("tags cannot be null");
        }
        this.tags.addAll(tags);
    }
}
