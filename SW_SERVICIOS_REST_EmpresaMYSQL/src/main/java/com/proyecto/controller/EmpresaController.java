package com.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entity.Empresa;

import com.proyecto.service.EmpresaService;


@RestController
@RequestMapping("/rest/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService service;

	@GetMapping("/porUsuario/{id}")
	public ResponseEntity<?> listaPorEmpresa(@PathVariable("id") int idEmpresa) {
		List<Empresa> lstSalida = service.listaEmpresaPorEmpresa(idEmpresa);
		return ResponseEntity.ok(lstSalida);
	}
	

	@GetMapping()
	public ResponseEntity<?> lista() {
		List<Empresa> lstSalida = service.listaEmpresa();
		return ResponseEntity.ok(lstSalida);
	}
	
	@PostMapping
	public ResponseEntity<?> inserta(@RequestBody Empresa obj) {
		Empresa objSalida = service.insertaEmpresa(obj);
		return ResponseEntity.ok(objSalida);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminaEmpresa(@PathVariable Integer id) {
		service.eliminaEmpresa(id);
		Optional<Empresa> optEmpresa = service.buscaEmpresa(id);
		if (optEmpresa.isEmpty()) {
			return ResponseEntity.ok("Eliminación exitosa");
		}
		return ResponseEntity.ok("No existe el id " + id);
	}

	@PutMapping
	public ResponseEntity<?> actualiza(@RequestBody Empresa obj) {
		Optional<Empresa> optEmpresa = service.buscaEmpresa(obj.getIdEmpresa());
		if (optEmpresa.isPresent()) {
			Empresa objSalida = service.insertaEmpresa(obj);
			return ResponseEntity.ok(objSalida);
		} else {
			return ResponseEntity.ok("El Matricula no existe");
		}
	}
}
