package br.ufpb.agenda;

public class Contato {
    private String nome;
    //adicionei email ao contato
    private String email;
    private Endereco endereco;

    public Contato(String nome, String email,Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
    }

    public Contato() {
        this("", "", new Endereco());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {this.email = email;}
    public String getEmail() {return email;}
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String toString() {
        return "Contato de nome "+this.nome+ " e "+this.endereco.toString();
    }

}