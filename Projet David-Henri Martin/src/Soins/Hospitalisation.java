package Soins;

public class Hospitalisation extends Soins implements InterfaceFacture{


	private int nombreDeJour;
	private Double montant;
	private Double montantAppareil;
	private Double montantHospitalisationMontant;
	private Double montantMedicament;
	private Double montantSoinsExterne;

	public Hospitalisation(int nombreDejour,String type, String nom, Double montant) {
		super(type,nom);
		this.nombreDeJour=nombreDejour;
		this.montant=montant;
	}

	public int getNombreDeJour() {
		return nombreDeJour;
	}

	public void setNombreDeJour(int nombreDeJour) {
		this.nombreDeJour = nombreDeJour;
	}

	public void setHospitalisationMontant(Double montant) {
		this.montant = montant;
	}

	public Double getHospitalisationMontant() {
		return montant;
	}

	public Double getAppareilMontant() {
		return montant;
	}

	public Double getMedicamentMontant() {
		return montant;
	}

	public Double getSoinsexterneMontant() {
		return montant;
	}

	public void setAppareilMontant(Double montant) {
		this.montantAppareil = montant;
	}

	public void setMedicamentMontant(Double montant) {
		this.montantMedicament = montant;
	}

	public void setSoinsExterne(Double soinsExterne) {
		this.montantSoinsExterne = soinsExterne;
	}
}
