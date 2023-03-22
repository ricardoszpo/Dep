package com.example.carros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static carros carros;

    private Button btncadastro;
    private Button btncadastrados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btncadastro = findViewById(R.id.btncadastro);
        btncadastrados = findViewById(R.id.btncadastrados);

        btncadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l = new Intent(MainActivity.this, cadastro.class);
                startActivity(l);
            }
        });
        btncadastrados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l = new Intent(MainActivity.this, cadastrados.class);
                startActivity(l);
            }
        });
    }



}