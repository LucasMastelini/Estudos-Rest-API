package com.projeto5.orm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired // Injeção de dependencia
    private MusicaRepository musicaRepository;

    @GetMapping
    public ResponseEntity<List<Musica>> listar(){

        List<Musica> musicas = musicaRepository.findAll();

        return musicas.isEmpty()? ResponseEntity.status(204).build():
                ResponseEntity.status(200).body(musicas);
    }

    @PostMapping
    public ResponseEntity<Musica> cadastrar(@RequestBody Musica musica){

        Musica musicaCadastrada = musicaRepository.save(musica);

        return ResponseEntity.status(201).body(musicaCadastrada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musica> buscarPorId(@PathVariable int id) {
        return ResponseEntity.of(musicaRepository.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Musica> atualizar(@PathVariable int id, @RequestBody Musica musica) {
        musica.setId(id);

        if (musicaRepository.existsById(id)){
            musicaRepository.save(musica);
            return ResponseEntity.status(200).body(musica);
        }

        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/id")
    public ResponseEntity<Musica> remover(@PathVariable int id){

        if (musicaRepository.existsById(id)){
            musicaRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }

}
