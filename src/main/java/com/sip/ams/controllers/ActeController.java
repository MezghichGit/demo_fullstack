package com.sip.ams.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sip.ams.entities.Acte;
import com.sip.ams.repositories.ActeRepository;

@RestController
public class ActeController {
	
	private final ActeRepository acteRepository;
	
	public ActeController(ActeRepository acteRepository) {
		super();
		this.acteRepository = acteRepository;
	}

	@GetMapping("/actes")
	public List<Acte> getAllActes()
	{
		return (List<Acte>)this.acteRepository.findAll();
	}
	
	@PostMapping("/actes")
	public Acte saveActe(@RequestBody Acte acte)
	{
		return this.acteRepository.save(acte);
	}
	
	@PutMapping("/actes")
	public Acte updateActe(@RequestBody Acte acte)
	{
		return this.acteRepository.save(acte);
	}
	
	@DeleteMapping("/actes/{id}")
	public void deleteActe(@PathVariable("id")int id)
	{
		this.acteRepository.deleteById(id);
	}



}
