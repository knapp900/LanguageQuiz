package com.lQuiz.entity;

import java.util.ArrayList;
import java.util.List;

public class WordsAnswers {

    List<WordPair> answers = new ArrayList<>();

    public void addAnswerToList(WordPair wordPair) {
        answers.add(wordPair);
    }

    public List<WordPair> getAnswers() {
        return answers;
    }
}
