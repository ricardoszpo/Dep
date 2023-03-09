package com.example.projeto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class demonstrativo extends AppCompatActivity {
    static ArrayList<Cliente> lista;
    TextView contador, atendimento, infra, qualidade, conhecimento, geral;
    int quantidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demonstrativo);
        getSupportActionBar().hide();
        contador = findViewById(R.id.cont);
        atendimento = findViewById(R.id.mdatendimento);
        conhecimento = findViewById(R.id.mdconhecimento);
        infra = findViewById(R.id.mdinfraestrutura);
        qualidade = findViewById(R.id.mdqualidadedoservico);
        geral = findViewById(R.id.mediageral);
        quantidade = lista.size();
        contador.setText("Total de " + quantidade + " clientes fizeram a avaliação");
        fazmedias();
    }

    public void fazmedias() {
        double mediaatendimento = 0;
        double mediainfra = 0;
        double mediaqualidade = 0;
        double mediaconhecimento = 0;
        double mediageral = 0;
        for (Cliente c : lista) {
            mediaatendimento += c.getAtendimento();
            mediainfra += c.getInfraestrutura();
            mediaqualidade += c.getQualidadedoservico();
            mediaconhecimento += c.getConhecimento();
        }
        mediaatendimento /= quantidade;
        mediainfra /= quantidade;
        mediaqualidade /= quantidade;
        mediaconhecimento /= quantidade;
        mediageral = (mediaatendimento+mediainfra+mediaconhecimento+mediaqualidade)/4.0;
        atendimento.setText("Média de atendimento: " +String.format("%.2f",mediaatendimento));
        infra.setText("Média da infraestrutura: " +String.format("%.2f",mediainfra));
        qualidade.setText("Média de qualidade de serviço: " +String.format("%.2f",mediaqualidade));
        conhecimento.setText("Média do conhecimento: " +String.format("%.2f",mediaconhecimento));
        geral.setText("Média geral da loja: " +String.format("%.2f",mediageral));
    }
}