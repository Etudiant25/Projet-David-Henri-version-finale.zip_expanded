package Soins;


import java.sql.SQLException;

import java.util.Date;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;

import Entree.Patient;
import Entree.PatientDAO;
import Entree.SingleConnection;

public class Transmissions extends Patient{

	private static int idTransmission;
	private static int idStaticBis;
	private static int idPatient;
	private  static String nom;
	private  static String prenom;
	private static  boolean ECG; 
	private static  boolean PrisedeTension ;
	private static  boolean Injection; 
	private static  boolean Pillule;
	private static  boolean Pansement;
	private static  boolean Escarre;
	private static  boolean Toilette;
	private static String Observation;
	private static Date date;
	private String nomdusoignant;

	public Transmissions(int idTransmission, int idPatient, String nom, String prenom, boolean ECG, boolean PrisedeTension, boolean Injection, boolean Pillule, boolean Pansement, boolean Escarre, boolean Toilette, String Observation, String nomdusoignant, Date date) {
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
		this.ECG=ECG;
		this.PrisedeTension=PrisedeTension;
		this.Injection=Injection;
		this.Pillule=Pillule;
		this.Pansement=Pansement;
		this.Escarre=Escarre;
		this.Toilette=Toilette;
		this.Observation=Observation;
		this.nomdusoignant=nomdusoignant;
		this.date=date;
	}

	public Transmissions() {
	}

	public static int getIdTransmission() {
		return idTransmission;
	}

	public static void setIdTransmission(int idTransmission) {
		Transmissions.idTransmission = idTransmission;
	}

	public static int getIdStaticBis() {
		return idStaticBis;
	}

	public static void setIdStaticBis(int idStaticBis) {
		Transmissions.idStaticBis = idStaticBis;
	}

	public static int getIdPatient() {
		return idPatient;
	}

	public static void setIdPatient(int idPatient) {
		Transmissions.idPatient = idPatient;
	}

	public static String getNom() {
		return nom;
	}

	public static void setNom(String nom) {
		Transmissions.nom = nom;
	}

	public static String getPrenom() {
		return prenom;
	}

	public static void setPrenom(String prenom) {
		Transmissions.prenom = prenom;
	}

	public static boolean isECG() {
		return ECG;
	}

	public static void setECG(boolean eCG) {
		ECG = eCG;
	}

	public static boolean isPrisedeTension() {
		return PrisedeTension;
	}

	public static void setPrisedeTension(boolean prisedeTension) {
		PrisedeTension = prisedeTension;
	}

	public static boolean isInjection() {
		return Injection;
	}

	public static void setInjection(boolean injection) {
		Injection = injection;
	}

	public static boolean isPillule() {
		return Pillule;
	}

	public static void setPillule(boolean pillule) {
		Pillule = pillule;
	}

	public static boolean isPansement() {
		return Pansement;
	}

	public static void setPansement(boolean pansement) {
		Pansement = pansement;
	}

	public static boolean isEscarre() {
		return Escarre;
	}

	public static void setEscarre(boolean escarre) {
		Escarre = escarre;
	}

	public static boolean isToilette() {
		return Toilette;
	}

	public static void setToilette(boolean toilette) {
		Toilette = toilette;
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
		Transmissions.date = date;
	}

	public String getNomdusoignant() {
		return nomdusoignant;
	}

	public void setNomdusoignant(String nomdusoignant) {
		this.nomdusoignant = nomdusoignant;
	}	
}
