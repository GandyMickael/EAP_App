import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

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
import javax.persistence.Transient;

import javafx.event.EventHandler;
import javafx.scene.control.Button;



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
	
	@Transient
	private String type;
	
	@Transient
	private Button reserver = new Button("Réserver");
	
	
	public Salle(){
		reserver.setOnAction(e->{
			Controleur c = new Controleur();
			System.out.println(this.getNom()+this.getId());
			try {
				c.reservation(this.getNom());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
	
	public Salle(int unID, String unNom, String unEtat, int unNb) {
		this.id = unID;
		this.nom = unNom;
		this.etat = unEtat;
		this.nbLocation=unNb;
	}
	
	public Salle(String unNom) {
		this.nom = unNom;
		this.etat = "Libre";
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

	public Button getReserver() {
		return reserver;
	}

	public void setReserver(Button reserver) {
		this.reserver = reserver;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		// TODO Auto-generated method stub
		String leType=null;
		/*if(this.nom.contains("Bureau")){
			leType="Bureau";
		}
		else{
			leType="Salle de réunion";
		}*/
		return leType;
	}
}
