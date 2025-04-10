package com.mmendoza.blog.mappers;

import com.mmendoza.blog.domain.dto.PostDto;
import com.mmendoza.blog.domain.entity.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPostMapper extends GenericMapper<Post, PostDto> {
}
