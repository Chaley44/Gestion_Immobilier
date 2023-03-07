package service;

import java.util.ArrayList;
import java.util.List;

import dao.DaoBien;
import domaine.Bien;

public class BienG implements IMetier<Bien, Integer>{

	List<Bien> listeBien = new ArrayList<>();
	private DaoBien bdBien = new DaoBien();
	@Override
	public List<Bien> liste() {
		// TODO Auto-generated method stub
		return bdBien.listerBien();
	}

	@Override
	public void creer(Bien o) {
		bdBien.creerBien(o);
		
	}

	@Override
	public void supprimer(Bien o) {
		bdBien.supprimerBien(o);
	}

	@Override
	public void modifier(Bien o) {
		bdBien.modifierBien(o);
		
	}

	@Override
	public Bien getById(Integer id) {
		for(Bien o : bdBien.listerBien()) {
			if(o.getId().equals(id)) {
				return o;
			}
		}
		return null;
	}
	
	public List<Bien> listerBienByProprietaire(Integer id) {
		List<Bien> listBienByPropriete = new ArrayList<>(); 
		for(Bien o : bdBien.listerBien()) {
			if(o.getProprietaire().getId().equals(id)) {
				listBienByPropriete.add(o);
				return listBienByPropriete;
			}
		}
		return null;
	}

}
