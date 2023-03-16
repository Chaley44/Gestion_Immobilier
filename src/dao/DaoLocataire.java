package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domaine.Locataire;

public class DaoLocataire {

	
	public List<Locataire> listerLocataire() {
		List<Locataire> listeLo = new ArrayList<>();
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
		
			
			//Creation de requete
			PreparedStatement ts = creerConnexion.getCon().prepareStatement(" select * from locataire");
			
			//Execute la requete
			ResultSet rs = ts.executeQuery();
			
			//affichage des resultat obtenus
			while(rs.next()) {
				//initialistaion du Locataire
				Locataire locataire = new Locataire();
				locataire.setId(rs.getInt("Id"));
				locataire.setNumCin(rs.getString(2));
				locataire.setNom(rs.getString(3));
				locataire.setPrenom(rs.getString(4));
				locataire.setAge(rs.getInt(5));
				locataire.setNumTel(rs.getString(6));
				locataire.setAdressePersonne(rs.getString(7));
				listeLo.add(locataire);
			}
			
			creerConnexion.getCon().close();
			rs.close();
			ts.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return listeLo;
	}
	
	public Locataire findLocataire(int id) {
		Locataire locataire = new Locataire();
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
		
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(""
					+ " select * from locataire where id = ?");
			pst.setInt(1, id);
			//Execute la requete
			ResultSet rs = pst.executeQuery();
			
			//affichage des resultat obtenus
			while(rs.next()) {
				//initialistaion du Locataire
				
				locataire.setId(rs.getInt("Id"));
				locataire.setNumCin(rs.getString(2));
				locataire.setNom(rs.getString(3));
				locataire.setPrenom(rs.getString(4));
				locataire.setAge(rs.getInt(5));
				locataire.setNumTel(rs.getString(6));
				locataire.setAdressePersonne(rs.getString(7));
				
			}
			
			creerConnexion.getCon().close();
			rs.close();
			pst.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return locataire;
	}
	
	public void creerLocataire(Locataire locataire) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement("insert into locataire(numCin, nom, prenom, age, numTel, adressePersonne)" 
					+ "values(?, ?, ?, ?, ?, ?)");
			pst.setString(1, locataire.getNumCin());
			pst.setString(2, locataire.getNom());
			pst.setString(3, locataire.getPrenom());
			pst.setInt(4, locataire.getAge());
			pst.setString(5, locataire.getNumTel());
			pst.setString(6, locataire.getAdressePersonne());
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("Insertion effectuee");
		
			
			
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	
	}
	
	public void modifierLocataire(Locataire locataire) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement("update locataire set numCin = ? ,nom = ? ,"
					+ "prenom = ? ,age = ?,numTel = ?, adressePersonne = ? where Id = ?") ;

			pst.setString(1, locataire.getNumCin());
			pst.setString(2, locataire.getNom());
			pst.setString(3, locataire.getPrenom());
			pst.setInt(4, locataire.getAge());
			pst.setString(5, locataire.getNumTel());
			pst.setString(6, locataire.getAdressePersonne());
			pst.setInt(7, locataire.getId());
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("Modification efectuée");	
			
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public void supprimerLocataire(Locataire locataire) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement("delete from locataire where id= ? "); 
			pst.setInt(1, locataire.getId());
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
