package Entree;




import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import Personnel.Medecin;
import Personnel.Personne;


public class Patient extends Personne {

	protected static int idStaticBis=1;
	protected static int idPatient;
	protected static String numero;
	protected static Date date;

	public Patient(int idPatient, String nom, String prenom, String numero, String adresse, String mail, String age, Date date) {
		super(nom, prenom, adresse, mail, age);	
		this.idPatient=idStaticBis;
		this.idStaticBis++;
		this.idStaticBis=idStaticBis;
		this.numero=numero;
		this.date=date;
	}

	public Patient() {
	}

	public static Date getDate() {
		return date;
	}

	public static void setDate(Date date) {
		Patient.date = date;
	}

	public Patient(int idPatient, String nom, String prenom){
		super(nom, prenom);
		this.idPatient=idStaticBis;
		this.idStaticBis++;
		idStaticBis=idStaticBis;
	}

	public static int getIdBis() {
		return idStaticBis;
	}

	public static void setIdBis(int id) {
		Patient.idStaticBis = id;
	}

	public static int getIdStaticBis() {
		return idStaticBis;
	}

	public static void setIdStaticBis(int idStaticBis) {
		Patient.idStaticBis = idStaticBis;
	}

	public static int getIdPatient() {
		return idPatient;
	}

	public static void setIdPatient(int idPatient) {
		Patient.idPatient = idPatient;
	}

	public static String getNumero() {
		return numero;
	}

	public static void setNumero(String numero) {
		Patient.numero = numero;
	}
}	

