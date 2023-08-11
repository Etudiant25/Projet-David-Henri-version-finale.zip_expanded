package Soins;


public class Facture implements InterfaceFacture{	

	private double montantTotal;
	private double montantAppareil;
	private double montantHospitalisationMontant;
	private double montantMedicament;
	private double montantSoinsExterne;

	public Facture() {	
	}

	public Double calculMontant() {			
		montantTotal=getHospitalisationMontant()+getAppareilMontant()+getMedicamentMontant()+getSoinsexterneMontant();	
		return montantTotal;		
	}

	public Double getHospitalisationMontant() {
		return montantAppareil;
	}

	public Double getAppareilMontant() {
		return montantHospitalisationMontant;
	}

	public Double getMedicamentMontant() {
		return montantMedicament;
	}

	public Double getSoinsexterneMontant() {
		return montantSoinsExterne;
	}

	public void setAppareilMontant(Double montant) {
		this.montantAppareil = montant;
	}

	public void setHospitalisationMontant(Double montant) {
		this.montantHospitalisationMontant = montant;
	}

	public void setMedicamentMontant(Double montant) {
		this.montantMedicament = montant;
	}

	public void setSoinsExterne(Double soinsExterne) {
		this.montantSoinsExterne = soinsExterne;
	}	
}
