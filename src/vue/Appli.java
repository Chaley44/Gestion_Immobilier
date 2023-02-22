package vue;

public class Appli {

	public static void main(String[] args) {
		VueBien vueBien = new VueBien();
		VueLocataire vueLocataire = new VueLocataire();
		
		//vueLocataire.listerLocataire();
		
		VueLocation vueLocation = new VueLocation();
		//vueLocation.creerLocation();
		
		VueContratLocation vueContratLocation = new VueContratLocation();
		vueContratLocation.listerContratLocation();
		//vueBien.listerBienByProprietaire();
		VueProprietaire vueProprietaire = new VueProprietaire();
		//vueProprietaire.creerProprietaire();
		//vueProprietaire.supprimerProprietaire();
		
		
		
	}
}
