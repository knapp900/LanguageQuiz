package com.lQuiz.entity;

import java.io.Serializable;
import java.util.Objects;

public class WordPair implements Serializable {
    String wordSource;
    String wordTranslate;
    boolean guessed;

    int countOfGuessed;

    {

        guessed = false;
    }

    public WordPair() {
        super();
    }

    public WordPair(String wordSource, String wordTranslate) {
        super();
        this.wordSource = wordSource;
        this.wordTranslate = wordTranslate;

    }

    public String getWordSource() {
        return wordSource;
    }

    public void setWordSource(String wordSource) {
        this.wordSource = wordSource;
    }

    public String getWordTranslate() {
        return wordTranslate;
    }

    public void setWordTranslate(String wordTranslate) {
        this.wordTranslate = wordTranslate;
    }

    public boolean isGuessed() {
        return guessed;
    }

    public void setGuessed(boolean isGuessed) {
        this.guessed = isGuessed;
    }

    public int getCountOfGuessed() {
        return countOfGuessed;
    }

    public void setCountOfGuessed(int countOfGuessed) {
        this.countOfGuessed = countOfGuessed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countOfGuessed, guessed, wordSource, wordTranslate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WordPair other = (WordPair) obj;
        return countOfGuessed == other.countOfGuessed && guessed == other.guessed
                && Objects.equals(wordSource, other.wordSource) && Objects.equals(wordTranslate, other.wordTranslate);
    }

    @Override
    public String toString() {


        return wordSource + "-" + wordTranslate + "-" + countOfGuessed + "-" + guessed + '\n';
    }

}
