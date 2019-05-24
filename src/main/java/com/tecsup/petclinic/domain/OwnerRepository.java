package com.tecsup.petclinic.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author jgomezm
 *
 */
@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {

	// Fetch pets by name
	List<Owner> findByFirstName(String first_name );

	// Fetch pets by typeId
	List<Owner> findByLastName(String last_name);

	// Fetch pets by ownerId
	List<Owner> findByAddress(String address);
	
	
	List<Owner> findByTelephone(String telephone);
	
	List<Owner> findByCity(String city);

}
