import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="entreprisecliente")
public class EntrepriseCliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idEntrepriseCliente")
	private int id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="adresse")
	private String adresse;
	
	@Column(name="numtel")
	private int numTel;
	
	@Column(name="adressemail")
	private String adresseMail;
	
	@Column(name="nbLocationsEffectuee")
	private int nbLocations;
	
	@Column(name="mdp")
	private String mdp;
	
	@Transient
	ArrayList<Location> lesLocations;
	
	public EntrepriseCliente(){
	}
	
	public EntrepriseCliente(int unID, String unNom, String uneAdresse, int unNumTel, String uneAdresseMail){
		this.id = unID;
		this.nom = unNom;
		this.adresse = uneAdresse;
		this.numTel = unNumTel;
		this.adresseMail = uneAdresseMail;
		this.lesLocations =  new ArrayList<Location>();
		this.nbLocations = 0;
		this.mdp=unNom;
	}
	
	
	public EntrepriseCliente(int unID, String unNom, String uneAdresse, int unNumTel, String uneAdresseMail, 
			ArrayList<Location> desLocations) {
		this.id = unID;
		this.nom = unNom;
		this.adresse = uneAdresse;
		this.numTel = unNumTel;
		this.adresseMail = uneAdresseMail;
		this.lesLocations = desLocations;
		this.nbLocations = 0;
		this.mdp=unNom;
	}


	public void setNbLocations(int nbLocations) {
		this.nbLocations = nbLocations;
	}
	
	public int getNbLocations() {
		return this.nbLocations;
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
}
