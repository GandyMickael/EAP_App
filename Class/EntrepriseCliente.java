import java.util.ArrayList;


public class EntrepriseCliente {
	private int id;
	private String nom;
	private String adresse;
	private int numTel;
	private String adresseMail;
	ArrayList<Location> lesLocations;
	
	public EntrepriseCliente(int unID, String unNom, String uneAdresse, int unNumTel, String uneAdresseMail){
		this.id = unID;
		this.nom = unNom;
		this.adresse = uneAdresse;
		this.numTel = unNumTel;
		this.adresseMail = uneAdresseMail;
		this.lesLocations =  new ArrayList<Location>();
	}
	
	
	public EntrepriseCliente(int unID, String unNom, String uneAdresse, int unNumTel, String uneAdresseMail, 
			ArrayList<Location> desLocations) {
		this.id = unID;
		this.nom = unNom;
		this.adresse = uneAdresse;
		this.numTel = unNumTel;
		this.adresseMail = uneAdresseMail;
		this.lesLocations = desLocations;
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


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public int getNumTel() {
		return numTel;
	}


	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}


	public String getAdresseMail() {
		return adresseMail;
	}


	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}


	public ArrayList<Location> getLesLocations() {
		return lesLocations;
	}


	public void setLesLocations(ArrayList<Location> lesLocations) {
		this.lesLocations = lesLocations;
	}
	
	public int getNbLocations(){
		return this.lesLocations.size();
	}

}
