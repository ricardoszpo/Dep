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

public class sugestoes extends AppCompatActivity {
    static Cliente cliente;
    EditText campo;
    EditText nome;
    EditText telefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugestoes);
        getSupportActionBar().hide();
        nome = findViewById(R.id.nome);
        telefone = findViewById(R.id.telefone);
        campo = findViewById(R.id.sugestao);
        limpar();
    }

    @Override
    public void onBackPressed() {
        String mensagem = "<h1><big>Você precisa finalizar a pesquisa</big></h1>";
        Toast toast = Toast.makeText(this, HtmlCompat.fromHtml(mensagem, HtmlCompat.FROM_HTML_MODE_COMPACT), Toast.LENGTH_LONG);
        toast.getView().setBackgroundColor(Color.GREEN);
        toast.show();
    }
    public void limpar() {
        nome.setText("");
        telefone.setText("");
        campo.setText("");
    }

    public void envia(View v) {
        String texto = campo.getText().toString();
        cliente.setSugestoes(texto);
        cliente.setNome(nome.getText().toString());
        cliente.setTelefone(telefone.getText().toString());
        campo.setText("");
        cliente.salvar();
        telapesquisa.avaliando = false;
        super.onBackPressed();
        limpar();
    }
}