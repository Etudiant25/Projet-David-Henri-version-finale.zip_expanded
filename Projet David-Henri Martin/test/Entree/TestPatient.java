package Entree;

import java.sql.Date;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import org.junit.Before;
import org.junit.Test;

import Personnel.AgentDaccueil;

import static org.junit.Assert.*;

public class TestPatient {




	private static final String DateTimeZone = null;

	@Test
	public void createTABLE() throws SQLException{
		int id=508;
		PatientDAO emp = new PatientDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		Patient testPatient = new Patient();
		boolean bool = emp.createTABLE();
		assertTrue(bool);
	}

	@Test
	public void insereTUPLE() throws SQLException {
		PatientDAO emp = new PatientDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		Date aujourdhui = new Date(System.currentTimeMillis());
		Patient testPatient=new Patient(47, "Dupont","richard","4444","3 rue Edouard","Richardatpomail.com","55", aujourdhui);
		boolean bool = emp.insereTUPLE(testPatient);
		assertFalse(bool);
	}

	@Test
	public void testfindById() throws SQLException {
		PatientDAO emp = new PatientDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		Date aujourdhui = new Date(System.currentTimeMillis());
		Patient testPatient=new Patient(47, "marco","san","44455554","3 rue  michelon","sanmarcoatpomail.com","185", aujourdhui);
		boolean booli = false;
		boolean bool = emp.insereTUPLE(testPatient);
		if(bool == true) {
			emp.findById(2);
			booli=true;
		}
		assertFalse(booli);
	}

	@Test
	public void testdeleteTUPLE() throws SQLException {
		PatientDAO emp = new PatientDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		Date aujourdhui = new Date(System.currentTimeMillis());
		Patient testPatient=new Patient(47, "Dupont","richard","4444","3 rue Edouard Garcin","Richardatpomail.com","55",aujourdhui);
		boolean booli = false;
		boolean bool = emp.deleteTUPLE(testPatient);
		assertFalse(bool);	
	}

	@Test
	public void testupdateNomTuple() throws SQLException {
		PatientDAO emp = new PatientDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		Date aujourdhui = new Date(System.currentTimeMillis());
		Patient testPatient=new Patient(47, "Dupont","richard","4444","3 rue Edouard Garcin","Richardatpomail.com","55",aujourdhui);
		int id=58;
		boolean bool = emp.updateNomTuple(testPatient, 58);
		assertFalse(bool);
	}

	@Test
	public void testupdatePrenomTuple() throws SQLException {
		PatientDAO emp = new PatientDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		Date aujourdhui = new Date(System.currentTimeMillis());
		Patient testPatient=new Patient(47, "Dupont","richard","4444","3 rue Edouard Garcin","Richardatpomail.com","55",aujourdhui);
		int id=58;
		boolean bool = emp.updatePrenomTuple(testPatient, id);
		assertFalse(bool);
	}

	@Test
	public void testupdateNomTuple(Patient p, int id) throws SQLException {
		PatientDAO emp = new PatientDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		Date aujourdhui = new Date(System.currentTimeMillis());
		Patient testPatient=new Patient(47, "Dupont","richard","4444","3 rue Edouard Garcin","Richardatpomail.com","55",aujourdhui);
		int id1=58;
		boolean bool = emp.updateNomTuple(testPatient, id1);
		assertFalse(bool);
	}

	@Test
	public void testupdateNumeroTuple() throws SQLException {
		PatientDAO emp = new PatientDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		Date aujourdhui = new Date(System.currentTimeMillis());
		Patient testPatient=new Patient(47, "Dupont","richard","4444","3 rue Edouard Garcin","Richardatpomail.com","55",aujourdhui);
		int id=58;
		boolean bool = emp.updateNumeroTuple(testPatient, id);
		assertFalse(bool);
	}

	@Test
	public void updateAdresseTuple() throws SQLException {
		PatientDAO emp = new PatientDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		Date aujourdhui = new Date(System.currentTimeMillis());
		Patient testPatient=new Patient(47, "Dupont","richard","4444","89 Avenue de la Republique","Richardatpomail.com","55",aujourdhui);
		int id=58;
		boolean bool = emp.updateMailTuple(testPatient, id);
		assertFalse(bool);
	}

	@Test
	public void updateMailTuple() throws SQLException {
		PatientDAO emp = new PatientDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		Date aujourdhui = new Date(System.currentTimeMillis());
		Patient testPatient=new Patient(47, "Dupont","richard","4444","89 Avenue de la Republique","Richardatpomail.com","55",aujourdhui);
		int id=58;
		boolean bool = emp.updateMailTuple(testPatient, id);
		assertFalse(bool);
	}
}
