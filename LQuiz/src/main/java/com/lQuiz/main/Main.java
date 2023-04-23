package com.lQuiz.main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lQuiz.DAO.DAO;
import com.lQuiz.DAO.impl.FileDAOImpl;
import com.lQuiz.entity.WordPair;
import com.lQuiz.entity.WordsAnswers;
import com.lQuiz.entity.WordsQueue;
import com.lQuiz.serves.QuizInput;
import com.lQuiz.serves.impl.LearningQuizService;
import com.lQuiz.serves.impl.RepetitionQuizService;

public class Main {

    static List<WordPair> pairStorage = new ArrayList<>();
    static List<String> destinationList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        DAO dao = FileDAOImpl.getInstance();
        WordsQueue queue = new WordsQueue();
        WordsAnswers answers = new WordsAnswers();
        LearningQuizService learning = new LearningQuizService();
        RepetitionQuizService repetition = new RepetitionQuizService();
        System.out.println( learning.getListWordsForLearning(10,dao));
        Scanner scanner = new Scanner(System.in);

        repetition.init(dao,queue,answers);

        while (true){

            repetition.start(queue,answers,scanner.nextLine());

        }




    }

    private static void updateListPairs() throws IOException {
        int counter = 0;
        File file = new File("D:\\Учеба\\Java\\Git\\LQuiz\\src\\main\\resources\\words.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));

        while (reader.ready()) {
            counter++;
            String wordPair = reader.readLine();
            String[] words = wordPair.split("-");
            WordPair pair = new WordPair();
            pair.setWordSource(words[0]);
            pair.setWordTranslate(words[1]);
            pair.setCountOfGuessed(0);
            pair.setGuessed(false);
            pairStorage.add(pair);
        }

        reader.close();

    }
}
