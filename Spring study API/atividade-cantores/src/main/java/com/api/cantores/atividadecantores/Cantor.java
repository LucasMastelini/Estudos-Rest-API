package com.api.cantores.atividadecantores;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Cantor {

    private static int id;
    private String nome;
    private String categoria;
    private double cache;
    private boolean constaNoSpotify;
    @JsonIgnore
    private  int senha;


    public Cantor() {
        Cantor.id++;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getCache() {
        return cache;
    }

    public boolean isConstaNoSpotify() {
        return constaNoSpotify;
    }
}
