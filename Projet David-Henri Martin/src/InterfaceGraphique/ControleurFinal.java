package InterfaceGraphique;

import java.awt.event.ActionEvent;





import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.EventObject;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;


import Entree.AntecedentDAO;
import Entree.Antecedents;
import Entree.Patient;
import Entree.PatientDAO;
import Entree.SingleConnection;
import Papier.Ordonnance;
import Papier.OrdonnanceDAO;
import Personnel.AgentDaccueil;
import Personnel.AgentDaccueilDAO;
import Personnel.AideServiceHospitalier;
import Personnel.AideServiceHospitalierDAO;
import Personnel.AideSoignant;
import Personnel.AideSoignantDAO;
import Personnel.Direction;
import Personnel.DirectionDAO;
import Personnel.Infirmier;
import Personnel.InfirmierDAO;
import Personnel.Kinesitherapeute;
import Personnel.KinesitherapeuteDAO;
import Personnel.Medecin;
import Personnel.MedecinDAO;
import Personnel.Psychologue;
import Personnel.PsychologueDAO;
import Soins.Transmissions;
import Soins.TransmissionsAideSoignant;
import Soins.TransmissionsAideSoignantDAO;
import Soins.TransmissionsDAO;



public class ControleurFinal extends Patient {

	
	private InterfaceMedecin medecin;
	private InterfaceInfirmier infirmier;
	private Transmissions transmission;
	private TransmissionsAideSoignant transmissionsAS;
	private InterfaceAntecedentPatientMedecin ante = new InterfaceAntecedentPatientMedecin();
	private Ordonnance ordonnance;
	private InterfaceLogin login;
	private Patient patient;
	private InterfaceAgentDaccueil agent;
	private InterfaceFenetreAntecedents antecedents;
	private InterfaceVisualiserUneOrdonnance ordo = new InterfaceVisualiserUneOrdonnance();
	private InterfaceTransmissionsSoinsInfirmier transmi = new InterfaceTransmissionsSoinsInfirmier();
	private InterfaceAideSoignant aidesoignant;
	private InterfaceAgentAdministratif admin;

