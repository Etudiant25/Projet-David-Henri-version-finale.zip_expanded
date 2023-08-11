package InterfaceGraphique;

import java.awt.BorderLayout;




import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import Entree.Antecedents;
import InterfaceGraphique.ControleurFinal.VisualiserLalisteDantecedents;

import java.awt.Color;


public class InterfaceMedecin extends JFrame{


	private InterfaceTransmissionsSoinsInfirmier transmi = new InterfaceTransmissionsSoinsInfirmier();	
	private JMenuBar menubarre= new JMenuBar();
	private JMenu menu2= new JMenu("Ordonnance");
	private JMenu menu3= new JMenu("Patient");
	private JMenu menu4= new JMenu("Paramedical");
	private JMenuItem OrdonnancePatient = new JMenuItem("Ordonnance Patient");
	protected JMenuItem VisualiserAntecedent=new JMenuItem("Visualiser Antecedent");
	private JMenuItem VisualiserTransmissionInfirmier=new JMenuItem("Visualiser Transmission Infirmier");
	private JLabel nomMED = new JLabel("Nom du medecin prescripteur");
	protected JTextField nomMedecin = new JTextField(30);
	private JLabel afficherTextAntecedent = new JLabel("Antécédents");
	protected JTextArea antecedent = new JTextArea(30,30);
	private JButton validerAntecedent= new JButton("Valider");
	private JLabel afficherObservationMedecin = new JLabel("Observations Medecin");
	protected JTextArea ObservationMed= new JTextArea(30,30);
	private JLabel piqure1 = new JLabel ("Piqure");
	protected JTextField piqure = new JTextField(30);
	private JButton validerPiqure = new JButton("Valider");
	private JLabel pillule1 = new JLabel ("Comprimés");
	protected JTextField pillule = new JTextField(30);
	private JButton validerPillule = new JButton("Valider");
	private JLabel pansement1 = new JLabel ("Pansement");
	protected JTextField pansement = new JTextField(30);
	private JButton validerPansement = new JButton("Valider");
	private JLabel exercice1 = new JLabel ("Exercice à faire");
	protected JTextField exercice = new JTextField(30);
	private JButton validerExercice = new JButton("Valider");
	private JLabel materiel1 = new JLabel ("Materiels");
	protected JTextField materiels = new JTextField(30);
	private JButton validerMateriels = new JButton("Valider");
	private JLabel operation1 = new JLabel ("Operation à Realiser");
	protected JTextField operation = new JTextField(30);
	private JButton validerOperation = new JButton("Valider");	
	protected JCheckBox ECG= new JCheckBox("ECG");
	protected JCheckBox PriseTension=new JCheckBox("Prise de tension");
	private JButton Valider = new JButton("Valider");
	private JScrollPane scrollableTextArea = new JScrollPane(antecedent);
	private JScrollPane scrollableTextArea3 = new JScrollPane(ObservationMed);
	private JLabel Materiel = new JLabel("Liste de matériel");
	String [] materiel = {"Fauteuil roulant", "Velo", "Deambulateur", "Barrière", "Cannes"};
	protected JList<String> listedeMateriel = new JList<String>(materiel);
	private JScrollPane scrollableTextArea4 = new JScrollPane(listedeMateriel);
	private JButton selectionner = new JButton("Sélectionner");
	protected JLabel NomDuPatient = new JLabel("Nom du Patient");
	protected JLabel PrenomDuPatient = new JLabel("Prenom du Patient");
	protected JTextField nomdupatient = new JTextField();
	protected JTextField prenomdupatient = new JTextField();

