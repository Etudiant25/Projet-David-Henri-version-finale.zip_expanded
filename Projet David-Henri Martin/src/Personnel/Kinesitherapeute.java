package Personnel;

public class Kinesitherapeute extends Personne {

	private String pole;
	protected static int idMatricule;
	protected static int idStaticBis;

	public Kinesitherapeute(int matricule, String pole, String nom, String prenom, String adresse, String mail, String age) {
		super(nom, prenom, adresse, mail, age);
		this.pole=pole;
		this.idMatricule=idStaticBis;
		this.idStaticBis++;
		this.idStaticBis=idStaticBis;
	}

	public Kinesitherapeute() {
	}

	public String getPole() {
		return pole;
	}

	public void setPole(String pole) {
		this.pole = pole;
	}

	public static int getIdMatricule() {
		return idMatricule;
	}

	public static void setIdMatricule(int idMatricule) {
		Kinesitherapeute.idMatricule = idMatricule;
	}

	public static int getIdStaticBis() {
		return idStaticBis;
	}

	public static void setIdStaticBis(int idStaticBis) {
		Kinesitherapeute.idStaticBis = idStaticBis;
	}
}
