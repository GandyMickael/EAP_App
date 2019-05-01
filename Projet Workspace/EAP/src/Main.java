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


public class Main extends Application {
	static String valeur = null;
	static Stage primaryStage=null;
	static Scene StaticScene;
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public void start(Stage primaryStage) {

		try {
			this.primaryStage=primaryStage;
			primaryStage.setTitle("Connexion");
			@SuppressWarnings("unused")
			BorderPane root = new BorderPane();
			GridPane grid = new GridPane ();//Grille qui va permettre positionnés les nœuds. 
			Scene scene = new Scene(grid,700,500);
			scene.getStylesheets().add(getClass().getResource("Scene/application.css").toExternalForm());
		
			
			
			grid.setAlignment (Pos.CENTER);
			
			grid.setHgap(20);
			grid.setVgap(20);
			grid.setPadding(new Insets(25, 25, 25, 25));
			
			
			
			//Label titre = new Label("Interface de Connexion :");
			//titre.setFont (Font.font ("Tahoma", FontWeight.NORMAL, 20)); //Permet de définir la taille,police du LabelTitre
			//qui contient du texte
			//grid.add(titre, 0, 0);
			Label identifiant = new Label("Identifiant:");
			grid.add(identifiant, 0, 1);
			Text message = new Text();
			TextField userTextField = new TextField();
			
			grid.add(userTextField, 1, 1);
			
			Label motDePasse = new Label("Mot de Passe");
			grid.add(motDePasse, 0, 2);
			
			Text combo = new Text("Vous êtes :");
			grid.add(combo, 0, 3);
			
			PasswordField mdpZone = new PasswordField();
			grid.add(mdpZone, 1, 2);
			
			Button button = new Button("Se Connecter");
			grid.add(button, 1, 6);
			
			final Text messageDerreur = new Text();
	        grid.add(messageDerreur, 1, 9);
	        
	       /* -------------------------------------------------------------------*/
	        
	        @SuppressWarnings("rawtypes")
			final ComboBox comboBox = new ComboBox(); 
	        comboBox.getItems().setAll("Administrateur", "Client");
			grid.add(comboBox,1, 3);
			
	        button.setOnAction(new EventHandler<ActionEvent>() {
	        	 
	            @Override
	            public void handle(ActionEvent e) {
	                messageDerreur.setFill(Color.FIREBRICK);//Definit la couleur du message d'erreur
	               // valeur = comboBox.valueProperty().addListener(observable ->comboBox.getValue()); 
	                if(userTextField.getText().length()==0 ||mdpZone.getText().length()==0) {//Affiche message d'erreur si l'un des 2 champs est vide
	                	messageDerreur.setText("");
	                	messageDerreur.setText("Veuillez remplir tous les champs");
	                }else{
                		messageDerreur.setText("");
	                }
	                
	                if(userTextField.getText().length()!=0 ||mdpZone.getText().length()!=0) {
	                	//Modele.connectionDb();//Connexion à la Base de donnée.
	                	String login = userTextField.getText().toString();
	                	String mdp = mdpZone.getText().toString().toString();
	                	if(mdp.isEmpty()||login.isEmpty()){
	                			login=null;
	                			mdp=null;
	                	}
	                	if(comboBox.getValue()!=null){

		                	switch (comboBox.getValue().toString())
		                	{
		                	  case "Administrateur":
		                		  valeur="administrateur";
		                	  break;
		                	  case "Client":
		                		  valeur="client";
		                	  break;
		                	  default:
		                		   
		                	}
	                	}else{
	                		valeur=null;
	                		messageDerreur.setText("Vous n'avez pas choisi votre type");
	                	}
	                	if (valeur!=null && login!=null && mdp!=null &&  Modele.logIn(login, mdp,valeur)==true) {
	                		 try {
	                			 Controleur c = new Controleur();
	                			 switch (valeur)
	     	                	{
	     	                	  case "administrateur":
	     	                		 c.changeToAdministrateur();
	     	                	  break;
	     	                	  case "client":
	     	                		 c.changeToClient(Modele.getIdEnt(login));
	     	                	  break;
	     	                	  default:
	     	                		   
	     	                	}
	                	          
	                	       
	                	            
	                	        } catch(Exception err) {
	                	            err.printStackTrace();
	                	        }

	                	}
	                	else {
	                		System.out.println(login+" "+mdp+" "+valeur+" "+Modele.logIn(login, mdp,valeur));
	                		message.setText("");
	                		message.setFill(Color.FIREBRICK);//Couleur du message
	                		message.setText("Identifiant inconnue ou mot de passe incorrecte");
	                		grid.add(message,1,7);
	                		System.out.println (comboBox.getValue ());
	                	
	         
	                }
	            }  
	            }
	        });
	        StaticScene=scene;
			primaryStage.setTitle("Interface de Connexion");	
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public static String  getValue(){
		return valeur;
		
	}
	
	public static Scene getScene(){
		return StaticScene;
		
	}
	public static Stage getPrimaryStage(){
		return primaryStage;
		
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	
}