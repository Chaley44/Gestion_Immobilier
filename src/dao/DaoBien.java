package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domaine.Bien;
import domaine.EtatBien;
import domaine.Proprietaire;

public class DaoBien {

	
	public List<Bien> listerBien() {
		List<Bien> listeBien = new ArrayList<>();
		DaoProprietaire pDao = new DaoProprietaire();
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement ts = creerConnexion.getCon().prepareStatement(" select * from bien b left join "
					+ "proprietaire p on b.id_proprietaire = p.id");
			
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
				
				int idProprietaire = rs.getInt(7);
				Proprietaire proprietaire = pDao.findProprietaire(idProprietaire);
				bien.setProprietaire(proprietaire);
				
				
				listeBien.add(bien);
			}
			
			creerConnexion.getCon().close();
			rs.close();
			ts.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return listeBien;
	}
	
	public List<Bien> listerBienByProprietaire(int id) {
		List<Bien> listeBien = new ArrayList<>();
		DaoProprietaire pDao = new DaoProprietaire();
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(" select * from "
					+ "bien b join proprietaire p on b.id_proprietaire = "
					+ "p.id where p.id =?;");
			
			pst.setInt(1, id);
			//Execute la requete
			ResultSet rs = pst.executeQuery();
			
			//affichage des resultat obtenus
			while(rs.next()) {
				//initialistaion du Bien
				Bien bien = new Bien();
				bien.setId(rs.getInt("id"));
				bien.setAdresse(rs.getString(2));
				bien.setVille(rs.getString(3));
				bien.setNbrPiece(rs.getInt(4));
				bien.setSurface(rs.getFloat(5));
				bien.setType(rs.getString(6));
				
				int idProprietaire = rs.getInt(7);
				Proprietaire proprietaire = pDao.findProprietaire(idProprietaire);
				bien.setProprietaire(proprietaire);
				
				String etatBien = rs.getString(8);
				bien.setEtatBien(EtatBien.valueOf(etatBien));
				
				
				listeBien.add(bien);
			}
			
			creerConnexion.getCon().close();
			rs.close();
			pst.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return listeBien;
	}
	
	public Bien findBien(int id) {
		Bien bien = new Bien();
		CreerConnexion creerConnexion = new CreerConnexion();
		DaoProprietaire pDao = new DaoProprietaire();
		try {
				
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(
					" select * from bien where id = ?");
			pst.setInt(1, id);
			//Execute la requete
			ResultSet rs = pst.executeQuery();
			
			//affichage des resultat obtenus
			while(rs.next()) {
				//initialistaion du Bien
				
				bien.setId(rs.getInt("id"));
				bien.setAdresse(rs.getString(2));
				bien.setVille(rs.getString(3));
				bien.setNbrPiece(rs.getInt(4));
				bien.setSurface(rs.getFloat(5));
				bien.setType(rs.getString(6));

				int idProprietaire = rs.getInt(7);
				Proprietaire proprietaire = pDao.findProprietaire(idProprietaire);
				bien.setProprietaire(proprietaire);
				
				String etatBien = rs.getString(8);
				bien.setEtatBien(EtatBien.valueOf(etatBien));
				
			}
			
			creerConnexion.getCon().close();
			rs.close();
			pst.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return bien;
	}
	
	
	
	public void creerBien(Bien bien) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement("insert into bien(adresse, ville,"
					+ " nbrPiece, surface, type, id_proprietaire)" 
					+ "values(?, ?, ?, ?, ?,?)");
			pst.setString(1, bien.getAdresse());
			pst.setString(2, bien.getVille());
			pst.setInt(3, bien.getNbrPiece());
			pst.setFloat(4, bien.getSurface());
			pst.setString(5, bien.getType());
			pst.setInt(6, bien.getProprietaire().getId());
			
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("Insertion effectuee");
		
			
			
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	
	}
	
	public void modifierBien(Bien bien) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
		
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement("update bien set numCin = ? ,nom = ? ,"
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
			
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public void supprimerBien(Bien bien) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement("delete bien where id= ? "); 
			pst.setInt(1, bien.getId());
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
