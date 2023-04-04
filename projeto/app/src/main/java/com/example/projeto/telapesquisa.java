package com.example.projeto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class telapesquisa extends AppCompatActivity {
    static Cliente cliente;
    TextView pergunta;
    TextView pergunta2;
    TextView pergunta3;
    TextView pergunta4;
    private ImageButton regular;
    private ImageButton excelente;
    private ImageButton pessimo;
    ImageView e1, e2, e3, e4, r1, r2, r3, r4, p1, p2, p3, p4;
    static boolean avaliando = true;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telapesquisa);
        getSupportActionBar().hide();
        cliente.setAtendimento(5);
        cliente.setConhecimento(5);
        cliente.setInfraestrutura(5);
        cliente.setQualidadedoservico(5);
        pergunta = findViewById(R.id.pergunta);
        pergunta2 = findViewById(R.id.pergunta2);
        pergunta3 = findViewById(R.id.pergunta3);
        pergunta4 = findViewById(R.id.pergunta4);
        e1 = findViewById(R.id.excelente);
        e2 = findViewById(R.id.excelente2);
        e3 = findViewById(R.id.excelente3);
        e4 = findViewById(R.id.excelente4);
        r1 = findViewById(R.id.regular);
        r2 = findViewById(R.id.regular2);
        r3 = findViewById(R.id.regular3);
        r4 = findViewById(R.id.regular4);
        p1 = findViewById(R.id.pessimo);
        p2 = findViewById(R.id.pessimo2);
        p3 = findViewById(R.id.pessimo3);
        p4 = findViewById(R.id.pessimo4);
        excelente = findViewById(R.id.excelente);
        regular = findViewById(R.id.regular);
        pessimo = findViewById(R.id.pessimo);
        definePergunta();
    }


    public void definePergunta() { //define quais perguntas serão feitas aos clientes
        pergunta.setText("Atendimento:");
        pergunta2.setText("Infraestrutura:");
        pergunta3.setText("Qualidade do serviço:");
        pergunta4.setText("Conhecimento:");
        sugestoes.cliente = cliente;
    }

    public void excelente(View v) {
        if (cliente.getAtendimento() == 5) {
            cliente.setAtendimento(3);
            contador++;
            e1.setBackgroundResource(R.drawable.otimo);
            r1.setBackgroundResource(R.drawable.feito);
            p1.setBackgroundResource(R.drawable.feito);
            verificaavaliacoes();
        }
    }
    public void regular(View v) {
        if (cliente.getAtendimento() == 5) {
            cliente.setAtendimento(1);
            contador++;
            e1.setBackgroundResource(R.drawable.feito);
            r1.setBackgroundResource(R.drawable.mediano);
            p1.setBackgroundResource(R.drawable.feito);
            verificaavaliacoes();
        }
    }
    public void pessimo(View v) {
        if (cliente.getAtendimento() == 5) {
            cliente.setAtendimento(0);
            contador++;
            e1.setBackgroundResource(R.drawable.feito);
            r1.setBackgroundResource(R.drawable.feito);
            p1.setBackgroundResource(R.drawable.pessimo);
            verificaavaliacoes();
        }
    }
    public void excelente2(View v) {
        if (cliente.getInfraestrutura() == 5) {
            cliente.setInfraestrutura(3);
            contador++;
            e2.setBackgroundResource(R.drawable.otimo);
            r2.setBackgroundResource(R.drawable.feito);
            p2.setBackgroundResource(R.drawable.feito);
            verificaavaliacoes();
        }
    }
    public void regular2(View v) {
        if (cliente.getInfraestrutura() == 5) {
            cliente.setInfraestrutura(1);
            contador++;
            e2.setBackgroundResource(R.drawable.feito);
            r2.setBackgroundResource(R.drawable.mediano);
            p2.setBackgroundResource(R.drawable.feito);
            verificaavaliacoes();
        }
    }
    public void pessimo2(View v) {
        if (cliente.getInfraestrutura() == 5) {
            cliente.setInfraestrutura(0);
            contador++;
            e2.setBackgroundResource(R.drawable.feito);
            r2.setBackgroundResource(R.drawable.feito);
            p2.setBackgroundResource(R.drawable.pessimo);
            verificaavaliacoes();
        }
    }
    public void excelente3(View v) {
        if (cliente.getQualidadedoservico() == 5) {
            cliente.setQualidadedoservico(3);
            contador++;
            e3.setBackgroundResource(R.drawable.otimo);
            r3.setBackgroundResource(R.drawable.feito);
            p3.setBackgroundResource(R.drawable.feito);
            verificaavaliacoes();
        }
    }
    public void regular3(View v) {
        if (cliente.getQualidadedoservico() == 5) {
            cliente.setQualidadedoservico(1);
            contador++;
            e3.setBackgroundResource(R.drawable.feito);
            r3.setBackgroundResource(R.drawable.mediano);
            p3.setBackgroundResource(R.drawable.feito);
            verificaavaliacoes();
        }
    }
    public void pessimo3(View v) {
        if (cliente.getQualidadedoservico() == 5) {
            cliente.setQualidadedoservico(0);
            contador++;
            e3.setBackgroundResource(R.drawable.feito);
            r3.setBackgroundResource(R.drawable.feito);
            p3.setBackgroundResource(R.drawable.pessimo);
            verificaavaliacoes();
        }
    }
    public void execelente4(View v) {
        if (cliente.getConhecimento() == 5) {
            cliente.setConhecimento(3);
            contador++;
            e4.setBackgroundResource(R.drawable.otimo);
            r4.setBackgroundResource(R.drawable.feito);
            p4.setBackgroundResource(R.drawable.feito);
            verificaavaliacoes();
        }
    }
    public void regular4(View v) {
        if (cliente.getConhecimento() == 5) {
            cliente.setConhecimento(1);
            contador++;
            e4.setBackgroundResource(R.drawable.feito);
            r4.setBackgroundResource(R.drawable.mediano);
            p4.setBackgroundResource(R.drawable.feito);
            verificaavaliacoes();
        }
    }
    public void pessimo4(View v) {
        if (cliente.getConhecimento() == 5) {
            cliente.setConhecimento(0);
            contador++;
            e4.setBackgroundResource(R.drawable.feito);
            r4.setBackgroundResource(R.drawable.feito);
            p4.setBackgroundResource(R.drawable.pessimo);
            verificaavaliacoes();
        }
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
    public void onBackPressed() {
        String mensagem = "<h1><big>Você precisa finalizar a pesquisa</big></h1>";
        Toast toast = Toast.makeText(this, HtmlCompat.fromHtml(mensagem, HtmlCompat.FROM_HTML_MODE_COMPACT), Toast.LENGTH_LONG);
        toast.getView().setBackgroundColor(Color.RED);
        toast.show();
    }

    public void verificaavaliacoes() {
        if (contador >= 4) {
            sugestoes.cliente = cliente;
            Intent i = new Intent(this, sugestoes.class);
            startActivity(i);
        }
    }
}