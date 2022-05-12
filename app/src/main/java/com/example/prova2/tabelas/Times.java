package com.example.prova2.tabelas;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Times {

    @PrimaryKey(autoGenerate = true)
    public int idTime;

    @ColumnInfo(name = "Nome_Time")
    public String nome;

    public int getIdTime() {
        return idTime;
    }

    public void setIdTime(int idTime) {
        this.idTime = idTime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
