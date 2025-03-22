package com.mmendoza.blog.services;

import java.util.List;

import com.mmendoza.blog.models.entities.Post;

public interface IPostService {

    List<Post> getAllPost();

    Post getPostById(Integer postId);

    List<Post> getPostsByTagIds(List<Integer> tagIds);

    List<Post> getPostsByTitle(String title);

    List<Post> getPostsSortedByDate(String order);

    void createPost(String title);

    void updatePostById(Integer postId);

    void deletePostById(Integer postId);
}
