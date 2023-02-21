package service;

import java.util.ArrayList;
import java.util.List;

import domaine.Locataire;
import domaine.Proprietaire;

public class ProprietaireG implements IMetier<Proprietaire, Integer> {

	List<Proprietaire> listeProprietaire = new ArrayList<>();

	@Override
	public List<Proprietaire> liste() {
		// TODO Auto-generated method stub
		return listeProprietaire;
	}

	@Override
	public void creer(Proprietaire o) {
		listeProprietaire.add(o);
		
	}

	@Override
	public void supprimer(Proprietaire o) {
		listeProprietaire.remove(o);
		
	}

	@Override
	public void modifier(Proprietaire o) {
		Proprietaire o2 = getById(o.getId());
		int index = listeProprietaire.indexOf(o2);
		
		listeProprietaire.set(index, o);
		
	}

	@Override
	public Proprietaire getById(Integer id) {
		for(Proprietaire o : listeProprietaire) {
			if(o.getId().equals(id)) {
				return o;
			}
		}
		return null;
	}
	

}
