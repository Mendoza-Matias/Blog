package com.mmendoza.blog.mappers;

import com.mmendoza.blog.domain.dto.TagDto;
import com.mmendoza.blog.domain.entity.Tag;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring") //TODO HACER TEST
public interface ITagMapper extends GenericMapper<Tag, TagDto> {
}
