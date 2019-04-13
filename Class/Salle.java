import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="salle")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
	    name="typeSalle",
	    discriminatorType=DiscriminatorType.STRING
	    )
public class Salle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idSalle")
	private int id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="etat")
	private String etat;
	
	@Column(name="nbLocations")
	private int nbLocation;
	
	public Salle(){
	}
	
	public Salle(int unID, String unNom, String unEtat, int unNb) {
		this.id = unID;
		this.nom = unNom;
		this.etat = unEtat;
		this.nbLocation=unNb;
	}
	
	public Salle(String unNom) {
		this.nom = unNom;
		this.etat = "Disponible";
		this.nbLocation=0;
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
