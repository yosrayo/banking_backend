package tn.ddops.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.ddops.demo.entities.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String userName);
	public User findByIdPaiement(double idPaiement);

}
