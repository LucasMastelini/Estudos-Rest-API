package com.exercicio.entrega.lucas.mastelini.exerciocioroupas;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/lutadores")
public class LutadoresController {

    List<Lutador> lutadores = new ArrayList<>();
    @PostMapping
    public List<Lutador> cadastrarLutador(@RequestBody List<Lutador> lutadoresAdd) {
        lutadores.addAll(lutadoresAdd);
        return lutadoresAdd;
    }

    @GetMapping
    public List<Lutador> listar() {

        return lutadores;
    }

    @PatchMapping("/{posicaoBate}/golpe/{posicaoApanha}")
    public List<Lutador> apanhou(@PathVariable int posicaoBate, @PathVariable int posicaoApanha) {

        List<Lutador> luta = new ArrayList<>();
        Lutador lutadorApanha;
        Lutador lutadorBate;
        lutadorApanha = lutadores.get(posicaoApanha);
        lutadorBate = lutadores.get(posicaoBate);

        int danoLutadorBate = lutadorBate.getForcaGolpe();
        int defesaLutadorApanha = lutadorApanha.getForcaDefesa();
        int vidaPerdida = danoLutadorBate - defesaLutadorApanha;

        Objects.requireNonNull(lutadorApanha).setVida( lutadorApanha.getVida() - vidaPerdida);

        if (lutadorApanha.getVida() < 0)

            lutadorApanha.setVida(0);

        luta.add(lutadorBate);
        luta.add(lutadorApanha);

        return luta;
    }

    @GetMapping("/sobreviventes")
    public List<Lutador> maisFortes() {

        return lutadores.stream().filter(x -> x.getVida() > 0).toList();
    }

}
