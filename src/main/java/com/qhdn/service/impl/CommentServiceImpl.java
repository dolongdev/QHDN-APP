package com.qhdn.service.impl;

import com.qhdn.entity.Comment;
import com.qhdn.exceptions.ResourceNotFoundException;
import com.qhdn.repository.CommentRepo;
import com.qhdn.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo;

    @Override
    public Comment findCommentById(Integer id) {
        Comment comment = this.commentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "Comment", id));
        return comment;
    }

    @Override
    public void addComment(Comment comment) {
        this.commentRepo.save(comment);
    }

    @Override
    public void deleteComment(Comment comment) {
        this.commentRepo.delete(comment);
    }

    @Override
    public List<Comment> getAllComment() {
        List<Comment> list = this.commentRepo.findAll();
        return list;
    }
}
