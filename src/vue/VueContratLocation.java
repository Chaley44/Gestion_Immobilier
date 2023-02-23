package vue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
	
	VueProprietaire vueProprietaire = new VueProprietaire();
	VueBien vueBien = new VueBien();
	VueLocataire vueLocataire = new VueLocataire();
	VueLocation vueLocation = new VueLocation();
	
	public  VueContratLocation() {
		Proprietaire proprietaire1 = new Proprietaire(1, "1234","chaley", "fabrice",
				21, "774032534", "Ouakam");
		Proprietaire proprietaire2 = new Proprietaire(2, "4321","charles", "brice",
				30, "774052638", "Amadie");
		vueProprietaire.impl.creer(proprietaire1);
		vueProprietaire.impl.creer(proprietaire2);
		
		
		Bien bien1 = new Bien(1, "Ouakam", "Dakar", 4, 120f, "appartement", proprietaire1 );
		vueBien.impl.creer(bien1);
		Bien bien2 = new Bien(2, "Point E", "Dakar", 3, 150f, "appartement", proprietaire2 );
		vueBien.impl.creer(bien2);
		Bien bien3 = new Bien(3, "Ouakam", "Dakar", 6, 200f, "maison", proprietaire2);
		vueBien.impl.creer(bien3);
		
		Location location1 = new Location(1, 12000f, LocalDate.now());
		Location location2 = new Location(2, 240000f, LocalDate.now());
		location1.setBien(bien2);
		location2.setBien(bien1);
		
		ContratLocation contratLocation1 = new ContratLocation(1, "6 mois ", LocalDate.now(), "6 mois ");
		ContratLocation contratLocation2 = new ContratLocation(2, "2 an ", LocalDate.now(), "1 an ");
		contratLocation1.setLocation(location1);
		contratLocation2.setLocation(location2);
		impl.creer(contratLocation1);
		impl.creer(contratLocation2);
		
	}
	
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
			System.out.println("ID Bien : " + contratLocation.getLocation().getBien().getId());
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
		
		System.out.print("Id : ");
		input = scanner.nextLine();
		contratLocation.setId(Integer.parseInt(input));
		
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
	
		
		impl.creer(contratLocation);
		listerContratLocation();
		
		
	}
	
	public void rechercherLocation() {
		ContratLocation contratLocation = new ContratLocation();
		Scanner scanner = new Scanner(System.in);
		String input;
		System.out.print("Id : ");
		input = scanner.nextLine();
		contratLocation= impl.getById(Integer.parseInt(input));
		
		
		if(impl.liste().contains(contratLocation)) {
			System.out.println("id : " + contratLocation.getId());
			System.out.println("Duree du contrat : " + contratLocation.getDureeContrat());
			System.out.println("Date du contrat : " + contratLocation.getDateContrat());
			System.out.println("Renouvellement : " + contratLocation.getRenouvellement());

			System.out.println("-----------------------------------");
			
			
		}else {
			System.out.println("Le contrat de location n'existe pas !!");
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
		
		System.out.print("Duree contrat : ");
		input = scanner.nextLine();
		contratLocation.setDureeContrat(input);
		
		System.out.print("Date de debut : ");
		input = scanner.nextLine();
		contratLocation.setDateContrat(LocalDate.parse(input,dateTimeFormatter));
		
		System.out.print("Renouvellement : ");
		input = scanner.nextLine();
		contratLocation.setRenouvellement(input);
		
		impl.modifier(contratLocation);
		listerContratLocation();
		
	}
}
