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
import tn.ddops.demo.repositories.OrganizationRepository;
import tn.ddops.demo.repositories.UserRepository;
import tn.ddops.demo.services.IFactureService;

@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping("/facture")
public class FactureController {

	

	@Autowired
	IFactureService factureService;

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	OrganizationRepository organizationRepo;
	
	@PostMapping("/addFacture/{userFrom}/{organizationTo}")
	@ResponseBody
	public Facture addFacture(@PathVariable (value = "userFrom") Long userFrom, @PathVariable (value = "organizationTo") Long organizationTo,@RequestBody Facture facture) {
		
		facture.setUserFrom(userRepo.findById(userFrom).get());
		facture.setOrganizationTo(organizationRepo.findById(organizationTo).get());
		factureService.addFacture(facture);
		facture.setReference(facture.getIdFacture()+Math.pow(10,9));
		System.out.println("facture added succesfully !");
		return factureService.addFacture(facture);
	}
	
	@GetMapping("findAll/{reference}")
	@ResponseBody
	public Facture findFacture(@PathVariable (value="reference") Long reference){
		System.out.println("List of actions found");
		return factureService.findByReference(reference);
	}
	

}
