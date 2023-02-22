package vue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import domaine.Location;
import service.IMetier;
import service.LocationG;

public class VueLocation {


	public IMetier<Location, Integer> impl = new LocationG();
	DateTimeFormatter dateTimeFormatter =DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public  VueLocation() {
		Location location1 = new Location(1, 12000f, LocalDate.parse("10/02/2023"));
		Location location2 = new Location(1, 12000f, LocalDate.parse("27/01/2023"));
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
