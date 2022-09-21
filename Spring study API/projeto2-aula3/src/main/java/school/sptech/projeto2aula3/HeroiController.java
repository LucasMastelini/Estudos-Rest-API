package school.sptech.projeto2aula3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {

  private List<Heroi> herois = new ArrayList<>();

  @GetMapping("/favoritos")
  public Heroi getFavorito() {
    return new Heroi(
        "Batman",
        "Dinheiro",
        25,
        10.0,
        true
    );
  }

  @GetMapping // URI: /herois
  public List<Heroi> getHerois() {
    return herois;
  }

    /* Chamada: /herois/{indice}
Ela retorna o JSON do herói na posição da lista indicada
ex: /herois/0  -> retorna o JSON do 1º herói da lista
ex: /herois/2  -> retorna o JSON do 3º herói da lista
     */

  @GetMapping("/{indice}")
  public Heroi getHeroi(@PathVariable int indice) {
    if (indice >= 0 && indice < herois.size()) {
      return herois.get(indice);
    } else {
      return null;
    }
  }

  /* Chamada:
  /herois/cadastrar/{nome}/{poder}/{idade}/{forca}/{vivo}
  Ela cadastra um novo herói e retorna o JSON dele
       */
  @GetMapping("/cadastrar/{nome}/{poder}/{idade}/{forca}/{vivo}")
  public Heroi cadastrar(@PathVariable String nome,
                         @PathVariable String poder,
                         @PathVariable int idade,
                         @PathVariable double forca,
                         @PathVariable boolean vivo) {
    Heroi novoHeroi = new Heroi(nome, poder, idade, forca, vivo);
    herois.add(novoHeroi);

    return novoHeroi;
  }

  /* Chamada:
  /herois/atualizar/{indice}/{nome}/{poder}/{idade}/{forca}/{vivo}
  Ela atualiza os dados do herói na posição "indice" da lista
  e retorna o JSON novo dele
  // ex: /herois/atualizar/0/a/b/25/1000/true
  // iria atualizar os dados do herói na posição 0 da lista
  // se o indice for inválido não retorne nada
  */
  @GetMapping("/atualizar/{indice}/{nome}/{poder}/{idade}/{forca}/{vivo}")
  public Heroi atualizar(@PathVariable int indice,
                         @PathVariable String nome,
                         @PathVariable String poder,
                         @PathVariable int idade,
                         @PathVariable double forca,
                         @PathVariable boolean vivo) {
    if (indice >= 0 && indice < herois.size()) {
      Heroi heroiAtualizado = new Heroi(nome, poder, idade, forca, vivo);
      herois.set(indice, heroiAtualizado);

      return heroiAtualizado;
    }
    return null;
  }
}