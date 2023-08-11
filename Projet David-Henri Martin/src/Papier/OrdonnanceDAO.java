package Papier;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Entree.Patient;
import Personnel.AgentDaccueil;

public class OrdonnanceDAO {



	private String url;
	private String login;
	private String password;
	private Connection cn;

	public OrdonnanceDAO(Connection conn) {
		this.cn=conn;
	}

	public boolean createTABLE() throws SQLException {
		boolean bool=false;
		boolean bool2= false;
		AgentDaccueil lagent = new AgentDaccueil();
		Statement stmt = cn.createStatement();
		if (!bool2) {
			int i = stmt.executeUpdate("CREATE TABLE Ordonnance (idOrdonnance INT PRIMARY KEY not NULL, idPatient INT, Nom VARCHAR(20), Prenom VARCHAR(20), nomMedecin VARCHAR(20), Injection VARCHAR(20), Comprimes VARCHAR(20), Pansement VARCHAR(20), Exercice VARCHAR(20), Materiel VARCHAR (50), Operation VARCHAR (20), Observation VARCHAR(500), ECG BIT, Prisedetension BIT, Date DATE)");
			bool=true;
		}
		return bool;
	}	

	public Ordonnance findById(int idOrdonnance) throws SQLException {
		Ordonnance ordonnance = new Ordonnance();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM Patient WHERE id="+idOrdonnance);
		while(rs.next()) {
			ordonnance= new Ordonnance(idOrdonnance, rs.getInt("idPatient"), rs.getString("Nom"), rs.getString("Prenom"), rs.getString("nomMedecin"), rs.getString("Injection"), rs.getString("Comprimes"), rs.getString("Pansement"), rs.getString("Exercice"), rs.getString("Materiel"), rs.getString("Operation"), rs.getString("Observation"), rs.getBoolean("ECG"), rs.getBoolean("Prisedetension"), rs.getDate("date"));
		}
		return ordonnance;		
	}

	public Patient findByNom(String nom, String prenom) throws SQLException {
		Ordonnance ordonnance = new Ordonnance();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM Patient WHERE nom='"+nom+"'AND prenom = '"+prenom+"'");
		while(rs.next()) {
			ordonnance= new Ordonnance(rs.getInt("idOrdonnance"), rs.getInt("idPatient"), nom, prenom, rs.getString("nomMedecin"), rs.getString("Injection"), rs.getString("Comprimes"), rs.getString("Pansement"), rs.getString("Exercice"), rs.getString("Materiel"), rs.getString("Operation"), rs.getString("Observation"), rs.getBoolean("ECG"), rs.getBoolean("Prisedetension"), rs.getDate("date"));
		}
		return ordonnance;		
	}

