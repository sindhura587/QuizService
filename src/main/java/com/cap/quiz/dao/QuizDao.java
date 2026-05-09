package com.cap.quiz.dao;

import com.cap.quiz.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
