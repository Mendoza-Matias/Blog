package com.mmendoza.blog.services.impl;

import java.util.List;

import com.mmendoza.blog.models.exceptions.DuplicateNameException;
import com.mmendoza.blog.models.exceptions.InvalidIdException;
import com.mmendoza.blog.repositories.ITagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmendoza.blog.models.entities.Tag;
import com.mmendoza.blog.models.exceptions.InvalidNameException;
import com.mmendoza.blog.models.exceptions.NotFoundException;
import com.mmendoza.blog.services.ITagService;

import io.micrometer.common.util.StringUtils;

@Service
public class TagServiceImpl implements ITagService {

    private final ITagRepository repository;

    @Autowired
    public TagServiceImpl(ITagRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Tag> getAllTags() {
        return repository.findAll();
    }

    @Override
    public Tag getTagById(Integer tagId) {
        validateTagId(tagId);
        return repository.findById(tagId)
                .orElseThrow(() -> new NotFoundException("Tag with ID " + tagId + " not found"));
    }

    @Override
    public void updateTag(Integer tagId, String name) {
        validateTagId(tagId);
        validateName(name);
        checkIfNameExists(name);

        if (!repository.existsById(tagId)) {
            throw new NotFoundException("Tag with ID " + tagId + " not found");
        }
        repository.updateTagName(tagId, name);
    }

    @Override
    public void deleteTag(Integer tagId) {
        validateTagId(tagId);
        if (!repository.existsById(tagId)) {
            throw new NotFoundException("Tag with ID " + tagId + " not found");
        }
        repository.deleteById(tagId);
    }

    @Override
    public void createTag(String name) {
        validateName(name);
        checkIfNameExists(name);
        repository.save(Tag.builder().name(name).build());
    }

    /* validaciones*/

    private void validateTagId(Integer tagId) {
        if (tagId == null || tagId <= 0) {
            throw new InvalidIdException("ID must be a positive integer and cannot be null");
        }
    }

    private void validateName(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new InvalidNameException("Name cannot be empty");
        }
    }

    private void checkIfNameExists(String name) {
        if (repository.existsByName(name)) {
            throw new DuplicateNameException("Tag with name '" + name + "' already exists");
        }
    }
}
