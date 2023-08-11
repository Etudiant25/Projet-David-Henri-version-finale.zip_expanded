package Personnel;

public class Psychologue extends Personne {

	private String Pole;
	protected static int idMatricule;
	protected static int idStaticBis;


	public Psychologue(int matricule,String Pole, String nom, String prenom, String adresse, String mail, String age) {
		super(nom, prenom, adresse, mail, age);
		this.Pole=Pole;
		this.idMatricule=idStaticBis;
		this.idStaticBis++;
		this.idStaticBis=idStaticBis;
	}

	public Psychologue() {
	}

	public String getPole() {
		return Pole;
	}

	public static int getIdMatricule() {
		return idMatricule;
	}

	public static void setIdMatricule(int idMatricule) {
		Psychologue.idMatricule = idMatricule;
	}

	public static int getIdStaticBis() {
		return idStaticBis;
	}

	public static void setIdStaticBis(int idStaticBis) {
		Psychologue.idStaticBis = idStaticBis;
	}

	public void setPole(String servicePole) {
		this.Pole = servicePole;
	}
}
