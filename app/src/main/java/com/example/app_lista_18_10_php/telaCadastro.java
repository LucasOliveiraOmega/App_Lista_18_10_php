package com.example.app_lista_18_10_php;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class telaCadastro extends AppCompatActivity {

    EditText edtNome, edtCurso, edtCidade, edtCpf, edtEmail, edtTelefone;
    Button btnCad, edtEditar, edtExcluir;
    Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
        edtCidade = findViewById(R.id.edtCidade);
        edtCurso = findViewById(R.id.edtCurso);
        edtNome = findViewById(R.id.edtNome);

        edtCpf = findViewById(R.id.edtCpf);
        edtEmail = findViewById(R.id.edtEmail);
        edtTelefone = findViewById(R.id.edtTelefone);

        btnCad = findViewById(R.id.btnCad);
        edtEditar = findViewById(R.id.edtEditar);
        edtExcluir = findViewById(R.id.edtExcluir);

        Intent it = getIntent();
        Bundle valor = (it != null) ? it.getExtras() : null;
        String op = (valor != null && valor.containsKey("op")) ? valor.getString("op") : "";

        bloquear();
        if ("1".equals(op)) {
            aluno = (Aluno) it.getSerializableExtra("aluno");

            if (aluno != null) {
                edtNome.setText(aluno.getNome());
                edtCurso.setText(aluno.getCurso());
                edtCidade.setText(aluno.getCidade());

                edtCpf.setText(aluno.getCpf());
                edtEmail.setText(aluno.getEmail());
                edtTelefone.setText(aluno.getTelefone());
            }

            desbloquear(1);
        } else {
            desbloquear(2);
        }

        btnCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Aluno obj = new Aluno();
                obj.setNome(edtNome.getText().toString());
                obj.setCidade(edtCidade.getText().toString());
                obj.setCurso(edtCurso.getText().toString());

                obj.setCpf(edtCpf.getText().toString());
                obj.setEmail(edtEmail.getText().toString());
                obj.setTelefone(edtTelefone.getText().toString());

                MainActivity.listaAlunos.add(obj);
                Toast.makeText(telaCadastro.this, "Aluno cadastrado com sucesso!", Toast.LENGTH_SHORT).show();

                finish();
            }
        });

        edtEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aluno != null && aluno.getId() >= 0 && aluno.getId() < MainActivity.listaAlunos.size()) {
                    Aluno obj = new Aluno();
                    obj.setId(aluno.getId());
                    obj.setNome(edtNome.getText().toString());
                    obj.setCidade(edtCidade.getText().toString());
                    obj.setCurso(edtCurso.getText().toString());

                    obj.setCpf(edtCpf.getText().toString());
                    obj.setEmail(edtEmail.getText().toString());
                    obj.setTelefone(edtTelefone.getText().toString());

                    MainActivity.listaAlunos.set(aluno.getId(), obj);
                    Toast.makeText(telaCadastro.this, "Aluno editado com sucesso!", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });

        edtExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aluno != null && aluno.getId() >= 0 && aluno.getId() < MainActivity.listaAlunos.size()) {
                    MainActivity.listaAlunos.remove(aluno.getId());
                    Toast.makeText(telaCadastro.this, "Aluno excluído com sucesso!", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
    }

    public void bloquear() {
        edtExcluir.setEnabled(false);
        edtEditar.setEnabled(false);
        btnCad.setEnabled(false);
    }

    public void desbloquear(int i) {
        if (i == 1) {
            edtExcluir.setEnabled(true);
            edtEditar.setEnabled(true);
        } else {
            btnCad.setEnabled(true);
        }
    }
}
