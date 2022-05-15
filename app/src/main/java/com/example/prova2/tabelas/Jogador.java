package com.example.prova2.tabelas;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Times.class,
parentColumns = "idTime", childColumns = "idTime"))
public class Jogador {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int idTime;
    private String nome;
    private String cpf;
    private int anoNascimento;
    private String nomeTimeJogador;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getNomeTimeJogador() {
        return nomeTimeJogador;
    }

    public void setNomeTimeJogador(String nomeTimeJogador) {
        this.nomeTimeJogador = nomeTimeJogador;
    }
}
