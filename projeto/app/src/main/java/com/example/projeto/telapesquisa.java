package com.example.projeto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class telapesquisa extends AppCompatActivity {
    static Cliente cliente;
    TextView pergunta;
    TextView pergunta2;
    TextView pergunta3;
    TextView pergunta4;
    static boolean avaliando = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telapesquisa);
        getSupportActionBar().hide();
        cliente.setAtendimento(0);
        cliente.setConhecimento(0);
        cliente.setInfraestrutura(0);
        cliente.setQualidadedoservico(0);
        pergunta = findViewById(R.id.pergunta);
        pergunta2 = findViewById(R.id.pergunta2);
        pergunta3 = findViewById(R.id.pergunta3);
        pergunta4 = findViewById(R.id.pergunta4);
        definePergunta();
    }


    public void definePergunta() { //define quais perguntas serão feitas aos clientes
            pergunta.setText("Atendimento");
            pergunta2.setText("Avalie nossa infraestrutura");
            pergunta3.setText("Avalie nossa qualidade do serviço");
            pergunta4.setText("Avalie o nosso grau de conhecimento");
            sugestoes.cliente = cliente;
//            Intent i = new Intent(this, sugestoes.class);
//            startActivity(i);

        }


    @Override
    protected void onStart() {
        super.onStart();
        if (!avaliando) {
            avaliando = true;
            super.onBackPressed();
        }
    }

        @Override
        public void onBackPressed () {
            String mensagem = "<h1><big>Você precisa finalizar a pesquisa</big></h1>";
            Toast toast = Toast.makeText(this, HtmlCompat.fromHtml(mensagem, HtmlCompat.FROM_HTML_MODE_COMPACT), Toast.LENGTH_LONG);
            toast.getView().setBackgroundColor(Color.RED);
            toast.show();
        }
    }