package domaine;

public abstract class Personne {

	private Integer id;
	private String numCin;
	private String nom;
	private String prenom;
	private int age;
	private String numTel;
	private String adressePersonne;
	
	
	public Personne() {}


	public Personne(Integer id, String numCin, String nom, String prenom, int age, String numTel, String adressePersonne) {
		super();
		this.id = id;
		this.numCin = numCin;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.numTel = numTel;
		this.adressePersonne = adressePersonne;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNumCin() {
		return numCin;
	}


	public void setNumCin(String numCin) {
		this.numCin = numCin;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getNumTel() {
		return numTel;
	}


	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}


	public String getAdressePersonne() {
		return adressePersonne;
	}


	public void setAdressePersonne(String adressePersonne) {
		this.adressePersonne = adressePersonne;
	};
	
}
