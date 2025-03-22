package com.mmendoza.blog.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {
    private Integer id;
    private String title;
    private String subtitle;
    private String content;
    private LocalDate datePublished;
    private List<TagDto> tags;
}
