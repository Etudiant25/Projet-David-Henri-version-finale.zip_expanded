package Soins;

public class Appareil extends Soins{


	public String appareil;
	protected String idPatient;
	private Double montant;

	public Appareil(String idAppareil, String type, String nom, Double montant, String IdPatient) {
		super(type, nom);
		this.appareil=appareil;
		this.montant=montant;
		this.idPatient=IdPatient;
	}

	public Double getAppareilMontant() {
		return montant;
	}
}
