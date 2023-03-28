package com.example.carros;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recycleraptertodos extends RecyclerView.Adapter<Recycleraptertodos.MyviewHolder> {
    Context context;
    ArrayList<Carro> lista;
    Recycleraptertodos.OnItemClickListener listener;

    public Recycleraptertodos(Context context, ArrayList<Carro> lista, OnItemClickListener listener) {
        this.context = context;
        this.lista = lista;
        this.listener = listener;
    }

    @NonNull
    @Override
    public Recycleraptertodos.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layouttodos,parent,false);
        return new Recycleraptertodos.MyviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Recycleraptertodos.MyviewHolder holder, int position) {
        Carro c = lista.get(position);
        holder.marcaT.setText(c.getmarca());
        holder.modeloT.setText(c.getModelo());
        holder.anoT.setText(c.getAno());
        holder.placaT.setText(c.getPlaca());
        holder.precoT.setText(c.getpreco());
        holder.itemView.setOnClickListener(view ->{
            listener.onItemClick(c);
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView marcaT, modeloT, anoT, placaT, precoT;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            marcaT = itemView.findViewById(R.id.marcaT);
            modeloT = itemView.findViewById(R.id.modeloT);
            anoT = itemView.findViewById(R.id.anoT);
            placaT = itemView.findViewById(R.id.placaT);
            precoT = itemView.findViewById(R.id.precoT);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Carro c);
    }
}
