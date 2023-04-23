package com.lQuiz.entity;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class WordsQueue {

    Queue<WordPair> wordPairs = new LinkedList<>();

    public WordPair getWord() {

        return wordPairs.peek();
    }

    public WordPair getWordAndRemove() {
        return wordPairs.poll();
    }

    public void addWordPair(WordPair wordPair) {
        wordPairs.add(wordPair);
    }

    public boolean isEmpty() {
        return wordPairs.isEmpty();
    }

    public boolean fillQueue(Collection<WordPair> pairs) {
        return wordPairs.addAll(pairs);
    }
}
