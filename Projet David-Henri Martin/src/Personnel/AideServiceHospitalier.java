package Personnel;

public class AideServiceHospitalier extends Personne {

	private String service;
	protected static int idMatricule;
	protected static int idStaticBis;

	public AideServiceHospitalier(int matricule, String service, String Nom, String prenom, String adresse, String Mail, String age) {
		super(Nom, prenom, adresse, Mail, age);
		this.service=service;
		this.idMatricule=idStaticBis;
		this.idStaticBis++;
		this.idStaticBis=idStaticBis;
	}	

	public AideServiceHospitalier() {
	}

	public String getService() {
		return service;
	}

	public static int getIdMatricule() {
		return idMatricule;
	}

	public static void setIdMatricule(int idMatricule) {
		AideServiceHospitalier.idMatricule = idMatricule;
	}

	public static int getIdStaticBis() {
		return idStaticBis;
	}

	public static void setIdStaticBis(int idStaticBis) {
		AideServiceHospitalier.idStaticBis = idStaticBis;
	}

	public void setService(String service) {
		this.service = service;
	}
}
