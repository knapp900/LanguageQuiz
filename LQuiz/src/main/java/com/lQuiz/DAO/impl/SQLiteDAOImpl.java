package com.lQuiz.DAO.impl;

import com.lQuiz.DAO.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class SQLiteDAOImpl implements DAO {

    private static final SQLiteDAOImpl instance = new SQLiteDAOImpl();

    private SQLiteDAOImpl(){}

    public static SQLiteDAOImpl getInstance(){
        return instance;
    }
    public void connect(){
        Connection connection = null;
        try{
            Class.forName("SQLite.JDBCDriver").newInstance();
            String url = "jdbc:sqlite:words.db";
            connection = DriverManager.getConnection(url);
            System.out.println("SQLiteDAOImpl connected!");

        }catch (SQLException e){
            System.out.println("SQLiteDAOImpl error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean create(String pair) {
        return false;
    }

    @Override
    public String read(int index) {
        return null;
    }

    @Override
    public boolean updateAll(List<String> updateOfList) {
        return false;
    }

    @Override
    public boolean delete(int index) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
