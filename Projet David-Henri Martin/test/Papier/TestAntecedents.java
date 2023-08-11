package Papier;

import static org.junit.Assert.assertTrue;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import static org.junit.Assert.*;

import Entree.AntecedentDAO;
import Entree.Antecedents;
import Entree.Patient;
import Entree.SingleConnection;

public class TestAntecedents {	

	@Test
	public void createTABLE2() throws SQLException {
		boolean bool=false;
		AntecedentDAO emp = new AntecedentDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		Antecedents ante = new Antecedents();
		bool = emp.createTABLE();
		assertTrue(bool);
	}

	@Test
	public void insereTUPLE() throws SQLException {
		AntecedentDAO emp = new AntecedentDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		Date aujourdhui = new Date(System.currentTimeMillis());
		Antecedents ante = new Antecedents (1, "Richard", "Dupont", "non", "non", "non", "non", "non", "non", "non", aujourdhui);
		boolean bool = emp.insereTUPLE(ante);
		assertFalse(bool);		
	}
}
