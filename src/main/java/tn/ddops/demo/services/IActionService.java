package tn.ddops.demo.services;

import java.util.List;

import tn.ddops.demo.entities.Action;

public interface IActionService {
	
	public Action addAction(Action act);
	
	public List<Action> findActions(long userId);
	
	public List<Action> findRecuPaiement(long userId);

}
