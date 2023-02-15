package domaine;

import java.time.LocalDate;

public class Location  {

	private int id;
	private float prix;
	private LocalDate dateDebut;
	
	public Location() {}

	public Location(int id, float prix, LocalDate dateDebut) {
		super();
		this.id = id;
		this.prix = prix;
		this.dateDebut = dateDebut;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	
	
	
	
	
}
