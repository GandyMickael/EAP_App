import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Salle de Réunion")
@DiscriminatorValue(value="Salle de Réunion")
public class Salle_de_reunion extends Salle {
 
	public Salle_de_reunion(String nom) {
		super(nom);
	}
	
	public Salle_de_reunion(){
		
	}
}
