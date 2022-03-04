package com.coches.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coches.app.entity.Coche;
import com.coches.app.entity.Marca;
import com.coches.app.entity.Modelo;

@Repository
public interface CocheDao extends CrudRepository<Coche, Long>{

	@Query("from Marca")
	public List<Marca> findAllMarcas();
	
	@Query("from Modelo")
	public List<Modelo> findAllModelos();
}
