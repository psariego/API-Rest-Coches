package com.coches.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coches.app.dao.CocheDao;
import com.coches.app.entity.Coche;
import com.coches.app.entity.Marca;
import com.coches.app.entity.Modelo;

@Service
public class CocheServiceImpl implements CocheService {

	@Autowired CocheDao cocheDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Coche> finAll() {
		return (List<Coche>) cocheDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Coche findById(Long id) {
		return cocheDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Coche save(Coche coche) {
		return cocheDao.save(coche);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		cocheDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Marca> findAllMarcas() {
		return cocheDao.findAllMarcas();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Modelo> findAllModelos() {
		return cocheDao.findAllModelos();
	}

}
