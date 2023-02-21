package domaine;

import java.time.LocalDate;

public class ContratLocation {

	private Integer id;
	private String dureeContrat;
	private LocalDate dateContrat;
	private String renouvellement;
	private Location location;
	
	public ContratLocation(){}

	public ContratLocation(Integer id, String dureeContrat, LocalDate dateContrat, String renouvellement) {
		super();
		this.id = id;
		this.dureeContrat = dureeContrat;
		this.dateContrat = dateContrat;
		this.renouvellement = renouvellement;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDureeContrat() {
		return dureeContrat;
	}

	public void setDureeContrat(String dureeContrat) {
		this.dureeContrat = dureeContrat;
	}

	public LocalDate getDateContrat() {
		return dateContrat;
	}

	public void setDateContrat(LocalDate dateContrat) {
		this.dateContrat = dateContrat;
	}

	public String getRenouvellement() {
		return renouvellement;
	}

	public void setRenouvellement(String renouvellement) {
		this.renouvellement = renouvellement;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	
}
