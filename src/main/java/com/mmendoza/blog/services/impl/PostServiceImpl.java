package com.mmendoza.blog.services.impl;

import com.mmendoza.blog.models.entities.Post;
import com.mmendoza.blog.repositories.IPostRepository;
import com.mmendoza.blog.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements IPostService {

    @Autowired
    private IPostRepository repository;


    @Override
    public List<Post> getAllPost() {
        return List.of();
    }

    @Override
    public Post getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<Post> getPostsByTagIds(List<Integer> tagIds) {
        return List.of();
    }

    @Override
    public List<Post> getPostsByTitle(String title) {
        return List.of();
    }

    @Override
    public List<Post> getPostsSortedByDate(String order) {
        return List.of();
    }

    @Override
    public void createPost(String title) {

    }

    @Override
    public void updatePostById(Integer postId) {

    }

    @Override
    public void deletePostById(Integer postId) {

    }
}
