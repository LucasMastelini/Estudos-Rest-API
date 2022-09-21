package school.sptech.projeto1aula2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
public class ContadorController {

    private int contador = 0;


    @GetMapping("/acumular")
    public String acumular(){
        contador++;
        return "ok";
    }

    @GetMapping("/resultado")
    public String getResultado(){

        return "Valor Atual: " + contador;
    }

}
