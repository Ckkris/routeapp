package web.controllers;

import java.util.List;

import org.demo.core.entities.Client;
import org.demo.core.entities.Compte;
import org.demo.core.entities.Courant;
import org.demo.core.entities.PEL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import web.models.ApplicationModel;
import web.models.Reponse;

@RestController
public class Controller1 {
	
	@Autowired
	private ApplicationModel application;
	//private List<String> messages;
	
//	@PostConstruct
//	public void init() {
//	// messages d'erreur de l'application
//	messages = application.getMessages();
//	}
	
	

	@RequestMapping(value = "/client", method = RequestMethod.POST)
	public Client saveClient(@RequestBody Client client) {
		return application.saveClient(client);
	}
	
	
	//CLIENTS______________________________________________________________
	
	// liste des clients
	@RequestMapping(value = "/getAllClients", method = RequestMethod.GET)
	public List<Client> getAllClients() {
			return application.getAllClients();
	}
	
	//	@RequestMapping(value = "/compte", method = RequestMethod.POST)
	//	public Compte saveCompte(@RequestBody Compte compte) {
	//		return application.saveCompte(compte);
	//	}
	
	// liste des comptes
	@RequestMapping(value = "/getAllComptes", method = RequestMethod.GET)
	public List<Compte> getAllComptes() {
			return application.getAllComptes();
	}
	
	
	//COURANTS______________________________________________________________
	
	// liste des courants
	@RequestMapping(value = "/getAllCourants", method = RequestMethod.GET)
	public List<Courant> getAllCourants() {
			return application.getAllCourants();
	}
	
	// liste des courants
	@RequestMapping(value = "/getCourantNegatif()", method = RequestMethod.GET)
	public List<Courant> get() {
			return application.getCourantNegatif();
	}
	
	
	// liste des courants d'un client
		@RequestMapping(value = "/getCourantByLogin()/{loginfk}", method = RequestMethod.GET)
		public List<Courant> getcourantbylogin(String loginfk) {
				return application.findByLoginfk(loginfk);
		}
		
		
	@RequestMapping(value = "/courant", method = RequestMethod.POST)
	public Courant saveCourant(@RequestBody Courant courant) {
		return application.saveCourant(courant);
	}
		
	//PELS__________________________________________________________________
	
	// liste des pels
	@RequestMapping(value = "/getAllPels", method = RequestMethod.GET)
	public List<PEL> getAllPels() {
			return application.getAllPels();
	}
	
	
	}
