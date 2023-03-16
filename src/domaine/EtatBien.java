package domaine;

public enum EtatBien {

	NEUF("Neuf"),TRES_BON_ETAT("Tres bon etat"), BON_ETAT("Bon etat"),
	A_RENOVER("A renover");
	
	private String etat;
	
	private EtatBien(String etat){
		this.etat=etat;
	}

	public String getEtat() {
		return etat;
	}
	
	
}
