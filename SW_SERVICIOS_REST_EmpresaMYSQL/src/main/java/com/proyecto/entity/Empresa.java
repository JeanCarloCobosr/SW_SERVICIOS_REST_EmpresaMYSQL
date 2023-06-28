package com.proyecto.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEmpresa")
	private int idEmpresa;

	@Column(name = "contacto")
	private String contacto;

	@Column(name = "email")
	private String email;

	@Column(name = "flag")
	private int flag;

	@Column(name = "razonSocial")
	private String razonSocial;

	@Column(name = "ruc")
	private String ruc;
	
	@Column(name = "idTipoRiesgo")
	private int idTipoRiesgo;

	
}
