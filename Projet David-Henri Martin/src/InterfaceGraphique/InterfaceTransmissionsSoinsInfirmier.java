package InterfaceGraphique;

import java.awt.FlowLayout;

import java.awt.event.ActionListener;

import javax.swing.*;

public class InterfaceTransmissionsSoinsInfirmier extends JFrame{

	private JLabel prenom = new JLabel("Prénom");
	protected JTextField prenomdupatient = new JTextField(20); 
	private JLabel nom = new JLabel("Nom");
	protected JTextField nomdupatient = new JTextField(20);
	protected JButton SelectionnerTransmi = new JButton("Selectionner un patient");	
	private JLabel TransmissionPatient = new JLabel("Transmission pour le patient");
	protected JTextArea transmission = new JTextArea(20,20);
	private JScrollPane scrollableTextArea = new JScrollPane(transmission);

	public InterfaceTransmissionsSoinsInfirmier() {
		JPanel panel=new JPanel();
		setSize(500,900);
		setContentPane(panel);
		panel.setLayout(new FlowLayout(1, 150, 20));	
		getContentPane().add(nom);
		getContentPane().add(nomdupatient);
		getContentPane().add(prenom);
		getContentPane().add(prenomdupatient);;	
		getContentPane().add(TransmissionPatient);
		getContentPane().add(transmission);
		scrollableTextArea.getViewport().add(transmission);
		getContentPane().add(scrollableTextArea);
		transmission.setEditable(false);
		getContentPane().add(SelectionnerTransmi);
		setVisible(false);
	}

	public void SelectionnerTransmissionActionListener(ActionListener l) {
		SelectionnerTransmi.addActionListener(l);
	}	
}
