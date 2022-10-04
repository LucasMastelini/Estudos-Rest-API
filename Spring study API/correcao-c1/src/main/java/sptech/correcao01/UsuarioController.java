package sptech.correcao01;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario novoUsuario) {
        usuarios.add(novoUsuario);
        return ResponseEntity.status(201).body(novoUsuario);
    }

    @PostMapping("/autenticacao/{usuario}/{senha}")
    public ResponseEntity<Usuario> logonUsuario(@PathVariable String usuario,
                                                @PathVariable String senha) {
        for (Usuario usuarioAtual : usuarios) {
            if (usuarioAtual.autenticar(usuario, senha)) {
                return ResponseEntity.status(201).body(usuarioAtual);
            }
        }
        return ResponseEntity.status(204).build();
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {

        return usuarios.isEmpty() ? ResponseEntity.status(204).build() :
                ResponseEntity.status(200).body(usuarios);
    }

    @DeleteMapping("/autenticacao/{usuario}")
    public ResponseEntity<String> logoffUsuario(@PathVariable String usuario) {
        for (Usuario usuarioAtual : usuarios) {
            if (usuarioAtual.getUsuario().equals(usuario)) {
                if (usuarioAtual.isAutenticado()) {
                    usuarioAtual.setAutenticado(false);
                    return ResponseEntity.status(201).body(String.format("Logoff do usuário %s concluído", usuarioAtual.getNome()));
                } else {
                    return ResponseEntity.status(201).body(String.format("Usuário %s NÃO está autenticado", usuarioAtual.getNome()));
                }
            }
        }
        return ResponseEntity.status(204).body(String.format("Usuário %s não encontrado", usuario));
    }

    // EndPoints extras:

    @GetMapping("/autenticados")
    public ResponseEntity<List<Usuario>> getUsuariosAutenticados() {

        List<Usuario> autenticados = usuarios.stream()
                .filter(Usuario::isAutenticado)
                .collect(Collectors.toList());

        return autenticados.isEmpty() ? ResponseEntity.status(204).build() :
                ResponseEntity.status(200).body(autenticados);
    }

    @DeleteMapping("/autenticacao")
    public ResponseEntity<String> logoffGeral() {

        int logOff = 0;
        for (Usuario usuario : usuarios) {
            usuario.setAutenticado(false);
            if (!usuario.isAutenticado()) {
                logOff++;
            }
        }
        return logOff == 0 ? ResponseEntity.status(500).body("Erro ao tentar LogOff") :
                ResponseEntity.status(201).body("todos os usuarios sofreram LogOff");
    }

    @GetMapping("/relatorio")
    public ResponseEntity<String> getRelatorio() {
        long autenticados = usuarios.stream()
                .filter(Usuario::isAutenticado)
                .count();

        return ResponseEntity.status(201).body(String.format(
                "Total de usuários: %s. Autenticados: %d. Não autenticados: %s",
                usuarios.size(), autenticados, usuarios.size() - autenticados
        ));
    }
}

