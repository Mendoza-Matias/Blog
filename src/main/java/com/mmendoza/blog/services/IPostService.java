package com.mmendoza.blog.services;

import java.util.List;

import com.mmendoza.blog.models.entities.Post;

public interface IPostService {

    List<Post> getAllPost();

    Post getPostById(Integer postId);

    List<Post> getAllPostsWithTag(List<Integer> tagIds);

    List<Post> getPostByTitle(String title)

    List<Post> getAllPostsOrderedByDate(String order); //asc - desc

    void createPost(String name);

    void updatePost(Integer postId);

    void deletePost(Integer postId);
}
