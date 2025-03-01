package com.mmendoza.blog.api;

import com.mmendoza.blog.models.dto.PostDto;

import java.util.List;

public interface IPostApi {

    List<PostDto> getAllPosts();

    List<PostDto> getPostByTags(List<Integer> tagsIds);

    PostDto getPostById(Integer id);

    Integer createPost(PostDto post);

    Integer addTagAPost(Integer postId, List<Integer> tagsIds);

    Integer removeTagAPost(Integer postId, List<Integer> tagsIds);

    Integer updatePost(PostDto post);

    Integer deletePost(Integer id);
}
