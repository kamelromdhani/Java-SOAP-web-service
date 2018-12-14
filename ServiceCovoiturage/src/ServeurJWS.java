import javax.xml.ws.Endpoint;

import ws.ServiceCovoiturage;
public class ServeurJWS {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8585/", new ServiceCovoiturage());


	}

}
