package tn.ddops.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.ddops.demo.entities.Action;
import tn.ddops.demo.entities.User;
import tn.ddops.demo.repositories.ActionRepository;
import tn.ddops.demo.repositories.UserRepository;

@Service
public class ActionServiceImpl implements IActionService {

	@Autowired
	ActionRepository actionRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Action addAction(Action act) {
		// TODO Auto-generated method stub
		return actionRepository.save(act);
	}

	@Override
	public List<Action> findActions(long userId) {
		
		List<Action> actions = new ArrayList<>();
		
		User user = userRepository.findById(userId).orElse(null);
		
		actions = actionRepository.findByUserTo(user);
		actions.addAll(actionRepository.findByUserFrom(user));
		return actions;
	}

	@Override
	public List<Action> findRecuPaiement(long userId) {
		
		User user = userRepository.findById(userId).orElse(null);
		
		List<Action> actions = actionRepository.findByUserTo(user);
		return actions;
	}
	

	
}
