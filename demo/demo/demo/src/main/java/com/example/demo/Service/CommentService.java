package com.example.demo.Service;

import com.example.demo.Entity.Cemment;
import com.example.demo.Repsitory.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    public void AjoutCommentaire(Cemment cemment){
        commentRepository.save(cemment);
    }
    public List<Cemment> GetCommentaire(){
        return commentRepository.findAll();
    }
    public void SupprimComment(Long id){
        if (commentRepository.findById(id).get() != null){
            commentRepository.deleteById(id);

        }
        else{
            System.out.println("not valid comment");
        }
    }
    public void UpdateComment(Long id , Cemment cemment){
        if (commentRepository.findById(id).get() != null){
            commentRepository.findById(id).get().setCommentaire(cemment.getCommentaire());
            commentRepository.save(commentRepository.findById(id).get());


        }
        else{
            System.out.println("not valid comment");
        }
    }
}
