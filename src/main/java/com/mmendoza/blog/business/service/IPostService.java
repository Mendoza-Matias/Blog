package com.mmendoza.blog.business.service;

import com.mmendoza.blog.domain.entity.Post;

import java.util.List;
import java.util.UUID;

public interface IPostService {

    List<Post> getAllPosts();

    Post getPostById(Integer postId);

    List<Post> getPostsByTagIds(List<Integer> tagIds);

    List<Post> searchPostsByText(String text);

    List<Post> getPostsSorted(String order);

    void createPost(Post post);

    void addTagToPost(Integer postId, List<Integer> tagIds);

    void removeTagsFromPost(Integer postId, List<Integer> tagIds);

    void deletePostById(Integer postId);
}
