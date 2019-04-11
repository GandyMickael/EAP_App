
public class Salle {
	
	private int id;
	private String nom;
	private String etat;
	private int nbLocation;
	
	public Salle(int unID, String unNom, String unEtat, int unNb) {
		this.id = unID;
		this.nom = unNom;
		this.etat = unEtat;
		this.nbLocation=unNb;
	}
	
	public Salle(String unNom) {
		this.nom = unNom;
	}
	
	public int getNbLocation() {
		return nbLocation;
	}

	public void setNbLocation(int nbLocation) {
		this.nbLocation = nbLocation;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	 public void incrementNbLocations(){
		 this.nbLocation=this.nbLocation+1;
	 }

}
