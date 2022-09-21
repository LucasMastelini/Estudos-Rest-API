package com.exercicio.entrega.lucas.mastelini.exerciocioroupas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/grifes")
public class RoupasController {
    List<MarcasGrife> marcasGrifes = new ArrayList<>();

    //201 - created

    @PostMapping
    public ResponseEntity<MarcasGrife> cadastrarMarca(@RequestBody MarcasGrife marcaGrife){
        marcasGrifes.add(marcaGrife);
        return ResponseEntity.status(201).body(marcaGrife);
    }

    @GetMapping
    public ResponseEntity<List<MarcasGrife>> Listar(){

        return marcasGrifes.isEmpty() ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(marcasGrifes);
    }

    @PutMapping("/{posicao}")
    public ResponseEntity<MarcasGrife> atuliazarCadastro(@PathVariable int posicao,@RequestBody MarcasGrife marcaGrife ){

        ResponseEntity<MarcasGrife> result = null;
        int t = marcasGrifes.size();
        for (int i = 0; i < t ; i++) {
            if (i == posicao) {
                marcasGrifes.set(i, marcaGrife);
                result = ResponseEntity.status(200).body(marcaGrife);
            }
        }
        return Objects.requireNonNull(result).getStatusCode() == HttpStatus.valueOf(200) ?
                result : ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{posicao}")
    public String DeletarCadastrado(@PathVariable int posicao){

        MarcasGrife result = null;
        int l = marcasGrifes.size();
        for (int i = 0; i < l ; i++) {
            if (i == posicao) {
                result = marcasGrifes.get(i);
                marcasGrifes.remove(i);
            }
        }
        return marcasGrifes.contains(result) ? "Erro ao deletar marca" : "Deletado com sucesso";
    }

    @GetMapping("/populares")
    public ResponseEntity<List<MarcasGrife>> populares(){

        List<MarcasGrife> populares = marcasGrifes.stream().filter(x -> x.getValorAcaoBolsa() > 15).toList();

        return populares.isEmpty()? ResponseEntity.status(204).build() : ResponseEntity.status(201).body(populares);

    }
}
