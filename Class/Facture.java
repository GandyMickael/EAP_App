import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="facture")
public class Facture {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idFacture")
	private int numFacture;
	
	@Column(name="prix")
	private float prix;
	
	@Transient
	private ArrayList<Location> lesLocations;
	
	@Column(name="etat")
	private String etat;
	
	@Column(name="idEntrepriseCliente")
	private int idClt;

	public Facture(){
	}
	
	public Facture(int idEnt) {
		this.lesLocations = new ArrayList<Location>();
		this.etat="En attente de paiement";
		this.idClt=idEnt;
		this.calcul_Prix();
		
	}

	public Facture(ArrayList<Location> lesLocations, int idEnt) {
		this.lesLocations=lesLocations;
		this.etat="En attente de paiement";
		this.idClt=idEnt;
		this.calcul_Prix();
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


	private void setPrix(float prix) {
		this.prix = prix;
	}

	public ArrayList<Location> getlesLocations() {
		return lesLocations;
	}


	public void setlesLocations(ArrayList<Location> lesLoc) {
		this.lesLocations = lesLoc;
	}

	public void addLocation(Location uneLocation){
		this.lesLocations.add(uneLocation);
		this.calcul_Prix();
	}
	
	public void removeLocation(Location uneLocation){
		this.lesLocations.remove(uneLocation);
		this.calcul_Prix();
	}
	
	public boolean rechercheLocation(Location uneLocation){
		return this.lesLocations.contains(uneLocation);
	}
	
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	public void calcul_Prix(){
		float prix = 0;
		int cptB=0;
		int cptS=0;
		if(!this.lesLocations.isEmpty()){
			for(int i=0;i<this.lesLocations.size();i++){
				Location laLocation=this.lesLocations.get(i);
				String dateDebutS = laLocation.getDateDebut();
				String dateFinS = laLocation.getDateFin();
				
				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
				LocalDate date1 = LocalDate.parse(dateDebutS, format);
				LocalDate date2 = LocalDate.parse(dateFinS, format);
				Period period = Period.between(date1, date2);
				Salle laSalle=Modele.getSalle(laLocation.getIdSalle());
				if(laSalle.getNom().contains("Bureau")){
					cptB=cptB+1;
					prix=prix+10*period.getDays();
					System.out.println("Bureau "+ prix);
				}
				else{
					cptS=cptS+1;
					prix=prix+20*period.getDays();
					System.out.println("SalleR "+ prix);
				}
			}
		}
		else{
			System.out.println("Pas de Locations");
		}
		System.out.println(prix+" "+cptB+" "+cptS);
		this.prix=prix;
		
	}
	
}
