package service;

import java.util.ArrayList;
import java.util.List;

import domaine.Location;

public class LocationG implements IMetier<Location, Integer>{

	List<Location> listeLocation = new ArrayList<>();
	
	@Override
	public List<Location> liste() {
		// TODO Auto-generated method stub
		return listeLocation;
	}

	@Override
	public void creer(Location o) {
		listeLocation.add(o);
		
	}

	@Override
	public void supprimer(Location o) {
		listeLocation.remove(o);
		
	}

	@Override
	public void modifier(Location o) {
		Location o2 = getById(o.getId());
		int index = listeLocation.indexOf(o2);
		
		listeLocation.set(index, o);
		
	}

	@Override
	public Location getById(Integer id) {
		for(Location o : listeLocation) {
			if(o.getId()== id) {
				return o;
			}
		}
		return null;
	}

}
