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
		try {
			//Chargement du pilote
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Connexion a la bd
			Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/gestion_immobiliere",
					"root", "");
			
			//Creation de requete
			PreparedStatement ts = con.prepareStatement(" select * from locataire");
			
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
			
			con.close();
			rs.close();
			ts.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return listeLo;
	}
	
	public void creerLocataire(Locataire locataire) {
		try {
			//Chargement du pilote
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Connexion a la bd
			Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/gestion_immobiliere",
					"root", "");
			//Creation de requete
			PreparedStatement pst = con.prepareStatement("insert into locataire(numCin, nom, prenom, age, numTel, adressePersonne)" 
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
		
			
			
			con.close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	
	}
	
	public void modifierLocataire(Locataire locataire) {
		try {
			//Chargement du pilote
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Connexion a la bd
			Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/gestion_immobiliere",
					"root", "");
			//Creation de requete
			PreparedStatement pst = con.prepareStatement("update locataire set numCin = ? ,nom = ? ,"
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
			
			con.close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public void supprimerLocataire(Locataire locataire) {
		try {
			//Chargement du pilote
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Connexion a la bd
			Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/gestion_immobiliere",
					"root", "");
			
			//Creation de requete
			PreparedStatement pst = con.prepareStatement("delete from locataire where id= ? "); 
			pst.setInt(1, locataire.getId());
			//execution de la requete
			pst.executeUpdate();
			System.out.println("Suppression effectuée");
			
			con.close();
			pst.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}


}
