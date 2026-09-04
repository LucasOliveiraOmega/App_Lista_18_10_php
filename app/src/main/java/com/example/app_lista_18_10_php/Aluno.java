package com.example.app_lista_18_10_php;

import java.io.Serializable;

public class Aluno implements Serializable {


        private String nome;

        private String cidade;

        private String curso;

        private String cpf;

        private String email;

        private String telefone;

        private int id;

        // public void getNome(String nome) { this.nome = nome;}



        public String getNome() {
                return nome;
        }

        public String getCidade() {
                return cidade;
        }

        public String getCurso() {
                return curso;
        }

        public String getCpf() {
                return cpf;
        }

        public String getEmail() {
                return email;
        }

        public String getTelefone() {
                return telefone;
        }


        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public void setCidade(String cidade) {
                this.cidade = cidade;
        }

        public void setCurso(String curso) {
                this.curso = curso;
        }


        public void setCpf(String cpf) {
                this.cpf = cpf;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public void setTelefone(String telefone) {
                this.telefone = telefone;
        }


        public String toString() {
                return " Nome: " + nome + "\n Curso: " + curso +  "\n Cidade: " + cidade + "\n CPF: " + cpf + "" +
                        "\n E-mail: " + email + "\n Telefone: " + telefone;
        }

}

//public void getCidade(String cidade) { this.cidade = cidade;}
//
//    public void getCurso(String curso) { this.curso = curso;}
//
//    public int getId() { return id;}
//
//    public void getId(int id) { this.id = id;}

