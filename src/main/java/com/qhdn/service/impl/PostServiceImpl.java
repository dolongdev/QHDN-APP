package com.qhdn.service.impl;

import com.qhdn.dto.PostResponsive;
import com.qhdn.entity.Account;
import com.qhdn.entity.Category;
import com.qhdn.entity.Post;
import com.qhdn.exceptions.ResourceNotFoundException;
import com.qhdn.repository.AccountRepo;
import com.qhdn.repository.CategoryRepo;
import com.qhdn.repository.PostRepo;
import com.qhdn.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    CategoryRepo categoryRepo;


    @Override
    public Post createPost(Post post, String username, Integer categoryId) {
        Account account = this.accountRepo.findById(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "User", 1));
        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category", categoryId));

        post.setAccount(account);
        post.setCategory(category);
        post.setAddedDate(new Date());

        this.postRepo.save(post);

        return post;
    }

    @Override
    public Post updatePost(Post post, Integer postId) {
        Post post1 = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "Post", postId));

        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public PostResponsive getAllPostApi(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {

        Sort sort = ((sortDir.equalsIgnoreCase("asc"))?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());

        Pageable p = PageRequest.of(pageNumber, pageSize, sort);

        Page<Post> postPage = this.postRepo.findAll(p);

        List<Post> posts = postPage.getContent();

        PostResponsive postResponsive = new PostResponsive();
        postResponsive.setContent(posts);
        postResponsive.setPageNumber(postPage.getNumber());
        postResponsive.setPageSize(postPage.getSize());
        postResponsive.setTotalElements(postPage.getTotalElements());

        postResponsive.setTotalPages(postPage.getTotalPages());
        postResponsive.setLastPage(postPage.isLast());

        return postResponsive;
    }

    @Override
    public List<Post> getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {

        Sort sort = ((sortDir.equalsIgnoreCase("asc"))?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());

        Pageable p = PageRequest.of(pageNumber, pageSize, sort);

        Page<Post> postPage = this.postRepo.findAll(p);

        List<Post> posts = postPage.getContent();

        return posts;
    }

    @Override
    public List<Post> getPosts() {
        List<Post> posts = this.postRepo.findAll();
        return posts;
    }

    @Override
    public Post getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<Post> getPostsByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<Post> getPostsByUser(Integer userId) {
        return null;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }
}
