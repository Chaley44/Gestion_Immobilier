package service;

import java.util.ArrayList;

import java.util.List;
import domaine.Locataire;

public class LocataireG implements IMetier<Locataire, Integer> {

	List<Locataire> listeLocataire = new ArrayList<>();
	
	@Override
	public List<Locataire> liste() {
		// TODO Auto-generated method stub
		return listeLocataire;
	}

	@Override
	public void creer(Locataire o) {
		listeLocataire.add(o);
		
	}

	@Override
	public void supprimer(Locataire o) {
		listeLocataire.remove(o);
		
	}

	@Override
	public void modifier(Locataire o) {
		Locataire o2 = getById(o.getId());
		int index = listeLocataire.indexOf(o2);
		
		listeLocataire.set(index, o);
		
	}

	@Override
	public Locataire getById(Integer id) {
		for(Locataire o : listeLocataire) {
			if(o.getId()== id) {
				return o;
			}
		}
		return null;
	}

	

	
	
}
