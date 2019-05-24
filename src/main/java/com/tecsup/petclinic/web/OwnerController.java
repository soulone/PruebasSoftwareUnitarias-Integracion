package com.tecsup.petclinic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tecsup.petclinic.domain.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.service.OwnerService;

/**
 * 
 * @author jgomezm
 *
 */
@RestController
public class OwnerController {

	@Autowired
	private OwnerService service;

	/**
	 * 
	 * @return
	 */
	// @JsonIgnore
	@GetMapping("/pets")
	public Iterable<Owner> getPets() {
		//
		return service.findAll();
	}

	/**
	 * Create Pet
	 * 
	 * @param newPet
	 * @return
	 */
	@PostMapping("/pets")
	@ResponseStatus(HttpStatus.CREATED)
	Owner create(@RequestBody Owner newPet) {
		return service.create(newPet);
	}

	/**
	 * Find by id
	 * 
	 * @param id
	 * @return
	 * @throws OwnerNotFoundException
	 */
	@GetMapping("/pets/{id}")
	ResponseEntity<Owner> findOne(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
		} catch (OwnerNotFoundException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	

	/**
	 * 
	 * @param id
	 */
	@DeleteMapping("/pets/{id}")
	ResponseEntity<String> delete(@PathVariable Long id) {

		try {
			service.delete(id);
			return new ResponseEntity<>("" + id, HttpStatus.OK);
		} catch (OwnerNotFoundException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
