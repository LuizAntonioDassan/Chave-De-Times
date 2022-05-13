package com.example.prova2.tabelas;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface JogadorDAO {

    @Query("SELECT * FROM Jogador")
    List<Jogador> getAllJogadores();

    @Insert
    void InsertJogador(Jogador jogador);

    @Delete
    void delete(Jogador jogador);

}
