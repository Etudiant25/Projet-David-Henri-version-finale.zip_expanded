package Personnel;

public class AgentDaccueil extends Personne {



	private String role;
	protected static int idMatricule;
	protected static int idStaticBis;

	public AgentDaccueil(int matricule, String role, String nom, String prenom, String adresse, String mail, String age) {
		super(nom, prenom, adresse, mail, age);
		this.role=role;
		this.idMatricule=idStaticBis;
		this.idStaticBis++;
		this.idStaticBis=idStaticBis;
	}

	public static int getIdMatricule() {
		return idMatricule;
	}

	public static void setIdMatricule(int idMatricule) {
		AgentDaccueil.idMatricule = idMatricule;
	}

	public static int getIdStaticBis() {
		return idStaticBis;
	}

	public static void setIdStaticBis(int idStaticBis) {
		AgentDaccueil.idStaticBis = idStaticBis;
	}

	public AgentDaccueil(){
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role=role;
	}	
}
