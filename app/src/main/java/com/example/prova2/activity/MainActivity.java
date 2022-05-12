package com.example.prova2.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.prova2.R;
import com.example.prova2.adapter.Adapter;
import com.example.prova2.databinding.ActivityMainBinding;
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

        String nomeTime = binding.editNomeTime.getEditText().toString();

        if(nomeTime != null){
            binding.btnAdicionar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    salvarTime(nomeTime);
                    Log.i("Teste", "Aqui Passou 1");
                }
            });
        }

        reciclaNomeInit();
        loadListaTime();
    }

    private void reciclaNomeInit(){
        binding.reciclaTimes.setLayoutManager(new LinearLayoutManager(this));
        binding.reciclaTimes.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new Adapter(this);
        binding.reciclaTimes.setAdapter(adapter);
    }

    public void salvarTime(String Nome){
        Tabelas db = Tabelas.getDbInstance(this.getApplicationContext());

        Times time = new Times();
        time.setNome(Nome);

        db.userDao().insertUser(time);

        recreate();
    }

    public void loadListaTime(){
        Tabelas db = Tabelas.getDbInstance(this.getApplicationContext());
        List<Times> timesList = db.userDao().getAllUsers();

        adapter.setTimesList(timesList);

    }


}