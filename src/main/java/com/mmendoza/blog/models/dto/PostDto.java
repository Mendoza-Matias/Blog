package com.mmendoza.blog.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PostDto {
    private Integer id;
    private String title;
    private String subtitle;
    private String content;
    private List<TagDto> tags;
}
