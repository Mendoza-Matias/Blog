package com.mmendoza.blog.business.impl;

import com.mmendoza.blog.business.service.IPostService;
import com.mmendoza.blog.business.service.ITagService;
import com.mmendoza.blog.domain.entity.Post;
import com.mmendoza.blog.domain.entity.Tag;
import com.mmendoza.blog.domain.exception.InvalidFieldException;
import com.mmendoza.blog.domain.exception.InvalidIdException;
import com.mmendoza.blog.domain.exception.NotFoundException;
import com.mmendoza.blog.domain.repository.IPostRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private ITagService tagService;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Integer postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException("Post with ID" + postId + "not found"));
    }

    @Override
    public List<Post> getPostsByTagIds(List<Integer> tagIds) {
        return postRepository.getPostsByTagIds(tagIds);
    }


    @Override
    public List<Post> searchPostsByText(String text) {
        return postRepository.getPostContaining(text);
    }

    @Override
    public List<Post> getPostsSorted(String order) {
        if (order.equals("ASC")) {
            return postRepository.findAllPostsOrderedAsc();
        }
        if (order.equals("DESC")) {
            return postRepository.findAllPostsOrderedDesc();
        }
        return postRepository.findAll();
    }

    @Override
    public void createPost(Post post) {
        validatePostFields(post);

        Post entity = Post.builder()
                .title(post.getTitle())
                .subtitle(post.getSubtitle())
                .content(post.getContent())
                .datePublished(LocalDate.now())
                .build();

        postRepository.save(entity);
    }

    @Override
    public void addTagToPost(Integer postId, List<Integer> tagIds) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException("Tag with ID" + postId + "not found"));

        validateTagIds(tagIds);

        //convierto la lista a una de tags
        List<Tag> tags = tagIds.stream()
                .map(tagService::getTagById)
                .toList();

        for (Tag tag : tags) {
            if (post.getTags().contains(tag)) { //valido si existe ya en la lista
                throw new InvalidIdException("Tag with ID" + tag.getId() + " already exists");
            }
            post.addTag(tag);
        }
        postRepository.save(post);
    }

    @Override
    public void removeTagsFromPost(Integer postId, List<Integer> tagIds) {
        validPostId(postId);
        validateTagIds(tagIds);

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException("Post with ID" + postId + "not found"));

        if (post.getTags() == null || post.getTags().isEmpty()) {
            throw new InvalidIdException("Post with ID" + postId + "has no tags");
        }

        List<Tag> tags = tagIds.stream().map(tagService::getTagById).toList();

        if (post.getTags().size() - tags.size() < 1) {
            throw new InvalidIdException("Tags cannot be deleted");
        }
        post.getTags().removeAll(tags); //quito los tags

        postRepository.save(post); //guardo los cambios
    }

    @Override
    public void deletePostById(Integer postId) {
        validPostId(postId);
        postRepository.deleteById(postId);
    }

    //Validación de id
    private void validPostId(Integer postId) {
        if (postId == null || postId <= 0) {
            throw new InvalidIdException("Post ID cannot be null");
        }
    }

    //validacion de campos
    private void validatePostFields(Post post) {
        if (post == null) {
            throw new IllegalArgumentException("Post cannot be null");
        }
        if (StringUtils.isEmpty(post.getTitle())) {
            throw new InvalidFieldException("Title cannot be null or empty");
        }
        if (StringUtils.isEmpty(post.getSubtitle())) {
            throw new InvalidFieldException("Subtitle cannot be null or empty");
        }
        if (StringUtils.isEmpty(post.getContent())) {
            throw new InvalidFieldException("Content cannot be null or empty");
        }
    }

    //validacion de tagIds
    private void validateTagIds(List<Integer> tagIds) {
        if (tagIds == null || tagIds.isEmpty()) {
            throw new InvalidFieldException("Tags cannot be null or empty");
        }
    }
}
