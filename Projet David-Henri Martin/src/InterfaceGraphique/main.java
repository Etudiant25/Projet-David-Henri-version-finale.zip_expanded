package InterfaceGraphique;

import Entree.Patient;

import Papier.Ordonnance;
import Soins.Transmissions;
import Soins.TransmissionsAideSoignant;

public class main {


	public static void main(String [] args) {	
		InterfaceLogin login= new InterfaceLogin();	
		InterfaceMedecin mede=new InterfaceMedecin();
		InterfaceInfirmier infirmier = new InterfaceInfirmier();
		Transmissions transmission = new Transmissions();
		TransmissionsAideSoignant transmissionsAS = new TransmissionsAideSoignant();
		Ordonnance ordonnance = new Ordonnance();
		InterfaceAgentDaccueil agent = new InterfaceAgentDaccueil();
		InterfaceFenetreAntecedents antecedents = new InterfaceFenetreAntecedents();
		InterfaceAideSoignant aidesoignant = new InterfaceAideSoignant();
		Patient patient = new Patient();
		InterfaceVisualiserUneOrdonnance ordo = new InterfaceVisualiserUneOrdonnance();
		InterfaceTransmissionsSoinsInfirmier transmi = new InterfaceTransmissionsSoinsInfirmier();
		InterfaceAntecedentPatientMedecin ante = new InterfaceAntecedentPatientMedecin(); 
		InterfaceAgentAdministratif admin = new InterfaceAgentAdministratif();

		ControleurFinal contre = new ControleurFinal(mede, infirmier, agent,  antecedents, aidesoignant, login, admin);		
	}
}
