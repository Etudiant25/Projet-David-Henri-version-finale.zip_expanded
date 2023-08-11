package Personnel;

public class Personne {


	protected static int IdPatient;
	protected static String Nom;
	protected static String Prenom;
	protected static String Adresse;
	protected static String Mail;
	protected static String age;

	public Personne(String nom, String prenom, String adresse, String mail, String age) {
		this.Nom=nom;
		this.Prenom=prenom;
		this.Adresse=adresse;
		this.Mail=mail;
		this.age=age;
	}

	public Personne(String nom, String prenom) {
		//this.IdPatient=IdPatient;
		this.Nom=nom;
		this.Prenom=prenom;
	}

	public Personne() {
	}

	public static int getIdPatient() {
		return IdPatient;
	}

	public static void setIdPatient(int idPatient) {
		IdPatient = idPatient;
	}

	public static String getNom() {
		return Nom;
	}

	public static void setNom(String nom) {
		Nom = nom;
	}

	public static String getPrenom() {
		return Prenom;
	}

	public static void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public static String getAdresse() {
		return Adresse;
	}

	public static void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public static String getMail() {
		return Mail;
	}

	public static void setMail(String mail) {
		Mail = mail;
	}

	public static String getAge() {
		return age;
	}

	public static void setAge(String age) {
		Personne.age = age;
	}	
}
