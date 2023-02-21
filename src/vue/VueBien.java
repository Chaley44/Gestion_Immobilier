package vue;

import java.util.List;
import java.util.Scanner;

import domaine.Bien;
import domaine.Proprietaire;
import service.BienG;
import service.IMetier;

public class VueBien {

	public IMetier<Bien, Integer> impl = new BienG();
	VueProprietaire vueProprietaire = new VueProprietaire();
	
	public  VueBien() {
		Proprietaire proprietaire1 = new Proprietaire(1, "1234","chaley", "fabrice",
				21, "774032534", "Ouakam");
		Proprietaire proprietaire2 = new Proprietaire(2, "4321","charles", "brice",
				30, "774052638", "Amadie");
		vueProprietaire.impl.creer(proprietaire1);
		vueProprietaire.impl.creer(proprietaire2);
		
		
		Bien bien1 = new Bien(1, "Ouakam", "Dakar", 4, 120f, "appartement", proprietaire1 );
		impl.creer(bien1);
		Bien bien2 = new Bien(2, "Point E", "Dakar", 3, 150f, "appartement", proprietaire2 );
		impl.creer(bien2);
		Bien bien3 = new Bien(3, "Ouakam", "Dakar", 6, 200f, "maison", proprietaire2);
		impl.creer(bien3);
	}
	
	public void listerBien() {
		
		System.out.println("Liste des biens");
		System.out.println("===================================");
		for(Bien bien : impl.liste()) {
			System.out.println("ID : " + bien.getId());
			System.out.println("Adresse : " + bien.getAdresse());
			System.out.println("Ville: " + bien.getVille());
			System.out.println("Nombre de piece : " + bien.getNbrPiece());
			System.out.println("Surface : " + bien.getSurface());
			System.out.println("Type : " + bien.getType());
			System.out.println("Proprietaire : " + bien.getProprietaire().getPrenom()
					+ " " + bien.getProprietaire().getNom());
			
			System.out.println("-----------------------------------");
		}
	}
	

	public void listerBienByProprietaire() {
		
		Scanner scanner = new Scanner(System.in);
		String input;
		System.out.print("Id : ");
		input = scanner.nextLine(); 
		System.out.println("Liste des biens");
		System.out.println("===================================");
		for(Bien bien : impl.liste()) {
			if(bien.getProprietaire().getId().equals(Integer.parseInt(input))) {
				System.out.println("ID : " + bien.getId());
				System.out.println("Adresse : " + bien.getAdresse());
				System.out.println("Ville: " + bien.getVille());
				System.out.println("Nombre de piece : " + bien.getNbrPiece());
				System.out.println("Surface : " + bien.getSurface());
				System.out.println("Type : " + bien.getType());
				System.out.println("-----------------------------------");
			}
			
		}
//		if(listBienByProprietaire.isEmpty()) {
//			System.out.println("Il n'y aps de bien assossier a ce proprietaire");
//		}else {
//			
//		}
		
	}
	
	public void creerBien() {
		Bien bien = new Bien();
		Scanner scanner = new Scanner(System.in);
		String input;
		
		System.out.print("Id : ");
		input = scanner.nextLine();
		bien.setId(Integer.parseInt(input));
		
		System.out.print("Adresse : ");
		input = scanner.nextLine();
		bien.setAdresse(input);
		
		System.out.print("Ville : ");
		input = scanner.nextLine();
		bien.setVille(input);
		
		System.out.print("Nombre de piece : ");
		input = scanner.nextLine();
		bien.setNbrPiece(Integer.parseInt(input));
		
		System.out.print("Surface : ");
		input = scanner.nextLine();
		bien.setSurface(Integer.parseInt(input));
		
		System.out.print("Type : ");
		input = scanner.nextLine();
		bien.setType(input);
		
		impl.creer(bien);
		listerBien();
		
		
	}
	
	public void rechercherBien() {
		Bien bien = new Bien();
		Scanner scanner = new Scanner(System.in);
		String input;
		System.out.print("Id : ");
		input = scanner.nextLine();
		bien= impl.getById(Integer.parseInt(input));
		
		
		if(impl.liste().contains(bien)) {
			System.out.println("ID : " + bien.getId());
			System.out.println("Adresse : " + bien.getAdresse());
			System.out.println("Ville: " + bien.getVille());
			System.out.println("Nombre de piece : " + bien.getNbrPiece());
			System.out.println("Surface : " + bien.getSurface());
			System.out.println("Type : " + bien.getType());
			System.out.println("-----------------------------------");
			
			
		}else {
			System.out.println("La bien n'existe pas !!");
		}
	}
	
	public void supprimerBien() {
		Bien bien ;
		Scanner scanner = new Scanner(System.in);
		String input;
		System.out.print("Id : ");
		input = scanner.nextLine();
		bien= impl.getById(Integer.parseInt(input));
		impl.supprimer(bien);
		
		listerBien();
	}
	
	public void modifierBien() {
		Bien bien = new Bien();
		Scanner scanner = new Scanner(System.in);
		String input;
		System.out.print("Entrer id : ");
		input = scanner.nextLine();
		bien = impl.getById(Integer.parseInt(input));
		
		System.out.print("Adresse : ");
		input = scanner.nextLine();
		bien.setAdresse(input);
		
		System.out.print("Ville : ");
		input = scanner.nextLine();
		bien.setVille(input);
		
		System.out.print("Nombre de piece : ");
		input = scanner.nextLine();
		bien.setNbrPiece(Integer.parseInt(input));
		
		System.out.print("Surface : ");
		input = scanner.nextLine();
		bien.setSurface(Integer.parseInt(input));
		
		System.out.print("Type : ");
		input = scanner.nextLine();
		bien.setType(input);
		
		impl.modifier(bien);
		listerBien();
		
	}
}
