package com.open.feingn.application.openfeign;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class Usuario {

    private String nome;

    private String sexo;

    private String cpf;

    private String telefone;

    private String celular;

    private String email;

    private String senha;
}
