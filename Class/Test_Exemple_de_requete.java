import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Test_Exemple_de_requete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// AJOUT D'UNE SALLE
		//Salle_de_reunion n135 = new Salle_de_reunion("Bureaux 136");
		//Modele.addSalle(n135);
		
		
		//SUPPRESSION D'UNE SALLE
		// Modele.removeSalle("Bureaux 136");

		
		// MODIF ETAT D'UNE SALLE
		//Modele.updateSalle("Bureaux 1", "Libre");
		//Modele.updateSalle("Salle de Réunion 1", "Libre");
		
		//AJOUT D'UN CLIENT
		//EntrepriseCliente clt = new EntrepriseCliente(1235468734,  "Anim'aBoire",  "jesaisplus",  0625234546,  "anim@boire.com");
		//Modele.addClient(clt);
		
		//SUPPRESSION D'UN CLIENT
		//Modele.removeClient("AnimaBoire");
		
		//AJOUT D'UNE RESERVATION
			//Location loc = new Location("12/05/2010", "13/05/2010", n135, 1);
			//Location loc = new Location("12/05/2010", "13/05/2010", 22, 1);
			//Modele.addLocation(loc);
		
		//TEST RECUPERATION DES LIST
		 // ArrayList<Salle> lesS = Modele.getAllSalle();
		 // ArrayList<EntrepriseCliente> lesClt = Modele.getAllClt();
		 // ArrayList<Location> lesLocs = Modele.getAllReserv(1);
		  
		/*for(int i =0; i<lesS.size(); i++){
			  System.out.println(lesS.get(i).getNom());
		  }
		  for(int j=0; j<lesClt.size(); j++){
			  System.out.println(lesClt.get(j).getNom());
		  }
		 System.out.println("ID SALLE RES");
		  for(int k=0; k<lesLocs.size(); k++){
			  System.out.println(lesLocs.get(k).getIdSalle());
		  }*/
		
		// Generation Facture -> ajout en base -> recupération POUR ENT 1
		//Facture fact = new Facture(lesLocs, 1);
		//Modele.addFacture(fact);
		//Modele.getFacture(1);
		//Modif etat Facture
		//Modele.updateFacture(1); //idEnt && etat = "En cours"
		
	}

}
