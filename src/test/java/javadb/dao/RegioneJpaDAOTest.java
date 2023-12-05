package javadb.dao;

import com.example.javadb.dao.RegioneJpaDAO;
import com.example.javadb.entities.Regione;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class RegioneJpaDAOTest {
	private static final Logger log = LogManager.getLogger(RegioneJpaDAO.class);

//	@Test
	void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAll() {
		RegioneJpaDAO rJpaDao = new RegioneJpaDAO();
		List<Regione> regioni = rJpaDao.findAll();
		assert(regioni.size() > 0);
		for(Regione r : regioni) {
			log.debug(r);
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


