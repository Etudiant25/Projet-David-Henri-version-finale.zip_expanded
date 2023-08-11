package Entree;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import org.junit.Test;

public class TestPlusUn {

	@Test
	public void testPlusUn() {

		FormulaireEntree form=new FormulaireEntree();
		FormulaireEntree form2=new FormulaireEntree();
		assertEquals(2,form2.getNumeroFormulaire());
		assertTrue(form.isEmpty());
		assertTrue(form.addEntreeNoSS());
		assertTrue(form.entreeNom());
	}
}


