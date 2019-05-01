import java.math.BigDecimal;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Controleur implements Initializable {
	
	
   @FXML private Button button;
   private Stage primaryStage;
   private static int idEntConnected;
   ObservableList<Salle> listSalles = FXCollections.observableArrayList(Modele.getAllSalle());
   ObservableList<EntrepriseCliente> listClients = FXCollections.observableArrayList(Modele.getAllClt());
   ObservableList<Location> listReservs = null;
   ObservableList<String> lesSalles = FXCollections.observableArrayList(this.SalleArraytoString());
   ObservableList<String> lesClients = FXCollections.observableArrayList(this.ClientArraytoString());
   ObservableList<String> etatsSalle = FXCollections.observableArrayList("Libre","Réservée");
   ObservableList<String> typesSalle = FXCollections.observableArrayList("Bureau","Salle de réunion");
   @FXML private ComboBox<String> boxSalles= new ComboBox<String>();
   @FXML private ComboBox<String> boxClients= new ComboBox<String>();
   @FXML private ComboBox<String> boxtypeSalle= new ComboBox<String>();
   @FXML private ComboBox<String> boxetatSalle= new ComboBox<String>();
   ArrayList<Location> lesLocations = new  ArrayList<Location>();
   @FXML TextField fieldDateDebut;
   private static String dateDebut;
   @FXML TextField fieldDateFin;
   private static String dateFin;
   @FXML TextField FieldNomEnt;
   @FXML TextField fieldAdr;
   @FXML TextField fieldMail ;
   @FXML TextField fieldTel= new NumberField("test");
   @FXML TextField fieldNomSalle = new NumberField("test");
   @FXML Label labelTest = new Label();
   @FXML Label prix = new Label();
   @FXML TableView listSalle = new TableView<>();
   @FXML TableColumn<Salle,String> col_name = new TableColumn<>("Salle");
  // @FXML TableColumn<Salle,String> col_type = new TableColumn<>("Type");
   @FXML TableColumn<Salle,Button> col_updt = new TableColumn<>("Réserver");
   @FXML TableView listPlusClt = new TableView<>();;
   @FXML TableView listPlusSalle = new TableView<>();
   @FXML TableView listFacture = new TableView<>();
   @FXML TableView listLocation = new TableView<>();
   @FXML TableColumn<Location,String> col_salle = new TableColumn<>("Salle");
   @FXML TableColumn<Location,String> col_debut = new TableColumn<>("Début");
   @FXML TableColumn<Location,String> col_fin = new TableColumn<>("Fin");
   @FXML TableColumn<Location,Button> col_supp = new TableColumn<>("");
   @FXML TableColumn<Salle,Integer> col_nbLocation = new TableColumn<>("");
   @FXML TableColumn<EntrepriseCliente,String> col_ent = new TableColumn<>("Salle");
   @FXML TableColumn<EntrepriseCliente,String> col_adr = new TableColumn<>("Adresse");
   @FXML TableColumn<EntrepriseCliente,String> col_mail = new TableColumn<>("E-Mail");
   @FXML TableColumn<EntrepriseCliente,Integer> col_numTel = new TableColumn<>("Tel");
   @FXML TableColumn<EntrepriseCliente,Integer> col_nbLoc = new TableColumn<>("Nombre de locations");
   @FXML Text message = new Text();

   
   //Charge
   //@FXML Menu deco;
   @FXML private javafx.scene.control.Button closeButton;
	  
   public Controleur(){
	   primaryStage=Main.getPrimaryStage();  		   
   }
   @Override
   public void initialize(URL location, ResourceBundle resources) {
	   boxSalles.setItems(lesSalles);
	   boxClients.setItems(lesClients);
	   boxtypeSalle.setItems(typesSalle);
	   boxetatSalle.setItems(etatsSalle);
	   Controleur.NumberField(fieldTel);
	   Controleur.NumberField(fieldNomSalle);
	   
   }
   


   public  ArrayList<String> SalleArraytoString(){
	   ArrayList<Salle> lesSalle = Modele.getAllSalle();
	   ArrayList<String> lesSalles = new ArrayList<String>();
	   for (int i=0; i<lesSalle.size();i++){
		   if(lesSalle.get(i).getNom()!=null){
			   lesSalles.add(lesSalle.get(i).getNom());
		   }
		  
	   }
	   if(lesSalles.isEmpty()){
		   System.out.println("Liste Salle vide");
	   }
	   return lesSalles;   
   }
   
   public ArrayList<String> ClientArraytoString(){
	   ArrayList<EntrepriseCliente> lesClient = Modele.getAllClt();
	   ArrayList<String> lesClients = new ArrayList<String>();
	   for (int i=0; i<lesClient.size();i++){
		   if(lesClient.get(i)!=null){
			   lesClients.add(lesClient.get(i).getNom());
		   }
	   }
	   if(lesClients.isEmpty()){
		   System.out.println("Liste Client vide");
	   }
	   return lesClients;   
   }


	// TODO Auto-generated method stub
   	public  void changeToAdministrateur() {
   		try {
   			// Read file fxml and draw interface.
   			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("/Scene/BaseAdmin.fxml"));
	        Parent content = loader.load(); 
	         
	        primaryStage.setTitle("Espace Administrateur");
	        primaryStage.setScene(new Scene(content));
	        primaryStage.show();
	            
	    } catch(Exception err) {
	        err.printStackTrace();
	    }	      
   	}
   	
	// TODO Auto-generated method stub
   	public  void changeToClient(int idEnt) {
   		this.idEntConnected=idEnt;
   		System.out.println(this.idEntConnected);
   		try {
   			// Read file fxml and draw interface.
   			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("/Scene/BaseClient.fxml"));
	        Parent content = loader.load(); 
	         
	        primaryStage.setTitle("Espace Client");
	        primaryStage.setScene(new Scene(content));
	        primaryStage.show();
	            
	    } catch(Exception err) {
	        err.printStackTrace();
	    }	      
   	}
   	
   	// TODO Auto-generated method stub
   	public  void changeToAjoutSalle() {
   		try {
   			// Read file fxml and draw interface.
   			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("/Scene/AjouterUneSalle.fxml"));
	        Parent content = loader.load(); 
	         
	        primaryStage.setTitle("Espace Client");
	        primaryStage.setScene(new Scene(content));
	        primaryStage.show();
	            
	    } catch(Exception err) {
	        err.printStackTrace();
	    }	      
   	}
   	
   	// TODO Auto-generated method stub
   	public  void changeToAjoutClient() {
   		try {
   			// Read file fxml and draw interface.
   			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("/Scene/AjouterUnClient.fxml"));
	        Parent content = loader.load(); 
	         
	        primaryStage.setTitle("Espace Client");
	        primaryStage.setScene(new Scene(content));
	        primaryStage.show();
	            
	    } catch(Exception err) {
	        err.printStackTrace();
	    }	      
   	}
   	
   	// TODO Auto-generated method stub
   	public  void changeToSuppSalle() {
   		try {
   			// Read file fxml and draw interface.
   			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("/Scene/SupprimerUneSalle.fxml"));
	        Parent content = loader.load(); 
	         
	        primaryStage.setTitle("Espace Client");
	        primaryStage.setScene(new Scene(content));
	        primaryStage.show();
	            
	    } catch(Exception err) {
	        err.printStackTrace();
	    }	      
   	}
   	
   	// TODO Auto-generated method stub
   	public  void changeToSuppEClient() {
   		try {
   			// Read file fxml and draw interface.
   			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("/Scene/SupprimerUnClient.fxml"));
	        Parent content = loader.load(); 
	         
	        primaryStage.setTitle("Espace Client");
	        primaryStage.setScene(new Scene(content));
	        primaryStage.show();
	            
	    } catch(Exception err) {
	        err.printStackTrace();
	    }	      
   	}
   	
   	// TODO Auto-generated method stub
   	public  void changeToModifSalle() {
   		try {
   			// Read file fxml and draw interface.
   			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("/Scene/ModifierUneSalle.fxml"));
	        Parent content = loader.load(); 
	         
	        primaryStage.setTitle("Espace Client");
	        primaryStage.setScene(new Scene(content));
	        primaryStage.show();
	            
	    } catch(Exception err) {
	        err.printStackTrace();
	    }	      
   	}
   	
   	// TODO Auto-generated method stub
   	public  void changeToAjoutLocation() {
   		try {
   			// Read file fxml and draw interface.
   			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("/Scene/Rechercher&Reserver.fxml"));
	        Parent content = loader.load(); 
	         
	        primaryStage.setTitle("Espace Client");
	        primaryStage.setScene(new Scene(content));
	        primaryStage.show();
	            
	    } catch(Exception err) {
	        err.printStackTrace();
	    }	      
   	}
   	
   
   	// TODO Auto-generated method stub
   	public  void changeToViewLocation() {
   		initTableLoc(listLocation);
   		try {
   			System.out.println("Fen1");
   			// Read file fxml and draw interface.
   			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("/Scene/Recapitulatif.fxml"));
	        Parent content = loader.load(); 
	        primaryStage.setTitle("Espace Client");
	        primaryStage.setScene(new Scene(content));
	        primaryStage.show();
	        System.out.println("Fen");
	        initTableLoc(listLocation);
	    } catch(Exception err) {
	        err.printStackTrace();
	    }	      
   	}
   	
   	// TODO Auto-generated method stub
   	public  void changeToViewFacture() {
   		try {
   			// Read file fxml and draw interface.
   			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("/Scene/Facture&Paiement.fxml"));
	        Parent content = loader.load(); 
	         
	        primaryStage.setTitle("Espace Client");
	        primaryStage.setScene(new Scene(content));
	        primaryStage.show();
	            
	    } catch(Exception err) {
	        err.printStackTrace();
	    }	      
   	}
   	
   	// TODO Auto-generated method stub
   	public  void changeToSuiviSalles() {
   		try {
   			// Read file fxml and draw interface.
   			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("/Scene/SuiviDesSalles.fxml"));
	        Parent content = loader.load(); 
	         
	        primaryStage.setTitle("Espace Client");
	        primaryStage.setScene(new Scene(content));
	        primaryStage.show();
	            
	    } catch(Exception err) {
	        err.printStackTrace();
	    }	      
   	}
   	
   	// TODO Auto-generated method stub
   	public  void changeToSuiviClients() {
   		try {
   			// Read file fxml and draw interface.
   			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("/Scene/SuiviDesClients.fxml"));
	        Parent content = loader.load(); 
	         
	        primaryStage.setTitle("Espace Client");
	        primaryStage.setScene(new Scene(content));
	        primaryStage.show();
	            
	    } catch(Exception err) {
	        err.printStackTrace();
	    }	      
   	}
   	
	// TODO Auto-generated method stub
   	public  void ajoutClient() {
   	    String nom = FieldNomEnt.getText();
   	    String adr = fieldAdr.getText();
   	    String mail = fieldMail.getText();
   	    int tel = Integer.parseInt(fieldTel.getText());
   	    String testTel = String.valueOf(tel);
   	    System.out.println(testTel.length());
   	    if( testTel.length() == 9 && Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$", mail)) {
   	    	EntrepriseCliente unEnt = new EntrepriseCliente(nom,adr,tel,mail);
   	    	EntrepriseCliente testClient = Modele.getClient(nom,nom);
   	    	if(testClient!=null) {
   	    		message.setFill(Color.FIREBRICK);//Couleur du message
   	    		message.setText("L'entreprise existe déjà dans la BDD.");
   			
   	    	}
   	    	else {
   	    		message.setFill(Color.GREEN);//Couleur du message
   	    		message.setText("Entreprise enregistrée");
   	    		Modele.addClient(unEnt);
   	    	}
   	    }
   	    else {
	    		message.setFill(Color.FIREBRICK);//Couleur du message
	    		message.setText("Le numéro de téléphone n'est pas valide");
   	    }
   	}
   	
   	// TODO Auto-generated method stub
   	public  void ajoutSalle() {
   		String nomSalle = boxtypeSalle.getValue()+" "+fieldNomSalle.getText();
   		Salle uneSalle = null;
   		if(nomSalle.contains("Bureau")){
   			 uneSalle = new Bureaux(nomSalle);
   		}
   		else {
   			 uneSalle = new Salle_de_reunion(nomSalle);
   		}
   		Salle testSalle = Modele.getSalle(nomSalle);
   		if(testSalle!=null) {
   			message.setFill(Color.FIREBRICK);//Couleur du message
   			message.setText("La salle sélectionné existe déjà.");
   			
   		}
   		else {
   			message.setFill(Color.GREEN);//Couleur du message
   			message.setText("Salle enregistrée");
   			Modele.addSalle(uneSalle);
   		}
   	}
   	
   	// TODO Auto-generated method stub
   	public  void updateEtatFacture() {
   		Modele.updateFacture(idEntConnected); 
   		for(int i=0;i<lesLocations.size();i++){
   			Location laLocation = lesLocations.get(i);
   			Modele.removeLocation(laLocation.getId());
   			Modele.updateSalle(laLocation.getNomSalle(), "Libre");
   		}
   		lesLocations.clear();
   		changeToClient(idEntConnected);
   	}
   	
   	
   	// TODO Auto-generated method stub
   	public  void updateSalle() {Modele.updtSalle(boxSalles.getValue(), boxetatSalle.getValue()); changeToModifSalle();}
   	
   	// TODO Auto-generated method stub
   	public  void getFacture() {
   		changeToViewFacture(); 
   	}
   	
   	public void setFacture(){
   		initTableFacture(listFacture); 
   		Facture laFact = new Facture(lesLocations,idEntConnected); 
   		Modele.addFacture(laFact);
   		prix.setText(String.valueOf(laFact.getPrix()));
   	}
   	
	public  void getListRes() {initTableLoc(listLocation);}
	
   	// TODO Auto-generated method stub
   	public  void searchSalle() throws ParseException {

		int compareDate = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	dateDebut=this.fieldDateDebut.getText();
    	dateFin=this.fieldDateFin.getText();
        Date d1 = new Date();
        Date d2 = new Date();
        d1 = sdf.parse(dateDebut);
    	d2 = sdf.parse(dateFin);
        String t1 = sdf.format(d1);
        String t2 = sdf.format(d2);
        compareDate = d1.compareTo(d2);
        
		if(t1.compareTo(dateDebut) != 0 && t2.compareTo(dateFin) != 0){
			System.out.println("Erreur saisie date");
			message.setFill(Color.FIREBRICK);//Couleur du message
			message.setText("Au moins une des dates n'est pas saisie correctement.");
		}else {	
			System.out.println();
			if(compareDate <= 0 && dateDebut.length() == 10 && dateFin.length() == 10) {
				initTableSalle(listSalle);
				message.setText("");
			}else {
				System.out.println("Erreur saisie date");
				message.setFill(Color.FIREBRICK);//Couleur du message
				message.setText("Au moins une des dates n'est pas saisie correctement.");
			}
		}
   	}
   	
   	// TODO Auto-generated method stub
   	public  void suppClient() {Modele.removeClient(boxClients.getValue()); changeToSuppEClient();}
   	
   	// TODO Auto-generated method stub
   	public  void suppSalle() {Modele.removeSalle(boxSalles.getValue()); changeToSuppSalle();}
   	
   	// TODO Auto-generated method stub
   	public  void setSuiviSalles() {initTableSuiviSalle(listPlusSalle);}
   	
   	// TODO Auto-generated method stub
   	public  void setSuiviClients() {
   		initTableClt(listPlusClt);
   	}
   	
    public void initTableClt(TableView table){
    	initColsClt(table);  
    }
    public void initColsClt(TableView table){
 	   //switch/if
    	col_ent.setCellValueFactory(new PropertyValueFactory<EntrepriseCliente,String>("nom"));
    	col_adr.setCellValueFactory(new PropertyValueFactory<EntrepriseCliente,String>("adresse"));
    	col_numTel.setCellValueFactory(new PropertyValueFactory<EntrepriseCliente,Integer>("numTel"));
    	col_mail.setCellValueFactory(new PropertyValueFactory<EntrepriseCliente,String>("adresseMail"));
    	col_nbLoc.setCellValueFactory(new PropertyValueFactory<EntrepriseCliente,Integer>("nbLocations"));
    	setTableClt(table);
    }
    
    public void setTableClt(TableView table){
 	   //switch/if
 		   table.getColumns().clear();
 		   ArrayList<EntrepriseCliente> lesEnts = Modele.getAllClt();
 		   table.setItems(FXCollections.observableArrayList(lesEnts));
 		   table.getColumns().addAll(col_ent,col_adr,col_mail,col_numTel,col_nbLoc);	
    }


   	
	public static void NumberField(TextField field){
		//NumberField test= this;
		field.textProperty().addListener(new ChangeListener<String>() {
			   @Override
			   public void changed(ObservableValue<? extends String> observable, String oldValue, 
			       String newValue) {
			       if (!newValue.matches("\\d*")) {
			    	   field.setText(newValue.replaceAll("[^\\d]", ""));
			       }
			   }
		});
	}
	
	public void reservation(String nameSalle) throws ParseException{
		Label labelTest=new Label();
		int idSalle = Modele.getIdSalle(nameSalle);
			if(dateDebut==null || dateFin==null || dateDebut.equals("") || dateFin.equals("")){
				try {
	   				// Read file fxml and draw interface.
	   				FXMLLoader loader = new FXMLLoader();
	   				loader.setLocation(getClass().getResource("/Scene/Rechercher&ReserverFailed.fxml"));
		        	Parent content = loader.load(); 
		         
		        	primaryStage.setTitle("Espace Client");
		        	primaryStage.setScene(new Scene(content));
		        	primaryStage.show();
		            
				} catch(Exception err) {
					err.printStackTrace();
		    	}	   
			}else{
				System.out.println("else"+idSalle+" "+idEntConnected+" "+
					dateDebut+" "+
					dateFin);
				Location loc = new Location(dateDebut, dateFin, idSalle, idEntConnected);
				Modele.addLocation(loc);
				Modele.updateSalle(nameSalle, "Réservée");
		        }
		        
				changeToAjoutLocation();
			
        
	}
	
	public void annuler_Reservation(int idLoc, int idSalle){
		Label labelTest=new Label();
		//int idSalle = Modele.getIdSalle(nameSalle);
		System.out.println(idLoc+" "+idEntConnected+" "+
				dateDebut+" "+
				dateFin);
		Modele.removeLocation(idLoc);
		System.out.println(idSalle);
		String nomSalle = Modele.getNomSalle(idSalle);
		Modele.updateSalle(nomSalle, "Libre");
		Modele.decrementNbLocations(idSalle,"Salle");
		Modele.decrementNbLocations(idEntConnected,"Ent");
		changeToViewLocation();
	}
	

   	
   	public void retour(ActionEvent event) {
		   String valeur=Main.getValue();
		   try {
		        switch (valeur)
	             	{
	           	  case "administrateur":
	           		 this.changeToAdministrateur();
	           	  break;
	           	  case "client":
	           		 this.changeToClient(idEntConnected);
	           	  break;
	           	  default:
	             }
	           
	        } catch(Exception err) {
	            err.printStackTrace();
	        }	     
		      
	   }
   	
   	public void disconnect(ActionEvent event) {
		   try {
	            // Read file fxml and draw interface.
	            primaryStage.setTitle("Connexion");
	            primaryStage.setScene(Main.getScene());
	            primaryStage.show();
	           
	        } catch(Exception err) {
	            err.printStackTrace();
	        }	   
	   }
   	
   	public void exit(ActionEvent event) {
		   try {
	           primaryStage.close();
	           
	        } catch(Exception err) {
	            err.printStackTrace();
	        }	    
   	}
   	
    public void initTableSalle(TableView table){
 	   initColsSalle(table);  
    }
    public void initColsSalle(TableView table){
 	   //switch/if
 	   col_name.setCellValueFactory(new PropertyValueFactory<Salle,String>("nom"));
 	 //  col_type.setCellValueFactory(new PropertyValueFactory<Salle,String>("type"));
 	   col_updt.setCellValueFactory(new PropertyValueFactory<Salle,Button>("reserver"));
 	   setTableSalle(table);
    }
    
    public void setTableSalle(TableView table){
 	   //switch/if
 	   if(boxtypeSalle.getValue()=="Bureau"){
 		   table.getColumns().clear();
 		   table.setItems(FXCollections.observableArrayList(Modele.getAllBureauDispo()));
 		   table.getColumns().addAll(col_name,col_updt);
 	   }
 	   else{
 		   table.getColumns().clear();
 		   table.setItems(FXCollections.observableArrayList(Modele.getAllSalleRDispo()));
 		   table.getColumns().addAll(col_name,col_updt);
 	   }
 	   
    }
    
    public void initTableSuiviSalle(TableView table){
  	   initColsSuiviSalle(table);  
     }
     public void initColsSuiviSalle(TableView table){
  	   //switch/if
  	   col_name.setCellValueFactory(new PropertyValueFactory<Salle,String>("nom"));
  	   col_nbLocation.setCellValueFactory(new PropertyValueFactory<Salle,Integer>("nbLocation"));
  	   setTableSuiviSalle(table);
     }
     
     public void setTableSuiviSalle(TableView table){
  	   //switch/if
  	   if(boxtypeSalle.getValue()=="Bureau"){
  		   table.getColumns().clear();
  		   table.setItems(FXCollections.observableArrayList(Modele.getAllBureauDispo()));
  		   table.getColumns().addAll(col_name,col_nbLocation);
  	   }
  	   else{
  		   table.getColumns().clear();
  		   table.setItems(FXCollections.observableArrayList(Modele.getAllSalleRDispo()));
  		   table.getColumns().addAll(col_name,col_nbLocation);
  	   }
  	   
     }

    
    public void initTableLoc(TableView table){
    	initColsLoc(table);  
    }
    public void initColsLoc(TableView table){
 	   //switch/if
    	col_salle.setCellValueFactory(new PropertyValueFactory<Location,String>("nomSalle"));
    	col_debut.setCellValueFactory(new PropertyValueFactory<Location,String>("dateDebut"));
    	col_fin.setCellValueFactory(new PropertyValueFactory<Location,String>("dateFin"));
    	col_supp.setCellValueFactory(new PropertyValueFactory<Location,Button>("annuler"));
    	setTableLoc(table);
    }
    
    public void setTableLoc(TableView table){
 	   //switch/if
 		   table.getColumns().clear();
 		   ArrayList<Location> lesLocs = Modele.getAllReserv(idEntConnected);
 		   for(int i=0;i<lesLocs.size();i++){
 			  int idSalle=lesLocs.get(i).getIdSalle();
 			  System.out.println(idSalle);
 			  lesLocs.get(i).setNomSalle(Modele.getNomSalle(idSalle));
 		   }
 		   lesLocations=lesLocs;
 		   table.setItems(FXCollections.observableArrayList(lesLocations));
 		   table.getColumns().addAll(col_salle,col_debut,col_fin,col_supp);	
    }
    
    public void initTableFacture(TableView table){
    	initColsLoc(table);  
    }
    public void initColsFacture(TableView table){
 	   //switch/if
    	col_salle.setCellValueFactory(new PropertyValueFactory<Location,String>("nomSalle"));
    	col_debut.setCellValueFactory(new PropertyValueFactory<Location,String>("dateDebut"));
    	col_fin.setCellValueFactory(new PropertyValueFactory<Location,String>("dateFin"));
    	//col_supp.setCellValueFactory(new PropertyValueFactory<Location,Button>("annuler"));
    	setTableFacture(table);
    }
    
    public void setTableFacture(TableView table){
 		   table.setItems(FXCollections.observableArrayList(lesLocations));
 		   table.getColumns().addAll(col_salle,col_debut,col_fin);	
    }
   	
   	
   	
}

