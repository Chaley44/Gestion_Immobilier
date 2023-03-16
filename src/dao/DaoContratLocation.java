package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import domaine.ContratLocation;
import domaine.Locataire;
import domaine.Location;

public class DaoContratLocation {

	public List<ContratLocation> listerContratLocation() {
		List<ContratLocation> listeContrat = new ArrayList<>();
		CreerConnexion creerConnexion = new CreerConnexion();
		DaoLocation loDao = new DaoLocation();
		try {
			
			//Creation de requete
			PreparedStatement ts = creerConnexion.getCon().prepareStatement(""
					+ " select * from contratLocation");
			
			//Execute la requete
			ResultSet rs = ts.executeQuery();
			
			//affichage des resultat obtenus
			while(rs.next()) {
				//initialistaion du Locataire
				ContratLocation contratLocation = new ContratLocation();
				contratLocation.setId(rs.getInt("id"));
				contratLocation.setDureeContrat(rs.getString(2));
				Date date = rs.getDate(3);
				LocalDate date2 = date.toLocalDate();
				contratLocation.setDateContrat(date2);
				contratLocation.setRenouvellement(rs.getString(4));
				
				int idLocation = rs.getInt(5);
				Location location = loDao.findLocation(idLocation);
				contratLocation.setLocation(location);
				
				listeContrat.add(contratLocation);
			}
			
			creerConnexion.getCon().close();
			rs.close();
			ts.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return listeContrat;
	}
	
	public ContratLocation findContratLocation(int id) {
		ContratLocation contratLocation = new ContratLocation();
		CreerConnexion creerConnexion = new CreerConnexion();
		DaoLocation loDao = new DaoLocation();
		try {
			
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(
					" select * from contratLocation where id = ?");
			pst.setInt(1, id);
			//Execute la requete
			ResultSet rs = pst.executeQuery();
			
			//affichage des resultat obtenus
			while(rs.next()) {
				
				
				contratLocation.setId(rs.getInt("id"));
				contratLocation.setDureeContrat(rs.getString(2));
				Date date = rs.getDate(3);
				LocalDate date2 = date.toLocalDate();
				contratLocation.setDateContrat(date2);
				contratLocation.setRenouvellement(rs.getString(4));
				int idLocation = rs.getInt(5);
				Location location = loDao.findLocation(idLocation);
				contratLocation.setLocation(location);
				
				
			}
			
			creerConnexion.getCon().close();
			rs.close();
			pst.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return contratLocation;
	}
	public void creerContratLocation(ContratLocation contratLocation) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(
					"insert into contratLocation(duree_contrat, dateContrat,"
					+ " renouvellement, id_location)" 
					+ "values(?, ?, ?,?)");
			pst.setString(1, contratLocation.getDureeContrat());
			LocalDate dateContrat = contratLocation.getDateContrat();
			pst.setDate(2, Date.valueOf(dateContrat) );
			pst.setString(3, contratLocation.getRenouvellement());
			pst.setInt(4, contratLocation.getLocation().getId());
			
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("Insertion effectuee");	
			
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	
	}
	
	public void modifierContratLocation(ContratLocation contratLocation) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(
					"update contratLocation set duree_contrat = ? ,dateContrat = ?,"
					+ " renouvellement = ?, id_location = ? where Id = ?") ;

			pst.setString(1, contratLocation.getDureeContrat());
			LocalDate dateContrat = contratLocation.getDateContrat();
			pst.setDate(2, Date.valueOf(dateContrat) );
			pst.setString(3, contratLocation.getRenouvellement());
			pst.setInt(4, contratLocation.getLocation().getId());
			pst.setInt(5, contratLocation.getId());
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("Modification efectuée");	
			
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public void supprimerContratLocation(ContratLocation contratLocation) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(
					"delete from contratLocation where id= ? "); 
			pst.setInt(1, contratLocation.getId());
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
