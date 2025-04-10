package com.mmendoza.blog.presentation.controller;

import com.mmendoza.blog.business.service.IPostService;
import com.mmendoza.blog.domain.dto.AddTagToPostDto;
import com.mmendoza.blog.domain.dto.BasicInformationOfPostDto;
import com.mmendoza.blog.domain.dto.PostDto;
import com.mmendoza.blog.domain.dto.RemoveTagsDto;
import com.mmendoza.blog.mappers.IPostMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/posts")
@Tag(name = "Post", description = "API related to post")
public class PostController {
    @Autowired
    private IPostService postService;

    @Autowired
    private IPostMapper postMapper;

    @GetMapping
    public ResponseEntity<List<BasicInformationOfPostDto>> getAllPosts() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<PostDto>> searchPostsByText(@RequestParam String text) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<PostDto>> getPostsSorted(@RequestParam String order) {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody PostDto postDto) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/tags")
    public ResponseEntity<Void> addTagsToPost(@RequestBody AddTagToPostDto request) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/tags")
    public ResponseEntity<Void> removeTagsFromPost(@RequestBody RemoveTagsDto request) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("{post_id}/image")
    public ResponseEntity<Void> addImageToPost(@PathVariable(name = "post_id") Integer postId, @RequestParam(name = "image") MultipartFile image) {
        return ResponseEntity.ok().build();
    }
}
