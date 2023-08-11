package InterfaceGraphique;

import java.awt.FlowLayout;

import java.awt.event.ActionListener;

import javax.swing.*;

public class InterfaceAntecedentPatientMedecin extends JFrame {


	private JLabel prenom = new JLabel("Prénom");
	protected JTextField prenomdupatient = new JTextField(20); 
	private JLabel nom = new JLabel("Nom");
	protected JTextField nomdupatient = new JTextField(20);
	protected JButton Selectionner = new JButton("Selectionner un patient");
	private JLabel AntecentsPatient = new JLabel("Antecedents du Patient");
	protected JTextArea antecedents = new JTextArea(20,20);
	private JScrollPane scrollableTextArea = new JScrollPane(antecedents);

	public InterfaceAntecedentPatientMedecin() {
		JPanel panel=new JPanel();
		setSize(500,900);
		setContentPane(panel);
		panel.setLayout(new FlowLayout(1, 150, 20));	
		getContentPane().add(nom);
		getContentPane().add(nomdupatient);
		getContentPane().add(prenom);
		getContentPane().add(prenomdupatient);;	
		getContentPane().add(AntecentsPatient);
		getContentPane().add(antecedents);
		scrollableTextArea.getViewport().add(antecedents);
		getContentPane().add(scrollableTextArea);
		antecedents.setEditable(false);
		getContentPane().add(Selectionner);
		setVisible(false);
	}

	public void VisualiserAntecdentSelectionner(ActionListener l) {
		Selectionner.addActionListener(l);
	}	
}
