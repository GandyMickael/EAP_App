import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Modele {
	
	public static ArrayList<Salle> getAllSalle(){
		
		//create session factory
		SessionFactory factoryB = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Bureaux.class)
								.buildSessionFactory();
		//create session
		Session session = factoryB.getCurrentSession();
		ArrayList<Salle> lesSalles = new ArrayList<Salle>();
		try {
			//start a transaction
			session.beginTransaction();
			
			//query students
			ArrayList<Salle> lesBureaux = (ArrayList<Salle>) session.createQuery("from Salle where nom LIKE 'Bureau%'").getResultList();
			session.getTransaction().commit();
			
			//On change de factory pour pouvoir récupérer un nouveau type d'objet
			SessionFactory factoryS= new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Salle_de_reunion.class)
									.buildSessionFactory();
			session = factoryS.getCurrentSession();
			session.beginTransaction();
			ArrayList<Salle> lesSalles_de_reunion = (ArrayList<Salle>) session.createQuery("from Salle where nom LIKE 'Salle%'").getResultList();
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Fini");
			factoryS.close();
			lesSalles.addAll(lesBureaux);
			lesSalles.addAll(lesSalles_de_reunion);
		}
		finally{
			factoryB.close();
		}
		return lesSalles;
	}
	
	public static ArrayList<EntrepriseCliente> getAllClt(){
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(EntrepriseCliente.class)
								.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		ArrayList<EntrepriseCliente> lesClients = new ArrayList<EntrepriseCliente>();
		try{
			//start a transaction
			session.beginTransaction();
			
			//query students
			lesClients = (ArrayList<EntrepriseCliente>) session.createQuery("from EntrepriseCliente").getResultList();
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Fini");
		}
		finally{
			factory.close();
		}
		return lesClients;
	}
	
	public static ArrayList<Location> getAllReserv(int idEnt){
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Location.class)
								.buildSessionFactory();	
		//create session
		Session session = factory.getCurrentSession();
		ArrayList<Location> lesLocations = new ArrayList<Location>();
		try{
			//start a transaction
			session.beginTransaction();
	
			//query location
			lesLocations = (ArrayList<Location>) session.createQuery("from Location where idEntrepriseCliente="+idEnt).getResultList();
			
			//commit transaction
			session.getTransaction().commit();
		}
		finally{
			//End
			System.out.println("Fini");
			factory.close();
		}
		return lesLocations;
	}
	public static void addSalle(Salle uneSalle){
		
		if(uneSalle.getClass().getName()=="Bureaux"){
			//create session factory
			SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Bureaux.class)
									.buildSessionFactory();
			save(uneSalle,factory);	
		}
		else{
			//create session factory
			SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Salle_de_reunion.class)
					.buildSessionFactory();
			save(uneSalle,factory);
		}	
	}
	
	public static void removeSalle(String nomSalle){
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Salle.class)
								.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//now get a new session and start transaction
			session.beginTransaction();

			//delete
			System.out.println("Suppression "+nomSalle);
			session.createQuery("delete from Salle where nom='"+nomSalle+"'").executeUpdate();
			
			// End
			System.out.println("Fini");
			session.getTransaction().commit();
		}
		finally{
			factory.close();
		}	
	}
	
	public static void updateSalle(String nomSalle, String unEtat){
		//create session factory
		if(nomSalle.contains("Bureau")){
			SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Bureaux.class)
									.buildSessionFactory();
			//create session
			Session session = factory.getCurrentSession();
			
			try {
				session.beginTransaction();
				//retrieve salle based on the id: primary key
					Bureaux laSalle = (Bureaux) session.createQuery("from Salle where nom = '"+nomSalle+"'").getSingleResult();
					changeEtat(laSalle, unEtat, session);
			}
			finally{
				factory.close();
			}
		}
		else{
			//create session factory
			SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Salle_de_reunion.class)
									.buildSessionFactory();
			//create session
			Session session = factory.getCurrentSession();
					
			try {
				session.beginTransaction();	
				//retrieve salle based on the id: primary key
				Salle_de_reunion laSalle = (Salle_de_reunion) session.createQuery("from Salle where nom = '"+nomSalle+"'").getSingleResult();
				changeEtat(laSalle, unEtat, session);
				}
			finally{
				factory.close();
			}
		}	
	}
	
	
	private static void changeEtat(Salle laSalle, String unEtat, Session session){
		//update salle
		System.out.println("Updating student...");
		laSalle.setEtat(unEtat);
		
		// Commit & End
		System.out.println("Fini");
		session.getTransaction().commit();
		
	}

	public static Salle getSalle(int idSalle){
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Salle.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		Salle laSalle=null;
		try{
			//start a transaction
			session.beginTransaction();
			laSalle = (Salle) session.createQuery("from Salle where idSalle = "+idSalle).getSingleResult();
			//commit les transactions
			session.getTransaction().commit();
			if(laSalle==null){
				System.out.println("Get Salle Null");
			}
			else{
				System.out.println("Success GET Salle");
			}
		}
		finally{
			factory.close();
		}
		return laSalle;
	}
	
	public static void addClient(EntrepriseCliente clt){
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(EntrepriseCliente.class)
								.buildSessionFactory();
		save(clt,factory);	
	}
	
	public static void removeClient(String nomClt){
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(EntrepriseCliente.class)
								.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		try {
			//now get a new session and start transaction
			session.beginTransaction();

			//delete
			System.out.println("Suppression "+nomClt);
			session.createQuery("delete from EntrepriseCliente where nom='"+nomClt+"'").executeUpdate();
			
			// End
			System.out.println("Fini");
			session.getTransaction().commit();
		}
		finally{
			factory.close();
		}	
	}
	
	public static void addLocation(Location loc){
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Location.class)
								.buildSessionFactory();
		save(loc,factory);	
	}
	
	public static void addFacture(Facture fact){
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Facture.class)
								.buildSessionFactory();
		save(fact,factory);	

	}
	
	public static Facture getFacture(int idEnt){
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Facture.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		Facture laFacture=null;
		try{
			//start a transaction
			session.beginTransaction();
			laFacture = (Facture) session.createQuery("from Facture where idEntrepriseCliente = '"+idEnt+"' AND etat='En cours'").getSingleResult();
			//commit les transactions
			session.getTransaction().commit();
			System.out.println("Success GET");
		}
		finally{
			factory.close();
		}
		return laFacture;
	}
	
	public static void updateFacture(int idEnt){
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Facture.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		Facture laFacture=null;
		try{
			//start a transaction
			session.beginTransaction();
			laFacture = (Facture) session.createQuery("from Facture where idEntrepriseCliente = "+idEnt+" AND etat='En attente de paiement'").getSingleResult();
			laFacture.setEtat("Payée");

			//commit les transactions
			session.getTransaction().commit();
			System.out.println("Success UPDATE");
		}
		
		finally{
			factory.close();
		}
	}
	
	public static void incrementNbLocations(int id, String type){
		
		if(type=="Salle"){
			SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Salle.class)
					.buildSessionFactory();
			Session session = factory.getCurrentSession();
			try{
				session.beginTransaction();
				Salle laSalle = (Salle) session.createQuery("from Salle where idSalle = "+id).getSingleResult();
				if(laSalle==null){
					System.out.println("increment salle null");
				}
				else{
					laSalle.setNbLocation(laSalle.getNbLocation()+1);
				}
				//commit les transactions
				session.getTransaction().commit();
				System.out.println("Success UPDATE");
			}
			
			finally{
				factory.close();
			}
			
		}
		else{
			SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(EntrepriseCliente.class)
					.buildSessionFactory();
			Session session = factory.getCurrentSession();
			try{
				session.beginTransaction();
				EntrepriseCliente uneEnt = (EntrepriseCliente) session.createQuery("from EntrepriseCliente where idEntrepriseCliente = "+id).getSingleResult();
				uneEnt.setNbLocations(uneEnt.getNbLocations()+1);
		
				//commit les transactions
				session.getTransaction().commit();
				System.out.println("Success UPDATE");
			}
			
			finally{
				factory.close();
			}
		}
	}
	
	private static void save(Object o, SessionFactory factory){
		//create session
		Session session = factory.getCurrentSession();
		try {
			//use the session object to save Java object
			
			// create a student object
			Object tempObject = o;
			//start a transaction
			session.beginTransaction();
			
			session.save(tempObject);
			
			//commit les transactions
			session.getTransaction().commit();
			System.out.println("Success");
		}
		finally{
			factory.close();
		}
	}
	
}
