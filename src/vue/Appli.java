package vue;

import java.util.Scanner;

public class Appli {

	public static void main(String[] args) {
		menuPrincipal();
		

	}

	public static void menuPrincipal() {
		Scanner scanner = new Scanner(System.in);
		int choix;
		
		do {
			System.out.println("==========================");
			System.out.println(" Menu Principal");
			System.out.println("1 : Menu Proprietaire");
			System.out.println("2 : Menu Locataire");
			System.out.println("3 : Menu Bien");
			System.out.println("4 : Menu Location");
			System.out.println("5 : Menu Contrat Location");
			System.out.println("6 : Quitter");
			System.out.println();
			
			System.out.print("Votre choix ");
			choix = scanner.nextInt();
			
			switch (choix) {
				case 1: menuProprietaire();			
				break;
				
				case 2: menuLocataire();
				break;
				
				case 3 : menuBien();
				break;
				
				case 4 : menuLocation();
				break;
				
				case 5 : menuContratLocation();
				break;
				
				case 6 : System.out.println("Au revoir");
				break;
				
				default: System.out.println("choix invalide");
				break; 
			}
				
		}while(choix != 6 );
	}
			
	
	public static void menuBien() {
		VueBien vueBien = new VueBien();
		Scanner scanner = new Scanner(System.in);
		int choix;
		
		do {
		System.out.println("==========================");
		System.out.println(" Menu Bien");
		System.out.println("0 : Menu principal");
		System.out.println("1 : liste des Bien");
		System.out.println("2 : creer un Bien");
		System.out.println("3 : modifier un Bien");
		System.out.println("4 : rechercher un Bien");
		System.out.println("5 : supprimer un Bien");
		System.out.println();
		
		System.out.print("votre choix ");
		choix = scanner.nextInt();
		
		switch(choix) {
		case 0: menuPrincipal();
		break;
		case 1 : vueBien.listerBien();
			break;
			
		case 2 : vueBien.listerBienByProprietaire();
		break;
		case 3 : vueBien.creerBien();
			break;			
		case 4 : vueBien.modifierBien();
			break;
		case 5 : vueBien.rechercherBien();
			break;
		case 6 : vueBien.supprimerBien();
			break;
		case 7 : System.out.println("Au revoir");
		break;
		default : System.out.println("Choix invalide");
			break;
		
		}
	}while(choix!=6);
	}
	public static void menuProprietaire() {
		Scanner scanner = new Scanner(System.in);
		VueProprietaire vueProprietaire = new VueProprietaire();

		int choix;
		
		do {
			System.out.println("==========================");
			System.out.println(" Menu Proprietaire");
			System.out.println("0 : Menu principal");
			System.out.println("1 : liste des proprietaires");
			System.out.println("2 : creer un proprietaire");
			System.out.println("3 : modifier un proprietaire");
			System.out.println("4 : rechercher un proprietaire");
			System.out.println("5 : supprimer un proprietaire");
			System.out.println();
			
			System.out.print("votre choix ");
			choix = scanner.nextInt();
			
			switch(choix) {
			case 0: menuPrincipal();
			break;
			case 1 : vueProprietaire.listerProprietaire();
				break;
			case 2 : vueProprietaire.creerProprietaire();
				break;			
			case 3 : vueProprietaire.modifierProprietaire();
				break;
			case 4 : vueProprietaire.rechercherProprietaire();
				break;
			case 5 : vueProprietaire.supprimerProprietaire();
				break;
			case 6 : System.out.println("Au revoir");
			break;
			default : System.out.println("Choix invalide");
				break;
			
			}
		}while(choix!=6);
	}
	
	
	
	
	public static void menuLocataire() {
		Scanner scanner = new Scanner(System.in);
		VueLocataire vueLocataire = new VueLocataire();

		int choix;
		
		do {
			System.out.println("==========================");
			System.out.println(" Menu Locataires");
			System.out.println("0 : Menu Principal");
			System.out.println("1 : liste des locataires");
			System.out.println("2 : creer un locataire");
			System.out.println("3 : modifier un locataire");
			System.out.println("4 : rechercher un locataire");
			System.out.println("5 : supprimer un locataire");
			System.out.println();
			
			System.out.print("votre choix ");
			choix = scanner.nextInt();
			
			switch(choix) {
			case 0: menuPrincipal();
			break;
			case 1 : vueLocataire.listerLocataire();
				break;
			case 2 : vueLocataire.creerLocataire();
				break;			
			case 3 : vueLocataire.modifierLocataire();
				break;
			case 4 : vueLocataire.rechercherLocataire();
				break;
			case 5 : vueLocataire.supprimerLocataire();
				break;
			case 6 : System.out.println("Au revoir");
			break;
			default : System.out.println("Choix invalide");
				break;
			
			}
		}while(choix!=6);
	}
	
	
	public static void menuContratLocation() {
		Scanner scanner = new Scanner(System.in);
		VueContratLocation vueContratLocation = new VueContratLocation();

		int choix;
		
		do {
			System.out.println("==========================");
			System.out.println(" Menu Location");
			System.out.println("0 : Menu principal");
			System.out.println("1 : liste des Contrat Locations");
			System.out.println("2 : creer un Contrat Location");
			System.out.println("3 : modifier un Contrat Location");
			System.out.println("4 : rechercher un Contrat Location");
			System.out.println("5 : supprimer un Contrat Location");
			System.out.println("6 : Quitter");
			System.out.println();
			
			System.out.print("votre choix ");
			choix = scanner.nextInt();
			
			switch(choix) {
			case 0: menuPrincipal();
			break;
			case 1 : vueContratLocation.listerContratLocation();
				break;
			case 2 : vueContratLocation.creerContratLocation();
				break;			
			case 3 : vueContratLocation.modifierLocataire();
				break;
			case 4 : vueContratLocation.rechercherLocation();
				break;
			case 5 : vueContratLocation.supprimerLocation();
				break;
			case 6 : System.out.println("Au revoir");
			break;
			default : System.out.println("Choix invalide");
				break;
			
			}
		}while(choix!=6);
	}
	
	public static void menuLocation() {
		Scanner scanner = new Scanner(System.in);
		VueLocation vueLocation = new VueLocation();

		int choix;
		
		do {
			System.out.println("==========================");
			System.out.println(" Menu Location");
			System.out.println("0 : Menu principal");
			System.out.println("1 : liste des locations");
			System.out.println("2 : creer un location");
			System.out.println("3 : modifier un location");
			System.out.println("4 : rechercher un location");
			System.out.println("5 : supprimer un location");
			System.out.println("6 : Quitter");
			System.out.println();
			
			System.out.print("votre choix ");
			choix = scanner.nextInt();
			
			switch(choix) {
			case 0: menuPrincipal();
			break;
			case 1 : vueLocation.listerLocation();
				break;
			case 2 : vueLocation.creerLocation();
				break;			
			case 3 : vueLocation.modifierLocataire();
				break;
			case 4 : vueLocation.rechercherLocation();
				break;
			case 5 : vueLocation.supprimerLocation();
				break;
			case 6 : System.out.println("Au revoir");
			break;
			default : System.out.println("Choix invalide");
				break;
			
			}
		}while(choix!=6);
	}
	
	

	
}


