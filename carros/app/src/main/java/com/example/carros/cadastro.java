package com.example.carros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class cadastro extends AppCompatActivity {
    EditText ano, marca, placa, modelo, preco;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().hide();
        marca = findViewById(R.id.marca);
        ano = findViewById(R.id.ano);
        placa = findViewById(R.id.placa);
        modelo = findViewById(R.id.modelo);
        preco = findViewById(R.id.preco);
        limpar();

    }

    public void limpar() {
        marca.setText("");
        placa.setText("");
        ano.setText("");
        modelo.setText("");
        preco.setText("");
    }

    public void proximo(View view) {
        String m = marca.getText().toString();
        String p = placa.getText().toString();
        String a = ano.getText().toString();
        String o = modelo.getText().toString();
        String r = preco.getText().toString();
        limpar();

        if (!p.equals("")) {
            Carro c = new Carro(p, m, a, o, r);
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            c.salvar();
            limpar();
        } else {
            String mensagem = "<h1><big>Preencha todos corretamente</big></h1>";
            Toast toast = Toast.makeText(this, HtmlCompat.fromHtml(mensagem, HtmlCompat.FROM_HTML_MODE_COMPACT), Toast.LENGTH_LONG);
            toast.getView().setBackgroundColor(Color.GREEN);
            toast.show();

        }

        }
    }
    

