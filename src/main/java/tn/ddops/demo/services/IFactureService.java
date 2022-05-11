package tn.ddops.demo.services;

import tn.ddops.demo.entities.Facture;

public interface IFactureService {
	
	public Facture addFacture(Facture fact);

	public Facture findByReference(double reference);
}
