package com.example.prova2.tabelas;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.sql.Time;
import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM Times")
    List<Times> getAllUsers();

    @Insert
    void insertUser(Times... times);

    @Delete
    void delete(Times times);



}
