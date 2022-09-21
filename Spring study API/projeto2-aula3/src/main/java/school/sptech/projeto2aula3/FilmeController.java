package school.sptech.projeto2aula3;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

  private List<Filme> filmes = new ArrayList<>();

  @GetMapping
  public List<Filme> listar() {
    return filmes;
  }

  @GetMapping("/{indice}")
  public Filme buscarPorIndice(@PathVariable int indice) {
    return filmes.get(indice);
  }

  @PostMapping // Indica uma criação de um recurso
  public Filme cadastrarFilme(@RequestBody Filme filme) {
    filmes.add(filme);
    return filme;
  }

  @PutMapping("/{indice}") // Indica uma atualização de um recurso;
  public String atualizar(
      @PathVariable int indice,
      @RequestBody Filme filmeParaAtualizar
  ) {
    filmes.set(indice, filmeParaAtualizar);
    return "Filme atualizado com sucesso";
  }

  @PatchMapping("/{indice}/{faixaEtaria}") // Indica uma atualização de um recurso;
  public String atualizarParcial(
      @PathVariable int indice,
      @PathVariable int faixaEtaria
  ) {

    //Ideal validar se existe o indice....

    Filme filme = filmes.get(indice);
    filme.setFaixaEtaria(faixaEtaria);

    return "Filme atualizado com sucesso";

  }

  @DeleteMapping("/{indice}") // Indica uma remoção de um recurso
  public String removerFilmePorIndice(@PathVariable int indice) {
    filmes.remove(indice);
    return "Filme removido com sucesso!";
  }
}
