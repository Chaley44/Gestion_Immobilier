package vue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import domaine.Bien;
import domaine.ContratLocation;
import domaine.Location;
import domaine.Proprietaire;
import service.ContratLocationG;
import service.IMetier;

public class VueContratLocation {

	public IMetier<ContratLocation, Integer> impl = new ContratLocationG();
	DateTimeFormatter dateTimeFormatter =DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	VueLocation vueLocation = new VueLocation();
	
	public  VueContratLocation() {}
	
	public void listerContratLocation() {
		System.out.println("Liste des Contrat de Locations");
		System.out.println("===================================");
		for(ContratLocation contratLocation : impl.liste()) {
			System.out.println("ID : " + contratLocation.getId());
			System.out.println("Duree du contrat : " + contratLocation.getDureeContrat());
			System.out.println("Date du contrat : " + contratLocation.getDateContrat());
			System.out.println("Renouvellement : " + contratLocation.getRenouvellement());
			System.out.println("-----------------------------------");
			
			System.out.println("ID Location: " + contratLocation.getLocation().getId());
			System.out.println("Prix location : " + contratLocation.getLocation().getPrix());
			System.out.println("Date de but : " + contratLocation.getLocation().getDateDebut());
			System.out.println("-----------------------------------");
			
			System.out.println("ID Bien : " + contratLocation.getLocation().getBien());
			System.out.println("Adresse du bien : " + contratLocation.getLocation().getBien().getAdresse());
			System.out.println("Ville : " + contratLocation.getLocation().getBien().getVille());
			System.out.println("Nombre de piece : " + contratLocation.getLocation().getBien().getNbrPiece());
			System.out.println("Surface : " + contratLocation.getLocation().getBien().getSurface());
			System.out.println("type : " + contratLocation.getLocation().getBien().getType());
			System.out.println("-----------------------------------");
			
			System.out.println("ID Proprietaire : " + contratLocation.getLocation().getBien().getProprietaire().getId());
			System.out.println("Nom et prenom du proprietaire : " + contratLocation.getLocation().getBien().getProprietaire().getNom()
					+ " " + contratLocation.getLocation().getBien().getProprietaire().getPrenom());
			System.out.println("Adresse du Prorpietaire : " + contratLocation.getLocation().getBien().getProprietaire().getAdressePersonne());
			System.out.println("=============================================");

		}
	}
	
	public void creerContratLocation() {
		ContratLocation contratLocation = new ContratLocation();
		Scanner scanner = new Scanner(System.in);
		String input;
		
		System.out.print("Duree contrat : ");
		try {
			input = scanner.nextLine();
			contratLocation.setDureeContrat(input);
		} catch (InputMismatchException e) {
			System.out.println("Veuiller entrer un nombre reel");
			e.getStackTrace();
		}
		
		System.out.print("Date de debut : ");
		try {
			input = scanner.nextLine();
			contratLocation.setDateContrat(LocalDate.parse(input,dateTimeFormatter));
		} catch (InputMismatchException e) {
			System.out.println("Veuiller entrer une une date correct");
		}
		System.out.print("Renouvellement : ");
		try {
			input = scanner.nextLine();
			contratLocation.setRenouvellement(input);
		} catch (InputMismatchException e) {
			System.out.println("Veuiller entrer un nombre reel");
			e.getStackTrace();
		}

		vueLocation.listerLocation();
		System.out.println("Choisir une location ");
		try {
			input =scanner.nextLine();
			contratLocation.setLocation(vueLocation.impl.getById(Integer.parseInt(input)));
		} catch (NumberFormatException e) {
			System.out.println("Veuiller entrer un nombre entier");
			e.getStackTrace();		
			}
		
		impl.creer(contratLocation);
		listerContratLocation();
		
	}
	
	public void rechercherLocation() {
		ContratLocation contratLocation = new ContratLocation();
		Scanner scanner = new Scanner(System.in);
		String input;	
		try {
			System.out.print("Id : ");
			input = scanner.nextLine();
			contratLocation= impl.getById(Integer.parseInt(input));

			System.out.println("id : " + contratLocation.getId());
			System.out.println("Duree du contrat : " + contratLocation.getDureeContrat());
			System.out.println("Date du contrat : " + contratLocation.getDateContrat());
			System.out.println("Renouvellement : " + contratLocation.getRenouvellement());
			System.out.println("-----------------------------------");
				
		} catch (NullPointerException e) {
			System.err.println("Le contrat de location n'existe pas !!");
		}
		
	}
	
	public void supprimerLocation() {
		ContratLocation contratLocation ;
		Scanner scanner = new Scanner(System.in);
		String input;
		System.out.print("Id : ");
		input = scanner.nextLine();
		contratLocation= impl.getById(Integer.parseInt(input));
		impl.supprimer(contratLocation);
		
		listerContratLocation();
	}
	
	public void modifierLocataire() {
		ContratLocation contratLocation = new ContratLocation();
		Scanner scanner = new Scanner(System.in);
		String input;
		System.out.print("Entrer id : ");
		input = scanner.nextLine();
		contratLocation = impl.getById(Integer.parseInt(input));
		try {
			System.out.print("Duree contrat : ");
			input = scanner.nextLine();
			contratLocation.setDureeContrat(input);
			
			System.out.print("Date de debut : ");
			input = scanner.nextLine();
			contratLocation.setDateContrat(LocalDate.parse(input,dateTimeFormatter));
			
			System.out.print("Renouvellement : ");
			input = scanner.nextLine();
			contratLocation.setRenouvellement(input);
			
			vueLocation.listerLocation();
			System.out.println("Choisir une location ");
			input =scanner.nextLine();
			contratLocation.setLocation(vueLocation.impl.getById(Integer.parseInt(input)));
		
			impl.modifier(contratLocation);
			listerContratLocation();
		} catch (NullPointerException e) {
			System.err.println("le contrat de location n'existe pas!!");
			e.getMessage();
		}
		
		
		
	}
}
