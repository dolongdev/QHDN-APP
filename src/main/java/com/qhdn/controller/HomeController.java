package com.qhdn.controller;

import com.qhdn.entity.Post;
import com.qhdn.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    PostService postService;

    @GetMapping({"/home", ""})
    public String home(Model model){
        List<Post> posts = this.postService
                .getAllPost(0, 6, "addedDate", "esc");
        model.addAttribute("posts", posts);
        return "/page/home";
    }

    @GetMapping("/post/{postId}")
    public String getPost(Model model,
                          @PathVariable Integer postId){
        Post post = this.postService.getPostById(postId);
        model.addAttribute("post", post);
        return "/page/singlePost";
    }


}
