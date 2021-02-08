import com.mongodb.MongoClient;

import java.net.UnknownHostException;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.bson.types.ObjectId;

public class MongoClass {

	public static void main(String[] args) {
		
		try {
			MongoClient mongoClient= new MongoClient("localhost",27017);
			System.out.println("Connexion � la db reussie !");
			
			
			DB db = mongoClient.getDB("DataLivres");
			DBCollection dbLivres=db.getCollection("DataL");
		
			
			
			System.out.println("########### Bienvenue sur notre application de gestion de libraire ! ###########");
			System.out.println("#                                                                              #");
			System.out.println("#                       Que souhaitez vous faire ?                             #");
			System.out.println("#                                                                              #");
			System.out.println("# -Pour ajouter un livre saisir: Ajouter                                       #");
			System.out.println("# -Pour supprimer un livre saisir: Supprimer                                   #");
			System.out.println("# -Pour modifier un livre saisir: Modifier                                     #");
			System.out.println("# -Pour rechercher un livre saisir: Rechercher                                 #");
			System.out.println("# -Pour obtenir des infos stock saisir: Infos                                  #");
			System.out.println("# -Pour voir les livres dans l'ordre alphabetique saisir: Ordonn�              #");
			System.out.println("################################################################################");
			
		

			System.out.println("Saisir choix:");
			Scanner sc = new Scanner(System.in);
		    String i = sc.nextLine();
		    
		    if(i.contentEquals("Ordonn�")) {
	    		 System.out.println("########################## Livres ordre alphabetique ############################");
	    		 
	    		 BasicDBObject query = new BasicDBObject();
	    		    query.put("title", new BasicDBObject("$lt", "ZZZZZZZZZZ"));
	    		    DBCursor cursor = dbLivres.find(query).sort(new BasicDBObject("title",1)).limit(425);
	    		    for (DBObject dbObject : cursor) {
	    		        System.out.println(dbObject);
	    		    }
				 
		    	
		    }
		
		  
	    	 if(i.equals("Infos")) {
	    		 
	    		 System.out.println("################################## Page infos  #################################");
			    	
			    
			    	System.out.println("Pour connaitre le nombre de livre par cat�gorie saisir: 1 pour le nombre total 2");
			    	 String choix1 = sc.nextLine();
		
			    	 if(choix1.equals("1")) {
			    		 
			    			System.out.println("Saisir cat�gorie livre rechercher: \n");
				    		System.out.println("Cat�gories existantsJava,Internet,Perl,Microsoft .NET");
				    		 String nbcatr = sc.nextLine();
				    		 
				    		
				    		 
				    		  BasicDBObject whereQuery = new BasicDBObject();
							    whereQuery.put("categories", nbcatr);
							    DBCursor cursor = dbLivres.find(whereQuery);
							  
							   int i1 = cursor.count();
							   System.out.println("Le nombre de livre dans cet cat�gorie est de :");
							   System.out.println(i1);
							    
					
							    
			    	 }
			    	 
			    	 if(choix1.equals("2")) {
			    		 
			    		 
			    		int i2 = (int) dbLivres.count();
			    		System.out.println("Le nombre de livre total est de :");
						System.out.println(i2);							
							
			    	 }
			    	 
			    }
		
		    
		    if(i.equals("Ajouter")) {
			   
				System.out.println("################################ Page d'ajout de livre #########################");
			 
				System.out.println("Saisir titre du livre:");
			    String titre = sc.nextLine();
			    System.out.println("Saisir nombre de page du livre:");
			    String nombrepg = sc.nextLine();
			    System.out.println("Saisir Description du livre:");
			    String desc = sc.nextLine();
			    System.out.println("Saisir Cat�gorie du livre:");
			    String cat = sc.nextLine();
			    
			    
			    BasicDBObject ajoutLivre = new BasicDBObject();
			    ajoutLivre.put("title",titre);
			    ajoutLivre.put("pageCount",nombrepg);
			    ajoutLivre.put("shortDescription",desc);
			    ajoutLivre.put("categories",cat);
			    
			    dbLivres.insert(ajoutLivre);
			    
				System.out.println("L'ajout � bien �t� effectuer !");
		
			    /**
			    BasicDBObject whereQuery = new BasicDBObject();
			    whereQuery.put("categories", "Internet");
			    DBCursor cursor = dbLivres.find(whereQuery);
			    while(cursor.hasNext()) {
			        System.out.println(cursor.next());
			    }
		**/
			    
		    }
		    if(i.equals("Supprimer")) {
		    	System.out.println("############################ Page de suppression de livre #######################");
		    
		    	
		    	 System.out.println("Saisir le titre du livre � supprimer:");
				 String titreLS = sc.nextLine();
		    	 BasicDBObject document = new BasicDBObject();
		    	 
		    	 document.put("title",titreLS);
		    	 dbLivres.remove(document);
		    	 /**
		    	   BasicDBObject whereQuery = new BasicDBObject();
				    whereQuery.put("categories", "Internet");
				    DBCursor cursor = dbLivres.find(whereQuery);
				    while(cursor.hasNext()) {
				        System.out.println(cursor.next());
				    } **/
		 	
				System.out.println("Le livre a bien �t� supprimer !");

		    }
		   
		    if(i.equals("Modifier")) {
		    	
		    	System.out.println("########################### Page de modification de livre #######################");
		    
		    	System.out.println("Saisir titre du livre � modifier");
			    String titreLM = sc.nextLine();
			    System.out.println("Saisir la nouvelle description");
			    String NVdesc = sc.nextLine();
			    
			    BasicDBObject document1 = new BasicDBObject();
			    BasicDBObject document2 = new BasicDBObject();
			    
		    	 document1.put("title",titreLM);
		    	 document2.put("shortDescription",NVdesc);

		
		    	dbLivres.update(document1, document2);
		    	
		    	 

				System.out.println("Ma modification � bien �t� effectuer !");

		    }
		    
		    if(i.equals("Rechercher")) {
		    	
		    	System.out.println("########################### Page de recherche de livree ########################");
		    	
		 
		    	System.out.println("Vous souhaitez rechercher par titre ou cat�gorie?");
				 String Trech = sc.nextLine();
		    	if(Trech.equals("titre")) {
		    		
		    		System.out.println("Saisir titre du livre rechercher:");
		    		 String TLrech = sc.nextLine();
		    		 
		    		  BasicDBObject whereQuery = new BasicDBObject();
					    whereQuery.put("titre", TLrech);
					    DBCursor cursor = dbLivres.find(whereQuery);
					    while(cursor.hasNext()) {
					        System.out.println(cursor.next());
					    }
					    System.out.println("Voici les resultats !");
		    	}
		    	
		    	if(Trech.equals("cat�gorie")){
		    		
		    		System.out.println("Saisir cat�gorie livre rechercher: \n");
		    		System.out.println("Cat�gories existantsJava,Internet,Perl,Microsoft .NET");
		    		 String TLrech = sc.nextLine();
		    		 
		    		  BasicDBObject whereQuery = new BasicDBObject();
					    whereQuery.put("categories", TLrech);
					    DBCursor cursor = dbLivres.find(whereQuery);
					    while(cursor.hasNext()) {
					        System.out.println(cursor.next());
					    }    
					    System.out.println("Voici les resultats !");
		    	}
		    			    	
		    }
		    
		 	   
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("Connection echou� !");
		}
		
	}

}
