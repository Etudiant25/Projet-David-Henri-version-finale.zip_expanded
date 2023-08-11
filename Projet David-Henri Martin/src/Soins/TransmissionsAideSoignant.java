package Soins;

import java.sql.SQLException;

import java.util.Date;

import Entree.PatientDAO;
import Entree.SingleConnection;

public class TransmissionsAideSoignant {

	private static int idTransmission;
	private static int idStaticBis;
	private static int idPatient;
	private  static String nom;
	private  static String prenom;
	private static  boolean Soinsdebouche; 
	private static  boolean PrisedeTension ;
	private static  boolean AideauLever; 
	private static  boolean ToiletteAuLit;
	private static  boolean ToiletteAuLavabo;
	private static  boolean Douche;
	private static  boolean Escarre;
	private static String Observation;
	private static Date date;
	private String nomdusoignant;

	public TransmissionsAideSoignant(int idTransmission, int idPatient, String nom, String prenom, boolean Soinsdebouche, boolean PrisedeTension, boolean Aideaulever, boolean ToiletteAuLit, boolean ToiletteAuLavabo, boolean Douche, boolean Escarre, String Observation, String nomdusoignant, Date date) {	
		PatientDAO emp2 = new PatientDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		this.idTransmission=idStaticBis;
		this.idStaticBis++;
		this.idStaticBis=idStaticBis;
		this.nom=nom;
		this.prenom=prenom;
		try {
			this.idPatient= emp2.TrouverIdDuPatient(nom, prenom);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.Soinsdebouche=Soinsdebouche;
		this.PrisedeTension=PrisedeTension;
		this.AideauLever=Aideaulever;
		this.ToiletteAuLit=ToiletteAuLit;
		this.ToiletteAuLavabo=ToiletteAuLavabo;
		this.Douche=Douche;
		this.Escarre=Escarre;
		this.Observation=Observation;
		this.nomdusoignant=nomdusoignant;
		this.date=date;
	}

	public TransmissionsAideSoignant() {
	}	

	public static int getIdTransmission() {
		return idTransmission;
	}

	public static void setIdTransmission(int idTransmission) {
		TransmissionsAideSoignant.idTransmission = idTransmission;
	}

	public static int getIdStaticBis() {
		return idStaticBis;
	}

	public static void setIdStaticBis(int idStaticBis) {
		TransmissionsAideSoignant.idStaticBis = idStaticBis;
	}

	public static int getIdPatient() {
		return idPatient;
	}

	public static void setIdPatient(int idPatient) {
		TransmissionsAideSoignant.idPatient = idPatient;
	}

	public static String getNom() {
		return nom;
	}

	public static void setNom(String nom) {
		TransmissionsAideSoignant.nom = nom;
	}

	public static String getPrenom() {
		return prenom;
	}

	public static void setPrenom(String prenom) {
		TransmissionsAideSoignant.prenom = prenom;
	}

	public static boolean isSoinsdebouche() {
		return Soinsdebouche;
	}

	public static void setSoinsdebouche(boolean soinsdebouche) {
		Soinsdebouche = soinsdebouche;
	}

	public static boolean isPrisedeTension() {
		return PrisedeTension;
	}

	public static void setPrisedeTension(boolean prisedeTension) {
		PrisedeTension = prisedeTension;
	}

	public static boolean isAideauLever() {
		return AideauLever;
	}

	public static void setAideauLever(boolean aideauLever) {
		AideauLever = aideauLever;
	}

	public static boolean isToiletteAuLit() {
		return ToiletteAuLit;
	}

	public static void setToiletteAuLit(boolean toiletteAuLit) {
		ToiletteAuLit = toiletteAuLit;
	}

	public static boolean isToiletteAuLavabo() {
		return ToiletteAuLavabo;
	}

	public static void setToiletteAuLavabo(boolean toiletteAuLavabo) {
		ToiletteAuLavabo = toiletteAuLavabo;
	}

	public static boolean isDouche() {
		return Douche;
	}

	public static void setDouche(boolean douche) {
		Douche = douche;
	}

	public static boolean isEscarreAS() {
		return Escarre;
	}

	public static void setEscarreAS(boolean escarre) {
		Escarre = escarre;
	}

	public static String getObservation() {
		return Observation;
	}

	public static void setObservation(String observation) {
		Observation = observation;
	}

	public static Date getDate() {
		return date;
	}

	public static void setDate(Date date) {
		TransmissionsAideSoignant.date = date;
	}

	public String getNomdusoignant() {
		return nomdusoignant;
	}

	public void setNomdusoignant(String nomdusoignant) {
		this.nomdusoignant = nomdusoignant;
	}	
}
