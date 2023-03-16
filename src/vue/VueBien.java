package vue;


import java.util.Scanner;

import domaine.Bien;
import domaine.EtatBien;
import service.BienG;
import service.IMetier;

public class VueBien {

	public IMetier<Bien, Integer> impl = new BienG();
	VueProprietaire vueProprietaire = new VueProprietaire();
	
	public  VueBien() {
		
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
			System.out.println("Etat bien : " + bien.getEtatBien().getEtat());
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
	}
	
	public void creerBien() {
		Bien bien = new Bien();
		Scanner scanner = new Scanner(System.in);
		String input;
		
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
		
		vueProprietaire.listerProprietaire();
		System.out.println("Choisir un proprietaire ");
		
		try {
			input =scanner.nextLine();
			bien.setProprietaire(vueProprietaire.impl.getById(Integer.parseInt(input)));

		} catch (NumberFormatException e) {
			System.out.println("Veuiller entrer un nombre entier");
			e.getStackTrace();
		}
		
		
		impl.creer(bien);
		listerBien();
		
		
	}
	
	public void rechercherBien() {
		Bien bien = new Bien();
		Scanner scanner = new Scanner(System.in);
		String input;
		
		try {
			System.out.print("Id : ");
			input = scanner.nextLine();
			bien= impl.getById(Integer.parseInt(input));
		
		    System.out.println("ID : " + bien.getId());
			System.out.println("Adresse : " + bien.getAdresse());
			System.out.println("Ville: " + bien.getVille());
			System.out.println("Nombre de piece : " + bien.getNbrPiece());
			System.out.println("Surface : " + bien.getSurface());
			System.out.println("Type : " + bien.getType());
			System.out.println("Etat bien : " + bien.getEtatBien());

			System.out.println("-----------------------------------");
			
		} catch (Exception e) {
			//System.out.println("La bien n'existe pas !!");
			e.getMessage();
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
		try {
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
		} catch (NullPointerException e) {
			System.out.println("Le bien n'existe pas !!");
		}
		
	}
}
