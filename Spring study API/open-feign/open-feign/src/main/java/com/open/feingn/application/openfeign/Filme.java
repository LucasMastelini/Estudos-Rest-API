package com.open.feingn.application.openfeign;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class Filme {

    @JsonIgnore
    private UUID id;
    private String nome;
    private String diretor;
    private String genero;
    private double duracao;
    private int faixaEtaria;

    public Filme(String nome, String diretor, String genero, double duracao, int faixaEtaria) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.diretor = diretor;
        this.genero = genero;
        this.duracao = duracao;
        this.faixaEtaria = faixaEtaria;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDiretor() {
        return diretor;
    }

    public String getGenero() {
        return genero;
    }

    public double getDuracao() {
        return duracao;
    }

    public int getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public void setFaixaEtaria(int faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", diretor='" + diretor + '\'' +
                ", genero='" + genero + '\'' +
                ", duracao=" + duracao +
                ", faixaEtaria=" + faixaEtaria +
                '}';
    }
}
