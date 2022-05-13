package com.example.prova2.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.prova2.R;
import com.example.prova2.adapter.Adapter;
import com.example.prova2.databinding.ActivityMainBinding;
import com.example.prova2.tabelas.Jogador;
import com.example.prova2.tabelas.Tabelas;
import com.example.prova2.tabelas.Times;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.btnAdicionarTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AdicionarTime.class));
            }
        });

        binding.btnAdicionarJogador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AdicionarJogador.class));
            }
        });

        reciclaNomeInit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadListaTime();
    }

    private void reciclaNomeInit(){
        binding.reciclaTimes.setLayoutManager(new LinearLayoutManager(this));
        binding.reciclaTimes.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new Adapter(this);
        binding.reciclaTimes.setAdapter(adapter);
    }

    public void loadListaTime(){
        Tabelas db = Tabelas.getDbInstance(this.getApplicationContext());
        List<Times> timesList = db.userDao().getAllUsers();
        List<Jogador> jogadorList = db.jogadorDao().getAllJogadores();

        adapter.setTimesList(jogadorList);

    }


}