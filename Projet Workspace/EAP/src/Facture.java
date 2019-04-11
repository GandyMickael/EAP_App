import java.util.ArrayList;

public class Facture {
	
	private int numFacture;
	private float prix;
	private ArrayList<Salle> LesSallesLoues;
	private String etat;

	public Facture(int unNumFacture, float unPrix, int unNumBureauxLoue, int unNumSalleDRLoue, int unNbHeureSalleDRLoue) {
		this.numFacture = unNumFacture;
		this.prix = unPrix;
		this.LesSallesLoues = new ArrayList<Salle>();
		this.etat="En attente de paiement";
		
	}
	
	public Facture(int unNumFacture, float unPrix, int unNumBureauxLoue, int unNumSalleDRLoue, int unNbHeureSalleDRLoue, 
			ArrayList<Location> lesLocations) {
		this.numFacture = unNumFacture;
		this.prix = unPrix;
		for(int i=0; i<lesLocations.size();i++){
			LesSallesLoues.add(lesLocations.get(i).getLaSalle());
		}
	}


	public int getNumFacture() {
		return numFacture;
	}


	public void setNumFacture(int numFacture) {
		this.numFacture = numFacture;
	}


	public float getPrix() {
		return prix;
	}


	public void setPrix(float prix) {
		this.prix = prix;
	}

	public ArrayList<Salle> getSallesLoue() {
		return LesSallesLoues;
	}


	public void setSallesLoue(ArrayList<Salle> lesSalles) {
		this.LesSallesLoues = lesSalles;
	}

	public void addSalle(Salle salle){
		this.LesSallesLoues.add(salle);
	}
	
	public void removeSalle(Salle salle){
		this.LesSallesLoues.remove(salle);
	}
	
	public boolean rechercheSalle(Salle salle){
		return this.LesSallesLoues.contains(salle);
	}
	
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	
}
