package com.qhdn.controller.admin;

import com.qhdn.entity.Category;
import com.qhdn.entity.Post;
import com.qhdn.service.CategoryService;
import com.qhdn.service.FileService;
import com.qhdn.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/posts")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    FileService fileService;

    @Value("${project.image}")
    private String path;


    @GetMapping("")
    public String getPosts(Model model, @ModelAttribute Post post){
        List<Post> posts = this.postService.getAllPost(0, 6, "title", "asc");
        model.addAttribute("posts", posts);

        return "/admin/posts-list";
    }

    @GetMapping("/add/form")
    public String addPostForm(Model model, @ModelAttribute Post post){

        List<Category> categories = this.categoryService.getAllCategory();
        model.addAttribute("categories", categories);

        return "/admin/post-form";
    }

    @GetMapping("/update/{postId}")
    public ModelAndView updatePostForm(Model model,
                                 @ModelAttribute Post post,
                                 @PathVariable Integer postId){
        ModelAndView view = new ModelAndView("/admin/post-form");

        List<Category> categories = this.categoryService.getAllCategory();
        view.addObject("categories", categories);

        Post postUpdate = this.postService.getPostById(postId);
        view.addObject("post", postUpdate);

        return view;
    }

    @PostMapping("/add")
    public ModelAndView addPost(@RequestParam("category") Integer category,
                                @RequestParam("username") String username,
                                @ModelAttribute Post post) throws Exception{
        ModelAndView view = new ModelAndView("/admin/post-form");

        Post postNew = this.postService.createPost(post, username, category);
        view.addObject("post", postNew);

        List<Category> categories = this.categoryService.getAllCategory();
        view.addObject("categories", categories);

        return view;
    }

//    @PostMapping("/update/{postId}")
//    public ModelAndView updatePost(@ModelAttribute Post post,
//                                   @PathVariable Integer postId){
//        ModelAndView view = new ModelAndView("/admin/post-form");
//
//        Post updatePost = this.postService.updatePost(post, postId);
//        view.addObject("post", updatePost);
//
//        return view;
//    }

    //delete post
    @GetMapping("delete/{postId}")
    public String deletePost(Model model,
                             @PathVariable Integer postId){
        this.postService.deletePost(postId);
        return "redirect:/admin/posts";
    }

}
