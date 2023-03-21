package com.example.projeto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recycleradapter extends RecyclerView.Adapter<Recycleradapter.MyviewHolder> {
    Context context;
    ArrayList<Cliente> lista;
    Recycleradapter.OnItemClickListener listener;

    public Recycleradapter(Context context, ArrayList<Cliente> lista, OnItemClickListener listener) {
        this.context = context;
        this.lista = lista;
        this.listener = listener;
    }

    @NonNull
    @Override
    public Recycleradapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layoutsugestoes,parent,false);
        return new Recycleradapter.MyviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Recycleradapter.MyviewHolder holder, int position) {
        Cliente c = lista.get(position);
        holder.placa.setText(c.getPlaca());
        holder.texto.setText(c.getSugestoes());
        holder.itemView.setOnClickListener(view ->{
            listener.onItemClick(c);
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView placa, texto;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            placa = itemView.findViewById(R.id.placaS);
            texto = itemView.findViewById(R.id.texto);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Cliente c);
    }
}
