package com.example.prova2.tabelas;


import android.content.Context;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Times.class, Jogador.class}, version = 1)
public abstract class Tabelas extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract JogadorDAO jogadorDao();

    private static Tabelas INSTANCE;

    public static Tabelas getDbInstance(Context context){

        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), Tabelas.class, "DB_TIMES")
                    .allowMainThreadQueries()
                    .build();

        }
        return INSTANCE;

    }

}
