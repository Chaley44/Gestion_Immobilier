package service;

import java.util.ArrayList;

import java.util.List;

import dao.DaoLocataire;
import domaine.Locataire;

public class LocataireG implements IMetier<Locataire, Integer> {

	
	private DaoLocataire bdLocataire = new DaoLocataire();
	
	@Override
	public List<Locataire> liste() {
		// TODO Auto-generated method stub
		return bdLocataire.listerLocataire();
	}

	@Override
	public void creer(Locataire o) {
		bdLocataire.creerLocataire(o);
		
	}

	@Override
	public void supprimer(Locataire o) {
		bdLocataire.supprimerLocataire(o);
		
	}

	@Override
	public void modifier(Locataire o) {
		bdLocataire.modifierLocataire(o);
		
	}

	@Override
	public Locataire getById(Integer id) {
		for(Locataire o : bdLocataire.listerLocataire()) {
			if(o.getId().equals(id)) {
				return o;
			}
		}
		return null;
	}

	

	
	
}
