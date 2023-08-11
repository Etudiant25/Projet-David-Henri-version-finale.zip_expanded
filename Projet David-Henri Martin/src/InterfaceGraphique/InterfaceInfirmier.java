package InterfaceGraphique;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import InterfaceGraphique.ControleurFinal.VoirOrdonnance;


public class InterfaceInfirmier extends JFrame {



	private JMenuBar menubarre= new JMenuBar();
	private JMenu menu2= new JMenu("Ordonnance");
	private JMenu menu3= new JMenu("Patient");
	private JMenu menu4= new JMenu("Paramedical");
	private JMenuItem OrdonnancePatient = new JMenuItem("Ordonnance Patient");
	private JMenuItem VisualiserAntecedent=new JMenuItem("Visualiser Antecedent");
	private JLabel Transmissions = new JLabel("Transmissions");
	private JLabel OrdonnanceType = new JLabel("Ordonnance");
	protected JLabel ObservationType = new JLabel("Observations");
	protected JLabel ObservationPourEquipe = new JLabel("Observation de l'équipe");
	private JButton Valider = new JButton("Valider");
	protected JCheckBox ECG = new JCheckBox ("Electrocardiogramme");
	protected JCheckBox PrisedeTension = new JCheckBox ("Prise de tension");
	protected JCheckBox Injection = new JCheckBox ("Injection");
	protected JCheckBox Pillule = new JCheckBox("Pillule");
	protected JCheckBox Pansement = new JCheckBox ("Pansement");
	protected JCheckBox Escarre = new JCheckBox ("Soins d'escarre");
	protected JCheckBox Toilette = new JCheckBox ("Toilette");
	protected JTextArea Ordonnance = new JTextArea(30,30);
	protected JButton Visualiser = new JButton("Visualiser");
	protected JTextArea Observation = new JTextArea("Observations", 30,30);
	protected JTextArea ObservationsEquipe = new JTextArea("Observation équipe", 20,20);
	private JButton Observer = new JButton("Observer");
	private JScrollPane scrollableTextArea = new JScrollPane(Observation);
	private JScrollPane scrollableTextArea2 = new JScrollPane(ObservationsEquipe);
	protected JLabel NomDuPatient = new JLabel("Nom du Patient");
	protected JLabel PrenomDuPatient = new JLabel("Prenom du Patient");
	protected JTextField nomdupatient = new JTextField(20);
	protected JTextField prenomdupatient = new JTextField(20);
	private JLabel NomdeLinfirmier = new JLabel("Nom de l'infirmier");
	protected JTextField NomDeLIDE = new JTextField(30);

	public InterfaceInfirmier(){	
		JPanel panel= new JPanel();
		setSize(10000,10000);
		JPanel panneau = new JPanel();
		JPanel panneau2 = new JPanel();
		setContentPane(panel);
		setJMenuBar(menubarre);
		ajouterMenu();
		getContentPane().add(NomdeLinfirmier);
		getContentPane().add(NomDeLIDE);
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
		getContentPane().add(ObservationsEquipe);
		scrollableTextArea2.getViewport().add(ObservationsEquipe);
		getContentPane().add(scrollableTextArea2);
		getContentPane().add(Observer);	
		getContentPane().add(BorderLayout.EAST, panneau2);
		getContentPane().add(OrdonnanceType);
		getContentPane().add(Ordonnance);
		Ordonnance.setEditable(false);
		getContentPane().add(Visualiser);
		bordureText();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
	}

	public void ajouterMenu() {
		menubarre.add(menu2);
		menubarre.add(menu3);
		menu2.add(OrdonnancePatient);
		menu3.add(VisualiserAntecedent);
	}

	public void addPanneau(JPanel panneau) {
		panneau.add(ECG);
		panneau.add(PrisedeTension);
		panneau.add(Injection);
		panneau.add(Pillule);
		panneau.add(Pansement);
		panneau.add(Escarre);
		panneau.add(Toilette);
	}

	public void bordureText() {
		Border titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.black, new Color(156,156,156)));
		Ordonnance.setBorder(titledBorder1);
		Observation.setBorder(titledBorder1);
		ObservationsEquipe.setBorder(titledBorder1);
	}

	//MENU

	public void OrdonnancePatientListener(ActionListener e) {
		OrdonnancePatient.addActionListener(e);
	}

	public void ChoisirVisualiserAntecedents(ActionListener e) {
		VisualiserAntecedent.addActionListener(e);
	}

	//Bouton valider observation et transmission

	public void ValiderUneTransmissionInfirmier(ActionListener l) {
		Valider.addActionListener(l);		
	}


	//Soins effectués

	public void ECGaddItemListener(ActionListener l) {
		ECG.addActionListener(l);
	}

	public void PrisedeTensionaddItemListener(ActionListener l) {
		PrisedeTension.addActionListener(l);
	}

	public void InjectionaddItemListener(ActionListener l) {
		Injection.addActionListener(l);
	}

	public void PilluleaddItemListener(ActionListener l) {
		Pillule.addActionListener(l);
	}

	public void PansementaddItemListener(ActionListener l) {
		Pansement.addActionListener(l);
	}

	public void EscarretaddItemListener(ActionListener l) {
		Escarre.addActionListener(l);
	}

	public void ToiletteaddItemListener(ActionListener l) {
		Toilette.addActionListener(l);
	}

	//visualiser Ordonnance

	public void VisualiserOrdonnanceListener(ActionListener l) {
		Visualiser.addActionListener(l);
	}
	public void VisualiserObservationListener(ActionListener l) {
		Observer.addActionListener(l);
	}

	//obtenir le get text Observation
	public String getTextObservation() {
		String textObserv = Observation.getText();
		return textObserv;
	}

	public boolean getECGCheck() {
		boolean text= ECG.isSelected();;
		return text;
	}

	public boolean getPrisedetensionCheck() {
		boolean text= PrisedeTension.isSelected();;
		return text;
	}

	public boolean getInjectionCheck() {
		boolean text= Injection.isSelected();;
		return text;
	}

	public boolean getComprimeCheck() {
		boolean text= Pillule.isSelected();;
		return text;
	}

	public boolean getPansementCheck() {
		boolean text= Pansement.isSelected();;
		return text;
	}

	public boolean getEscarreCheck() {
		boolean text= Escarre.isSelected();;
		return text;
	}

	public boolean getToiletteCheck() {
		boolean text= Toilette.isSelected();;
		return text;
	}
}
