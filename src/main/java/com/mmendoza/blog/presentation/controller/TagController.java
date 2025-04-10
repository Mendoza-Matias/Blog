package com.mmendoza.blog.presentation.controller;

import com.mmendoza.blog.business.service.ITagService;
import com.mmendoza.blog.domain.dto.TagDto;
import com.mmendoza.blog.mappers.ITagMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
@Tag(name = "Tag", description = "API related to tags")
public class TagController {

    @Autowired
    private ITagService tagService;

    @Autowired
    private ITagMapper tagMapper;

    @Operation(summary = "Get all tags")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = TagDto.class))
            ),
            @ApiResponse(responseCode = "400", description = "ERROR", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<TagDto>> getAllTags() {
        return ResponseEntity.ok().body(tagMapper.toDtoList(tagService.getAllTags()));
    }

    @Operation(summary = "Get tag by id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = @Content(schema = @Schema(implementation = TagDto.class))
            ),
            @ApiResponse(responseCode = "400", description = "ERROR", content = @Content)
    })
    @GetMapping("/{tagId}")
    public ResponseEntity<TagDto> getTagById(@PathVariable Integer tagId) {
        return ResponseEntity.ok().body(tagMapper.toDto(tagService.getTagById(tagId)));
    }

    @Operation(summary = "Update tag")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content),
            @ApiResponse(responseCode = "400", description = "ERROR", content = @Content)
    })
    @PutMapping("/{tagId}")
    public ResponseEntity<Void> updateTag(@PathVariable Integer tagId, @RequestBody TagDto tag) {
        tagService.updateTag(tagId, tag.getName());
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Delete tag")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content),
            @ApiResponse(responseCode = "400", description = "ERROR", content = @Content)
    })
    @DeleteMapping("/{tagId}")
    public ResponseEntity<Void> deleteTag(@PathVariable Integer tagId) {
        tagService.deleteTag(tagId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Create tag")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "ERROR")
    })
    @PostMapping
    public ResponseEntity<Void> createTag(@RequestBody TagDto tag) {
        tagService.createTag(tag.getName());
        return ResponseEntity.ok().build();
    }
}
