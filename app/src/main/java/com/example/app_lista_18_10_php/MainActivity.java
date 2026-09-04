package com.example.app_lista_18_10_php;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //objeto onde os dados são mostrados na tela
    ListView lstDados;


    /*
    onde os dados serão armazenados
    Objeto estático que poderá ser acessado de todas as classes do projeto
     */
    public static ArrayList<Aluno> listaAlunos = new ArrayList<>();

    //Realiza a configuração dos dados na listview
    ArrayAdapter<Aluno> adapterAlunos;

    Aluno objAluno = new Aluno();

    Button btnCadastro, btnBuscar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBuscar = findViewById(R.id.btnBuscar);

        btnCadastro = findViewById(R.id.btnCadastro);

        lstDados = findViewById(R.id.lstDados);
        //preencheLista()


        lstDados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long l) {
                objAluno = listaAlunos.get(posicao);
                Intent it = new Intent(MainActivity.this, telaCadastro.class);
                objAluno.setId(posicao);
                it.putExtra("aluno", objAluno);
                it.putExtra("op", "1"); //Enviando objeto aluno com nome OP pra ser programado caso OP for recebido na outra tela
                startActivity(it);
            }
        });

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, telaCadastro.class);
                it.putExtra("op", "2");
                startActivity(it);
            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, telaConsulta.class);
                startActivity(it);
            }
        });
    }

    public void preencheLista(){
        adapterAlunos=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,listaAlunos);
        lstDados.setAdapter(adapterAlunos); // Pegando os modelos e parâmetros da linha acima, e relacionando adapterAlunos a lstDados
    }

    @Override
    protected void onResume() {
        super.onResume();
        preencheLista();
    }
}