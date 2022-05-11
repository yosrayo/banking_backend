package tn.ddops.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.ddops.demo.entities.Action;
import tn.ddops.demo.entities.User;

@Repository
public interface ActionRepository extends JpaRepository<Action,Long>{

	List<Action> findByUserTo(User user);

	List<Action> findByUserFrom(User user);

}
