package com.mmendoza.blog.mappers.impl;

import com.mmendoza.blog.mappers.IGenericMapper;
import com.mmendoza.blog.models.dtos.PostDto;
import com.mmendoza.blog.models.entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapper implements IGenericMapper<PostDto, Post> {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public Post toEntity(PostDto postDto) {
        return Post.builder()
                .id(postDto.getId())
                .title(postDto.getTitle())
                .subtitle(postDto.getSubtitle())
                .content(postDto.getContent())
                .datePublished(postDto.getDatePublished())
                .tags(tagMapper.toEntiyList(postDto.getTags()))
                .build();
    }

    @Override
    public PostDto toDto(Post d) {
        return PostDto.builder()
                .id(d.getId())
                .title(d.getTitle())
                .subtitle(d.getSubtitle())
                .content(d.getContent())
                .datePublished(d.getDatePublished())
                .tags(tagMapper.toDtoList(d.getTags()))
                .build();
    }

    @Override
    public List<Post> toEntiyList(List<PostDto> postDtos) {
        return postDtos == null ? Collections.emptyList() : postDtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> toDtoList(List<Post> posts) {
        return posts == null ? Collections.emptyList() : posts.stream().map(this::toDto).collect(Collectors.toList());
    }
}
