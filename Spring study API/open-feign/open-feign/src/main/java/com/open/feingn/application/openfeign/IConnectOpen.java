package com.open.feingn.application.openfeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name ="usuario", url = "localhost:8080")
public interface IConnectOpen{

   @RequestMapping(method = RequestMethod.POST, value = "/cadastro-usuario ")
   Usuario cadastro(Usuario usuario);

   @RequestMapping(method = RequestMethod.GET, value = "/usuarios")
   List<Usuario> listar();



}
