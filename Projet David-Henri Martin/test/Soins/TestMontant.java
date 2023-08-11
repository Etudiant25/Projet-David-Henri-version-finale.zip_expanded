package Soins;

import org.junit.*;
import static org.junit.Assert.*;


public class TestMontant {

	@Test
	public final void testmontant() {
		Facture fact=new Facture();
		fact.setAppareilMontant(25.00);
		fact.setHospitalisationMontant(25.00);		
		fact.setMedicamentMontant(25.00); 	
		fact.setSoinsExterne(25.00);
		assertEquals(Double.valueOf(100.00), fact.calculMontant());	
	}	
}