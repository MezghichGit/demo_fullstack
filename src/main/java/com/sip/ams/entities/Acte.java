package com.sip.ams.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Acte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Libelle is mandatory")
	private String libelle;

	public int getId() {
		return id;
	}

	public Acte(int id, @NotBlank(message = "Libelle is mandatory") String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	
	public Acte() {
		
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
