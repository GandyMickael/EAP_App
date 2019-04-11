
public class Location {
	
	private int id;
	private String dateDebut;
	private String dateFin ;
	private int idSalle;  //Necessaire pour correspondre à la base de données
	private Salle laSalle; //Necessaire au bon fonctionnement du programme au niveau des classes.
	
	public Location(int unID, String uneDateDebut, String uneDateFin, Salle laSalle){
		this.id = unID;
		this.dateDebut = uneDateDebut;
		this.dateFin = uneDateFin;
		this.laSalle =  laSalle;
		this.idSalle = laSalle.getId();
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
	
}
