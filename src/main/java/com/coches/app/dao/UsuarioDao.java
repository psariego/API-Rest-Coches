package com.coches.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coches.app.entity.Usuario;


@Repository
public interface UsuarioDao extends CrudRepository<Usuario, Long>{

	public Usuario findByUsername(String username);
}
