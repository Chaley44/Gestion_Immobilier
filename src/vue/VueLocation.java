package vue;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import domaine.Bien;
import domaine.Location;
import domaine.Proprietaire;
import service.IMetier;
import service.LocationG;

public class VueLocation {


	VueBien vueBien = new VueBien();
	public IMetier<Location, Integer> impl = new LocationG();
	DateTimeFormatter dateTimeFormatter =DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public  VueLocation() {
		Proprietaire proprietaire1 = new Proprietaire(1, "1234","chaley", "fabrice",
				21, "774032534", "Ouakam");
		Proprietaire proprietaire2 = new Proprietaire(2, "4321","charles", "brice",
				30, "774052638", "Amadie");
		Bien bien1 = new Bien(1, "Ouakam", "Dakar", 4, 120f, "appartement", proprietaire1 );
		
		Bien bien2 = new Bien(2, "Point E", "Dakar", 3, 150f, "appartement", proprietaire2 );
		
		
		Location location1 = new Location(1, 12000f, LocalDate.parse("10/02/2023", dateTimeFormatter));
		Location location2 = new Location(2, 12000f, LocalDate.parse("27/01/2023", dateTimeFormatter));
		location1.setBien(bien1);
		location2.setBien(bien2);
		impl.creer(location1);
		impl.creer(location2);
		
		
	}
	
	public void listerLocation() {
		System.out.println("Liste des Locations");
		System.out.println("===================================");
		for(Location location : impl.liste()) {
			System.out.println("id : " + location.getId());
			System.out.println("Prix : " + location.getPrix());
			System.out.println("Date de debut : " + location.getDateDebut());
			System.out.println("-----------------------------------");
		}
	}
	
	public void creerLocation() {
		Location location = new Location();
		Scanner scanner = new Scanner(System.in);
		String input;
		
		System.out.print("Id : ");
		input = scanner.nextLine();
		location.setId(Integer.parseInt(input));
		
		System.out.print("Prix : ");
		input = scanner.nextLine();
		location.setPrix(Float.parseFloat(input));
		
		System.out.print("Date de debut : ");
		input = scanner.nextLine();
		location.setDateDebut(LocalDate.parse(input,dateTimeFormatter));
		
		vueBien.listerBien();
		System.out.println("Choisir un bien ");
		input =scanner.nextLine();
		location.setBien(vueBien.impl.getById(Integer.parseInt(input)));
	
		
		impl.creer(location);
		listerLocation();
		
		
	}
	
	public void rechercherLocation() {
		Location location = new Location();
		Scanner scanner = new Scanner(System.in);
		String input;
		System.out.print("Id : ");
		input = scanner.nextLine();
		location= impl.getById(Integer.parseInt(input));
		
		
		if(impl.liste().contains(location)) {
			System.out.println("id : " + location.getId());
			System.out.println("Prix : " + location.getPrix());
			System.out.println("Date de debut : " + location.getDateDebut());
			System.out.println("-----------------------------------");
			
			
		}else {
			System.out.println("La Llocation n'existe pas !!");
		}
	}
	
	public void supprimerLocation() {
		Location location ;
		Scanner scanner = new Scanner(System.in);
		String input;
		System.out.print("Id : ");
		input = scanner.nextLine();
		location= impl.getById(Integer.parseInt(input));
		impl.supprimer(location);
		
		listerLocation();
	}
	
	public void modifierLocataire() {
		Location location = new Location();
		Scanner scanner = new Scanner(System.in);
		String input;
		System.out.print("Entrer id : ");
		input = scanner.nextLine();
		location = impl.getById(Integer.parseInt(input));
		
		System.out.print("Prix : ");
		input = scanner.nextLine();
		location.setPrix(Float.parseFloat(input));
		
		System.out.print("Date de debut : ");
		input = scanner.nextLine();
		location.setDateDebut(LocalDate.parse(input,dateTimeFormatter));
		
		impl.modifier(location);
		listerLocation();
		
	}
}
