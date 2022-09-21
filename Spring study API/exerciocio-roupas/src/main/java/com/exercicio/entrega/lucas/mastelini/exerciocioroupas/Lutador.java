package com.exercicio.entrega.lucas.mastelini.exerciocioroupas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Lutador {

    private String nome;
    private int forcaGolpe;
    private int forcaDefesa;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int vida;

    public Lutador() {
        this.vida = 100;
    }

}