	public boolean insereTUPLE(Ordonnance ordonnance) throws SQLException {
		String s = "INSERT into Ordonnance values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = this.cn.prepareStatement(s);
		ps.setInt(1, ordonnance.getIdOrdonnance());
		ps.setInt(2, ordonnance.getIdPatient());
		ps.setString(3, ordonnance.getNom());
		ps.setString(4, ordonnance.getPrenom());
		ps.setString(5, ordonnance.getNomMedecin());
		ps.setString(6, ordonnance.getPiqure());
		ps.setString(7, ordonnance.getPillule());
		ps.setString(8, ordonnance.getPansement());
		ps.setString(9, ordonnance.getExercice());
		ps.setString(10, ordonnance.getMateriel());
		ps.setString(11, ordonnance.getOperation());
		ps.setString(12, ordonnance.getObservation());
		ps.setBoolean(13, ordonnance.isECG());
		ps.setBoolean(14, ordonnance.isPrisedetension());
		ps.setDate(15,  (java.sql.Date) ordonnance.getDate());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean deleteTUPLE(Ordonnance ordonnance) {
		boolean test=false;
		try {
			String req="DELETE FROM Ordonnance WHERE IdOrdonnance=?";
			PreparedStatement ps = cn.prepareStatement(req);
			ps.setInt(1, ordonnance.getIdOrdonnance());
			boolean bool=ps.execute();
			ps.close();
		}catch(SQLException e) {
			System.out.print("Patient inconnu"); // mettre dans une efenetre
		}
		return test;
	}

	public boolean updateIdConsultation(Ordonnance ordonnance, String nom, String prenom) throws SQLException {
		String s="UPDATE Ordonnance SET IdConsulation= ? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setInt(1, ordonnance.getIdOrdonnance());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}


	public boolean updateIdPatient(Ordonnance ordonnance, String nom, String prenom) throws SQLException {
		String s="UPDATE Ordonnance SET IdPatient= ? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setInt(1, ordonnance.getIdPatient());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateNom(Ordonnance ordonnance, String nom, String prenom) throws SQLException {
		String s="UPDATE Ordonnance SET Nom= ? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, ordonnance.getNom());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updatePrenom(Ordonnance ordonnance, String nom, String prenom) throws SQLException {
		String s="UPDATE Ordonnance SET Prenom= ? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, ordonnance.getPrenom());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}	


	public boolean updateNomMedecin(Ordonnance ordonnance, String nom, String prenom) throws SQLException {
		String s="UPDATE Ordonnance SET nomMedecin=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, ordonnance.getNomMedecin());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updatePiqure(Ordonnance ordonnance, String nom, String prenom) throws SQLException {
		String s="UPDATE Ordonnance SET Piqure=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, ordonnance.getPiqure());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updatePillule(Ordonnance ordonnance, String nom, String prenom) throws SQLException {
		String s="UPDATE Ordonnance SET Pillule=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, ordonnance.getPillule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updatePansement(Ordonnance ordonnance, String nom, String prenom) throws SQLException {
		String s="UPDATE Ordonnance SET Pansement=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, ordonnance.getPansement());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateExercice(Ordonnance ordonnance, String nom, String prenom) throws SQLException {
		String s="UPDATE Ordonnance SET Exercice=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, ordonnance.getExercice());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateMateriel(Ordonnance ordonnance, String nom, String prenom) throws SQLException {
		String s="UPDATE Ordonnance SET Materiel=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, ordonnance.getMateriel());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateOperation(Ordonnance ordonnance, String nom, String prenom) throws SQLException {
		String s="UPDATE Ordonnance SET Operation=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, ordonnance.getOperation());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateObservation(Ordonnance ordonnance, String nom, String prenom) throws SQLException {
		String s="UPDATE Ordonnance SET Observation=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, ordonnance.getObservation());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateECG(Ordonnance ordonnance, String nom, String prenom) throws SQLException {
		String s="UPDATE Ordonnance SET ECG=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setBoolean(1, ordonnance.isECG());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updatePrisedeTension(Ordonnance ordonnance, String nom, String prenom) throws SQLException {
		String s="UPDATE Ordonnance SET Prisedetension=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setBoolean(1, ordonnance.isPrisedetension());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}



	public String afficherOrdonnance(String nom, String prenom) throws SQLException {
		String Ordo="";
		Statement stmt = cn.createStatement();		
		Ordo = "SELECT Injection, Comprimes, Pansement, Exercice, Materiel, Operation, Observation, ECG, Prisedetension FROM Ordonnance WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		ResultSet rs1 = stmt.executeQuery(Ordo);
		String newLine = System.getProperty("line.separator");
		while (rs1.next()) { 
			String collone1= rs1.getString(1);	
			String collone2= rs1.getString(2);
			String collone3= rs1.getString(3);
			String collone4= rs1.getString(4);
			String collone6= rs1.getString(6);
			String collone7= rs1.getString(7);
			boolean collone8 = rs1.getBoolean(8);
			boolean collone9 = rs1.getBoolean(9);
			Ordo="Injection"+" "+collone1+newLine+"Comprimes"+" "+collone2+newLine+"Pansement"+" "+collone3+newLine+"Exercice"+" "+collone4+newLine+"Operation"+" "+collone6+newLine+"Observation"+" "+collone7+newLine+"ECG"+" "+collone8+newLine+"Prisedetension"+" "+collone9;
		}
		return Ordo;
	}	
}
