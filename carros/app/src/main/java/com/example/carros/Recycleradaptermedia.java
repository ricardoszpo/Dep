package com.example.carros;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class Recycleradaptermedia extends RecyclerView.Adapter<Recycleradaptermedia.MyviewHolder> {
    Context context;
    ArrayList<carros> lista;
    Recycleradaptermedia.OnItemClickListener listener;

    public Recycleradaptermedia(Context context, ArrayList<carros> lista, OnItemClickListener listener) {
        this.context = context;
        this.lista = lista;
        this.listener = listener;
    }

    @NonNull
    @Override
    public Recycleradaptermedia.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layoutmedia,parent,false);
        return new Recycleradaptermedia.MyviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Recycleradaptermedia.MyviewHolder holder, int position) {
        carros c = lista.get(position);
        holder.marcaS.setText(c.getmarca());
        holder.precoS.setText(c.getpreco());
        holder.itemView.setOnClickListener(view ->{
            listener.onItemClick(c);
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView marcaS, precoS;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            marcaS = itemView.findViewById(R.id.marcaS);
            precoS = itemView.findViewById(R.id.precoS);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(carros c);
    }
}
