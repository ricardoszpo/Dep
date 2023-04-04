package com.example.projeto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText placa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        placa = findViewById(R.id.placa);
        limpar();
    }

    public void limpar() { //limpa todas as caixas de texto apos serem usadas
        placa.setText("");
    }

    public void proximo(View view) {
        String p = placa.getText().toString();
        if (p.equals("")) { //senha para entrar na parte das notas e sugestoes do app
            Intent i = new Intent(this, demonstrativo.class);
            startActivity(i);
            limpar();
        } else if (!p.equals("")) {
            int m = LocalDateTime.now().getMonthValue();
            int a = LocalDateTime.now().getYear();
            Cliente c = new Cliente(p, m, a);
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