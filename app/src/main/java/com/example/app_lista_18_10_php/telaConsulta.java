package com.example.app_lista_18_10_php;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class telaConsulta extends AppCompatActivity {

    EditText edtLocalizar;
    Button btnLocalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_consulta);

        edtLocalizar = findViewById(R.id.edtLocalizar);
        btnLocalizar = findViewById(R.id.btnLocalizar);

        btnLocalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeBusca = edtLocalizar.getText().toString().trim();

                if (nomeBusca.isEmpty()) {
                    Toast.makeText(telaConsulta.this, "Digite um nome para localizar!", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean encontrado = false;
                for (int i = 0; i < MainActivity.listaAlunos.size(); i++) {
                    Aluno aluno = MainActivity.listaAlunos.get(i);
                    if (aluno.getNome() != null && aluno.getNome().equalsIgnoreCase(nomeBusca)) {
                        aluno.setId(i);
                        Intent it = new Intent(telaConsulta.this, telaCadastro.class);
                        it.putExtra("aluno", aluno);
                        it.putExtra("op", "1");
                        startActivity(it);
                        Toast.makeText(telaConsulta.this, "Aluno encontrado: " + aluno.getNome(), Toast.LENGTH_SHORT).show();
                        encontrado = true;
                        finish();
                        break;
                    }
                }

                if (!encontrado) {
                    // Tenta busca parcial caso a busca exata não encontre nada
                    for (int i = 0; i < MainActivity.listaAlunos.size(); i++) {
                        Aluno aluno = MainActivity.listaAlunos.get(i);
                        if (aluno.getNome() != null && aluno.getNome().toLowerCase().contains(nomeBusca.toLowerCase())) {
                            aluno.setId(i);
                            Intent it = new Intent(telaConsulta.this, telaCadastro.class);
                            it.putExtra("aluno", aluno);
                            it.putExtra("op", "1");
                            startActivity(it);
                            Toast.makeText(telaConsulta.this, "Aluno encontrado: " + aluno.getNome(), Toast.LENGTH_SHORT).show();
                            encontrado = true;
                            finish();
                            break;
                        }
                    }
                }

                if (!encontrado) {
                    Toast.makeText(telaConsulta.this, "Aluno não encontrado!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}