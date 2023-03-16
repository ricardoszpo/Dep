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
    int numPergunta = 1;
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
        definePergunta();
    }


    public void definePergunta() { //define quais perguntas serão feitas aos clientes
        if (numPergunta == 1) {
            pergunta.setText("Avalie nosso atendimento");
        } else if (numPergunta == 2) {
            pergunta.setText("Avalie nossa infraestrutura");
        } else if (numPergunta == 3) {
            pergunta.setText("Avalie nossa qualidade do serviço");
        } else if (numPergunta == 4) {
            pergunta.setText("Avalie o nosso grau de conhecimento");
        } else {
            sugestoes.cliente = cliente;
            Intent i = new Intent(this, sugestoes.class);
            startActivity(i);

        }
    }

    public void excelente(View v) { //valor das perguntas
        if (numPergunta == 1) {
            cliente.atendimento += 5;
        } else if (numPergunta == 2) {
            cliente.infraestrutura += 5;
        } else if (numPergunta == 3) {
            cliente.qualidadedoservico += 5;
        } else if (numPergunta == 4) {
            cliente.conhecimento += 5;
        }
        numPergunta++;
        definePergunta();
    }

    public void bom(View v) {
        if (numPergunta == 1) {
            cliente.atendimento += 4;
        } else if (numPergunta == 2) {
            cliente.infraestrutura += 4;
        } else if (numPergunta == 3) {
            cliente.qualidadedoservico += 4;
        } else if (numPergunta == 4) {
            cliente.conhecimento += 4;
        }
        numPergunta++;
        definePergunta();
    }

    public void regular(View v) {
        if (numPergunta == 1) {
            cliente.atendimento += 3;
        } else if (numPergunta == 2) {
            cliente.infraestrutura += 3;
        } else if (numPergunta == 3) {
            cliente.qualidadedoservico += 3;
        } else if (numPergunta == 4) {
            cliente.conhecimento += 3;
        }
        numPergunta++;
        definePergunta();
    }

    public void ruim(View v) {
        if (numPergunta == 1) {
            cliente.atendimento += 2;
        } else if (numPergunta == 2) {
            cliente.infraestrutura += 2;
        } else if (numPergunta == 3) {
            cliente.qualidadedoservico += 2;
        } else if (numPergunta == 4) {
            cliente.conhecimento += 2;
        }
        numPergunta++;
        definePergunta();
    }

    public void pessimo(View v) {

        numPergunta++;
        definePergunta();
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
            toast.getView().setBackgroundColor(Color.GREEN);
            toast.show();
        }
    }