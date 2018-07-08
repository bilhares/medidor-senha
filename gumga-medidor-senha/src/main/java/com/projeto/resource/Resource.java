package com.projeto.resource;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.controller.MedidorSenhaController;
import com.projeto.model.Pontuacao;

@RestController
@RequestMapping("/validar-senha")
public class Resource {

	@Autowired
	MedidorSenhaController controller;

	@PostMapping
	public Pontuacao validarSen(@RequestBody HashMap<String, String> obj) {
		String senha = obj.get("senha");
		return controller.medirSenha(senha);
	}

}
