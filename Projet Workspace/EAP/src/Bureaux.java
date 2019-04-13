import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="bureaux")
@DiscriminatorValue(value="Bureaux")
public class Bureaux extends Salle {

	public Bureaux(String nom) {
		super(nom);
	}

	public Bureaux() {
	}

}
