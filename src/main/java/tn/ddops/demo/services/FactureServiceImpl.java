package tn.ddops.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.ddops.demo.entities.Facture;
import tn.ddops.demo.repositories.FactureRepository;

@Service
public class FactureServiceImpl implements IFactureService{

	@Autowired
	FactureRepository factureRepository;

	@Override
	public Facture addFacture(Facture fact) {
		// TODO Auto-generated method stub
		return factureRepository.save(fact);
	}

	@Override
	public Facture findByReference(double reference) {
		// TODO Auto-generated method stub
		return factureRepository.findByReference(reference);
	}
	
}
