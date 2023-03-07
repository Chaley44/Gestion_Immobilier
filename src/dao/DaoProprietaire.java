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
		try {
			//Chargement du pilote
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Connexion a la bd
			Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/gestion_immobiliere",
					"root", "");
			
			//Creation de requete
			PreparedStatement ts = con.prepareStatement(" select * from proprietaire");
			
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
			
			
			con.close();
			rs.close();
			ts.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return listePr;
	}
	
	public void creerProprietaire(Proprietaire proprietaire) {
		try {
			//Chargement du pilote
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Connexion a la bd
			Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/gestion_immobiliere",
					"root", "");
			//Creation de requete
			PreparedStatement pst = con.prepareStatement("insert into proprietaire(numCin, nom, prenom, age, numTel, adressePersonne)" 
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
		
			
			
			con.close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	
	}
	
	public void modifierProprietaire(Proprietaire proprietaire) {
		try {
			//Chargement du pilote
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Connexion a la bd
			Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/gestion_immobiliere",
					"root", "");
			//Creation de requete
			PreparedStatement pst = con.prepareStatement("update proprietaire set numCin = ? ,nom = ? ,"
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
			
			con.close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public void supprimerProprietaire(Proprietaire proprietaire) {
		try {
			//Chargement du pilote
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Connexion a la bd
			Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/gestion_immobiliere",
					"root", "");
			
			//Creation de requete
			PreparedStatement pst = con.prepareStatement("delete from proprietaire where id= ? "); 
			pst.setInt(1, proprietaire.getId());
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
