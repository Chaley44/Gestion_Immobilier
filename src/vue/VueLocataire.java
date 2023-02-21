package vue;

import java.util.Scanner;

import domaine.Locataire;
import service.IMetier;
import service.LocataireG;

public class VueLocataire {

public IMetier<Locataire, Integer> impl = new LocataireG();
	
	public  VueLocataire() {
		
	}
	
	public void listerLocataire() {
		System.out.println("Liste des Locataires");
		System.out.println("===================================");
		for(Locataire locataire : impl.liste()) {
			System.out.println("id : " + locataire.getId());
			System.out.println("Type : " + locataire.getNumCin());
			System.out.println("Adresse : " + locataire.getAdressePersonne());
			System.out.println("Ville: " + locataire.getNom());
			System.out.println("Nombre de piece : " + locataire.getPrenom());
			System.out.println("Surface : " + locataire.getAge());
			System.out.println("Type : " + locataire.getNumTel());
			System.out.println("-----------------------------------");
		}
	}
	
	public void creerLocataire() {
		Locataire locataire = new Locataire();
		Scanner scanner = new Scanner(System.in);
		String input;
		
		System.out.print("Id : ");
		input = scanner.nextLine();
		locataire.setId(Integer.parseInt(input));
		
		System.out.print("Numero cin : ");
		input = scanner.nextLine();
		locataire.setNumCin(input);
		
		System.out.print("Adresse : ");
		input = scanner.nextLine();
		locataire.setAdressePersonne(input);
		
		System.out.print("Nom : ");
		input = scanner.nextLine();
		locataire.setNom(input);
		
		System.out.print("Prenom : ");
		input = scanner.nextLine();
		locataire.setPrenom(input);
		
		System.out.print("Age : ");
		input = scanner.nextLine();
		locataire.setAge(Integer.parseInt(input));
		
		System.out.print("Numero tel : ");
		input = scanner.nextLine();
		locataire.setNumTel(input);
		
		impl.creer(locataire);
		listerLocataire();
		
		
	}
	
	public void rechercherLocataire() {
		Locataire locataire = new Locataire();
		Scanner scanner = new Scanner(System.in);
		String input;
		System.out.print("Id : ");
		input = scanner.nextLine();
		locataire= impl.getById(Integer.parseInt(input));
		
		
		if(impl.liste().contains(locataire)) {
			System.out.println("id : " + locataire.getId());
			System.out.println("Type : " + locataire.getNumCin());
			System.out.println("Adresse : " + locataire.getAdressePersonne());
			System.out.println("Ville: " + locataire.getNom());
			System.out.println("Nombre de piece : " + locataire.getPrenom());
			System.out.println("Surface : " + locataire.getAge());
			System.out.println("Type : " + locataire.getNumTel());
			System.out.println("-----------------------------------");
			
			
		}else {
			System.out.println("Le locataire n'existe pas !!");
		}
	}
	
	public void supprimerLocataire() {
		Locataire locataire ;
		Scanner scanner = new Scanner(System.in);
		String input;
		System.out.print("Id : ");
		input = scanner.nextLine();
		locataire= impl.getById(Integer.parseInt(input));
		impl.supprimer(locataire);
		
		listerLocataire();
	}
	
	public void modifierLocataire() {
		Locataire locataire = new Locataire();
		Scanner scanner = new Scanner(System.in);
		String input;
		System.out.print("Entrer id : ");
		input = scanner.nextLine();
		locataire = impl.getById(Integer.parseInt(input));
		
		System.out.print("Numero cin : ");
		input = scanner.nextLine();
		locataire.setNumCin(input);
		
		System.out.print("Adresse : ");
		input = scanner.nextLine();
		locataire.setAdressePersonne(input);
		
		System.out.print("Nom : ");
		input = scanner.nextLine();
		locataire.setNom(input);
		
		System.out.print("Prenom : ");
		input = scanner.nextLine();
		locataire.setPrenom(input);
		
		System.out.print("Age : ");
		input = scanner.nextLine();
		locataire.setAge(Integer.parseInt(input));
		
		System.out.print("Numero tel : ");
		input = scanner.nextLine();
		locataire.setNumTel(input);
		
		impl.modifier(locataire);
		listerLocataire();
		
	}
}
