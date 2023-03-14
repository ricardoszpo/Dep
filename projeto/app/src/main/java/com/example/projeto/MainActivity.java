package com.example.projeto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText nome, telefone, placa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        nome = findViewById(R.id.nome);
        telefone = findViewById(R.id.telefone);
        placa = findViewById(R.id.placa);
        limpar();
    }

    public void limpar() {
        nome.setText("");
        telefone.setText("");
        placa.setText("");
    }

    public void proximo(View view) {
        String n = nome.getText().toString();
        String t = telefone.getText().toString();
        String p = placa.getText().toString();
        if (n.equals("admin") && t.equals("0000") && p.equals("abc1234")) {
            Intent i = new Intent(this, demonstrativo.class);
            startActivity(i);
            limpar();
        } else if (!p.equals("")) {
            Cliente c = new Cliente(p, n, t);
            Intent i = new Intent(this, telapesquisa.class);
            startActivity(i);
            telapesquisa.cliente = c;
            limpar();
        } else {
            String mensagem = "<h1><big>O campo placa é obrigatório</big></h1>";
            Toast toast = Toast.makeText(this, HtmlCompat.fromHtml(mensagem, HtmlCompat.FROM_HTML_MODE_COMPACT), Toast.LENGTH_LONG);
            toast.getView().setBackgroundColor(Color.GREEN);
            toast.show();

        }

    }
}