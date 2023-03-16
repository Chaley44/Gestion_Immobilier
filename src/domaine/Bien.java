package domaine;

public class Bien {

	private Integer id;
	private String adresse;
	private String ville;
	private int nbrPiece;
	private float surface;
	private String type;
	private Proprietaire proprietaire;
	private EtatBien etatBien;
	
	public Bien(){}

	public Bien(Integer id, String adresse, String ville, int nbrPiece, 
			float surface, String type, Proprietaire proprietaire) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.ville = ville;
		this.nbrPiece = nbrPiece;
		this.surface = surface;
		this.type = type;
		this.proprietaire = proprietaire;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getNbrPiece() {
		return nbrPiece;
	}

	public void setNbrPiece(int nbrPiece) {
		this.nbrPiece = nbrPiece;
	}

	public float getSurface() {
		return surface;
	}

	public void setSurface(float surface) {
		this.surface = surface;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	public EtatBien getEtatBien() {
		return etatBien;
	}

	public void setEtatBien(EtatBien etatBien) {
		this.etatBien = etatBien;
	}
	
	
	
	
}
