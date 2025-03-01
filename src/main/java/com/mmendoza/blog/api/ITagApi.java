package com.mmendoza.blog.api;

import com.mmendoza.blog.models.dto.TagDto;

import java.util.List;

public interface ITagApi {

    List<TagDto> getAllTags();

    Integer createTag(TagDto tag);

    Integer updateTag(TagDto tag);

    Integer deleteTag(Integer id);
}
