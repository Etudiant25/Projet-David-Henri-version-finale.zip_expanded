package InterfaceGraphique;

import java.awt.FlowLayout;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InterfaceVisualiserUneOrdonnance extends JFrame {

	private JLabel prenom = new JLabel("Prénom");
	protected JTextField prenomdupatient = new JTextField(20); 
	private JLabel nom = new JLabel("Nom");
	protected JTextField nomdupatient = new JTextField(20);
	protected JButton Selectionner = new JButton("Selectionner un patient");	
	private JLabel OrdonnancePatient = new JLabel("Ordonnance du Patient");
	protected JTextArea Ordonnance = new JTextArea(20,20);
	private JScrollPane scrollableTextArea = new JScrollPane(Ordonnance);

	public InterfaceVisualiserUneOrdonnance() {
		JPanel panel=new JPanel();
		setSize(500,900);
		setContentPane(panel);
		panel.setLayout(new FlowLayout(1, 150, 20));	
		getContentPane().add(nom);
		getContentPane().add(nomdupatient);
		getContentPane().add(prenom);
		getContentPane().add(prenomdupatient);;
		getContentPane().add(OrdonnancePatient);
		getContentPane().add(Ordonnance);
		scrollableTextArea.getViewport().add(Ordonnance);
		getContentPane().add(scrollableTextArea);
		Ordonnance.setEditable(false);
		getContentPane().add(Selectionner);
		setVisible(false);	
	}

	public void SelectionnerActionListener(ActionListener l) {
		Selectionner.addActionListener(l);
	}
}
