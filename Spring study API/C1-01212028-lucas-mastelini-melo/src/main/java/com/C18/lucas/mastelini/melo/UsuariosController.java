package com.C18.lucas.mastelini.melo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    List<Usuario> usuarios;

    public UsuariosController() {
        this.usuarios = new ArrayList<>();
    }



    @PostMapping
    public String cadastrarUsuario(@RequestBody Usuario usuario){

        usuarios.add(usuario);
        return "Usuario cadastrado com suscesso";
    }

    @GetMapping
    public List<Usuario> listar(){
        return usuarios;
    }

    @PostMapping("/autentica/{usuario}/{senha}")
    public Usuario autenticaUsuario(@PathVariable String usuario, @PathVariable String senha){

        for (Usuario u: usuarios) {
            if (u.getUsuario().equals(usuario) &&
                    u.getSenha().equals(senha)){
                u.setAutenticado(true);
                if (u.isAutenticado()){
                    return u;
                }
            }
        }
            return null;

    }

    @DeleteMapping("autenticacao/{usuario}")
    public String deslogarUsuario(@PathVariable String usuario){

        boolean usuarioNaoEncontrado= false;
        for (Usuario u: usuarios) {
            if (u.getUsuario().equals(usuario) &&
            u.isAutenticado()){
                u.setAutenticado(false);
                return  "Logoff do usuário "+u.getNome()+" concluído";
            }else if (u.getUsuario().equals(usuario) &&
                    !u.isAutenticado()){
                return "Usuário "+u.getNome()+" Não esta autenticado";
            }
        }

       return "Usuário "+usuario+" Não encontrado";

    }








}
