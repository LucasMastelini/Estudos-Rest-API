package com.api.cantores.atividadecantores;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("/cantores")
public class CantorController {

    List<Cantor> cantores;

    public CantorController() {
        this.cantores = new ArrayList<>();
    }

    public boolean validarIndice(int indice){
        return indice >= 0 && indice < cantores.size();
    }

    @PostMapping
    public String cadastrarCantor(@RequestBody Cantor cantor) {

        cantores.add(cantor);
        return "Cantor cadastrado com sucesso";
    }

    @GetMapping("{id}")
    public Cantor buscarCantorIndice(@PathVariable int id) {

        if (validarIndice(id)) {
            for (Cantor c : cantores) {
                if (c.getId() == id) {
                    return c;
                }
            }
        }

        return null;
    }

    @GetMapping("/celebridade")
    public Cantor celebridade() {

        for (Cantor c : cantores) {
            if (c.getCache() > 10000) {
                return c;
            }
        }
        return null;
    }

}
