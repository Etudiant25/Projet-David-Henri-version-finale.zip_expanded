package Soins;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;

import org.junit.Test;

import Entree.Patient;
import Entree.PatientDAO;
import Entree.SingleConnection;




public class TestTransmissions {


	@Test
	public void createTABLE() throws SQLException {
		TransmissionsDAO emp = new TransmissionsDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		Transmissions testPatient2 = new Transmissions();
		boolean bool = emp.createTABLE();
		assertTrue(bool);
	}

	@Test
	public void insereTUPLE() throws SQLException {
		TransmissionsDAO emp = new TransmissionsDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		Date aujourdhui = new Date(System.currentTimeMillis());
		Transmissions testtransmi=new Transmissions(1, 5, "San", "Marco", false,false,false,false,false,false,false,"ras", "jean-pierre IDE", aujourdhui);
		boolean bool = emp.insereTUPLE(testtransmi);
		assertFalse(bool);
	}	
}
