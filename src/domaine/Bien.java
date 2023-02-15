package domaine;

public class Bien {

	private int id;
	private String adresse;
	private String ville;
	private int nbrPiece;
	private float surface;
	private String type;
	
	public Bien () {}

	public Bien(int id, String adresse, String ville, int nbrPiece, float surface, String type) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.ville = ville;
		this.nbrPiece = nbrPiece;
		this.surface = surface;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	
	
	
}
