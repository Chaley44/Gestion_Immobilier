package domaine;


import java.time.LocalDate;
import java.util.Date;

public class Location  {

	private Integer id;
	private float prix;
	//private Date dateDebut;
	private LocalDate dateDebut;
	private Locataire locataire;
	private Bien bien;
	
	public Location() {}

	public Location(Integer id, float prix, LocalDate dateDebut) {
		super();
		this.id = id;
		this.prix = prix;
		this.dateDebut = dateDebut;
	}
	
//	public Location(Integer id, float prix, Date dateDebut) {
//		super();
//		this.id = id;
//		this.prix = prix;
//		this.dateDebut = dateDebut;
//	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
//
//	public Date getDateDebut() {
//		return dateDebut;
//	}
//
//	public void setDateDebut(Date dateDebut) {
//		this.dateDebut = dateDebut;
//	}

	public Locataire getLocataire() {
		return locataire;
	}

	public void setLocataire(Locataire locataire) {
		this.locataire = locataire;
	}

	public Bien getBien() {
		return bien;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}
	
	
	
	
	
}
