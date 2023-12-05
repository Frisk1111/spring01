package javadb.dao;

import com.example.javadb.dao.ClientiJpaDAO;
import com.example.javadb.entities.Cliente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

class ClientiJpaDAOTest {

	private static final Logger log = LogManager.getLogger(ClientiJpaDAO.class);

//	@Test
	void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAll() {
		ClientiJpaDAO cJpaDao = new ClientiJpaDAO();
		List<Cliente> clienti = cJpaDao.findAll();
		assert(clienti.size() > 0);
		for(Cliente c : clienti) {
			log.debug(c);
		}
	}

//	@Test
	void testCreate() {
		fail("Not yet implemented");
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
