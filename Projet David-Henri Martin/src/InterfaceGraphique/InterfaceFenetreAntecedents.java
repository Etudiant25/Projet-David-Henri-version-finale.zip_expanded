package InterfaceGraphique;

import java.awt.Color;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class InterfaceFenetreAntecedents extends JFrame{



	protected JLabel Nom = new JLabel("Nom du Patient");
	protected JTextField NomDuPatient = new JTextField(30);
	protected JLabel Prenom = new JLabel("Prenom du Patient");
	protected JTextField PrenomDuPatient = new JTextField(30);
	protected JLabel Handicap = new JLabel("Handicap du Patient");
	protected JTextField HandicapDuPatient = new JTextField(30);
	protected JLabel Operation = new JLabel("Operation du Patient");
	protected JTextField OperationDuPatient = new JTextField(30);
	protected JLabel Addiction = new JLabel("Addiction");
	protected JTextField AddictionDuPatient = new JTextField(30);
	protected JLabel MaladieChronique = new JLabel("MaladieChronique du Patient");
	protected JTextField MaladieChroniqueDuPatient = new JTextField(30);
	protected JLabel MaladiePeau = new JLabel("Maladie de peau du Patient");
	protected JTextField MaladiePeauDuPatient = new JTextField(30);
	protected JLabel MaladieOrganique = new JLabel("Maladie Organique du Patient");
	protected JTextField MaladieOrganiqueDuPatient = new JTextField(30);
	protected JLabel MaladieInfectieuse = new JLabel("Maladie Infectieuse du Patient");
	protected JTextField MaladieInfectieuseDuPatient = new JTextField(30);	
	private JButton Enregistrer = new JButton("Enregistrer");

	public InterfaceFenetreAntecedents() {
		JPanel panel= new JPanel();
		setSize(10000,10000);
		JPanel panneau = new JPanel();
		setContentPane(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		getContentPane().add(Nom);
		getContentPane().add(NomDuPatient);
		getContentPane().add(Prenom);
		getContentPane().add(PrenomDuPatient);
		getContentPane().add(Handicap);
		getContentPane().add(HandicapDuPatient);
		getContentPane().add(Operation);
		getContentPane().add(OperationDuPatient);
		getContentPane().add(Addiction);
		getContentPane().add(AddictionDuPatient);
		getContentPane().add(MaladieChronique);
		getContentPane().add(MaladieChroniqueDuPatient);
		getContentPane().add(MaladiePeau);
		getContentPane().add(MaladiePeauDuPatient);
		getContentPane().add(MaladieOrganique);
		getContentPane().add(MaladieOrganiqueDuPatient);
		getContentPane().add(MaladieInfectieuse);
		getContentPane().add(MaladieInfectieuseDuPatient);
		getContentPane().add(Enregistrer);
		bordureText();
		setVisible(false);	
	}

	public void bordureText() {
		Border titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.black, new Color(156,156,156)));
		NomDuPatient.setBorder(titledBorder1);
		PrenomDuPatient.setBorder(titledBorder1);
		HandicapDuPatient.setBorder(titledBorder1);
		OperationDuPatient.setBorder(titledBorder1);
		AddictionDuPatient.setBorder(titledBorder1);
		MaladieChroniqueDuPatient.setBorder(titledBorder1);
		MaladiePeauDuPatient.setBorder(titledBorder1);
		MaladieOrganiqueDuPatient.setBorder(titledBorder1);
		MaladieInfectieuseDuPatient.setBorder(titledBorder1);
	}

	public void EnregistrerAntecedentsListener(ActionListener l) {
		Enregistrer.addActionListener(l);
	}	
}
