package InterfaceGraphique;

import java.awt.FlowLayout;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.swing.*;

public class InterfaceLogin extends JFrame {

	protected Map<String,String> mapMedecin = new HashMap<String,String>();
	private Map<String,String> mapInfirmier = new HashMap<String,String>();
	private Map<String,String> mapAideSoignant = new HashMap<String,String>();
	private Map<String,String> mapAgentDaccueil = new HashMap<String,String>();
	private Map<String,String> mapAgentAdministratif = new HashMap<String,String>();
	public JTextField Login = new JTextField(30);
	public JPasswordField motdePasse = new JPasswordField(30);
	protected JButton SeConnecter=new JButton("Se connecter");
	private FlowLayout layout=new FlowLayout(1, 0, 700);

	public InterfaceLogin() {
		JPanel panel=new JPanel();
		setSize(10000,10000);
		setContentPane(panel);
		panel.setLayout(layout);
		getContentPane().add(Login);
		getContentPane().add(motdePasse);
		getContentPane().add(SeConnecter);
		setVisible(true);
	}	

	public boolean addLoginetPassMedecin() {
		boolean bool=false;
		mapMedecin.put("Richard", "Eclaircie");
		String login =Login.getText();
		char [] passe= motdePasse.getPassword();
		String pass = new String(passe);
		for (Map.Entry<String, String> e : mapMedecin.entrySet()) {
			if (e.getKey().equals(login) == true && e.getValue().equals(pass)==true) {
				bool=true;
			}       
		}
		return bool;
	}

	public String getNom() {
		String text= Login.getText();
		return text;
	}

	public String getPass() {
		char [] passe= motdePasse.getPassword();
		String pass = new String(passe);
		return pass;
	}

	public boolean addLoginetPassInfirmier() {
		boolean bool=false;
		mapInfirmier.put("Nadine", "Ouragan");
		String login =Login.getText();
		char [] passe= motdePasse.getPassword();
		String pass = new String(passe);
		for (Map.Entry<String, String> e : mapInfirmier.entrySet()) {
			if (e.getKey().equals(login) == true && e.getValue().equals(pass)==true) {
				bool=true;
			}       
		}
		return bool;
	}

	public boolean addLoginetPassAideSoignant() {
		boolean bool=false;
		mapAideSoignant.put("Olivier", "Tempete");
		String login =Login.getText();
		char [] passe= motdePasse.getPassword();
		String pass = new String(passe);
		for (Map.Entry<String, String> e : mapAideSoignant.entrySet()) {
			if (e.getKey().equals(login) == true && e.getValue().equals(pass)==true) {
				bool=true;
			}       
		}
		return bool;
	}

	public boolean addLoginetPassAgentDaccueil() {
		boolean bool=false;
		mapAgentDaccueil.put("Jeanine", "Cyclone");
		String login =Login.getText();
		char [] passe= motdePasse.getPassword();
		String pass = new String(passe);
		for (Map.Entry<String, String> e : mapAgentDaccueil.entrySet()) {
			if (e.getKey().equals(login) == true && e.getValue().equals(pass)==true) {
				bool=true;
			}       
		}
		return bool;
	}

	public boolean addLoginetPassAgentAdministratif() {
		boolean bool=false;
		mapAgentAdministratif.put("Pascal", "Typhon");
		String login =Login.getText();
		char [] passe= motdePasse.getPassword();
		String pass = new String(passe);
		for (Map.Entry<String, String> e : mapAgentAdministratif.entrySet()) {
			if (e.getKey().equals(login) == true && e.getValue().equals(pass)==true) {
				bool=true;
			}       
		}
		return bool;
	}

	public void addSeConnecterListener(ActionListener l) {
		SeConnecter.addActionListener(l);		
	}
}




