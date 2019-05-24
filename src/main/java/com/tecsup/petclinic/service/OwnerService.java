package com.tecsup.petclinic.service;

import java.util.List;
import com.tecsup.petclinic.domain.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

/**
 * 
 * @author jgomezm
 *
 */
public interface OwnerService {

	/**
	 * 
	 * @param owner
	 * @return
	 */
	Owner create(Owner owner);

	/**
	 * 
	 * @param owner
	 * @return
	 */
	Owner update(Owner owner);

	/**
	 * 
	 * @param id
	 * @throws OwnerNotFoundException
	 */
	void delete(Long id) throws OwnerNotFoundException;

	/**
	 * 
	 * @param id
	 * @return
	 */
	Owner findById(long id) throws OwnerNotFoundException;

	/**
	 * 
	 * @param first_name
	 * @return
	 */
	List<Owner> findByFirstName(String first_name);

	/**
	 * 
	 * @param last_name
	 * @return
	 */
	List<Owner> findByLastName(String last_name);
	
	/**
	 * 
	 * @param city
	 * @return
	 */
	List<Owner> findByCity(String city);
	
	

	/**
	 * 
	 * @return
	 */
	Iterable<Owner> findAll();

}