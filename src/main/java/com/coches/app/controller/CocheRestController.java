package com.coches.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.coches.app.entity.Coche;
import com.coches.app.entity.Marca;
import com.coches.app.entity.Modelo;
import com.coches.app.service.CocheService;

@RestController
@RequestMapping("/api")
public class CocheRestController {

	@Autowired
	private CocheService cocheService;
	
	@GetMapping({"/coches", "/todos"})
	public List<Coche> index(){
		return cocheService.finAll();
	}
	
	
	@GetMapping("coches/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		
		Coche coche = null;
		Map<String, Object> response = new HashMap<>();
		
		try {		
			coche = cocheService.findById(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al reallizar consulta a base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		if(coche == null) {
			response.put("mensaje", "El coche con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Coche>(coche, HttpStatus.OK);
		
	}
	
	
	@PostMapping("/coche")
	public ResponseEntity<?> saveCoche(@RequestBody Coche coche){
		
		Coche cocheNuevo = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			cocheNuevo = cocheService.save(coche);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al insertar");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		response.put("mensaje", "El coche ha sido creado con éxito");
		response.put("coche", cocheNuevo);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/coche/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> updateCoche(@RequestBody Coche coche, @PathVariable Long id) {
		
		Coche cocheActual = cocheService.findById(id);
		Map<String, Object> response = new HashMap<>();
		
		if (cocheActual == null) {
			response.put("mensaje", "El coche con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			cocheActual.setCilindrada(coche.getCilindrada());
			cocheActual.setColor(coche.getColor());
			cocheActual.setMarca(coche.getMarca());
			cocheActual.setMatricula(coche.getMatricula());
			cocheActual.setModelo(coche.getModelo());
			cocheActual.setVelocidad(coche.getVelocidad());
			
			cocheService.save(cocheActual);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar update");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El coche ha sido actualizado con éxito");
		response.put("coche", cocheActual);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);	
	}
	
	
	@DeleteMapping("/coche/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> deleteCoche(@PathVariable Long id){
		
		Coche cocheEliminado = cocheService.findById(id);
		Map<String, Object> response = new HashMap<>();
		
		if (cocheEliminado == null) {
			response.put("mensaje", "El coche con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			cocheService.delete(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el coche");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		response.put("mensaje", "El coche ha sido eliminado con éxito");
		response.put("coche", cocheEliminado);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	
	@GetMapping("/coches/marcas")
	public List<Marca> listarMarcas(){
		return cocheService.findAllMarcas();
	}
	
	
	@GetMapping("/coches/modelos")
	public List<Modelo> listarModelos(){
		return cocheService.findAllModelos();
	}
}
