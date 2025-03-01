package com.mmendoza.blog.api;

import com.mmendoza.blog.models.dto.PostDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/post")
public class PostApiController implements IPostApi {

    @Override
    public List<PostDto> getAllPosts() {
        return List.of();
    }

    @Override
    public List<PostDto> getPostByTags(List<Integer> tagsIds) {
        return List.of();
    }

    @Override
    public PostDto getPostById(Integer id) {
        return null;
    }

    @Override
    public Integer createPost(PostDto post) {
        return 0;
    }

    @Override
    public Integer addTagAPost(Integer postId, List<Integer> tagsIds) {
        return 0;
    }

    @Override
    public Integer removeTagAPost(Integer postId, List<Integer> tagsIds) {
        return 0;
    }

    @Override
    public Integer updatePost(PostDto post) {
        return 0;
    }

    @Override
    public Integer deletePost(Integer id) {
        return 0;
    }
}
