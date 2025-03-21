package com.mmendoza.blog.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer id;

    @Column(length = 25, nullable = false)
    private String title;

    @Column(length = 25, nullable = false)
    private String subtitle;

    @Column(nullable = false)
    private String content;

    @ManyToMany
    private List<Tag> tags;

    public void addTag(List<Tag> tags) {
        if (this.tags == null) {
            this.tags = new ArrayList<>(); //inicializo la lista de tags
        }
        this.tags.addAll(tags);
    }
}
