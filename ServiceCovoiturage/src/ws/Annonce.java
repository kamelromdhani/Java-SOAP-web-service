package ws;

public class Annonce {
	String depart,destination,ptRencontre,date,heure,prix,fumeur,nbrplaces;

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getPtRencontre() {
		return ptRencontre;
	}

	public void setPtRencontre(String ptRencontre) {
		this.ptRencontre = ptRencontre;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getFumeur() {
		return fumeur;
	}

	public void setFumeur(String fumeur) {
		this.fumeur = fumeur;
	}

	public String getNbrplaces() {
		return nbrplaces;
	}

	public void setNbrplaces(String nbrplaces) {
		this.nbrplaces = nbrplaces;
	}

	public Annonce() {
		super();
	}

	public Annonce(String depart, String destination, String ptRencontre, String date, String heure, String prix,
			String fumeur, String nbrplaces) {
		super();
		this.depart = depart;
		this.destination = destination;
		this.ptRencontre = ptRencontre;
		this.date = date;
		this.heure = heure;
		this.prix = prix;
		this.fumeur = fumeur;
		this.nbrplaces = nbrplaces;
	}

	@Override
	public String toString() {
		return "Annonce [depart=" + depart + ", destination=" + destination + ", ptRencontre=" + ptRencontre + ", date="
				+ date + ", heure=" + heure + ", prix=" + prix + ", fumeur=" + fumeur + ", nbrplaces=" + nbrplaces
				+ "]";
	}
	
	
}
