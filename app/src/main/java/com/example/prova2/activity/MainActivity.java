package com.example.prova2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.prova2.R;
import com.example.prova2.databinding.ActivityMainBinding;
import com.example.prova2.tabelas.Tabelas;
import com.example.prova2.tabelas.Times;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*binding.btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarTime(binding.nomeTime.getText().toString());
            }
        });*/

    }

    public void salvarTime(String Nome){
        Tabelas db = Tabelas.getDbInstance(this.getApplicationContext());

        Times time = new Times();
        time.nome = Nome;

        db.userDao().insertUser(time);
    }

    public void loadListaTime(){
        Tabelas db = Tabelas.getDbInstance(this.getApplicationContext());
        List<Times> timesList = db.userDao().getAllUsers();
        binding.textNomes.setText(timesList.toString());
    }


}