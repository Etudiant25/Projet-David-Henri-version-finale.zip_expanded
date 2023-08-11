package Personnel;

public class AideSoignant extends Personne {

	private String service;
	protected static int idMatricule;
	protected static int idStaticBis;

	public AideSoignant(int matricule, String service, String nom, String prenom, String adresse, String mail, String age) {
		super(nom, prenom, adresse, mail, age);
		this.service=service;
		this.idMatricule=idStaticBis;
		this.idStaticBis++;
		this.idStaticBis=idStaticBis;
	}	

	public AideSoignant() {
	}

	public String getService() {
		return service;
	}

	public static int getIdMatricule() {
		return idMatricule;
	}

	public static void setIdMatricule(int idMatricule) {
		AideSoignant.idMatricule = idMatricule;
	}

	public static int getIdStaticBis() {
		return idStaticBis;
	}

	public static void setIdStaticBis(int idStaticBis) {
		AideSoignant.idStaticBis = idStaticBis;
	}

	public void setService(String service) {
		this.service = service;
	}
}
