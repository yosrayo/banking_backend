package tn.ddops.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.ddops.demo.entities.Action;
import tn.ddops.demo.entities.Facture;
import tn.ddops.demo.entities.Organization;
import tn.ddops.demo.entities.User;
import tn.ddops.demo.repositories.FactureRepository;
import tn.ddops.demo.repositories.UserRepository;
import tn.ddops.demo.services.IActionService;
import tn.ddops.demo.services.IFactureService;


@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping("/action")
public class ActionController {


	@Autowired
	IFactureService factureService;

	@Autowired
	IActionService actionService;

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	FactureRepository factureRepo;
	
	@GetMapping("findAll/{userId}")
	@ResponseBody
	public List<Action> findActions(@PathVariable (value="userId") Long userId){
		
		System.out.println("List of actions found");
		return actionService.findActions(userId);
	}
	
	
	
	
	@GetMapping("findRecuPaiement/{userId}")
	@ResponseBody
	public List<Action> findRecuPaiement(@PathVariable (value="userId") Long userId){
		
		System.out.println("List of actions found");
		return actionService.findRecuPaiement(userId);
	}
	
	
	
	@PostMapping("/addAction/{userFrom}/{userTo}")
	@ResponseBody
	public Action addAction(@PathVariable (value = "userFrom") Long userFrom, @PathVariable (value = "userTo") Long userTo,@RequestBody Action action) {
		
		action.setUserFrom(userRepo.findById(userFrom).get());
		action.setUserTo(userRepo.findById(userTo).get());
		System.out.println("action done succesfully !");
		return actionService.addAction(action);
	}
	
	@PostMapping("/virementByIds/{userFrom}/{userTo}")
	@ResponseBody
	public Action sendMoney(@PathVariable (value = "userFrom") Long userFrom, @PathVariable (value = "userTo") Long userTo,@RequestBody Action action) {
		
		action.setUserFrom(userRepo.findById(userFrom).get());
		action.setUserTo(userRepo.findById(userTo).get());
		User userSending =  userRepo.findById(userFrom).orElse(null);
		
		if(userSending.getSolde()-action.getAmount()<0) {
			//because user solde will be less then 0
			System.out.println("solde insuffisant");
			return null;
		}
		
		User userRecieving = userRepo.findById(userTo).orElse(null);
		
		userSending.setSolde(userSending.getSolde() - action.getAmount());
		
		userRecieving.setSolde(userRecieving.getSolde() + action.getAmount());
		
		System.out.println("action of type "+String.valueOf(action.getActionType())+" done succesfully !");
		return actionService.addAction(action);
	}
	
	@PostMapping("/virement/{userFrom}/{idPaiementUserTo}")
	@ResponseBody
	public Action sendMoneyByIdPaiement(@PathVariable (value = "userFrom") Long userFrom, @PathVariable (value = "idPaiementUserTo") double idPaiementUserTo,@RequestBody Action action) {
		
		action.setUserFrom(userRepo.findById(userFrom).get());
		action.setUserTo(userRepo.findByIdPaiement(idPaiementUserTo));
		User userSending =  userRepo.findById(userFrom).orElse(null);
		
		if(userSending.getSolde()-action.getAmount()<0) {
			//because user solde will be less then 0
			System.out.println("solde insuffisant");
			return null;
		}
		
		User userRecieving = userRepo.findByIdPaiement(idPaiementUserTo);
		
		userSending.setSolde(userSending.getSolde() - action.getAmount());
		
		userRecieving.setSolde(userRecieving.getSolde() + action.getAmount());
		
		System.out.println("action of type "+String.valueOf(action.getActionType())+" done succesfully !");
		return actionService.addAction(action);
	}
	

	
	@PostMapping("/payFacture/{userFrom}/{factureReference}")
	@ResponseBody
	public Action payFacture(@PathVariable (value = "userFrom") Long userFrom, @PathVariable (value = "factureReference") Long factureReference,@RequestBody Action action) {
		
		Facture f = factureService.findByReference(factureReference);
		if (f.isPayed() == true || f == null || f.getUserFrom().getIdUser() != userFrom) {
			// if facture exists but not for this user, it will be considered as doesn\'t exist
			System.out.println("either this facture is already payed or it doesn\'t exist");
			return null;
		}
		else {
			
			Organization org = f.getOrganizationTo();
			User user = userRepo.findById(userFrom).orElse(null);
			if(user.getSolde()-f.getAmount()<0) {
				//because user solde will be less then 0
				System.out.println("solde insuffisant");
				return null;
			}
			org.setSolde(org.getSolde()+f.getAmount());
			user.setSolde(user.getSolde()-f.getAmount());
			action.setAmount(f.getAmount());
			action.setUserFrom(userRepo.findById(userFrom).get());
			action.setOrganizationTo(f.getOrganizationTo());
			f.setPayed(true);
			return actionService.addAction(action);
		}
	}
	
}