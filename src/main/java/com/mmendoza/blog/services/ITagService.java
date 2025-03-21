package com.mmendoza.blog.services;

import java.util.List;
import java.util.Optional;

import com.mmendoza.blog.models.entities.Tag;

public interface ITagService {

    List<Tag> getAllTags();

    Tag getTagById(Integer tagId);

    void createTag(String name);
    
    void updateTag(Integer tagId, String name);
    
    void deleteTag(Integer tagId);
}
