package com.open.feingn.application.openfeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
public class TesteController {

    @Autowired
    IConnectOpen connectOpen;


    @PostMapping
    private Usuario cadastrar(@RequestBody Usuario usuario){
        return connectOpen.cadastro(usuario);
    }

    @GetMapping
    private List<Usuario> listar(){
        return connectOpen.listar();
    }
}
