package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.entity.Empresa;

public interface EmpresaService {

	public List<Empresa> listaEmpresa();

	public List<Empresa> listaEmpresaPorEmpresa(int idEmpresa);
	
	public Empresa insertaEmpresa(Empresa obj);

	public Optional<Empresa> buscaEmpresa(int idEmpresa);

	public void eliminaEmpresa(int idEmpresa);

}