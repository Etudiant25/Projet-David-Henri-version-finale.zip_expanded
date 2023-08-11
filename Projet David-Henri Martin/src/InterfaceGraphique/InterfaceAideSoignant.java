package InterfaceGraphique;

import java.awt.BorderLayout;

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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import InterfaceGraphique.ControleurFinal.VisualiserLalisteDante;

public class InterfaceAideSoignant extends JFrame{


	private JMenuBar menubarre= new JMenuBar();
	private JMenu menu3= new JMenu("Patient");
	private JMenu menu4= new JMenu("Paramedical");	
	private JMenuItem TransmissionsInfirmier = new JMenuItem("Transmissions infirmier");
	private JMenuItem VisualiserAntecedent=new JMenuItem("Visualiser Antecedent");
	protected JLabel NomDuPatient = new JLabel("Nom du Patient");
	protected JLabel PrenomDuPatient = new JLabel("Prenom du Patient");
	protected JTextField nomdupatient = new JTextField(20);
	protected JTextField prenomdupatient = new JTextField(20);	
	private JLabel NomdeLaideSoignant = new JLabel("Nom de l'aide soignant");
	protected JTextField NomDeLAS = new JTextField(30);	
	private JLabel Transmissions = new JLabel("Transmissions");
	protected JLabel ObservationType = new JLabel("Observations");
	protected JLabel ObservationPourEquipe = new JLabel("Observation de l'équipe");
	private JButton Valider = new JButton("Valider");
	protected JCheckBox Soinsdebouche = new JCheckBox ("Soins de bouche");
	protected JCheckBox PrisedeTension = new JCheckBox ("Prise de tension");
	protected JCheckBox AideAuLever = new JCheckBox ("Aide au Lever");
	protected JCheckBox Escarre = new JCheckBox ("Soins d'escarre");
	protected JCheckBox ToiletteAuLit = new JCheckBox ("Toilette au lit");
	protected JCheckBox ToiletteAuLavabo = new JCheckBox("Toilette au lavabo");
	protected JCheckBox Douche = new JCheckBox ("Douche");
	protected JTextArea Observation = new JTextArea("Observations", 30,30);
	protected JTextArea ObservationsEquipeAS = new JTextArea("Observation équipe", 20,20);
	private JButton Observer = new JButton("Observer");
	private JScrollPane scrollableTextArea = new JScrollPane(Observation);
	private JScrollPane scrollableTextArea2 = new JScrollPane(ObservationsEquipeAS);

	public InterfaceAideSoignant(){

		JPanel panel= new JPanel();
		setSize(10000,10000);
		JPanel panneau = new JPanel();
		JPanel panneau2 = new JPanel();
		setContentPane(panel);
		setJMenuBar(menubarre);
		ajouterMenu();	
		getContentPane().add(NomdeLaideSoignant);
		getContentPane().add(NomDeLAS);
		getContentPane().add(NomDuPatient);
		getContentPane().add(nomdupatient);
		getContentPane().add(PrenomDuPatient);
		getContentPane().add(prenomdupatient);	
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		getContentPane().add(Transmissions);
		getContentPane().add(BorderLayout.EAST, panneau);
		addPanneau(panneau);	
		getContentPane().add(ObservationType);
		getContentPane().add(Observation);
		scrollableTextArea.getViewport().add(Observation);
		getContentPane().add(scrollableTextArea);
		getContentPane().add(Valider);	
		getContentPane().add(ObservationPourEquipe);
		getContentPane().add(ObservationsEquipeAS);
		scrollableTextArea2.getViewport().add(ObservationsEquipeAS);
		getContentPane().add(scrollableTextArea2);
		getContentPane().add(Observer);
		getContentPane().add(BorderLayout.EAST, panneau2);
		bordureText();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
	}

	public void ajouterMenu() {
		menubarre.add(menu4);
		menubarre.add(menu3);
		menu4.add(TransmissionsInfirmier);
		menu3.add(VisualiserAntecedent);
	}

	public void addPanneau(JPanel panneau) {
		panneau.add(Soinsdebouche);
		panneau.add(PrisedeTension);
		panneau.add(AideAuLever);
		panneau.add(ToiletteAuLit);
		panneau.add(ToiletteAuLavabo);
		panneau.add(Douche);
		panneau.add(Escarre);
	}

	public void bordureText() {
		Border titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.black, new Color(156,156,156)));
		Observation.setBorder(titledBorder1);
		ObservationsEquipeAS.setBorder(titledBorder1);
	}

	public void SoinsdeboucheaddItemListener(ActionListener l) {
		Soinsdebouche.addActionListener(l);
	}

	public void PrisedeTensionaddItemListener(ActionListener l) {
		PrisedeTension.addActionListener(l);
	}

	public void AideAuLeveraddItemListener(ActionListener l) {
		AideAuLever.addActionListener(l);
	}

	public void ToiletteAuLitaddItemListener(ActionListener l) {
		ToiletteAuLit.addActionListener(l);
	}

	public void ToiletteAuLavaboaddItemListener(ActionListener l) {
		ToiletteAuLavabo.addActionListener(l);
	}

	public void EscarreASaddItemListener(ActionListener l) {
		Escarre.addActionListener(l);
	}

	public void DoucheaddItemListener(ActionListener l) {
		Douche.addActionListener(l);
	}

	public void ValidertransmissionASListener(ActionListener l) {
		Valider.addActionListener(l);
	}

	public void VisualiserObservationaASListener(ActionListener l) {
		Observer.addActionListener(l);
	}

	//visualiser transmission antecedents

	public void TransmissionInfirmierListener(ActionListener e) {
		TransmissionsInfirmier.addActionListener(e);
	}

	public void ChoisirVisualiserAntecedents(ActionListener e) {
		VisualiserAntecedent.addActionListener(e);
	}

	//obtenir le get text Observation

	public String getTextObservation() {
		String textObserv = Observation.getText();
		return textObserv;
	}

	// retroucher la transmission

	public boolean getSoinsdeboucheCheck() {
		boolean text= Soinsdebouche.isSelected();;
		return text;
	}

	public boolean getPrisedetensionCheck() {
		boolean text= PrisedeTension.isSelected();;
		return text;
	}

	public boolean getAideAuLeverCheck() {
		boolean text= AideAuLever.isSelected();;
		return text;
	}

	public boolean getToiletteAuLitCheck() {
		boolean text= ToiletteAuLit.isSelected();;
		return text;
	}	

	public boolean getToiletteAuLavaboCheck() {
		boolean text= ToiletteAuLavabo.isSelected();;
		return text;
	}

	public boolean getEscarreASCheck() {
		boolean text= Escarre.isSelected();;
		return text;
	}

	public boolean getDoucheCheck() {
		boolean text= Douche.isSelected();;
		return text;
	}
}
