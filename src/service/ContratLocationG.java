package service;

import java.util.ArrayList;
import java.util.List;

import dao.DaoContratLocation;
import domaine.ContratLocation;

public class ContratLocationG implements IMetier<ContratLocation, Integer> {

	List<ContratLocation> listeContrat = new ArrayList<>();
	private DaoContratLocation bdContrat = new DaoContratLocation();
	
	@Override
	public List<ContratLocation> liste() {
		// TODO Auto-generated method stub
		return bdContrat.listerContratLocation();
	}

	@Override
	public void creer(ContratLocation o) {
		bdContrat.creerContratLocation(o);
		
	}

	@Override
	public void supprimer(ContratLocation o) {
		bdContrat.supprimerContratLocation(o);
		
	}

	@Override
	public void modifier(ContratLocation o) {
		bdContrat.modifierContratLocation(o);
		
	}

	@Override
	public ContratLocation getById(Integer id) {
		for(ContratLocation o : bdContrat.listerContratLocation()) {
			if(o.getId().equals(id)) {
				return o;
			}
		}
		return null;
	}

}
