package Entree;

import static org.junit.Assert.assertFalse;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Antecedents {

	protected Patient patient;
	private static int idPatient;
	private static String nom;
	private static String prenom;
	private static String handicap;
	private static String operation;
	private static String addiction;
	private static String maladieChronique;
	private static String maladiePeau;
	private static String maladieOrganique;
	private static String maladieInfectieuse;
	private static Date date;


	public Antecedents(int idPatient, String nom, String prenom, String handicap, String operation, String addiction, String maladieChronique, String maladiePeau, String maladieOrganique, String maladieInfectieuse, Date date) {	
		PatientDAO emp2 = new PatientDAO(SingleConnection.getInstance("jdbc:mysql://localhost/tp_jdbc","root", ""));
		this.nom=nom;
		this.prenom=prenom;
		try {
			this.idPatient= emp2.TrouverIdDuPatient(nom, prenom);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.handicap=handicap;
		this.operation=operation;
		this.addiction=addiction;
		this.maladieChronique=maladieChronique;
		this.maladiePeau=maladiePeau;
		this.maladieOrganique=maladieOrganique;
		this.maladieInfectieuse=maladieInfectieuse;
		this.date=date;
	}

	public Antecedents() {	
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public static int getIdDuPatient() {
		return idPatient;
	}

	public static void setIdDuPatient(int idDuPatient) {
		Antecedents.idPatient = idDuPatient;
	}

	public static String getNom() {
		return nom;
	}

	public static void setNom(String nom) {
		Antecedents.nom = nom;
	}

	public static String getPrenom() {
		return prenom;
	}

	public static void setPrenom(String prenom) {
		Antecedents.prenom = prenom;
	}

	public static String getHandicap() {
		return handicap;
	}

	public static void setHandicap(String handicap) {
		Antecedents.handicap = handicap;
	}

	public static String getOperation() {
		return operation;
	}

	public static void setOperation(String operation) {
		Antecedents.operation = operation;
	}

	public static String getAddiction() {
		return addiction;
	}

	public static void setAddiction(String addiction) {
		Antecedents.addiction = addiction;
	}

	public static String getMaladieChronique() {
		return maladieChronique;
	}

	public static void setMaladieChronique(String maladieChronique) {
		Antecedents.maladieChronique = maladieChronique;
	}

	public static String getMaladiePeau() {
		return maladiePeau;
	}

	public static void setMaladiePeau(String maladiePeau) {
		Antecedents.maladiePeau = maladiePeau;
	}

	public static String getMaladieOrganique() {
		return maladieOrganique;
	}

	public static void setMaladieOrganique(String maladieOrganique) {
		Antecedents.maladieOrganique = maladieOrganique;
	}

	public static String getMaladieInfectieuse() {
		return maladieInfectieuse;
	}

	public static void setMaladieInfectieuse(String maladieInfectieuse) {
		Antecedents.maladieInfectieuse = maladieInfectieuse;
	}

	public static Date getDate() {
		return date;
	}

	public static void setDate(Date date) {
		Antecedents.date = date;
	}	
}



