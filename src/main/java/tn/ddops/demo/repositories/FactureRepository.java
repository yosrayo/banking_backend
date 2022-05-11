package tn.ddops.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.ddops.demo.entities.Facture;

@Repository
public interface FactureRepository  extends JpaRepository<Facture,Long>{

	Facture findByReference(double reference);

}
