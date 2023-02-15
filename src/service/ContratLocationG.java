package service;

import java.util.ArrayList;
import java.util.List;

import domaine.ContratLocation;

public class ContratLocationG implements IMetier<ContratLocation, Integer> {

	List<ContratLocation> listeContrat = new ArrayList<>();
	
	@Override
	public List<ContratLocation> liste() {
		// TODO Auto-generated method stub
		return listeContrat;
	}

	@Override
	public void creer(ContratLocation o) {
		listeContrat.add(o);
		
	}

	@Override
	public void supprimer(ContratLocation o) {
		listeContrat.remove(o);
		
	}

	@Override
	public void modifier(ContratLocation o) {
		ContratLocation o2 = getById(o.getId());
		int index = listeContrat.indexOf(o2);
		
		listeContrat.set(index, o);
		
	}

	@Override
	public ContratLocation getById(Integer id) {
		for(ContratLocation o : listeContrat) {
			if(o.getId()== id) {
				return o;
			}
		}
		return null;
	}

}
