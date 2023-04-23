package com.lQuiz.DAO;

import java.util.List;

public interface DAO {
    boolean create(String pair);

    String read(int index);

    boolean updateAll(List<String> updateOfList);

    boolean delete(int index);

    int size();
}
