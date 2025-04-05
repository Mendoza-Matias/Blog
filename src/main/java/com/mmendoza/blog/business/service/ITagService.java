package com.mmendoza.blog.business.service;

import com.mmendoza.blog.domain.entity.Tag;

import java.util.List;
import java.util.UUID;

public interface ITagService {

    List<Tag> getAllTags();

    Tag getTagById(UUID tagId);

    void createTag(String name);

    void updateTag(UUID tagId, String name);

    void deleteTag(UUID tagId);
}
