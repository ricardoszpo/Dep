package com.example.projeto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class sugestoes extends AppCompatActivity {
    static Cliente cliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugestoes);
        getSupportActionBar().hide();
    }

    public void enviarsugestao() {
            String sugestao = sugestao.getText().toString();
    }

    @Override
    public void onBackPressed() {
        String mensagem = "<h1><big>Você precisa finalizar a pesquisa</big></h1>";
        Toast toast = Toast.makeText(this, HtmlCompat.fromHtml(mensagem, HtmlCompat.FROM_HTML_MODE_COMPACT), Toast.LENGTH_LONG);
        toast.getView().setBackgroundColor(Color.GREEN);
        toast.show();
    }
}