package vue;

import java.util.Scanner;

import domaine.Bien;
import domaine.Proprietaire;
import service.IMetier;
import service.ProprietaireG;

public class VueProprietaire {

public IMetier<Proprietaire, Integer> impl = new ProprietaireG();
	
	public VueProprietaire() {
		Proprietaire proprietaire1 = new Proprietaire(1, "1234","chaley", "fabrice",
				21, "774032534", "Ouakam");
		Proprietaire proprietaire2 = new Proprietaire(2, "4321","charles", "brice",
				30, "774052638", "Amadie");
		impl.creer(proprietaire1);
		impl.creer(proprietaire2);
	}
	
	public void listerProprietaire() {
		
		System.out.println("Liste des proprietaires");
		System.out.println("===================================");
		for(Proprietaire proprietaire : impl.liste()) {
			System.out.println("ID : " + proprietaire.getId());
			System.out.println("NIN : " + proprietaire.getNumCin());
			System.out.println("Adresse : " + proprietaire.getAdressePersonne());
			System.out.println("Nom: " + proprietaire.getNom());
			System.out.println("Prenom : " + proprietaire.getPrenom());
			System.out.println("Age : " + proprietaire.getAge());
			System.out.println("Telephone : " + proprietaire.getNumTel());
			System.out.println("-----------------------------------");
		}
	}
	
	public void creerProprietaire() {
		Proprietaire proprietaire = new Proprietaire();
		Scanner scanner = new Scanner(System.in);
		String input;
		
		System.out.print("ID : ");
		input = scanner.nextLine();
		proprietaire.setId(Integer.parseInt(input));
		
		System.out.print("NIN : ");
		input = scanner.nextLine();
		proprietaire.setNumCin(input);
		
		System.out.print("Adresse : ");
		input = scanner.nextLine();
		proprietaire.setAdressePersonne(input);
		
		System.out.print("Nom : ");
		input = scanner.nextLine();
		proprietaire.setNom(input);
		
		System.out.print("Prenom : ");
		input = scanner.nextLine();
		proprietaire.setPrenom(input);
		
		System.out.print("Age : ");
		input = scanner.nextLine();
		proprietaire.setAge(Integer.parseInt(input));
		
		System.out.print("Telephone : ");
		input = scanner.nextLine();
		proprietaire.setNumTel(input);
		
		impl.creer(proprietaire);
		listerProprietaire();
		
		
	}
	
	public void rechercherProprietaire() {
		Proprietaire proprietaire = new Proprietaire();
		Scanner scanner = new Scanner(System.in);
		String input;
		System.out.print("Id : ");
		input = scanner.nextLine();
		proprietaire= impl.getById(Integer.parseInt(input));
		
		
		if(impl.liste().contains(proprietaire)) {
			System.out.println("id : " + proprietaire.getId());
			System.out.println("Type : " + proprietaire.getNumCin());
			System.out.println("Adresse : " + proprietaire.getAdressePersonne());
			System.out.println("Ville: " + proprietaire.getNom());
			System.out.println("Nombre de piece : " + proprietaire.getPrenom());
			System.out.println("Surface : " + proprietaire.getAge());
			System.out.println("Type : " + proprietaire.getNumTel());
			System.out.println("-----------------------------------");
			
			
		}else {
			System.out.println("Le proprietaire n'existe pas !!");
		}
	}
	
	public void supprimerProprietaire() {
		Proprietaire proprietaire ;
		Scanner scanner = new Scanner(System.in);
		String input;
		System.out.print("Id : ");
		input = scanner.nextLine();
		proprietaire= impl.getById(Integer.parseInt(input));
		impl.supprimer(proprietaire);
		
		listerProprietaire();
	}
	
	public void modifierProprietaire() {
		Proprietaire proprietaire = new Proprietaire();
		Scanner scanner = new Scanner(System.in);
		String input;
		System.out.print("Entrer ID : ");
		input = scanner.nextLine();
		proprietaire = impl.getById(Integer.parseInt(input));
		
		System.out.print("NIN : ");
		input = scanner.nextLine();
		proprietaire.setNumCin(input);
		
		System.out.print("Adresse : ");
		input = scanner.nextLine();
		proprietaire.setAdressePersonne(input);
		
		System.out.print("Nom : ");
		input = scanner.nextLine();
		proprietaire.setNom(input);
		
		System.out.print("Prenom : ");
		input = scanner.nextLine();
		proprietaire.setPrenom(input);
		
		System.out.print("Age : ");
		input = scanner.nextLine();
		proprietaire.setAge(Integer.parseInt(input));
		
		System.out.print("Telephone : ");
		input = scanner.nextLine();
		proprietaire.setNumTel(input);
		
		impl.modifier(proprietaire);
		listerProprietaire();
		
	}
}
