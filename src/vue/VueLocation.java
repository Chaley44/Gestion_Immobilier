package vue;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import domaine.Bien;
import domaine.Location;
import domaine.Proprietaire;
import service.BienG;
import service.IMetier;
import service.LocationG;

public class VueLocation {


	VueBien vueBien = new VueBien();
	public IMetier<Location, Integer> impl = new LocationG();
	IMetier<Bien, Integer> implBien = new BienG();
	DateTimeFormatter dateTimeFormatter =DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public  VueLocation() {
		
		
		
	}
	
	public void listerLocation() {
		System.out.println("Liste des Locations");
		System.out.println("===================================");
		for(Location location : impl.liste()) {
			System.out.println("Id : " + location.getId());
			System.out.println("Prix : " + location.getPrix());
			System.out.println("Date de debut : " + location.getDateDebut());
			System.out.println("Id bien : " + location.getBien().getId());
			System.out.println("Adresse bien  : " + location.getBien().getAdresse());
			System.out.println("Type bien : " + location.getBien().getType());
			System.out.println("-----------------------------------");
		}
	}
	
	public void creerLocation() {
		Location location = new Location();
		Scanner scanner = new Scanner(System.in);
		String input;
		
		
		System.out.print("Prix : ");
		input = scanner.nextLine();
		try {
			location.setPrix(Float.parseFloat(input));
		} catch (InputMismatchException e) {
			System.out.println("Veuiller entrer un nombre reel");
			e.getStackTrace();
		}
			
		System.out.print("Date de debut : ");
		input = scanner.next();
		try {
			location.setDateDebut(LocalDate.parse(input));
		} catch (InputMismatchException e) {
			System.out.println("Veuiller entrer une une date correct");
			e.getStackTrace();
		}
			
		vueBien.listerBien();
		System.out.println("Choisir un bien ");
		
		try {
			input =scanner.next();
			location.setBien(implBien.getById(Integer.parseInt(input)));
		} catch (NumberFormatException e) {
			System.out.println("Veuiller entrer un nombre entier");
			e.getStackTrace();
		}
	
		impl.creer(location);
		listerLocation();
		
		
	}
	
	public void rechercherLocation() {
		Location location = new Location();
		Scanner scanner = new Scanner(System.in);
		String input;
		
		try {
			System.out.print("Id : ");
			input = scanner.nextLine();
			location= impl.getById(Integer.parseInt(input));	
			System.out.println("id : " + location.getId());
			System.out.println("Prix : " + location.getPrix());
			System.out.println("Date de debut : " + location.getDateDebut());
			System.out.println("Id bien : " + location.getBien().getId());
			System.out.println("Adresse bien  : " + location.getBien().getAdresse());
			System.out.println("Type bien : " + location.getBien().getType());
			
			System.out.println("-----------------------------------");
		}catch(NullPointerException e){
		
			System.err.println("La Location n'existe pas !!");	
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
		try {
			System.out.print("Prix : ");
			input = scanner.nextLine();
			location.setPrix(Float.parseFloat(input));
			
			System.out.print("Date de debut : ");
			input = scanner.nextLine();
			location.setDateDebut(LocalDate.parse(input));
			
			vueBien.listerBien();
			System.out.println("Choisir un bien ");
			input =scanner.next();
			try {
				
				location.setBien(implBien.getById(Integer.parseInt(input)));
				
			} catch (NumberFormatException e) {
				System.out.println("Veuiller entrer un nombre entier");
				e.getStackTrace();
			}
			
			impl.modifier(location);
			listerLocation();
			
		}catch(NullPointerException e) {
			System.err.println("La location n'existe pas!!");
			
		}
		
		
		
	}
}
