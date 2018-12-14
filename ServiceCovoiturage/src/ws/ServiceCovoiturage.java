package ws;



import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class ServiceCovoiturage {

	@WebMethod
	public void InsertInternaute(@WebParam(name="nom")String nom,@WebParam(name="prenom")String prenom,@WebParam(name="fonction")String fonction,@WebParam(name="date")String date,@WebParam(name="tel")String tel,@WebParam(name="sexe")String sexe,@WebParam(name="login")String login,@WebParam(name="mdp")String mdp) {
		MongoDBAdapter mongoDBAdapter = new MongoDBAdapter();
		mongoDBAdapter.InsertInternaute(nom, prenom, fonction, date, tel, sexe, login, mdp);
	}
	
	@WebMethod
	public void InsertAnnonce(@WebParam(name="id")String id_chauffeur,@WebParam(name="dep")String depart,@WebParam(name="des")String destination,@WebParam(name="ptr")String pt_rencontre,@WebParam(name="d")String date,@WebParam(name="h")String heure,@WebParam(name="p")String prix,@WebParam(name="f")String fumeur,@WebParam(name="nbp")String nbr_place,@WebParam(name="idv")String id_voiture) {
		MongoDBAdapter mongoDBAdapter = new MongoDBAdapter();
		mongoDBAdapter.InsertAnnonce(id_chauffeur,depart,destination,pt_rencontre,date,heure,prix,fumeur,nbr_place,id_voiture) ;
	}
	
	@WebMethod
	public List<Annonce> getListAnnonces(){
		MongoDBAdapter mongoDBAdapter = new MongoDBAdapter();
		return mongoDBAdapter.getListAnnonces();
	}
	
	@WebMethod
	public List<Avis> getAvis(@WebParam(name="id") String id){
		MongoDBAdapter mongoDBAdapter = new MongoDBAdapter();
		return mongoDBAdapter.getListAvis(id) ;
	}
	
}
