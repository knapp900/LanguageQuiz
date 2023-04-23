package com.lQuiz.serves.impl;

import com.lQuiz.DAO.DAO;
import com.lQuiz.entity.WordPair;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LearningQuizService {

    /**
     * Return a list of words to learn and save their indexes to a file
     * @param quantity of words for learning
     * @param dao
     * @return ArrayList<WordPair>
     */
    public List<WordPair> getListWordsForLearning(int quantity, DAO dao) {
        //Возможно WordPair не нужен! хватит и String! word[0] + "-" + "word[1];

        List<WordPair> wordsForLearning = new ArrayList<>();

        int[] indexes = randomizer(quantity, dao);

        for (int i = 0; i < indexes.length; i++) {
            WordPair wordPair = new WordPair();

            String[] word = dao.read(indexes[i]).split("-");

            wordPair.setWordSource(word[0]);
            wordPair.setWordTranslate(word[1]);
            wordPair.setCountOfGuessed(Integer.valueOf(word[2]));
            wordPair.setGuessed(Boolean.valueOf(word[3]));

            wordsForLearning.add(wordPair);

        }

        saveIndexesOfList(indexes);

        return wordsForLearning;
    }


    private int[] randomizer(int val, DAO dao) {

        /**
         *  Возможно сдесь проверять выучиное слово или нет !
         *  Если нет то генерировать другой индекс
         *  Или переносить их в другую таблицу
         */
        int[] randomNumbers = new int[val];

        for (int i = 0; i < val; i++) {
            int tmp = (int) Math.floor((Math.random() * (dao.size() - 1)) + 1);
            randomNumbers[i] = tmp;
        }

        return randomNumbers;

    }

    private void saveIndexesOfList(int[] indexes) {

        File file = new File("indexesOfQuiz.csv");
        String index = null;

        for (int i = 0; i < indexes.length; i++) {
            index = indexes[i] + ",";
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

            writer.write(index);

        } catch (IOException e) {

            System.err.println("File indexesOfQuiz.csv error: " + e);
        }
    }
}
