package Personnel;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import Entree.SingleConnection;

public class TestPsychologue {

	@Test
	public void createTABLE2() throws SQLException {
		boolean bool=false;
		PsychologueDAO emp = new PsychologueDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		Medecin ante = new Medecin();
		bool = emp.createTABLE();
		assertTrue(bool);
	}

	@Test
	public void insereTUPLE() throws SQLException {
		PsychologueDAO emp = new PsychologueDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		Psychologue ante = new Psychologue (0, "agent d'accueil", "Jeanine", "Monts", "3 avenue Laplace", "travail@mail.Com", "47");
		boolean bool = emp.insereTUPLE(ante);
		assertFalse(bool);		
	}	
}
