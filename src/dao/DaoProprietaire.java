package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domaine.Proprietaire;

public class DaoProprietaire {

	
	
	public List<Proprietaire> listerProprietaire() {
		List<Proprietaire> listePr = new ArrayList<>();
		
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement ts = creerConnexion.getCon().prepareStatement(" select * from proprietaire");
			
			//Execute la requete
			ResultSet rs = ts.executeQuery();
			
			//affichage des resultat obtenus
//			for(int i =0; i>rs.getFetchSize(); i++) {
//				
//			}
			while(rs.next()) {
				//initialistaion du proprietaire
				Proprietaire proprietaire = new Proprietaire();
				proprietaire.setId(rs.getInt("Id"));
				proprietaire.setNumCin(rs.getString(2));
				proprietaire.setNom(rs.getString(3));
				proprietaire.setPrenom(rs.getString(4));
				proprietaire.setAge(rs.getInt(5));
				proprietaire.setNumTel(rs.getString(6));
				proprietaire.setAdressePersonne(rs.getString(7));
				listePr.add(proprietaire);
				
			}
			
			
			creerConnexion.getCon().close();
			rs.close();
			ts.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return listePr;
	}
	
	public Proprietaire findProprietaire(int id) {
		Proprietaire proprietaire = new Proprietaire();
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(" select * from proprietaire where id = ?");
			pst.setInt(1, id);
			//Execute la requete
			ResultSet rs = pst.executeQuery();
			
			//affichage des resultat obtenus
//			for(int i =0; i>rs.getFetchSize(); i++) {
//				
//			}
			while(rs.next()) {
				//initialistaion du proprietaire
				
				proprietaire.setId(rs.getInt("Id"));
				proprietaire.setNumCin(rs.getString(2));
				proprietaire.setNom(rs.getString(3));
				proprietaire.setPrenom(rs.getString(4));
				proprietaire.setAge(rs.getInt(5));
				proprietaire.setNumTel(rs.getString(6));
				proprietaire.setAdressePersonne(rs.getString(7));
						
			}		
			
			creerConnexion.getCon().close();
			rs.close();
			pst.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return proprietaire;
	}
	
	public void creerProprietaire(Proprietaire proprietaire) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement("insert into proprietaire(numCin, nom, prenom, age, numTel, adressePersonne)" 
					+ "values(?, ?, ?, ?, ?, ?)");
			pst.setString(1, proprietaire.getNumCin());
			pst.setString(2, proprietaire.getNom());
			pst.setString(3, proprietaire.getPrenom());
			pst.setInt(4, proprietaire.getAge());
			pst.setString(5, proprietaire.getNumTel());
			pst.setString(6, proprietaire.getAdressePersonne());
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("Insertion effectuee");
		
			
			
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	
	}
	
	public void modifierProprietaire(Proprietaire proprietaire) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement("update proprietaire set numCin = ? ,nom = ? ,"
					+ "prenom = ? ,age = ?,numTel = ?, adressePersonne = ? where Id = ?") ;

			pst.setString(1, proprietaire.getNumCin());
			pst.setString(2, proprietaire.getNom());
			pst.setString(3, proprietaire.getPrenom());
			pst.setInt(4, proprietaire.getAge());
			pst.setString(5, proprietaire.getNumTel());
			pst.setString(6, proprietaire.getAdressePersonne());
			pst.setInt(7, proprietaire.getId());
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("Modification eefectuée");	
			
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public void supprimerProprietaire(Proprietaire proprietaire) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement("delete from proprietaire where id= ? "); 
			pst.setInt(1, proprietaire.getId());
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
