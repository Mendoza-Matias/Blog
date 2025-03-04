package com.mmendoza.blog.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tags")

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Integer id;

    @Column(length = 25, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "tags")
    @JsonIgnore //ignoro el mapeo de este campo
    private List<Post> posts;
}
