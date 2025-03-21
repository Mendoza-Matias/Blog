package com.mmendoza.blog.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private ITagService tagService;

    @GetMapping
    public ResponseEntity<List<TagDto>> getAllTags() {
        List<Tag> response = tagService.getAllTags();
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/{tagId}")
    public ResponseEntity<TagDto> getTagById(@PathVariable(name = "tagId") Integer tagId) {
        Tag response = tagService.getTagById(tagId);
        return ResponseEntity.ok().body(null);
    }

    @PutMapping("/{tagId}")
    public ResponseEntity<Void> updateTag(@PathVariable(name = "tagId") Integer tagId, TagDto tag) {
        tagService.updateTag(tagId, tag.getName());
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping("/{tagId}")
    public ResponseEntity<Void> deleteTag(@PathVariable(name = "tagId") Integer tagId) {
        tagService.deleteTag(tagId);
        return ResponseEntity.ok().body(null);
    }

    @PostMapping()
    public ResponseEntity<Void> createTag(@RequestBody TagDto tag) {
        tagService.createTag(tag.getName());
        return ResponseEntity.ok().body(null);
    }
}