	public InterfaceMedecin() {
		JPanel panel=new JPanel();
		this.setSize(10000,10000);
		JPanel panneau = new JPanel();
		panneau.setBackground(Color.darkGray);;
		this.setContentPane(panel);
		setJMenuBar(menubarre);	
		ajouterMenu();				
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		getContentPane().add(nomMED);
		getContentPane().add(nomMedecin);

		//prenom et nom patient

		getContentPane().add(NomDuPatient);
		getContentPane().add(nomdupatient);
		getContentPane().add(PrenomDuPatient);
		getContentPane().add(prenomdupatient);

		//Observation Medicale

		getContentPane().add(afficherObservationMedecin);
		getContentPane().add(ObservationMed);
		scrollableTextArea3.getViewport().add(ObservationMed);
		getContentPane().add(scrollableTextArea3);
		getContentPane().add(piqure1);
		getContentPane().add(piqure);
		getContentPane().add(validerPiqure);
		getContentPane().add(pillule1);
		getContentPane().add(pillule);
		getContentPane().add(validerPillule);
		getContentPane().add(pansement1);
		getContentPane().add(pansement);
		getContentPane().add(validerPansement);
		getContentPane().add(exercice1);
		getContentPane().add(exercice);
		getContentPane().add(validerExercice);
		getContentPane().add(operation1);
		getContentPane().add(operation);
		getContentPane().add(validerOperation);
		getContentPane().add(afficherTextAntecedent);
		getContentPane().add(antecedent);
		scrollableTextArea.getViewport().add(antecedent);
		getContentPane().add(scrollableTextArea);
		getContentPane().add(validerAntecedent);
		antecedent.setEditable(false);
		bordureText();

		//liste de materiel

		getContentPane().add(Materiel);
		getContentPane().add(listedeMateriel);
		scrollableTextArea4.getViewport().add(listedeMateriel);
		getContentPane().add(scrollableTextArea4);
		getContentPane().add(selectionner);	
		getContentPane().add(ECG);
		getContentPane().add(PriseTension);
		getContentPane().add(BorderLayout.NORTH, panneau);
		panneau.add(Valider);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(false);
	}	

	public void ajouterMenu() {
		menubarre.add(menu2);
		menubarre.add(menu3);
		menu2.add(OrdonnancePatient);
		menu3.add(VisualiserAntecedent);
		menu3.add(VisualiserTransmissionInfirmier);
	}

	public void bordureText() {
		Border titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.black, new Color(156,156,156)));
		antecedent.setBorder(titledBorder1);
		ObservationMed.setBorder(titledBorder1);
	}

	//antecedent

	public void addVisualiserListener(ActionListener l) {
		validerAntecedent.addActionListener(l);		
	}

	//Bouton prescription

	public void addValiderPiqure(ActionListener l) {
		validerPiqure.addActionListener(l);		
	}

	public void addValiderPillule(ActionListener l) {
		validerPillule.addActionListener(l);		
	}

	public void addValiderPansement(ActionListener l) {
		validerPansement.addActionListener(l);		
	}

	public void addValiderExercice(ActionListener l) {
		validerExercice.addActionListener(l);		
	}


	public void addValiderOperation(ActionListener l) {
		operation.addActionListener(l);		
	}

	public void addValiderECG(ActionListener l) {
		ECG.addActionListener(l);		
	}

	public void addValiderPRISEDETENSION(ActionListener l) {
		PriseTension.addActionListener(l);		
	}

	public String getPiqureText() {
		String text = piqure.getText();
		return text;
	}

	public String getPansementText() {
		String text = pansement.getText();
		return text;
	}

	public String getPilluleText() {
		String text= pillule.getText();
		return text;
	}


	public String getExerciceText() {
		String text= exercice.getText();
		return text;
	}

	public String getOperationText() {
		String text= operation.getText();
		return text;
	}

	public boolean getECGCheck() {
		boolean text= ECG.isSelected();
		return text;
	}

	public boolean getPrisedetensionCheck() {
		boolean text= PriseTension.isSelected();
		return text;
	}

	public String getMaterielCheck() {
		String item = listedeMateriel.getSelectedValue();
		return item;
	}

	//enregistrer une ordonnance patient

	public void EnregistreruneOrdonnance(ActionListener l) {
		Valider.addActionListener(l);		
	}

	// bouton selectionner matériel

	public void addSelectionnerMateriel(ActionListener l) {
		selectionner.addActionListener(l);		
	}

	//menu

	public void addVisualiserAntecedentFenetre(ActionListener l) {
		VisualiserAntecedent.addActionListener(l);		
	}

	public void OrdonnancePatientListener(ActionListener l) {
		OrdonnancePatient.addActionListener(l);
	}

	public void VisualiserTransmissionsListener(ActionListener l) {
		VisualiserTransmissionInfirmier.addActionListener(l);
	}
}	
