package domaine;

import java.util.List;

public class Proprietaire extends Personne{

	
	private List<Bien> listeBien;
	
	public Proprietaire() {
		
	}

	public Proprietaire(int id, String numCin, String nom, 
			String prenom, int age, String numTel,
			String adressePersonne) {
		super(id, numCin, nom, prenom, age, numTel, adressePersonne);
		
	}

	public List<Bien> getListeBien() {
		return listeBien;
	}

	public void setListeBien(List<Bien> listeBien) {
		this.listeBien = listeBien;
	}
	
	

	
	
}
