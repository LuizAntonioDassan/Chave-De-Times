package com.example.prova2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.prova2.R;
import com.example.prova2.databinding.ActivityAdicionarJogadorBinding;
import com.example.prova2.databinding.SpinnerRowBinding;
import com.example.prova2.tabelas.Jogador;
import com.example.prova2.tabelas.Tabelas;
import com.example.prova2.tabelas.Times;

import java.util.List;

public class AdicionarJogador extends AppCompatActivity {

    private ActivityAdicionarJogadorBinding binding;
    private Times timeSelecionado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdicionarJogadorBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        carregaListaTimes();
        createSpinner();

        Tabelas db = Tabelas.getDbInstance(this.getApplicationContext());
        List<Times> times = db.userDao().getAllTimes();

        binding.spinnerTimes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                timeSelecionado = times.get(position);
                Log.i("Teste1" , times.get(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.btnSalvarJogador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarJogador(binding.nomeJogador.getText().toString(),
                        binding.cpf.getText().toString(),
                        binding.anoNascimento.getId());
            }
        });
    }

    private void carregaListaTimes() {

        Tabelas db = Tabelas.getDbInstance(this.getApplicationContext());
        List<Times> timesList = db.userDao().getAllTimes();

    }

    public void salvarJogador(String Nome, String CPF, int data){
        Tabelas db = Tabelas.getDbInstance(this.getApplicationContext());
        Log.i("Teste", CPF);

        Jogador jogador = new Jogador();
        jogador.setCpf(CPF);
        jogador.setNome(Nome);
        jogador.setAnoNascimento(data);
        jogador.setIdTime(timeSelecionado.getIdTime());



        db.jogadorDao().InsertJogador(jogador);

        finish();
    }
    public void createSpinner(){
        Tabelas db = Tabelas.getDbInstance(this.getApplicationContext());
        List<Times> times = db.userDao().getAllTimes();

        ArrayAdapter<Times> timesArrayAdapter = new ArrayAdapter<Times>(this, android.R.layout.simple_spinner_item, times);
        binding.spinnerTimes.setAdapter(timesArrayAdapter);



      /*  BaseAdapter spinnerAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return times.size();
            }

            @Override
            public Object getItem(int i) {
                return times.get(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                View contentView = view;

                if(contentView == null){
                    contentView = getLayoutInflater().inflate(R.layout.spinner_row,viewGroup,false);

                }else{

                }
                spinnerRowBinding.nomeDoTime.setText(times.get(i).getNome());

                return contentView;
            }
        };

        binding.spinnerTimes.setAdapter(spinnerAdapter);*/

    }
}