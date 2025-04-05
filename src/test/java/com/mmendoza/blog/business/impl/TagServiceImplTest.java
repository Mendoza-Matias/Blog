package com.mmendoza.blog.business.impl;

import com.mmendoza.blog.domain.entity.Tag;
import com.mmendoza.blog.domain.exception.ExistingEntityException;
import com.mmendoza.blog.domain.exception.InvalidFieldException;
import com.mmendoza.blog.domain.exception.InvalidIdException;
import com.mmendoza.blog.domain.exception.NotFoundException;
import com.mmendoza.blog.domain.repository.ITagRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TagServiceImplTest {

    @InjectMocks
    private TagServiceImpl tagService;

    @Mock
    private ITagRepository tagRepository;

    private List<Tag> tags;

    private Tag tag;

    @BeforeEach
    void setUp() {
        tags = List.of(
                Tag.builder().id(1).name("Refrigeracion").build()
        );
        tag = Tag.builder().id(1).name("Refrigeracion").build();
    }

    @Test
    void getAllTags() {
        Mockito.when(tagRepository.findAll()).thenReturn(tags);
        List<Tag> result = tagService.getAllTags();
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals("Refrigeracion", result.get(0).getName());
    }

    @Test
    void verifyTagIdIsNull() {
        InvalidIdException exception = assertThrows(InvalidIdException.class, () -> {
            tagService.getTagById(null);
        });
        assertEquals("ID must be a positive integer and cannot be null", exception.getMessage());
    }

    @Test
    void verifyTagIdIsZero() {
        InvalidIdException exception = assertThrows(InvalidIdException.class, () -> {
            tagService.getTagById(0);
        });
        assertEquals("ID must be a positive integer and cannot be null", exception.getMessage());
    }

    @Test
    void getTagById() {
        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
        Mockito.when(tagRepository.findById(captor.capture())).thenReturn(
                Optional.of(tag)
        );
        Tag result = tagService.getTagById(1);

        assertEquals(1, captor.getValue());
        assertEquals(1, result.getId());
        assertEquals("Refrigeracion", result.getName());
    }

    @Test
    void verifyNameIsNull() {
        InvalidFieldException exception = assertThrows(InvalidFieldException.class, () -> {
            tagService.createTag(null);
        });
        assertEquals("Name cannot be empty", exception.getMessage());
    }

    @Test
    void verifyNameIsEmpty() {
        InvalidFieldException exception = assertThrows(InvalidFieldException.class, () -> {
            tagService.createTag("");
        });
        assertEquals("Name cannot be empty", exception.getMessage());
    }

    @Test
    void verifyNameExist() {
        Mockito.when(tagRepository.existsByName(Mockito.anyString())).thenReturn(true);
        ExistingEntityException exception = assertThrows(ExistingEntityException.class, () -> {
            tagService.createTag("Refrigeracion");
        });
        assertEquals("Tag with name already exists", exception.getMessage());
    }

    @Test
    void verifyExistById() {
        Mockito.when(tagRepository.existsById(Mockito.anyInt())).thenReturn(false);
        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            tagService.deleteTag(1);
        });
        assertEquals("Tag not found", exception.getMessage());
    }

    @Test
    void updateTag() {
        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<String> captorName = ArgumentCaptor.forClass(String.class);
        Mockito.when(tagRepository.existsById(Mockito.eq(1))).thenReturn(true); //valido si existe el registro
        Mockito.doNothing().when(tagRepository).updateTagName(captor.capture(), captorName.capture());
        tagService.updateTag(1, "Aire acondicionado");
        assertEquals(1, captor.getValue());
        assertEquals("Aire acondicionado", captorName.getValue());
    }

    @Test
    void deleteTag() {
        Mockito.when(tagRepository.existsById(Mockito.any())).thenReturn(true);
        tagService.deleteTag(1);
        Mockito.verify(tagRepository, Mockito.times(1)).deleteById(Mockito.any());
    }

    @Test
    void createTag() {
        ArgumentCaptor<Tag> captor = ArgumentCaptor.forClass(Tag.class);
        Mockito.when(tagRepository.save(captor.capture())).thenReturn(tag);
        tagService.createTag("Refrigeracion");
        Mockito.verify(tagRepository).save(Mockito.any(Tag.class));
        assertEquals("Refrigeracion", captor.getValue().getName());
    }
}