package ws;
import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.bson.Document;
import org.bson.types.ObjectId;

import ws.Avis;
import ws.Annonce;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBAdapter {
	MongoClient mongo = new MongoClient( "localhost" , 27017 );
	MongoDatabase database = mongo.getDatabase("dbcovoiturage");
	MongoCollection<Document> collectionI = database.getCollection("internautes");
	MongoCollection<Document> collectionA = database.getCollection("annonces");
	
	public MongoDBAdapter() {
		super();
	}

	public void InsertInternaute(String nom,String prenom,String fonction,String date,String tel,String sexe,String login,String mdp) {
		Document doc = new Document("nom",nom).append("prenom", prenom).append("fonction", fonction).append("date", date).append("numtel", tel).append("sexe", sexe).append("login", login).append("motdepasse", mdp);
		collectionI.insertOne(doc);
	}
	
	public void InsertAnnonce(String id_chauffeur,String depart,String destination,String pt_rencontre,String date,String heure,String prix,String fumeur,String nbr_place,String id_voiture) {
		ArrayList<Document> documents = collectionI.find(eq("_id", new ObjectId(id_chauffeur))).into(new ArrayList<Document>());
		String nom = documents.get(0).get("nom").toString();
		String prenom = documents.get(0).get("prenom").toString();
		String tel = documents.get(0).get("numtel").toString();
		String subdocument = documents.get(0).get("voitures").toString();
		StringTokenizer st=new StringTokenizer(subdocument, "=,}");
		String marque="null";String model="null";
		if(!(subdocument.equals("null"))) {
			while(st.hasMoreTokens()) {
				st.nextToken();
				if(st.nextToken().equals(id_voiture)) {
					st.nextToken();
					marque = st.nextToken();
					st.nextToken();
					model = st.nextToken();
					break;
				}
				st.nextToken();st.nextToken();st.nextToken();st.nextToken();
				st.nextToken();st.nextToken();st.nextToken();st.nextToken();
				st.nextToken();
			}
		}
		Document doc = new Document("id_chauffeur",id_chauffeur).append("nom", nom).append("prenom", prenom).append("numtel", tel).append("date", date).append("point_depart", depart).append("point_arrivee", destination).append("point_rencontre", pt_rencontre).append("heure_depart", heure).append("prix", prix).append("nbr_place", nbr_place).append("fumeur", fumeur).append("voiture_marque", marque).append("voiture_modele", model);
		collectionA.insertOne(doc);
		
		
	}
	
	public List<Annonce> getListAnnonces(){
		int i=0;
		List<Annonce> annonces = new ArrayList<Annonce>();
		ArrayList<Document> documents = collectionA.find().into(new ArrayList<Document>());
		for(i=0;i<documents.size();i++) {
			annonces.add(new Annonce(documents.get(i).get("point_depart").toString(),documents.get(i).get("point_arrivee").toString(),documents.get(i).get("point_rencontre").toString(),documents.get(i).get("date").toString(),documents.get(i).get("heure_depart").toString(),documents.get(i).get("prix").toString(),documents.get(i).get("fumeur").toString(),documents.get(i).get("nbr_place").toString()));
		}
		return annonces;
	}
	
	public List<Avis> getListAvis(String id){
		int i=0;
		int note = 0;String comment = "";List<Avis> avis = new ArrayList<Avis>();
		ArrayList<Document> documents = collectionI.find().into(new ArrayList<Document>());
		String subdocument = "";
		StringTokenizer st;
		for(i=0;i<documents.size();i++) {
			if(documents.get(i).size()>6 && documents.get(i).get("_id").toString().equals(id)) {
				subdocument = documents.get(i).get("avis").toString();
				System.out.println(subdocument);
				st = new StringTokenizer(subdocument, "=,}");
				System.out.println("Tokens"+st.countTokens());
				st.nextToken();
				while(st.hasMoreTokens()) {
					st.nextToken();st.nextToken();
					st.nextToken();st.nextToken();
					note = Integer.parseInt(st.nextToken());
					st.nextToken();
					comment = st.nextToken();
					st.nextToken();
					System.out.println(note);
					System.out.println(comment);
					avis.add(new Avis(note,comment));
				}
				break;
			}
			System.out.println(avis);
		}
		return avis;
	}
	
	
}
