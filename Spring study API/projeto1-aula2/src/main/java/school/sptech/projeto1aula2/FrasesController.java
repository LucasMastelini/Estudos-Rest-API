package school.sptech.projeto1aula2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/frases")
public class FrasesController {


    @GetMapping
    public String padrao(){
        return "É nois na segunda API";
    }

    @GetMapping("/teste")
    public String teste(){
        return "Teste";
    }

    @GetMapping("/elogio/{nome}")
    public String elogio(@PathVariable String nome){
        return nome + " Vc é 10";
    }

    @GetMapping("/boa-noite")
    public String boaNoite(){
        return "Boa Noite";
    }

    @GetMapping("/maior/{n1}/{n2}")
    public String maior(@PathVariable Double n1 , @PathVariable Double n2){

        return "O maior numero é: " +(n1 > n2 ? n1 : n2);
    }

    @GetMapping("/somar/{n1}/{n2}")
    public Double somar(@PathVariable int n1 , @PathVariable int n2){;
        return Double.max(n1,n2);
    }

}
