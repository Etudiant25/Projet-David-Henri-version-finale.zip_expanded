package Interface;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.junit.Test;
import InterfaceGraphique.InterfaceLogin;


public class TestInterfaceLogin {	

	@Test (timeout=10000)
	public void LoginetPassAgentDaccueil() {
		InterfaceLogin login = new InterfaceLogin();
		boolean bool = false;
		JTextField Login = new JTextField("Jeanine",30);
		JPasswordField motdePasse = new JPasswordField("Cyclone",30);
		login.Login = Login;
		login.motdePasse = motdePasse;
		bool = login.addLoginetPassAgentDaccueil();
		assertTrue(bool);
	}
}
