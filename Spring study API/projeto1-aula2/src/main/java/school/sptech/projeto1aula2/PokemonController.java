package school.sptech.projeto1aula2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    final private List<String> pokemons = new ArrayList<>();

    @GetMapping
    public Integer getTotalPokemons(){
        return pokemons.size();
    }

    @GetMapping("/cadastrar/{pokemon}")
    public String cadastrarpokemon(@PathVariable String pokemon) {
        pokemons.add(pokemon);
        return "Pokemon cadastrado com sucesso";
    }

    @GetMapping("/buscar/{i}")
    public String buscarPokemonPeloIndice(@PathVariable int i) {

        String pokemon = pokemons.get(i);

        if (i < 0) {
            return i + " Valor invalido";
        } else if (pokemon == null) {
            return "Pokemon não encontrado";
        }
        return "Este foi o pokemon encontrado " + pokemon;

    }



}
