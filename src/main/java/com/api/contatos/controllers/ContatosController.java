package com.api.contatos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.contatos.entities.ContatoEntity;
import com.api.contatos.interfaces.ContatoInterface;

@RestController
public class ContatosController {
	@Autowired
	ContatoInterface contatointerface;

	@GetMapping
	public List<ContatoEntity> BuscarContatos() {
		Iterable<ContatoEntity> findAll = contatointerface.findAll();
		return (List<ContatoEntity>) findAll;
	}
	@PostMapping
	public ContatoEntity inserirContato(@RequestBody ContatoEntity entity) {
		ContatoEntity contato = contatointerface.save(entity);
		return contato;
	}

}
