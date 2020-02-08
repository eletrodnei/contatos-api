package com.api.contatos.controllers;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.contatos.entities.ContatoEntity;
import com.api.contatos.interfaces.ContatoInterface;

import javassist.NotFoundException;
import net.bytebuddy.implementation.bytecode.Throw;

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

	@DeleteMapping("/{ID}")
	public void deletarContato(@PathVariable long ID) {
		Optional<ContatoEntity> procurar = contatointerface.findById(ID);
		contatointerface.delete(procurar.get());
	}

	@PutMapping("/{ID}")
	public ContatoEntity AtualizarContato(@PathVariable long ID, @RequestBody ContatoEntity entity)
			throws NotFoundException {
		Optional<ContatoEntity> procurar = contatointerface.findById(ID);
		if (procurar.isPresent()) {
			ContatoEntity contatoEntity = procurar.get();
			contatoEntity.setNome(entity.getNome());
			contatoEntity.setTelefone(entity.getTelefone());
			contatointerface.save(contatoEntity);
			return contatoEntity;
		}
		throw new NotFoundException("Registro não encontrado !!!");
	}
}


