package com.api.contatos.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class ContatoEntity {
	@Id
	@GeneratedValue
	private long ID;
	@Column(length = 50,nullable = false)
	private String Nome;
	@Column(length = 15)
	private String telefone;

	
	
	public long getID() {
		return ID;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
