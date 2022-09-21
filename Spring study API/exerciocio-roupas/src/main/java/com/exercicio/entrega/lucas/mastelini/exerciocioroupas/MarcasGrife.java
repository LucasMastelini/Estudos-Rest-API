package com.exercicio.entrega.lucas.mastelini.exerciocioroupas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarcasGrife {

    private String nome;
    private int anoCriacao;
    private double valorAcaoBolsa;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String chaveAcesso;


    @Override
    public String toString() {
        return "MarcasGrife{" +
                "nome='" + nome + '\'' +
                ", anoCriacao=" + anoCriacao +
                ", valorAcaoBolsa=" + valorAcaoBolsa +
                ", chaveAcesso='" + chaveAcesso + '\'' +
                '}';
    }
}
