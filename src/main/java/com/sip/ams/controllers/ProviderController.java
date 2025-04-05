package com.sip.ams.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sip.ams.entities.Provider;
import com.sip.ams.exceptions.ResourceNotFoundException;
import com.sip.ams.services.ProviderService;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.*;
@RestController
@RequestMapping("/providers")
//@CrossOrigin("*")
public class ProviderController {

	private final ProviderService providerService;
	private static final Logger logger = Logger.getLogger(ProviderController.class.getName());
	
	static {
		   FileHandler fileHandler=null;
		try {
			fileHandler = new FileHandler("app.log", true);
		} catch (SecurityException | IOException e) {
			logger.log(Level.SEVERE, "Error setting up the file handler", e);
		}  
           fileHandler.setFormatter(new SimpleFormatter()); 
           logger.addHandler(fileHandler); 
	}
	public ProviderController(ProviderService providerService) {
		super();
		this.providerService = providerService;
	}

	@GetMapping("/")
	List<Provider> getAllProviders() {
		System.out.println(this.providerService.listProviders());
		return this.providerService.listProviders();
	}

	/*@PostMapping("/")
	Provider addProvider(@RequestBody Provider provider) {
		return this.providerService.saveProvider(provider);
	}*/
	
	@PostMapping("/")
	public Provider create(@RequestParam(name="imageFile") MultipartFile file,
			@RequestParam("name") String name,
			@RequestParam("email") String email, 
			@RequestParam("address") String address
			//@RequestParam("imageName") String imageName
			) throws IOException
	{
		return providerService.saveProvider(file,name,email,address);
	}

	@GetMapping("/{id}")
	Provider getProviderById(@PathVariable("id") long id) {
		return this.providerService.getProvider(id);
	}

	/*
	@DeleteMapping("/{id}")
	synchronized boolean deleteProviderById(@PathVariable("id") long id) {
		boolean deleted = false;
		try {
			Provider provider = this.providerService.getProvider(id);
			
			if (provider != null) {
				this.providerService.deleteProvider(id);
				deleted = true;
			} else {
				throw new IllegalArgumentException("Provider not found : "+id);
			}
		} catch (Exception ex) {
			//ex.printStackTrace();
			//System.out.println(ex.getMessage());
			logger.log(Level.INFO, "Delete provider problem : "+ LocalDateTime.now()+" "+ ex.getMessage()+" :"+id);
		}
		return deleted;

	}*/
	
    @DeleteMapping("/{providerId}")
    public ResponseEntity<?> deleteProvider(@PathVariable Long providerId) {
        return this.providerService.findProviderById(providerId).map(provider -> {
        	this.providerService.deleteProvider(providerId);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("ProviderId " + providerId + " not found"));
    }

	
	/*@PutMapping("/")
	Provider editProvider(@RequestBody Provider provider) {
		return this.providerService.saveProvider(provider);
	}*/

}
