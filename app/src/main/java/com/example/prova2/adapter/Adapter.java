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
import com.example.prova2.tabelas.Times;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context context;
    private List<Times> timesList;

    public Adapter(Context context){
        this.context = context;
    }

    public void setTimesList(List<Times> timesList){
        this.timesList = timesList;
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
        holder.nome.setText(this.timesList.get(position).getNome());
    }

    @Override
    public int getItemCount() {
        return timesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nome;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.NomeTimeTexto);

        }
    }
}
