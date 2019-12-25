package net.codejava.contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.codejava.contact.model.Contact;

class ContactDAOTest {
	private DriverManagerDataSource dataSource;
	private ContactDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/java_spring");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		dao = new ContactDAOSu(dataSource);
	}
	
	@Test
	void testSave() {
		Contact contact = new Contact("Bill Gate", "bill@microsoft.com","Califonia, CA", "12345678");
		int result = dao.save(contact);
		
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Contact contact = new Contact(2, "Bill Gate2", "bill.gates@microsoft.com","Califonia, CA", "12345678");
		int result = dao.update(contact);
		
		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Integer id = 1;
		Contact contact = dao.get(id);
		if(contact != null) {
			System.out.println(contact);
		}
		assertNotNull(contact);
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testList() {
		fail("Not yet implemented");
	}

}
