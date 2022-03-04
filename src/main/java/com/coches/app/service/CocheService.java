package com.coches.app.service;

import java.util.List;

import com.coches.app.entity.Coche;
import com.coches.app.entity.Marca;
import com.coches.app.entity.Modelo;

public interface CocheService {

	public List<Coche> finAll();
	
	public Coche findById(Long id);
	
	public Coche save(Coche coche);
	
	public void delete(Long id);
	
	public List<Marca> findAllMarcas();
	
	public List<Modelo> findAllModelos();
}
