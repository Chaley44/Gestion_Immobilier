package service;

import java.util.ArrayList;
import java.util.List;

import dao.DaoLocation;
import domaine.Location;


public class LocationG implements IMetier<Location, Integer>{

	List<Location> listeLocation = new ArrayList<>();
	private DaoLocation bdLocation = new DaoLocation();
	
	@Override
	public List<Location> liste() {
		// TODO Auto-generated method stub
		return bdLocation.listerLocation();
	}

	@Override
	public void creer(Location o) {
		bdLocation.creerLocation(o);
		
	}

	@Override
	public void supprimer(Location o) {
		bdLocation.supprimerLocation(o);
		
	}

	@Override
	public void modifier(Location o) {
		bdLocation.modifierLocation(o);
		
	}

	@Override
	public Location getById(Integer id) {
		for(Location o: bdLocation.listerLocation()) {
			if(o.getId().equals(id)) {
				return o;
			}
		}
		
		return null;
	}

}
