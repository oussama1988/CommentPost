package com.example.demo.Controller;

import com.example.demo.Entity.Cemment;
import com.example.demo.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {
    @Autowired
  CommentService commentService;
    @PostMapping("/post/{blog}/comment")
    public void AddComment(@PathVariable Optional<String> blog , @RequestBody Cemment cemment){
        String newBlog = "1";
        if (blog.isPresent()) {
            newBlog = blog.get();
        }
        commentService.AjoutCommentaire(cemment);
    }
    @GetMapping("/post/{blog}/comments")
    public List<Cemment> AllComments(@PathVariable Optional<String> blog){
        String newBlog = "1";
        if (blog.isPresent()) {
            newBlog = blog.get();
        }
       return commentService.GetCommentaire();
    }
    @DeleteMapping("/post/{blog}/comments/{id}")
    public void DeleteComment(@PathVariable Optional<String> blog , @PathVariable Long id){
        String newBlog = "1";
        if (blog.isPresent()) {
            newBlog = blog.get();
        }
        commentService.SupprimComment(id);
    }
    @PutMapping("/post/{blog}/comments/{id}")
    public void ModifComment(@PathVariable Optional<String> blog , @PathVariable Long id ,@RequestBody Cemment cemment){
        String newBlog = "1";
        if (blog.isPresent()) {
            newBlog = blog.get();
        }
        commentService.UpdateComment(id, cemment);
    }

}
