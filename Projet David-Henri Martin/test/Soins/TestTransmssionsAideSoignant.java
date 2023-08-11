package Soins;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import Entree.SingleConnection;

public class TestTransmssionsAideSoignant {


	@Test
	public void createTABLE() throws SQLException {
		TransmissionsAideSoignantDAO emp = new TransmissionsAideSoignantDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		TransmissionsAideSoignant testPatient = new TransmissionsAideSoignant();
		boolean bool = emp.createTABLE();
		assertTrue(bool);
	}

	@Test
	public void insereTUPLE() throws SQLException {
		TransmissionsAideSoignantDAO emp = new TransmissionsAideSoignantDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		Date aujourdhui = new Date(System.currentTimeMillis());
		TransmissionsAideSoignant testtransmi=new TransmissionsAideSoignant(1, 5, "San", "Marco", false,true,false,true,false,false,false,"patient calme", "Nadine AS", aujourdhui);
		boolean bool = emp.insereTUPLE(testtransmi);
		assertFalse(bool);
	}	
}
