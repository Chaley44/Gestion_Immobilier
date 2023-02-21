package service;

import java.util.ArrayList;
import java.util.List;

import domaine.Bien;

public class BienG implements IMetier<Bien, Integer>{

	List<Bien> listeBien = new ArrayList<>();
	
	@Override
	public List<Bien> liste() {
		// TODO Auto-generated method stub
		return listeBien;
	}

	@Override
	public void creer(Bien o) {
		listeBien.add(o);
		
	}

	@Override
	public void supprimer(Bien o) {
		listeBien.remove(o);
		
	}

	@Override
	public void modifier(Bien o) {
		Bien o2 = getById(o.getId());
		int index = listeBien.indexOf(o2);
		
		listeBien.set(index, o);
		
	}

	@Override
	public Bien getById(Integer id) {
		for(Bien o : listeBien) {
			if(o.getId().equals(id)) {
				return o;
			}
		}
		return null;
	}
	
	public List<Bien> listerBienByProprietaire(Integer id) {
		List<Bien> listBienByPropriete = new ArrayList<>(); 
		for(Bien o : listeBien) {
			if(o.getProprietaire().getId().equals(id)) {
				listBienByPropriete.add(o);
				return listBienByPropriete;
			}
		}
		return null;
	}

}
