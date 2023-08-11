package InterfaceGraphique;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class InterfaceAgentDaccueil extends JFrame {



	private JLabel Nom = new JLabel("Nom");
	protected JTextField NomText = new JTextField(30);
	private JLabel Prenom = new JLabel("Prenom");
	protected JTextField PrenomText = new JTextField(30);
	private JLabel NumerodeSecuriteSociale = new JLabel("Numero de Securité sociale");
	protected JTextField NumeroSSText = new JTextField(30);
	private JLabel Adresse = new JLabel("Adresse");
	protected JTextField AdresseText = new JTextField(30);
	private JLabel Mail = new JLabel("Mail");
	protected JTextField MailText = new JTextField(30);
	private JLabel Age= new JLabel("Age");
	protected JTextField AgeText = new JTextField(30);
	private JButton Inscrire = new JButton("Inscrire");
	private FlowLayout layout = new FlowLayout(1, 0, 400);

	public InterfaceAgentDaccueil() {
		JPanel panel=new JPanel();
		JPanel panneau = new JPanel();
		this.setSize(10000,10000);
		panel.setLayout(layout);
		this.setContentPane(panel);
		getContentPane().add(Nom);
		getContentPane().add(NomText);
		getContentPane().add(Prenom);
		getContentPane().add(PrenomText);
		getContentPane().add(NumerodeSecuriteSociale);
		getContentPane().add(NumeroSSText);
		getContentPane().add(Adresse);
		getContentPane().add(AdresseText);
		getContentPane().add(Mail);
		getContentPane().add(MailText);		
		getContentPane().add(Age);
		getContentPane().add(AgeText);
		getContentPane().add(Inscrire);
		bordureText();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
	}

	public void bordureText() {
		Border titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.black, new Color(156,156,156)));
		NomText.setBorder(titledBorder1);
		PrenomText.setBorder(titledBorder1);
		NumeroSSText.setBorder(titledBorder1);
		MailText.setBorder(titledBorder1);
		AgeText.setBorder(titledBorder1);
		AdresseText.setBorder(titledBorder1);
	}

	public void InscrireaddActionListener(ActionListener l) {
		Inscrire.addActionListener(l);
	}

	public String getNomText() {
		String textObserv = NomText.getText();
		return textObserv;
	}

	public String getPrenomText() {
		String textObserv = PrenomText.getText();
		return textObserv;
	}

	public String getNumeroSecturiteSocialeText() {
		String textObserv = NumeroSSText.getText();
		return textObserv;
	}	

	public String getAdresseText() {
		String textObserv = AdresseText.getText();
		return textObserv;
	}

	public String getMailText() {
		String textObserv = MailText.getText();
		return textObserv;
	}

	public String getAgeText() {
		String textObserv = (String)AgeText.getText();
		return textObserv;
	}	
}
