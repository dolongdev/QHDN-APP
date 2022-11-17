package com.qhdn.controller.rest;

import com.qhdn.config.AppConstants;
import com.qhdn.dto.PostResponsive;
import com.qhdn.entity.Post;
import com.qhdn.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostRestController {
    @Autowired
    PostService postService;

    @GetMapping("")
    public ResponseEntity<PostResponsive> getAllPost(
            @RequestParam(value = "pageNumber",
                    defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(value = "pageSize",
                    defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(value = "sortBy",
                    defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir",
                    defaultValue = AppConstants.SORT_DIR, required = false) String sortDir
    ){
        PostResponsive postResponsive = this.postService.getAllPostApi(pageNumber, pageSize, sortBy, sortDir);

        return new ResponseEntity<PostResponsive>(postResponsive, HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> get(@PathVariable Integer postId){
        Post post = this.postService.getPostById(postId);

        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }
}
