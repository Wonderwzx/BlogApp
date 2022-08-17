package com.wonder.blog.web;

import com.wonder.blog.po.Tag;
import com.wonder.blog.service.BlogService;
import com.wonder.blog.service.TagService;
import com.wonder.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TagShowController {

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/tags/{id}")
    public String tags(@PageableDefault(size = 10, sort = {"updateTime"}, direction = Sort.Direction.DESC)
                                   @PathVariable Long id, Pageable pageable, Model model){
        List<Tag> tags = tagService.listTagTop(10000);
        if(id == -1){
            id = tags.get(0).getId();
        }
        BlogQuery blogQuery = new BlogQuery();
        model.addAttribute("tags", tags);
        model.addAttribute("page", blogService.listBlog(id, pageable));
        model.addAttribute("activeTagId", id);
        return "tags";
    }
}
