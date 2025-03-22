package com.mmendoza.blog.api;

import java.util.List;

import com.mmendoza.blog.mappers.impl.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmendoza.blog.models.dtos.TagDto;
import com.mmendoza.blog.models.entities.Tag;
import com.mmendoza.blog.services.ITagService;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    @Autowired
    private ITagService service;

    @Autowired
    private TagMapper mapper;

    @GetMapping
    public ResponseEntity<List<TagDto>> getAllTags() {
        return ResponseEntity.ok().body(mapper.toDtoList(service.getAllTags()));
    }

    @GetMapping("/{tagId}")
    public ResponseEntity<TagDto> getTagById(@PathVariable(name = "tagId") Integer tagId) {
        return ResponseEntity.ok().body(mapper.toDto(service.getTagById(tagId)));
    }

    @PutMapping("/{tagId}")
    public ResponseEntity<Void> updateTag(@PathVariable(name = "tagId") Integer tagId, @RequestBody TagDto tag) {
        service.updateTag(tagId, tag.getName());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{tagId}")
    public ResponseEntity<Void> deleteTag(@PathVariable(name = "tagId") Integer tagId) {
        service.deleteTag(tagId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping()
    public ResponseEntity<Void> createTag(@Validated @RequestBody TagDto tag) {
        service.createTag(tag.getName());
        return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 Created
    }
}
