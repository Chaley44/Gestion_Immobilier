package service;

import java.util.ArrayList;
import java.util.List;

import dao.DaoProprietaire;
import domaine.Locataire;
import domaine.Proprietaire;

public class ProprietaireG implements IMetier<Proprietaire, Integer> {

	
	private  DaoProprietaire bdProprietaire = new DaoProprietaire();

	@Override
	public List<Proprietaire> liste() {
		
		return bdProprietaire.listerProprietaire();
	}

	@Override
	public void creer(Proprietaire o) {
		bdProprietaire.creerProprietaire(o);
		
	}

	@Override
	public void supprimer(Proprietaire o) {
		bdProprietaire.supprimerProprietaire(o);
		
	}

	@Override
	public void modifier(Proprietaire o) {
		bdProprietaire.modifierProprietaire(o);
		
	}

	@Override
	public Proprietaire getById(Integer id) {
		for(Proprietaire o : bdProprietaire.listerProprietaire()) {
			if(o.getId().equals(id)) {
				return o;
			}
		}
		return null;
	}
	

}
