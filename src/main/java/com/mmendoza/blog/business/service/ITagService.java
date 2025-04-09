package com.mmendoza.blog.business.service;

import com.mmendoza.blog.domain.entity.Tag;

import java.util.List;
import java.util.UUID;

public interface ITagService {

    List<Tag> getAllTags();

    Tag getTagById(Integer tagId);

    void createTag(String name);

    void updateTag(Integer tagId, String name);

    void deleteTag(Integer tagId);
}
