package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import domaine.Bien;
import domaine.Location;

public class DaoLocation {

	public List<Location> listerLocation() {
		List<Location> listeLocation = new ArrayList<>();
		DaoBien bDao = new DaoBien();
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			
			//Creation de requete
			PreparedStatement ts = creerConnexion.getCon().prepareStatement(" select * from location");
			
			//Execute la requete
			ResultSet rs = ts.executeQuery();
			
			//affichage des resultat obtenus
			while(rs.next()) {
				//initialistaion du Locataire
				Location location = new Location();
				location.setId(rs.getInt("Id"));
				location.setPrix(rs.getFloat(2));
				Date date = rs.getDate(3);
				LocalDate date2 = date.toLocalDate();
				location.setDateDebut(date2);
				
				int idBien = rs.getInt(4);
				Bien bien = bDao.findBien(idBien);
				location.setBien(bien);
				
				listeLocation.add(location);
			}
			
			creerConnexion.getCon().close();
			rs.close();
			ts.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return listeLocation;
	}
	
	public Location findLocation(int id) {
		Location location = new Location();
		DaoBien bDao = new DaoBien();
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
					
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(
					" select * from location where id = ?");
			pst.setInt(1, id);
			//Execute la requete
			ResultSet rs = pst.executeQuery();
			
			//affichage des resultat obtenus
			while(rs.next()) {
				//initialistaion du Locataire
				
				location.setId(rs.getInt("id"));
				location.setPrix(rs.getFloat(2));
				Date dateDebut = rs.getDate(3);
				LocalDate date2 = dateDebut.toLocalDate();
				location.setDateDebut(date2);

				int idBien = rs.getInt(4);
				Bien bien = bDao.findBien(idBien);
				location.setBien(bien);
				
				
			}
			
			creerConnexion.getCon().close();
			rs.close();
			pst.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		return location;
	}
	
	public void creerLocation(Location location) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(""
					+ "insert into location(prix, dateDebut, id_bien)" 
					+ "values(?, ?, ?)");
			
			pst.setFloat(1, location.getPrix());
			LocalDate dateDebut = location.getDateDebut();
			pst.setDate(2, Date.valueOf(dateDebut));
			pst.setInt(3, location.getBien().getId());
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("Insertion effectuee");
			
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	
	}
	
	public void modifierLocation(Location location) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(""
					+ "update location set prix = ?, dateDebut = ?,"
					+ " id_bien = ? where id = ?") ;

			pst.setFloat(1, location.getPrix());
			LocalDate dateDebut = location.getDateDebut();
			pst.setDate(2, Date.valueOf(dateDebut));
			pst.setInt(3, location.getBien().getId());
			pst.setInt(4, location.getId());
			
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("Modification efectuée");	
			
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public void supprimerLocation(Location location) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement("delete from location where id= ? "); 
			pst.setInt(1, location.getId());
			//execution de la requete
			pst.executeUpdate();
			System.out.println("Suppression effectuée");
			
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
