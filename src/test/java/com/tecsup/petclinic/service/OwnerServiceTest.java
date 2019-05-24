package com.tecsup.petclinic.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tecsup.petclinic.domain.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class OwnerServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceTest.class);

	@Autowired
	private OwnerService ownerService;

	/**
	 * 
	 */
	@Test
	public void testFindByFirstName() {
		String FIND_FIRSTNAME = "Betty";
		int SIZE_EXPECTED = 1;

		List<Owner> owners = ownerService.findByFirstName(FIND_FIRSTNAME);
		assertEquals(SIZE_EXPECTED, owners.size());
	}

	/**
	 * 
	 */
	@Test
	public void testFindByLastName() {
		String FIND_LASTNAME = "Coleman";
		int SIZE_EXPECTED = 1;

		List<Owner> owners = ownerService.findByLastName(FIND_LASTNAME);
		assertEquals(SIZE_EXPECTED, owners.size());
	}

	/**
	 * 
	 */
	@Test
	public void testFindByCity() {
		String FIND_CITY = "Monona";
		int SIZE_EXPECTED = 1;
		List<Owner> owners = ownerService.findByCity(FIND_CITY);
		assertEquals(SIZE_EXPECTED, owners.size());

	}
	
	/**
	 *  To get ID generate , you need 
	 *  setup in id primary key in your
	 *  entity this annotation :
	 *  	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 */
	@Test
	public void testCreateOwner() {

		String FIRST_NAME = "Sebastian";
		String LAST_NAME = "Cueva";
		String CITY="Lima";
		String ADDRESS="Lima,Lima";
		String TELEPHONE="947273663";

		Owner owner = new Owner(FIRST_NAME,LAST_NAME,CITY,ADDRESS,TELEPHONE);
		owner = ownerService.create(owner);
		logger.info("" + owner);

		assertThat(owner.getId()).isNotNull();
		assertEquals(FIRST_NAME, owner.getFirst_name());
		assertEquals(LAST_NAME, owner.getLast_name());
		assertEquals(CITY, owner.getCity());
		assertEquals(ADDRESS,owner.getAddress());
		assertEquals(TELEPHONE,owner.getTelephone());

	}
	
	/**
	 * 
	 */
	@Test
	public void testDeletePet() {

		String FIRST_NAME = "Sebastian";
		String LAST_NAME = "Cueva";
		String CITY="Lima";
		String ADDRESS="Lima,Lima";
		String TELEPHONE="947273663";

		Owner owner = new Owner(FIRST_NAME, LAST_NAME, CITY,ADDRESS,TELEPHONE);
		owner = ownerService.create(owner);
		logger.info("" + owner);

		try {
			ownerService.delete(owner.getId());
		} catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}
			
		try {
			ownerService.findById(owner.getId());
			assertTrue(false);
		} catch (OwnerNotFoundException e) {
			assertTrue(true);
		} 
				

	}
}
