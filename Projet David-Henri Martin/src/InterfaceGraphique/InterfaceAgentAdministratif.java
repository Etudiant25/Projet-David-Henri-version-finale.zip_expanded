package InterfaceGraphique;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


public class InterfaceAgentAdministratif extends JFrame {




	private JLabel Role = new JLabel("Role");
	protected JTextField RoleText = new JTextField(30);	
	private JLabel Service = new JLabel("Service");
	protected JTextField ServiceText = new JTextField(30);
	private JLabel Poste = new JLabel("Poste");
	protected JTextField PosteText = new JTextField(30);
	private JLabel Pole = new JLabel("Pole");
	protected JTextField PoleText = new JTextField(30);
	private JLabel Specialite = new JLabel("Specialité");
	protected JTextField SpecialiteText = new JTextField(30);	
	private JLabel Nom = new JLabel("Nom");
	protected JTextField NomText = new JTextField(30);
	private JLabel Prenom = new JLabel("Prenom");
	protected JTextField PrenomText = new JTextField(30);
	private JLabel Adresse = new JLabel("Adresse");
	protected JTextField AdresseText = new JTextField(30);
	private JLabel Mail = new JLabel("Mail");
	protected JTextField MailText = new JTextField(30);
	private JLabel Age= new JLabel("Age");
	protected JTextField AgeText = new JTextField(30);
	protected JCheckBox AgentDaccueilCheck = new JCheckBox ("Agent D'accueil");
	protected JCheckBox AideServiceHospitalierCheck = new JCheckBox ("Aide au Service Hospitalier");
	protected JCheckBox AideSoignantCheck = new JCheckBox ("Aide Soignant");
	protected JCheckBox DirectionCheck = new JCheckBox ("Direction");
	protected JCheckBox InfirmierCheck = new JCheckBox ("Infirmier");
	protected JCheckBox KinesitherapeuteCheck = new JCheckBox ("Kinesithérapeute");
	protected JCheckBox MedecinCheck = new JCheckBox("Medecin");
	protected JCheckBox PsychologueCheck = new JCheckBox ("Psychologue");
	private JButton Inscrire = new JButton("Inscrire");

	public InterfaceAgentAdministratif() {
		JPanel panel=new JPanel();
		JPanel panneau = new JPanel();
		this.setSize(10000,10000);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.setContentPane(panel);
		getContentPane().add(Nom);
		getContentPane().add(NomText);
		getContentPane().add(Prenom);
		getContentPane().add(PrenomText);
		getContentPane().add(Adresse);
		getContentPane().add(AdresseText);
		getContentPane().add(Mail);
		getContentPane().add(MailText);		
		getContentPane().add(Age);
		getContentPane().add(AgeText);
		getContentPane().add(AgentDaccueilCheck);
		getContentPane().add(AideServiceHospitalierCheck);
		getContentPane().add(AideSoignantCheck);
		getContentPane().add(InfirmierCheck);
		getContentPane().add(DirectionCheck);
		getContentPane().add(KinesitherapeuteCheck);
		getContentPane().add(PsychologueCheck);
		getContentPane().add(MedecinCheck);
		getContentPane().add(Role);
		getContentPane().add(RoleText);
		getContentPane().add(Service);
		getContentPane().add(ServiceText);
		getContentPane().add(Poste);
		getContentPane().add(PosteText);
		getContentPane().add(Pole);
		getContentPane().add(PoleText);
		getContentPane().add(Specialite);
		getContentPane().add(SpecialiteText);
		getContentPane().add(Inscrire);
		bordureText();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
	}

	public void bordureText() {
		Border titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.black, new Color(156,156,156)));
		NomText.setBorder(titledBorder1);
		PrenomText.setBorder(titledBorder1);
		MailText.setBorder(titledBorder1);
		AgeText.setBorder(titledBorder1);
		AdresseText.setBorder(titledBorder1);
		RoleText.setBorder(titledBorder1);
		ServiceText.setBorder(titledBorder1);
		PosteText.setBorder(titledBorder1);
		PoleText.setBorder(titledBorder1);
		SpecialiteText.setBorder(titledBorder1);
	}

	public void InscrirePersonneladdActionListener(ActionListener l) {
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

	public String getAdresseText() {
		String textObserv = AdresseText.getText();
		return textObserv;
	}

	public String getMailText() {
		String textObserv = MailText.getText();
		return textObserv;
	}

	public String getAgeText() {
		String textObserv = AgeText.getText();
		return textObserv;
	}

	public String getRoleText() {
		String textObserv = RoleText.getText();
		return textObserv;
	}

	public String getServiceText() {
		String textObserv = ServiceText.getText();
		return textObserv;
	}

	public String getPosteText() {
		String textObserv = PosteText.getText();
		return textObserv;
	}

	public String getPoleText() {
		String textObserv = PoleText.getText();
		return textObserv;
	}

	public String getSpecialiteText() {
		String textObserv = SpecialiteText.getText();
		return textObserv;
	}
}
