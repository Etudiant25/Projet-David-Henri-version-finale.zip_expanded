package Papier;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import Entree.SingleConnection;
import Soins.TransmissionsDAO;

public class TestOrdonnance {

	@Test
	public void createTABLE() throws SQLException {
		OrdonnanceDAO emp = new OrdonnanceDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		Ordonnance ordonnance = new Ordonnance();
		boolean bool = emp.createTABLE();
		assertTrue(bool);
	}

	@Test	
	public void insereTUPLE() throws SQLException {
		OrdonnanceDAO emp = new OrdonnanceDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		Date aujourdhui = new Date(System.currentTimeMillis());
		Ordonnance testPatient=new Ordonnance(1, 2,"Dupont","Richard","Dr Papoue", "mico","","","","","","",false,false, aujourdhui);
		boolean bool = emp.insereTUPLE(testPatient);
		assertFalse(bool);
	}

	@Test	 
	public void updatePiqure() throws SQLException{
		OrdonnanceDAO emp = new OrdonnanceDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		Date aujourdhui = new Date(System.currentTimeMillis());
		Ordonnance ordo = new Ordonnance(1, 2,"Dupont","Richard","Dr Papoue", "movicol","","","","","","",false,false, aujourdhui);
		String nom = "Dupont";
		String prenom = "Richard";
		boolean bool = emp.updatePiqure(ordo, "Dupont", "Richard");
		assertFalse(bool);
	}
}
