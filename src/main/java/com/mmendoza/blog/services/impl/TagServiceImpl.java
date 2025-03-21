package com.mmendoza.blog.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmendoza.blog.models.entities.Tag;
import com.mmendoza.blog.models.exceptions.InvalidNameException;
import com.mmendoza.blog.models.exceptions.NotFoundException;
import com.mmendoza.blog.repository.ITagRepository;
import com.mmendoza.blog.services.ITagService;

import io.micrometer.common.lang.NonNull;
import io.micrometer.common.util.StringUtils;

@Service
public class TagServiceImpl implements ITagService {

    @Autowired
    private ITagRepository tagRepository;

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public Tag getTagById(Integer tagId) {
        return tagRepository.findById(tagId)
                .orElseThrow(() -> new NotFoundException("tag not found"));
    }

    @Override
    public void updateTag(@NonNull Integer tagId, @NonNull String name) {
        verifyName(name);
        tagRepository.updateTagName(tagId, name);
    }

    @Override
    public void deleteTag(Integer tagId) {
        if (!tagRepository.existsById(tagId)) {
            throw new NotFoundException("tag not found");
        }
        tagRepository.deleteById(tagId);
    }

    @Override
    public void createTag(@NonNull String name) {
        verifyName(name);
        tagRepository.save(Tag.builder().name(name).build());
    }

    /* verificaciones para el nombre */
    private void verifyName(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new InvalidNameException("name is empty");
        }
        if (tagRepository.existsByName(name)) {
            throw new InvalidNameException("name already exists");
        }
    }
}
