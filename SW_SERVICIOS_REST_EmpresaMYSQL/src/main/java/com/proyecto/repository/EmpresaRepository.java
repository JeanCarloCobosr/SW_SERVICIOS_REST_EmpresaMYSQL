package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

	@Query("select a from Empresa a where a.idEmpresa = ?1")
	public List<Empresa>  listaEmpresa(int idEmpresa);
	
}