package Papier;


import java.sql.SQLException;


import java.util.ArrayList;
import java.util.Date;

import Entree.Patient;
import Entree.PatientDAO;
import Entree.SingleConnection;
import Personnel.Medecin;

public class Ordonnance extends Patient {


	private static int idOrdonnance;
	private static int idStaticBis;
	private static String nom;
	private static String prenom;
	private static String nomMedecin;
	private static String piqure;
	private static String pillule;
	private static String pansement;
	private static String exercice;
	private static String materiel;
	private static String operation;
	private static String observation;
	private static boolean ECG;
	private static boolean Prisedetension;
	private static Date date;

	public Ordonnance(int idOrdonnance, int idPatient, String nom, String prenom , String nomMedecin, String piqure, String pillule, String pansement, String exercice, String materiel, String operation, String observation, boolean ECG, boolean Prisedetension, Date date) {
		super(idPatient, nom, prenom);
		PatientDAO emp2 = new PatientDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		this.idOrdonnance=idStaticBis;
		this.idStaticBis++;
		this.idStaticBis=idStaticBis;
		this.nom=nom;
		this.prenom=prenom;
		try {
			this.idPatient= emp2.TrouverIdDuPatient(nom, prenom);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.nomMedecin=nomMedecin;
		this.piqure=piqure;
		this.pillule=pillule;
		this.pansement=pansement;
		this.exercice=exercice;
		this.materiel=materiel;
		this.operation=operation;
		this.observation=observation;
		this.ECG=ECG;
		this.Prisedetension=Prisedetension;
		this.date=date;
	}

	public Ordonnance() {
	}


	public static int getIdOrdonnance() {
		return idOrdonnance;
	}

	public static void setIdOrdonnance(int idOrdonnance) {
		Ordonnance.idOrdonnance = idOrdonnance;
	}

	public static int getIdPatient() {
		return Patient.idPatient;
	}

	public static void setIdPatient(int idPatient) {
		idPatient= Patient.idPatient;
	}

	public static String getNom() {
		return nom;
	}

	public static void setNom(String nom) {
		Ordonnance.nom = nom;
	}

	public static String getPrenom() {
		return prenom;
	}

	public static void setPrenom(String prenom) {
		Ordonnance.prenom = prenom;
	}

	public static String getNomMedecin() {
		return nomMedecin;
	}

	public static void setNomMedecin(String nomMedecin) {
		Ordonnance.nomMedecin = nomMedecin;
	}

	public static String getPiqure() {
		return piqure;
	}

	public static void setPiqure(String piqure) {
		Ordonnance.piqure = piqure;
	}

	public static String getPillule() {
		return pillule;
	}

	public static void setPillule(String pillule) {
		Ordonnance.pillule = pillule;
	}

	public static String getPansement() {
		return pansement;
	}

	public static void setPansement(String pansement) {
		Ordonnance.pansement = pansement;
	}

	public static String getExercice() {
		return exercice;
	}

	public static void setExercice(String exercice) {
		Ordonnance.exercice = exercice;
	}

	public static String getMateriel() {
		return materiel;
	}

	public static void setMateriel(String materiel) {
		Ordonnance.materiel = materiel;
	}

	public static String getOperation() {
		return operation;
	}

	public static void setOperation(String operation) {
		Ordonnance.operation = operation;
	}	

	public static String getObservation() {
		return observation;
	}

	public static void setObservation(String observation) {
		Ordonnance.observation = observation;
	}

	public static boolean isECG() {
		return ECG;
	}

	public static void setECG(boolean eCG) {
		ECG = eCG;
	}

	public static boolean isPrisedetension() {
		return Prisedetension;
	}

	public static void setPrisedetension(boolean prisedetension) {
		Prisedetension = prisedetension;
	}

	public static Date getDate() {
		return date;
	}

	public static void setDate(Date date) {
		Ordonnance.date = date;
	}	
}