import java.util.ArrayList;

public class EAP {
	private int id;
	private String nom;
	private String adresse;
	private int numTel;
	private String adresseMail;
	ArrayList<Salle> lesSalles;
	
	public EAP(int unID, String unNom, String uneAdresse, int unNumTel, String unMail){
		this.id = unID;
		this.nom = unNom;
		this.adresse = uneAdresse;
		this.numTel = unNumTel;
		this.adresseMail= unMail;
		this.lesSalles =  new ArrayList<Salle>();
	}
	public EAP(int unID, String unNom, String uneAdresse, int unNumTel, String unMail, ArrayList<Salle> desSalles){
		this.id = unID;
		this.nom = unNom;
		this.adresse = uneAdresse;
		this.numTel = unNumTel;
		this.adresseMail= unMail;
		this.lesSalles =  desSalles;		
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
	public ArrayList<Salle> getLesSalles() {
		return lesSalles;
	}
	public void setLesSalles(ArrayList<Salle> lesSalles) {
		this.lesSalles = lesSalles;
	}
	


}
