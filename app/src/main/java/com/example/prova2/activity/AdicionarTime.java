package com.example.prova2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.prova2.R;
import com.example.prova2.databinding.ActivityAdicionarTimeBinding;
import com.example.prova2.databinding.ActivityMainBinding;
import com.example.prova2.tabelas.Tabelas;
import com.example.prova2.tabelas.Times;

public class AdicionarTime extends AppCompatActivity {

    private ActivityAdicionarTimeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdicionarTimeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnSalvarTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.nomeTime.getText().toString() != null &&
                        binding.nomeTime.getText().toString() != "")
                {
                    salvarTime(binding.nomeTime.getText().toString());
                }else {
                    Toast.makeText(AdicionarTime.this, "Insira um Nome", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void salvarTime(String Nome){
        Tabelas db = Tabelas.getDbInstance(this.getApplicationContext());
        Log.i("Teste", Nome);
        Times time = new Times();
        time.setNome(Nome);

        db.userDao().insertUser(time);

        finish();
    }
}