package Entree;

import java.util.ArrayList;

import java.util.Scanner;

public class FormulaireEntree {

	private static int numeroForm=1;
	private int numeroFormulaire;
	private static ArrayList<String> formulaire;//=new ArrayList<String>();

	public FormulaireEntree () {
		this.numeroFormulaire=numeroForm;
		this.numeroForm++;
		this.formulaire=new ArrayList<String>();
	}

	public boolean addEntreeNoSS() {
		boolean test=false;
		Scanner sc= new Scanner(System.in);
		String num=sc.nextLine();
		boolean bool =formulaire.add(num);
		if(num.contentEquals("")) {
			throw new RuntimeException();
		}
		if(bool==true) {
			test=true;
		}
		return test;
	}

	public boolean entreeNom() {
		boolean test=false;
		Scanner sc=new Scanner(System.in);
		String nom=sc.nextLine();
		boolean bool=formulaire.add(nom);
		if(nom.contentEquals("")) {
			throw new RuntimeException();
		}
		if(bool==true) {
			test=true;
		}
		return test;
	}

	public boolean entreePrenom() {
		Scanner sc=new Scanner(System.in);
		String prenom=sc.nextLine();
		formulaire.add(prenom);
		if(prenom.contentEquals("")) {
			throw new RuntimeException();
		}
		return true;
	}

	public boolean entreeNumero() {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		String numero=num+"";
		formulaire.add(numero);
		if(numero.equals("")) {
			throw new RuntimeException();
		}
		return true;
	}

	public static boolean entreeAdresse() {
		Scanner sc=new Scanner(System.in);
		String adr=sc.nextLine();
		formulaire.add(adr);
		if(adr.contentEquals("")) {
			throw new RuntimeException();
		}
		return true;
	}

	public int getNumeroFormulaire() {
		System.out.print(numeroFormulaire);
		return numeroFormulaire;
	}

	public void setNumeroFormulaire(int numeroFormulaire) {
		this.numeroFormulaire = numeroFormulaire;
	}

	public static int numeroForm() {
		return numeroForm;
	}

	public static void setnumeroForm(int numeroForm) {
		FormulaireEntree.numeroForm = numeroForm;
	}

	public boolean isEmpty() {
		return formulaire.isEmpty();
	}

	public void lireFormulaire() {
		for(String e : formulaire) {
			System.out.println(e);			
		}
	}
}
