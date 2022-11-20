package com.qhdn.controller.admin;

import com.qhdn.entity.Comment;
import com.qhdn.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping({"/", "/list"})
    public String getAllComment(Model model){
        List<Comment> list = this.commentService.getAllComment();
        model.addAttribute("comments", list);

        return "/admin/comment-list";
    }
}
