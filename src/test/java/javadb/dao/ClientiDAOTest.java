package javadb.dao;

import com.example.javadb.dao.ClientiDAO;
import com.example.javadb.entities.Cliente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

class ClientiDAOTest {
	private static final Logger log = LogManager.getLogger(ClientiDAOTest.class);

//	@Test
	void testFindById() {
		fail("Not yet implemented");
	}

	// @Test
	void testFindAll() {
		ClientiDAO cd = new ClientiDAO();
		List<Cliente> clienti = cd.findAll();
		assert(clienti.size() > 0);
		for(Cliente c : clienti) {
			log.debug(c);
		}
	}

	@Test
	void testCreate() {
		ClientiDAO cd = new ClientiDAO();
		Cliente cliente = new Cliente();
		log.debug("Cliente vuoto {}", cliente);
		cliente.setNome("Ronald");
		cliente.setCognome("Regan");
		cliente.setEmail("rr@gmail.com");
		cliente.setIndirizzo("Via del boh, 54");
		cliente.setCitta("Roma");
		cliente.setProvincia("RM");
		cliente.setCap("00100");
		log.debug("Cliente pieno ma senza id {}", cliente);
		cliente = cd.create(cliente);
		assertNotNull( cliente.getIdCliente() );
		log.debug("Cliente ricevuto da DAO {}", cliente);
	}

//	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

//	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

}
