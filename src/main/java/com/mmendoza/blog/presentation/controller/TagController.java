package com.mmendoza.blog.presentation.controller;

import com.mmendoza.blog.business.service.ITagService;
import com.mmendoza.blog.domain.dto.TagDto;
import com.mmendoza.blog.mappers.ITagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags") //TODO HACER TEST
public class TagController {
    @Autowired
    private ITagService tagService;

    @Autowired
    private ITagMapper tagMapper;

    @GetMapping
    public ResponseEntity<List<TagDto>> getAllTags() {
        return null;
    }

    @GetMapping("/{tagId}")
    public ResponseEntity<TagDto> getTagById(@PathVariable Integer tagId) {
        return null;
    }

    @PutMapping("/{tagId}")
    public ResponseEntity<Void> updateTag(@PathVariable Integer tagId, @RequestBody TagDto tag) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{tagId}")
    public ResponseEntity<Void> deleteTag(@PathVariable Integer tagId) {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> createTag(@Validated @RequestBody TagDto tag) {
        return ResponseEntity.ok().build();
    }
}
