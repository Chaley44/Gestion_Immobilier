package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domaine.Bien;

public class DaoBien {

	
	public List<Bien> listerBien() {
		List<Bien> listeBien = new ArrayList<>();
		try {
			//Chargement du pilote
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Connexion a la bd
			Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/gestion_immobiliere",
					"root", "");
			
			//Creation de requete
			PreparedStatement ts = con.prepareStatement(" select * from bien");
			
			//Execute la requete
			ResultSet rs = ts.executeQuery();
			
			//affichage des resultat obtenus
			while(rs.next()) {
				//initialistaion du Bien
				Bien bien = new Bien();
				bien.setId(rs.getInt("Id"));
				bien.setAdresse(rs.getString(2));
				bien.setVille(rs.getString(3));
				bien.setNbrPiece(rs.getInt(4));
				bien.setSurface(rs.getFloat(5));
				bien.setType(rs.getString(6));
				
				listeBien.add(bien);
			}
			
			con.close();
			rs.close();
			ts.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return listeBien;
	}
	
	public void creerBien(Bien bien) {
		try {
			//Chargement du pilote
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Connexion a la bd
			Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/gestion_immobiliere",
					"root", "");
			//Creation de requete
			PreparedStatement pst = con.prepareStatement("insert into bien(adresse, ville, nbrPiece, surface, type)" 
					+ "values(?, ?, ?, ?, ?)");
			pst.setString(1, bien.getAdresse());
			pst.setString(2, bien.getVille());
			pst.setInt(3, bien.getNbrPiece());
			pst.setFloat(4, bien.getSurface());
			pst.setString(5, bien.getType());
			
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("Insertion effectuee");
		
			
			
			con.close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	
	}
	
	public void modifierBien(Bien bien) {
		try {
			//Chargement du pilote
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Connexion a la bd
			Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/gestion_immobiliere",
					"root", "");
			//Creation de requete
			PreparedStatement pst = con.prepareStatement("update bien set numCin = ? ,nom = ? ,"
					+ "prenom = ? ,age = ?,numTel = ?, adressePersonne = ? where Id = ?") ;

			pst.setString(1, bien.getAdresse());
			pst.setString(2, bien.getVille());
			pst.setInt(3, bien.getNbrPiece());
			pst.setFloat(4, bien.getSurface());
			pst.setString(5, bien.getType());
			pst.setInt(7, bien.getId());
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("Modification eefectuée");	
			
			con.close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public void supprimerBien(Bien bien) {
		try {
			//Chargement du pilote
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Connexion a la bd
			Connection con = DriverManager.getConnection("jdbc:mysql://localHost:3306/db_cours",
					"root", "");
			
			//Creation de requete
			PreparedStatement pst = con.prepareStatement("delete bien where id= ? "); 
			pst.setInt(1, bien.getId());
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
