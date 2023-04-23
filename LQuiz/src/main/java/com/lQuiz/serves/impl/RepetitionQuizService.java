package com.lQuiz.serves.impl;


import com.lQuiz.DAO.DAO;
import com.lQuiz.entity.WordPair;
import com.lQuiz.entity.WordsAnswers;
import com.lQuiz.entity.WordsQueue;
import com.lQuiz.serves.QuizInput;
import com.lQuiz.view.LearningQuizView;
import com.lQuiz.view.Presentation;
import com.lQuiz.view.presentationImpl.LearningQuizPresentationToPDF;

import java.io.*;
import java.util.Arrays;

public class RepetitionQuizService implements QuizInput {

    public void init(DAO dao, WordsQueue queue, WordsAnswers answersList) {

        WordPair word = new WordPair();
        int[] indexes = getIndexesFromFile();

        for (int i = 0; i < indexes.length; i++) {

            String[] tempWord = dao.read(indexes[i]).split("-");

            word.setWordSource(tempWord[0]);
            word.setWordTranslate(tempWord[1]);
            word.setCountOfGuessed(Integer.valueOf(tempWord[2]));
            word.setGuessed(Boolean.valueOf(tempWord[3]));

            queue.addWordPair(word);
            System.out.println(queue.getWord());

        }


    }


    @Override
    public boolean start(WordsQueue wordsQueue, WordsAnswers answersList, String request) {
        // продумать возвращать тру или фалс
        LearningQuizView view = new LearningQuizView();
        view.view(wordsQueue.getWord());
        return checkAnswer(request, wordsQueue, answersList);


    }

    public boolean checkAnswer(String answer, WordsQueue queue, WordsAnswers answersList) {

        if (answer.equals(queue.getWord().getWordTranslate())) {

            queue.getWord().setGuessed(true);
            queue.getWord().setCountOfGuessed(queue.getWord().getCountOfGuessed() + 1);
            answersList.addAnswerToList(queue.getWord());

            queue.getWordAndRemove();

            return true;

        } else {

            answersList.addAnswerToList(queue.getWordAndRemove());

            return false;
        }

    }

    public int[] getIndexesFromFile() {

        File file = new File("indexesOfQuiz.csv");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String [] index = reader.readLine().split(",");
            int [] indexes = new int[index.length];

            for (int i = 0; i < index.length; i++) {
                indexes[i] = Integer.valueOf(index[i]);
            }



//            int[] indexes = Arrays
//                    .stream(reader.readLine().split(","))
//                    .mapToInt(Integer::parseInt).toArray();


            return indexes;

        } catch (IOException e) {

            System.err.println("indexesOfQuiz.csv read error: " + e);

        }
        return null;
    }
}