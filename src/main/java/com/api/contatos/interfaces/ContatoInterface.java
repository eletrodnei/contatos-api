package com.api.contatos.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.contatos.entities.ContatoEntity;

@Repository
public interface ContatoInterface extends CrudRepository<ContatoEntity, Long>{

}