	public ControleurFinal(InterfaceMedecin medecin, InterfaceInfirmier infirmier, InterfaceAgentDaccueil agent, InterfaceFenetreAntecedents antecedents, InterfaceAideSoignant aidesoignant, InterfaceLogin login, InterfaceAgentAdministratif admin) {
		this.medecin=medecin;
		this.infirmier=infirmier;
		this.transmission=transmission;
		this.transmissionsAS=transmissionsAS;
		this.ante=ante;
		this.ordonnance=ordonnance;
		this.patient=patient;
		this.agent= agent;
		this.antecedents=antecedents;
		this.aidesoignant=aidesoignant;
		this.login=login;
		this.admin=admin;

		//interfaceLogin
		this.login.addSeConnecterListener(new Login());

		//rajouter les antecedents
		this.antecedents.EnregistrerAntecedentsListener(new EnregistrerAntecedentsPatient());

		//rajouter un patient
		this.agent.InscrireaddActionListener(new enregistrerPatientHopital());

		//interface admin
		this.admin.InscrirePersonneladdActionListener(new AjouterPersonnel());

		//aide-soignant	
		this.aidesoignant.VisualiserObservationaASListener(new ObserverEquipeASAvant());
		this.aidesoignant.SoinsdeboucheaddItemListener(new SoinsdeBoucheaddItemListenerAS());
		this.aidesoignant.PrisedeTensionaddItemListener(new PrisedeTensionASaddItemListenerAS());
		this.aidesoignant.AideAuLeveraddItemListener(new AideauleverASaddItemListenerAS());
		this.aidesoignant.ToiletteAuLitaddItemListener(new ToiletteauLitaddItemListenerAS());
		this.aidesoignant.ToiletteAuLavaboaddItemListener(new ToiletteauLavaboaddItemListenerAS());
		this.aidesoignant.EscarreASaddItemListener(new EscarreAStaddItemListenerAS());
		this.aidesoignant.DoucheaddItemListener(new DoucheaddItemListenerAS());
		this.aidesoignant.ValidertransmissionASListener(new ValiderUneTransmissionAideSoignantObservation());

		//infirmier
		this.infirmier.ECGaddItemListener(new ECGaddItemListenerInfirmier());
		this.infirmier.PrisedeTensionaddItemListener(new PrisedeTensionaddItemListenerInfirmier());
		this.infirmier.InjectionaddItemListener(new InjectionaddItemListenerInfirmier());
		this.infirmier.PilluleaddItemListener(new PilluleaddItemListenerInfirmier());
		this.infirmier.PansementaddItemListener(new PansementaddItemListenerInfirmier());
		this.infirmier.EscarretaddItemListener(new EscarretaddItemListenerInfirmier());
		this.infirmier.ToiletteaddItemListener(new ToiletteaddItemListenerInfirmier());
		this.infirmier.ValiderUneTransmissionInfirmier(new ValiderUneTransmissionObservation());
		this.infirmier.VisualiserOrdonnanceListener(new VoirOrdonnance());
		this.infirmier.VisualiserObservationListener(new ObserverEquipeAvant());

		//fenetres menu medecin	
		this.medecin.addVisualiserAntecedentFenetre( new VisualiserLalisteDante());
		this.ante.VisualiserAntecdentSelectionner(new VoirAntecedentMenu());
		this.medecin.OrdonnancePatientListener(new VisualiserOdonnance());
		this.ordo.SelectionnerActionListener(new VoirOrdonnanceMenu());
		this.medecin.VisualiserTransmissionsListener(new VisualiserTransmissionsInfirmier());
		this.transmi.SelectionnerTransmissionActionListener(new VoirTransmissionsMenu());

		//fenetres menu infirmier
		this.infirmier.ChoisirVisualiserAntecedents( new VisualiserLalisteDante());
		this.ante.VisualiserAntecdentSelectionner(new VoirAntecedentMenu());
		this.infirmier.OrdonnancePatientListener(new VisualiserOdonnance());
		this.ordo.SelectionnerActionListener(new VoirOrdonnanceMenu());

		//fenetre menu aidesoignant
		this.aidesoignant.TransmissionInfirmierListener(new VisualiserTransmissionsInfirmier());
		this.transmi.SelectionnerTransmissionActionListener(new VoirTransmissionsMenu());
		this.aidesoignant.ChoisirVisualiserAntecedents( new VisualiserLalisteDante());
		this.ante.VisualiserAntecdentSelectionner(new VoirAntecedentMenu());

		//medecin
		this.medecin.addVisualiserListener(new VisualiserLalisteDantecedents());
		this.medecin.addValiderPiqure(new validerPiqureText());
		this.medecin.addValiderPillule(new validerPilluleText());
		this.medecin.addValiderPansement(new validerPansementText());
		this.medecin.addValiderExercice(new validerExerciceText());
		this.medecin.addValiderOperation(new validerOperationText());
		this.medecin.addValiderECG (new validerECG());
		this.medecin.addValiderPRISEDETENSION( new validerPriseDeTension());
		this.medecin.addSelectionnerMateriel(new SelectionnerleMateriel());

		//enregistreruneOrdonnance
		this.medecin.EnregistreruneOrdonnance(new enregistrerPatientOrdo());


	}	

	//Fenetre Antecedents

