package com.qhdn.service;

import com.qhdn.dto.PostResponsive;
import com.qhdn.entity.Post;

import java.util.List;

public interface PostService {
    //create
    Post createPost(Post postDto, String username, Integer categoryId);

    //update
    Post updatePost(Post postDto, Integer postId);

    //delete
    void deletePost(Integer postId);

    //get all post
    PostResponsive getAllPostApi(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    List<Post> getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    List<Post> getPosts();

    //get single post
    Post getPostById(Integer postId);

    //get all post by category
    List<Post> getPostsByCategory(Integer categoryId);

    //get all post by account
    List<Post> getPostsByUser(Integer userId);

    //search post
    List<Post> searchPosts(String keyword);
}
