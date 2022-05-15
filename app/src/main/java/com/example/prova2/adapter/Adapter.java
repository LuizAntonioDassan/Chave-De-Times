package com.example.prova2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prova2.R;
import com.example.prova2.databinding.RecyclerBinding;
import com.example.prova2.tabelas.Jogador;
import com.example.prova2.tabelas.Times;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context context;
    private List<Times> timesList;
    private List<Jogador> jogadorList;

    public Adapter(Context context){
        this.context = context;
    }

    public void setTimesList(List<Jogador> jogadorList){
        this.jogadorList = jogadorList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nomeJogador.setText(this.jogadorList.get(position).getNome());
        holder.nomeTime.setText(this.jogadorList.get(position).getNomeTimeJogador());
    }

    @Override
    public int getItemCount() {
        return jogadorList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nomeTime;
        TextView nomeJogador;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeTime = itemView.findViewById(R.id.NomeTimeTexto);
            nomeJogador = itemView.findViewById(R.id.NomeJogador);

        }
    }
}
