package com.mmendoza.blog.business.impl;

import com.mmendoza.blog.business.service.ITagService;
import com.mmendoza.blog.domain.entity.Tag;
import com.mmendoza.blog.domain.exception.ExistingEntityException;
import com.mmendoza.blog.domain.exception.InvalidFieldException;
import com.mmendoza.blog.domain.exception.InvalidIdException;
import com.mmendoza.blog.domain.exception.NotFoundException;
import com.mmendoza.blog.domain.repository.ITagRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return repository.findById(tagId).orElseThrow(() -> new NotFoundException("Tag not found"));
    }

    @Override
    public void updateTag(Integer tagId, String name) {
        validateTagId(tagId);
        validateName(name);
        checkIfNameExists(name);

        if (!repository.existsById(tagId)) {
            throw new NotFoundException("Tag not found");
        }
        repository.updateTagName(tagId, name);
    }

    @Override
    public void deleteTag(Integer tagId) {
        validateTagId(tagId);
        if (!repository.existsById(tagId)) {
            throw new NotFoundException("Tag not found");
        }
        repository.deleteById(tagId);
    }

    @Override
    public void createTag(String name) {
        validateName(name);
        checkIfNameExists(name);
        repository.save(Tag.builder().name(name).build());
    }

    private void validateTagId(Integer tagId) {
        if (tagId == null || tagId <= 0) {
            throw new InvalidIdException("ID must be a positive integer and cannot be null");
        }
    }

    private void validateName(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new InvalidFieldException("Name cannot be empty");
        }
    }

    private void checkIfNameExists(String name) {
        if (repository.existsByName(name)) {
            throw new ExistingEntityException("Tag with name already exists");
        }
    }
}
