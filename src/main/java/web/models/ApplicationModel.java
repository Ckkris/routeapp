package web.models;

import java.util.List;

import org.demo.core.entities.Client;
import org.demo.core.entities.Compte;
import org.demo.core.entities.Courant;
import org.demo.core.entities.PEL;
import org.demo.core.metier.IMetier;
import org.demo.core.metier.Metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//l'implémentation de IMetier vient du projet dataBDD2. La dépendence du projet se trouve dans le POM
@Component
public class ApplicationModel implements IMetier{


	@Autowired
	private Metier métier;
	
	//Client___________________________________________
	@Override
	public List<Client> getAllClients() {
		return métier.getAllClients();
	}

	public Client saveClient(Client client) {
		return métier.saveClients(client);
	}
	
	
	//COMPTE______________________________________________
	@Override
	public List<Compte> getAllComptes() {
		return métier.getAllComptes();
	}

	@Override
	public Client getClientById(String Login) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//COURANT______________________________________________

	@Override
	public List<Courant> getAllCourants() {
		return métier.getAllCourants();
	}

	@Override
	public Courant getCourantById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Courant> getCourantNegatif() {
		return métier.getCourantNegatif();
	}
	
	@Override
	public List<Courant> findByLoginfk(String loginfk) {
		return métier.findByLoginfk(loginfk);
	}

	//PEL____________________________________________________
	
	@Override
	public List<PEL> getAllPels() {
		// TODO Auto-generated method stub
		return métier.getAllPels();
	}
	

	@Override
	public List<PEL> getPelNegatif() {
		// TODO Auto-generated method stub
		return null;
	}

	

//	public Compte saveCompte(Compte compte) {
//		return métier.saveComptes(compte);
//	}
}
