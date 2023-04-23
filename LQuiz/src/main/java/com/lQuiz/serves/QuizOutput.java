package com.lQuiz.serves;

import com.lQuiz.DAO.DAO;
import com.lQuiz.entity.WordPair;

import java.util.List;

public interface QuizOutput {
    public List<WordPair> getListWordsForLearning(int quantity, DAO dao);
}
