package domaine;

import java.util.List;

public class Locataire extends Personne {

	private List<Location> listLocation;
	public Locataire() {
		super();
		
	}

	public Locataire(int id, String numCin, String nom, String prenom,
			int age, String numTel, String adressePersonne) {
		super(id, numCin, nom, prenom, age, numTel, adressePersonne);
		
	}

	public List<Location> getListLocation() {
		return listLocation;
	}

	public void setListLocation(List<Location> listLocation) {
		this.listLocation = listLocation;
	}
	

	
}
