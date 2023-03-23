package com.example.carros;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class carros {
    String marca, placa, ano, preco, modelo;

    public carros(String placa, String marca, String ano, String preco, String modelo) {
        this.marca = marca;
        this.placa = placa;
        this.ano = ano;
        this.preco = preco;
        this.modelo = modelo;
    }

    public String getmarca() {
        return marca;
    }

    public void setmarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getpreco() {
        return preco;
    }

    public void setpreco(String preco) {
        this.preco = preco;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public carros() {

    }
    public void salvar() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        reference.child("Carros").child(placa).setValue(this);
    }
}
