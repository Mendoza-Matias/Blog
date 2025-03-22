package com.mmendoza.blog.mappers.impl;

import com.mmendoza.blog.mappers.IGenericMapper;
import com.mmendoza.blog.models.dtos.TagDto;
import com.mmendoza.blog.models.entities.Tag;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TagMapper implements IGenericMapper<TagDto, Tag> {

    @Override
    public Tag toEntity(TagDto tagDto) {
        return null;
    }

    @Override
    public TagDto toDto(Tag d) {
        return TagDto.builder()
                .id(d.getId())
                .name(d.getName())
                .build();
    }

    @Override
    public List<Tag> toEntiyList(List<TagDto> tagDtos) {
        return null;
    }

    @Override
    public List<TagDto> toDtoList(List<Tag> tags) {
        return tags == null ? Collections.emptyList() : tags.stream().map(this::toDto).collect(Collectors.toList());
    }
}
