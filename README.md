- INSTALLATION MONGODB
      MongoDB voir lien: https://www.web-explore.com/uk/web?q=Mongodb&cdr=9174dae3632a2d3210062a24bf203370&ehr=55a2d32a37a83b6310a9d82ce00541da&ugc=1#t=https://r.search.yahoo.com/cbclk/dWU9RTBDMjVENDIwNkU1NERBMyZ1dD0xNjEyNzkxMTE5MzExJnVvPTc1NTIyODQ1OTA5NDI4Jmx0PTImcz0yJmVzPTNuVldOQ0FHUFNfbUxKdlAwRE02ZXl2X25mTElHYkNmS2FRYVNXalJNU29zUXN1bw--/RV=2/RE=1612819919/RO=10/RU=https%3a%2f%2fwww.bing.com%2faclick%3fld%3de8g1mP5iXv4LmmergPNQdBwDVUCUwXobqqAA7y-HKo8Uu5H6fKIswu16DtO-EBhUUgSbSJvPrGTeSuoJBDjPCsOqjbPRW2vv-wzNFmenEAN6-McQo5jh1RDkhdNmZptmpIiZKP86b1Hwf2EutIJ1-CBDeYECzYPIapo-cqVprVtsWvCiJw%26u%3daHR0cHMlM2ElMmYlMmZ3d3cubW9uZ29kYi5jb20lMmZjbG91ZCUyZmF0bGFzJTJmbHAlMmZ0cnkyJTNmdXRtX3NvdXJjZSUzZGJpbmclMjZ1dG1fY2FtcGFpZ24lM2Ric19lbWVhX2ZyYW5jZV9zZWFyY2hfYnJhbmRfYXRsYXNfZGVza3RvcCUyNnV0bV90ZXJtJTNkbW9uZ29kYiUyNnV0bV9tZWRpdW0lM2RjcGNfcGFpZF9zZWFyY2glMjZ1dG1fYWQlM2RlJTI2dXRtX2FkX2NhbXBhaWduX2lkJTNkMzg2MDI4MjE0JTI2bXNjbGtpZCUzZGNiZjc1NWQ4ZTE1MzE0MzM1Mzk1MzVmOWRjMWMzZGE5%26rlid%3dcbf755d8e1531433539535f9dc1c3da9/RK=2/RS=BUh9mUxaGpXhA7LzScETmb0xb0I-
      Ajout des fonctionallité MongoDB voir lien: https://docs.mongodb.com/manual/reference/program/mongoimport/
      Commande d'ajout du JSON sur mongo DB: use NomDB sur mongo
                                             db.createCollection("NomCollection"); sur mongo
                                             mongoimpport --db tymongo --collection NomCollection C:\Chemin\du\json.Json (Ici Livres.json)

 - CONFIGURATION ECLIPSE
      Installation Eclipse : https://www.eclipse.org/
      Ajout du Package mongoDB via configuration Eclipse voir lien: https://mongodb.github.io/mongo-java-driver/


 - LANCEMENT DU PROJET
      Ouverture du projet avec Eclipse dans le Workspace fournis (Optionel)
      Configuration de la connection à la DB : try{ MongoClient mongoClient = new MongoClient("localhost",27017);
                                                    Systeme.out.println("Connexion à la db reussie");

                                                    //Acceder à la DB 
                                                    DB db = mongoClient.getDB("NomDB");
                                                    DBCollection LaDB = db.getCollection("NomCollection");

                                                    //vous pouvez effectuer la commande suivante afin de verifié que la connexion à bien été effecuter (Optionel)
                                                    System.out.println(LaDB);

                                                    }catch{ UnknowHostException e){
                                                    e.printStackTrace();
                                                    System.out.println("Connexion échoué!");

                    }
  - RESULTAT
  Un site fonctionnel avec plusieurs fonctionalité pour la gestion d'une libraire.