	class EnregistrerAntecedentsPatient implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			AntecedentDAO emp = new AntecedentDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			Antecedents ante;
			String nom1 = antecedents.NomDuPatient.getText();
			String prenom1 = antecedents.PrenomDuPatient.getText();
			String handicap = antecedents.HandicapDuPatient.getText();
			String operation = antecedents.OperationDuPatient.getText();
			String addiction = antecedents.AddictionDuPatient.getText();
			String maladieChronique= antecedents.MaladieChroniqueDuPatient.getText();
			String maladiePeau = antecedents.MaladiePeauDuPatient.getText();
			String maladieOrganique= antecedents.MaladieOrganiqueDuPatient.getText();
			String maladieInfectieuse= antecedents.MaladieInfectieuseDuPatient.getText();
			Date aujourdhui = new Date(System.currentTimeMillis());
			try {
				ante = new Antecedents(47, nom1, prenom1, handicap, operation, addiction, maladieChronique, maladiePeau, maladieOrganique, maladieInfectieuse, aujourdhui);
				emp.insereTUPLE(ante);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	//INFIRMIER

	class ECGaddItemListenerInfirmier implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TransmissionsDAO emp = new TransmissionsDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String prenom1 = infirmier.prenomdupatient.getText();
			String nom1 = infirmier.nomdupatient.getText();
			boolean ecg = infirmier.getECGCheck();
			if(ecg==true){
				Transmissions.setECG(true);
			}else {
				Transmissions.setECG(false);
			}
			try {
				emp.updateECGTuple(transmission, nom1, prenom1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	class PrisedeTensionaddItemListenerInfirmier implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TransmissionsDAO emp = new TransmissionsDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String prenom1 = infirmier.prenomdupatient.getText();
			String nom1 = infirmier.nomdupatient.getText();
			boolean prise = infirmier.getPrisedetensionCheck();
			if(prise==true){
				Transmissions.setPrisedeTension(true);
			}else {
				Transmissions.setPrisedeTension(false);
			}
			try {
				emp.updatePriseDeTensionTuple(transmission, nom1, prenom1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	class InjectionaddItemListenerInfirmier implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TransmissionsDAO emp = new TransmissionsDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String prenom1 = infirmier.prenomdupatient.getText();
			String nom1 = infirmier.nomdupatient.getText();
			boolean inject = infirmier.getInjectionCheck();
			if(inject==true){
				Transmissions.setInjection(true);
			}else {
				Transmissions.setInjection(false);
			}
			try {
				emp.updateInjectionTuple(transmission, nom1, prenom1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	class PilluleaddItemListenerInfirmier implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			TransmissionsDAO emp = new TransmissionsDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String prenom1 = infirmier.prenomdupatient.getText();
			String nom1 = infirmier.nomdupatient.getText();
			boolean comprime = infirmier.getComprimeCheck();
			if(comprime==true){
				Transmissions.setPillule(true);
			}else {
				Transmissions.setPillule(false);
			}
			try {
				emp.updatePilluleTuple(transmission, nom1, prenom1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	class PansementaddItemListenerInfirmier implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TransmissionsDAO emp = new TransmissionsDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String prenom1 = infirmier.prenomdupatient.getText();
			String nom1 = infirmier.nomdupatient.getText();
			boolean pansement = infirmier.getPansementCheck();
			if(pansement==true){
				Transmissions.setPansement(true);
			}else {
				Transmissions.setPansement(false);
			}
			try {
				emp.updatePansementTuple(transmission, nom1, prenom1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	class EscarretaddItemListenerInfirmier implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			TransmissionsDAO emp = new TransmissionsDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String prenom1 = infirmier.prenomdupatient.getText();
			String nom1 = infirmier.nomdupatient.getText();
			boolean escarre = infirmier.getEscarreCheck();
			if(escarre==true){
				Transmissions.setEscarre(true);
			}else {
				Transmissions.setEscarre(false);
			}
			try {
				emp.updateEscarreTuple(transmission, nom1, prenom1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	class ToiletteaddItemListenerInfirmier implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TransmissionsDAO emp = new TransmissionsDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String prenom1 = infirmier.prenomdupatient.getText();
			String nom1 = infirmier.nomdupatient.getText();
			boolean inject = infirmier.getToiletteCheck();
			if(inject==true){
				Transmissions.setToilette(true);
			}else {
				Transmissions.setToilette(false);
			}
			try {
				emp.updateToiletteTuple(transmission, nom1, prenom1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	//valider une transmission

	class ValiderUneTransmissionObservation implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			TransmissionsDAO emp = new TransmissionsDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String nomdusoignant = infirmier.NomDeLIDE.getText();
			String nom1 = infirmier.nomdupatient.getText();
			String prenom1 = infirmier.prenomdupatient.getText();
			boolean ecg = infirmier.ECG.isSelected();
			boolean prisedetension = infirmier.PrisedeTension.isSelected();
			boolean injection1 = infirmier.Injection.isSelected();
			boolean pansement1 = infirmier.Pansement.isSelected();
			boolean pillule = infirmier.Pillule.isSelected();
			boolean escarre = infirmier.Escarre.isSelected();
			boolean toilette = infirmier.Toilette.isSelected();
			String Observation= infirmier.getTextObservation();
			Date aujourdhui = new Date(System.currentTimeMillis());;
			Transmissions transmission = new Transmissions(1, 1 ,nom1,prenom1, ecg, prisedetension, injection1, pansement1, pillule,escarre, toilette,Observation, nomdusoignant, aujourdhui);
			try {
				emp.insereTUPLE(transmission);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}	
	}

	// Observer les observations de l'équipe précédente

	class ObserverEquipeAvant implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			TransmissionsDAO emp = new TransmissionsDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String nom1 = infirmier.nomdupatient.getText();
			String prenom1 = infirmier.prenomdupatient.getText();
			try {
				String s = emp.afficherTransmissionInfirmier(nom1, prenom1);
				infirmier.ObservationsEquipe.setText(s);

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}


	}

	//voir l'ordonnance du medecin

	class VoirOrdonnance implements ActionListener{
		public void actionPerformed(ActionEvent e) {			
			OrdonnanceDAO emp = new OrdonnanceDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String nom1 = infirmier.nomdupatient.getText();
			String prenom1 = infirmier.prenomdupatient.getText();
			try {
				String s = emp.afficherOrdonnance(nom1, prenom1);
				infirmier.Ordonnance.setText(s);

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	//medecin

	class VisualiserLalisteDantecedents implements ActionListener{
		public void actionPerformed(ActionEvent e) {			
			AntecedentDAO emp = new AntecedentDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));			
			String nom1 = medecin.nomdupatient.getText();
			String prenom1 = medecin.prenomdupatient.getText();
			try {
				String s = emp.afficherAntecedents(nom1, prenom1);
				medecin.antecedent.setText(s);

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	class validerPiqureText implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			OrdonnanceDAO emp = new OrdonnanceDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String nom1 = medecin.nomdupatient.getText();
			String prenom1 = medecin.prenomdupatient.getText();
			String text = medecin.getPiqureText();
			Ordonnance.setPiqure(text);
			try {
				emp.updatePiqure(ordonnance, nom1, prenom1);				
			} catch (SQLException e1) {
				e1.printStackTrace();				
			}
		}
	}

	class validerPansementText implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			OrdonnanceDAO emp = new OrdonnanceDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String nom1 = medecin.nomdupatient.getText();
			String prenom1 = medecin.prenomdupatient.getText();
			String text= medecin.getPansementText();
			Ordonnance.setPansement(text);
			try {				
				emp.updatePansement(ordonnance, nom1, prenom1);				
			} catch (SQLException e1) {
				e1.printStackTrace();				
			}
		}
	}

	class validerPilluleText implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			OrdonnanceDAO emp = new OrdonnanceDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String nom1 = medecin.nomdupatient.getText();
			String prenom1 = medecin.prenomdupatient.getText();
			String text= medecin.getPilluleText();
			Ordonnance.setPillule(text);
			try {				
				emp.updatePillule(ordonnance, nom1, prenom1);				
			} catch (SQLException e1) {
				e1.printStackTrace();				
			}
		}
	}

	class validerExerciceText implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			OrdonnanceDAO emp = new OrdonnanceDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String nom1 = medecin.nomdupatient.getText();
			String prenom1 = medecin.prenomdupatient.getText();
			String text= medecin.exercice.getText();
			Ordonnance.setExercice(text);
			try {				
				emp.updateExercice(ordonnance, nom1, prenom1);				
			} catch (SQLException e1) {
				e1.printStackTrace();				
			}
		}
	}

	class validerOperationText implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			OrdonnanceDAO emp = new OrdonnanceDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String nom1 = medecin.nomdupatient.getText();
			String prenom1 = medecin.prenomdupatient.getText();
			String text= medecin.operation.getText();
			try {				
				emp.updateOperation(ordonnance, nom1, prenom1);				
			} catch (SQLException e1) {
				e1.printStackTrace();				
			}
		}
	}

	class validerECG implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			OrdonnanceDAO emp = new OrdonnanceDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String nom1 = medecin.nomdupatient.getText();
			String prenom1 = medecin.prenomdupatient.getText();
			Boolean ecg = medecin.getECGCheck();
			if(ecg==true) {
				Ordonnance.setECG(true);
			}else {
				Ordonnance.setECG(false);	
			}
			try {				
				emp.updateOperation(ordonnance, nom1, prenom1);				
			} catch (SQLException e1) {
				e1.printStackTrace();				
			}
		}
	}

	class validerPriseDeTension implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			OrdonnanceDAO emp = new OrdonnanceDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String nom1 = medecin.nomdupatient.getText();
			String prenom1 = medecin.prenomdupatient.getText();
			Boolean prise = medecin.getPrisedetensionCheck();
			if(prise==true) {
				Ordonnance.setPrisedetension(true);
			}else {
				Ordonnance.setPrisedetension(false);	
			}
			try {				
				emp.updateOperation(ordonnance, nom1, prenom1);				
			} catch (SQLException e1) {
				e1.printStackTrace();				
			}
		}
	}

	class SelectionnerleMateriel implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			OrdonnanceDAO emp = new OrdonnanceDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String nom1 = medecin.nomdupatient.getText();
			String prenom1 = medecin.prenomdupatient.getText();
			String item = medecin.getMaterielCheck();
			Ordonnance.setMateriel(item);		
			try {				
				emp.updateMateriel(ordonnance, nom1, prenom1);				
			} catch (SQLException e1) {
				e1.printStackTrace();				
			}
		}
	}

	//Enregistrer une ordonnance

	class enregistrerPatientOrdo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			OrdonnanceDAO emp = new OrdonnanceDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			PatientDAO emp2 = new PatientDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String nomMede = medecin.nomMedecin.getText();
			String nom1 = medecin.nomdupatient.getText();
			String prenom1 = medecin.prenomdupatient.getText();
			String Observation= medecin.ObservationMed.getText();
			String piqure2 = medecin.piqure.getText();
			String pillule2 = medecin.pillule.getText();
			String pansement2 = medecin.pansement.getText();
			String exercice2 = medecin.exercice.getText();
			String operation2 = medecin.operation.getText();
			String materiel = medecin.listedeMateriel.getSelectedValue();
			boolean ecg = medecin.ECG.isSelected();
			boolean prisedetension = medecin.PriseTension.isSelected();
			Date aujourdhui = new Date(System.currentTimeMillis());
			Ordonnance ordo;
			try {
				ordo = new Ordonnance(1, emp2.TrouverIdDuPatient(nom1, prenom1) ,nom1,prenom1, nomMede, piqure2,pillule2,pansement2,exercice2,materiel,operation2,Observation,ecg,prisedetension, aujourdhui);
				emp.insereTUPLE(ordo);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	// aide-soignant

	class ValiderUneTransmissionAideSoignantObservation implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			TransmissionsAideSoignantDAO emp = new TransmissionsAideSoignantDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String nomdusoignant = aidesoignant.NomDeLAS.getText();
			String nom1 = aidesoignant.nomdupatient.getText();
			String prenom1 = aidesoignant.prenomdupatient.getText();
			boolean soinsdebouche = aidesoignant.Soinsdebouche.isSelected();
			boolean prisedetension = aidesoignant.PrisedeTension.isSelected();
			boolean aideaulever = aidesoignant.AideAuLever.isSelected();
			boolean toiletteaulit = aidesoignant.ToiletteAuLit.isSelected();
			boolean toiletteaulavabo = aidesoignant.ToiletteAuLavabo.isSelected();
			boolean douche = aidesoignant.Douche.isSelected();
			boolean escarre = aidesoignant.Escarre.isSelected();	
			String Observation= aidesoignant.getTextObservation();
			Date aujourdhui = new Date(System.currentTimeMillis());;
			TransmissionsAideSoignant transmission = new TransmissionsAideSoignant(1,1 ,nom1,prenom1, soinsdebouche, prisedetension, aideaulever, toiletteaulit, toiletteaulavabo, douche, escarre, Observation, nomdusoignant, aujourdhui);
			try {
				emp.insereTUPLE(transmission);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}	
	}

	class ObserverEquipeASAvant implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			TransmissionsAideSoignantDAO emp = new TransmissionsAideSoignantDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String nom1 = aidesoignant.nomdupatient.getText();
			String prenom1 = aidesoignant.prenomdupatient.getText();
			try {
				String s = emp.afficherTransmissionAS(nom1, prenom1);
				aidesoignant.ObservationsEquipeAS.setText(s);

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	class SoinsdeBoucheaddItemListenerAS implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TransmissionsAideSoignantDAO emp = new TransmissionsAideSoignantDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String prenom1 = aidesoignant.prenomdupatient.getText();
			String nom1 = aidesoignant.nomdupatient.getText();
			boolean baindebouche = aidesoignant.getSoinsdeboucheCheck();
			if(baindebouche==true){
				TransmissionsAideSoignant.setSoinsdebouche(true);
			}else {
				TransmissionsAideSoignant.setSoinsdebouche(false);
			}
			try {
				emp.updateSoinsdeBoucheTuple(transmissionsAS, nom1, prenom1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	class PrisedeTensionASaddItemListenerAS implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TransmissionsAideSoignantDAO emp = new TransmissionsAideSoignantDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String prenom1 = aidesoignant.prenomdupatient.getText();
			String nom1 = aidesoignant.nomdupatient.getText();
			boolean prise = aidesoignant.getPrisedetensionCheck();
			if(prise==true){
				TransmissionsAideSoignant.setPrisedeTension(true);
			}else {
				TransmissionsAideSoignant.setPrisedeTension(false);
			}
			try {
				emp.updatePriseDeTensionTuple(transmissionsAS, nom1, prenom1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	class AideauleverASaddItemListenerAS implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TransmissionsAideSoignantDAO emp = new TransmissionsAideSoignantDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String prenom1 = aidesoignant.prenomdupatient.getText();
			String nom1 = aidesoignant.nomdupatient.getText();
			boolean inject = aidesoignant.getAideAuLeverCheck();
			if(inject==true){
				TransmissionsAideSoignant.setAideauLever(true);
			}else {
				TransmissionsAideSoignant.setAideauLever(false);
			}
			try {
				emp.updateAideAuLeverTuple(transmissionsAS, nom1, prenom1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	class ToiletteauLitaddItemListenerAS implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			TransmissionsAideSoignantDAO emp = new TransmissionsAideSoignantDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String prenom1 = aidesoignant.prenomdupatient.getText();
			String nom1 = aidesoignant.nomdupatient.getText();
			boolean comprime = aidesoignant.getToiletteAuLitCheck();
			if(comprime==true){
				TransmissionsAideSoignant.setToiletteAuLit(true);
			}else {
				TransmissionsAideSoignant.setToiletteAuLit(false);
			}
			try {
				emp.updateToiletteAuLitTuple(transmissionsAS, nom1, prenom1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	class ToiletteauLavaboaddItemListenerAS implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TransmissionsAideSoignantDAO emp = new TransmissionsAideSoignantDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String prenom1 = aidesoignant.prenomdupatient.getText();
			String nom1 = aidesoignant.nomdupatient.getText();
			boolean pansement = aidesoignant.getToiletteAuLavaboCheck();
			if(pansement==true){
				TransmissionsAideSoignant.setToiletteAuLavabo(true);
			}else {
				TransmissionsAideSoignant.setToiletteAuLavabo(false);
			}
			try {
				emp.updateToiletteAuLavaboTuple(transmissionsAS, nom1, prenom1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	class EscarreAStaddItemListenerAS implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			TransmissionsAideSoignantDAO emp = new TransmissionsAideSoignantDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String prenom1 = aidesoignant.prenomdupatient.getText();
			String nom1 = aidesoignant.nomdupatient.getText();
			boolean escarre = aidesoignant.getEscarreASCheck();
			if(escarre==true){
				TransmissionsAideSoignant.setEscarreAS(true);
			}else {
				TransmissionsAideSoignant.setEscarreAS(false);
			}
			try {
				emp.updateEscarreASTuple(transmissionsAS, nom1, prenom1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	class DoucheaddItemListenerAS implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TransmissionsAideSoignantDAO emp = new TransmissionsAideSoignantDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String prenom1 = aidesoignant.prenomdupatient.getText();
			String nom1 = aidesoignant.nomdupatient.getText();
			boolean inject = aidesoignant.getDoucheCheck();
			if(inject==true){
				TransmissionsAideSoignant.setDouche(true);
			}else {
				TransmissionsAideSoignant.setDouche(false);
			}
			try {
				emp.updateDoucheTuple(transmissionsAS, nom1, prenom1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	//fenetre antecedent menu

	class VoirAntecedentMenu implements ActionListener{
		public void actionPerformed(ActionEvent e) {			
			AntecedentDAO emp = new AntecedentDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String nom1 = ante.nomdupatient.getText();
			String prenom1 = ante.prenomdupatient.getText();
			try {
				String s = emp.afficherAntecedents(nom1, prenom1);
				ante.antecedents.setText(s);

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	//fenetre Ordonnance menu

	class VoirOrdonnanceMenu implements ActionListener{
		public void actionPerformed(ActionEvent e) {			
			OrdonnanceDAO emp = new OrdonnanceDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String nom1 = ordo.nomdupatient.getText();
			String prenom1 = ordo.prenomdupatient.getText();
			try {
				String s = emp.afficherOrdonnance(nom1, prenom1);
				ordo.Ordonnance.setText(s);

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	//fenetre Tranmissions infirmier menu

	class VoirTransmissionsMenu implements ActionListener{
		public void actionPerformed(ActionEvent e) {			
			TransmissionsDAO emp = new TransmissionsDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			String nom1 = transmi.nomdupatient.getText();
			String prenom1 = transmi.prenomdupatient.getText();
			try {
				String s = emp.afficherTransmissionInfirmier(nom1, prenom1);
				transmi.transmission.setText(s);

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	//Rajouter un patient

	class enregistrerPatientHopital implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			PatientDAO emp = new PatientDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
			Patient pat;
			String nom1 = agent.getNomText();
			String prenom1 = agent.getPrenomText();
			String numeroSecuriteSociale = agent.NumeroSSText.getText();
			String adresse = agent.getAdresseText();
			String mail = agent.getMailText();
			String age= agent.getAgeText();
			Date aujourdhui = new Date(System.currentTimeMillis());
			try {
				pat = new Patient(1, nom1, prenom1, numeroSecuriteSociale, adresse, mail, age, aujourdhui);
				emp.insereTUPLE(pat);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	// open fenetre medecin

	class VisualiserLalisteDante implements ActionListener{		
		public void actionPerformed(ActionEvent e) {
			ante.setVisible(true);
		}
	}

	class VisualiserOdonnance implements ActionListener{		
		public void actionPerformed(ActionEvent e) {
			ordo.setVisible(true);
		}
	}

	class VisualiserTransmissionsInfirmier implements ActionListener{		
		public void actionPerformed(ActionEvent e) {
			transmi.setVisible(true);
		}
	}

	//interface Login

	class Login implements ActionListener{
		public void actionPerformed(ActionEvent e) {	
			if(login.addLoginetPassMedecin()==true){
				medecin.setVisible(true);
				antecedents.setVisible(true);
			}
			if(login.addLoginetPassInfirmier()==true) {
				infirmier.setVisible(true);
				antecedents.setVisible(true);
			}
			if(login.addLoginetPassAideSoignant()==true) {
				aidesoignant.setVisible(true);
			}
			if(login.addLoginetPassAgentDaccueil()==true) {
				agent.setVisible(true);
			}
			if(login.addLoginetPassAgentAdministratif() == true) {
				admin.setVisible(true);
			}
		}
	}

	//InterfaceAgentAdiministratif

	class AjouterPersonnel implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(admin.AgentDaccueilCheck.isSelected()) {
				AgentDaccueilDAO emp = new AgentDaccueilDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
				AgentDaccueil agent;
				String nom1 = admin.getNomText();
				String prenom1 = admin.getPrenomText();
				String adresse1 = admin.getAdresseText();
				String mail1 = admin.getMailText();
				String age1= admin.getAgeText();
				String role1 = admin.getRoleText();
				try {
					agent = new AgentDaccueil(1, role1, nom1, prenom1, adresse1, mail1, age1);
					emp.insereTUPLE(agent);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(admin.AideServiceHospitalierCheck.isSelected()) {
				AideServiceHospitalierDAO emp2 = new AideServiceHospitalierDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
				AideServiceHospitalier ash;
				String nom2 = admin.getNomText();
				String prenom2 = admin.getPrenomText();
				String adresse2 = admin.getAdresseText();
				String mail2 = admin.getMailText();
				String age2= admin.getAgeText();
				String service2 = admin.getServiceText();
				try {
					ash = new AideServiceHospitalier(1, service2, nom2, prenom2, adresse2, mail2, age2);
					emp2.insereTUPLE(ash);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(admin.AideSoignantCheck.isSelected()) {
				AideSoignantDAO emp3 = new AideSoignantDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
				AideSoignant as;
				String nom3 = admin.getNomText();
				String prenom3 = admin.getPrenomText();
				String adresse3 = admin.getAdresseText();
				String mail3 = admin.getMailText();
				String age3= admin.getAgeText();
				String service3 = admin.getServiceText();
				try {
					as = new AideSoignant(1, service3, nom3, prenom3, adresse3, mail3, age3);
					emp3.insereTUPLE(as);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(admin.DirectionCheck.isSelected()) {
				DirectionDAO emp4 = new DirectionDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
				Direction direction;
				String nom4 = admin.getNomText();
				String prenom4 = admin.getPrenomText();
				String adresse4 = admin.getAdresseText();
				String mail4 = admin.getMailText();
				String age4= admin.getAgeText();
				String poste4 = admin.getPosteText();
				try {
					direction = new Direction(1, poste4, nom4, prenom4, adresse4, mail4, age4);
					emp4.insereTUPLE(direction);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(admin.InfirmierCheck.isSelected()) {
				InfirmierDAO emp5 = new InfirmierDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
				Infirmier infir;
				String nom5 = admin.getNomText();
				String prenom5 = admin.getPrenomText();
				String adresse5 = admin.getAdresseText();
				String mail5 = admin.getMailText();
				String age5= admin.getAgeText();
				String service5 = admin.getServiceText();
				try {
					infir = new Infirmier(1, service5, nom5, prenom5, adresse5, mail5, age5);
					emp5.insereTUPLE(infir);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(admin.KinesitherapeuteCheck.isSelected()) {
				KinesitherapeuteDAO emp6 = new KinesitherapeuteDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
				Kinesitherapeute kine;
				String nom6 = admin.getNomText();
				String prenom6 = admin.getPrenomText();
				String adresse6 = admin.getAdresseText();
				String mail6 = admin.getMailText();
				String age6= admin.getAgeText();
				String pole6 = admin.getPoleText();
				try {
					kine = new Kinesitherapeute(1, pole6, nom6, prenom6, adresse6, mail6, age6);
					emp6.insereTUPLE(kine);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(admin.MedecinCheck.isSelected()) {
				MedecinDAO emp7 = new MedecinDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
				Medecin mede;
				String nom7 = admin.getNomText();
				String prenom7 = admin.getPrenomText();
				String adresse7 = admin.getAdresseText();
				String mail7 = admin.getMailText();
				String age7= admin.getAgeText();
				String specialite7 = admin.getSpecialiteText();
				try {
					mede = new Medecin(1, specialite7, nom7, prenom7, adresse7, mail7, age7);
					emp7.insereTUPLE(mede);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(admin.PsychologueCheck.isSelected()) {
				PsychologueDAO emp8 = new PsychologueDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
				Psychologue psyche;
				String nom8 = admin.getNomText();
				String prenom8 = admin.getPrenomText();
				String adresse8 = admin.getAdresseText();
				String mail8 = admin.getMailText();
				String age8= admin.getAgeText();
				String pole8 = admin.getPoleText();
				try {
					psyche = new Psychologue(1, pole8, nom8, prenom8, adresse8, mail8, age8);
					emp8.insereTUPLE(psyche);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
