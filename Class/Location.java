import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.text.ParseException;
import java.text.SimpleDateFormat;  


@Entity
@Table(name="location")
public class Location {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="dateDebut")
	private String dateDebut;
	
	@Column(name="dateFin")
	private String dateFin ;
	
	@Column(name="idEntrepriseCliente")
	private int idClt;
	
	@Column(name="idSalle")
	private int idSalle;  //Necessaire pour correspondre à la base de données
	
	@Transient
	private Salle laSalle; //Necessaire au bon fonctionnement du programme au niveau des classes.
	

	public Location(){
	}

	public Location(String uneDateDebut, String uneDateFin, Salle laSalle, int idEnt){
		this.dateDebut = uneDateDebut;
		this.dateFin = uneDateFin;
		this.laSalle =  laSalle;
		this.idSalle = laSalle.getId();
		this.idClt = idEnt;
		Modele.incrementNbLocations(laSalle.getId(),"Salle");
		Modele.incrementNbLocations(idEnt,"Ent");

	}
	
	public Location(String uneDateDebut, String uneDateFin, int idSalle, int idEnt){
		this.dateDebut = uneDateDebut;
		this.dateFin = uneDateFin;
		this.idSalle = idSalle;
		this.idClt = idEnt;
		Modele.incrementNbLocations(idSalle,"Salle");
		Modele.incrementNbLocations(idEnt,"Ent");

	}


	public int getIdSalle() {
		return idSalle;
	}

	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}

	public Salle getLaSalle() {
		return laSalle;
	}

	public void setLaSalle(Salle laSalle) {
		this.laSalle = laSalle;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}


	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	
	public int getIdClt() {
		return idClt;
	}

	public void setIdClt(int idClt) {
		this.idClt = idClt;
	}
	
	public Date StringToDate(String date){
		Date date1=null;
		try {
			date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return date1;
		
	}
}
