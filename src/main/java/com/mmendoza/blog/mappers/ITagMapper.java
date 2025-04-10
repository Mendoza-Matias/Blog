package com.mmendoza.blog.mappers;

import com.mmendoza.blog.domain.dto.TagDto;
import com.mmendoza.blog.domain.entity.Tag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITagMapper extends GenericMapper<Tag, TagDto> {
}
