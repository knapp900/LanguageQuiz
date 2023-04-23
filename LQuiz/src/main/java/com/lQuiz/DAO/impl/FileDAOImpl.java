package com.lQuiz.DAO.impl;

import com.lQuiz.DAO.DAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDAOImpl implements DAO {

    private static final FileDAOImpl instance = new FileDAOImpl();

    private FileDAOImpl(){}

    public static FileDAOImpl getInstance(){
        return instance;
    }
    private final File file = new File("D:\\Учеба\\Java\\Git\\LQuiz\\src\\main\\resources\\wordsOfQuiz.txt");

    @Override
    public boolean create(String pair) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {

            writer.write(pair);

            return true;

        } catch (IOException e) {

            return false;
        }
    }

    @Override
    public String read(int index) {
        if (index <= size()) {
            String tmp = "";

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

                for (int i = 0; i < index; i++) {
                    tmp = reader.readLine().toString();
                }

                return tmp;

            } catch (IOException e) {
                System.err.println("Read " + e);
                return "";
            }
        }
        return "";
    }

    @Override
    public boolean updateAll(List<String> updateOfList) {
        file.delete();

        for (String s:updateOfList) {
            create(s);
        }
        return true;
    }

    @Override
    public boolean delete(int index) {

        List<String> tmpList = new ArrayList<>();
        String deletedString;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            while (reader.ready()) {
                tmpList.add(reader.readLine());
            }

        } catch (IOException e) {

        }
        deletedString = tmpList.get(index - 1);

        file.delete();

        for (String s : tmpList) {
            if (!s.equals(deletedString))
                create(s + '\n');
        }
        return true;
    }

    @Override
    public int size() {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            do {

                reader.readLine();
                count++;

            } while (reader.ready());

            return count;

        } catch (IOException e) {

            return 0;
        }

    }
}
