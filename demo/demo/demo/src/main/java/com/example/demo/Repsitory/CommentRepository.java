package com.example.demo.Repsitory;

import com.example.demo.Entity.Cemment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Cemment,Long> {
}
