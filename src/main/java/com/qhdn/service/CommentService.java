package com.qhdn.service;

import com.qhdn.entity.Comment;

import java.util.List;

public interface CommentService {

    Comment findCommentById(Integer commentId);
    void addComment(Comment comment);

    void deleteComment(Comment comment);

    public List<Comment> getAllComment();
}
