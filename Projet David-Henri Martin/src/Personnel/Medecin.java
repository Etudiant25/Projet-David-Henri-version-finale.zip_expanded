package Personnel;

import java.util.Scanner;

import Entree.Patient;
import Papier.Ordonnance;

public class Medecin extends Personne {

	private static String Specialite;
	private int numeroOrdo;
	private static Patient patient;
	private int IdPatient;
	private static String nomPatient;
	protected static Ordonnance ordo;
	private String pathologie;
	protected static int idMatricule;
	protected static int idStaticBis;

	public Medecin(int matricule, String specialite, String nom, String prenom, String adresse, String mail, String age) {
		super(nom, prenom, adresse, mail, age);
		this.Specialite=specialite;
		this.idMatricule=idStaticBis;
		this.idStaticBis++;
		this.idStaticBis=idStaticBis;
	}

	public static Ordonnance getOrdo() {
		return ordo;
	}

	public static void setOrdo(Ordonnance ordo) {
		Medecin.ordo = ordo;
	}

	public static int getIdMatricule() {
		return idMatricule;
	}

	public static void setIdMatricule(int idMatricule) {
		Medecin.idMatricule = idMatricule;
	}

	public static int getIdStaticBis() {
		return idStaticBis;
	}

	public static void setIdStaticBis(int idStaticBis) {
		Medecin.idStaticBis = idStaticBis;
	}

	public Medecin() {
	}

	public String getSpecialite() {
		return this.Specialite;
	}

	public void setSpecialite(String spe) {
		this.Specialite=spe;
	}

	public String getPathologie() {
		return pathologie;
	}

	public void setPathologie(String pathologie) {
		this.pathologie = pathologie;
	}	
}