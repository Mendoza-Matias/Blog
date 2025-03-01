package com.mmendoza.blog.api;

import com.mmendoza.blog.models.dto.TagDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/tag")
public class TagApiController implements ITagApi {

    @Override
    public List<TagDto> getAllTags() {
        return List.of();
    }

    @Override
    public Integer createTag(TagDto tag) {
        return 0;
    }

    @Override
    public Integer updateTag(TagDto tag) {
        return 0;
    }

    @Override
    public Integer deleteTag(Integer id) {
        return 0;
    }
}
