package com.lQuiz.serves;

import com.lQuiz.entity.WordsAnswers;
import com.lQuiz.entity.WordsQueue;

public interface QuizInput {
    boolean start (WordsQueue wordsQueue, WordsAnswers answersList , String request);
}
