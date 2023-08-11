package Personnel;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import Entree.AntecedentDAO;
import Entree.Antecedents;
import Entree.SingleConnection;

public class TestAgentDaccueil {


	@Test
	public void createTABLE2() throws SQLException {
		boolean bool=false;
		AgentDaccueilDAO emp = new AgentDaccueilDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		AgentDaccueil ante = new AgentDaccueil();
		bool = emp.createTABLE();
		assertTrue(bool);
	}


	@Test
	public void insereTUPLE() throws SQLException {
		AgentDaccueilDAO emp = new AgentDaccueilDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		AgentDaccueil ante = new AgentDaccueil (0, "agent d'accueil", "Jeanine", "Monts", "3 avenue Laplace", "travail@mail.Com", "47");
		boolean bool = emp.insereTUPLE(ante);
		assertFalse(bool);		
	}	
}
