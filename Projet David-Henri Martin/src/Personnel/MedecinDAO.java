package Personnel;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Entree.Patient;

public class MedecinDAO {

	private String url;
	private String login;
	private String password;
	private Connection cn;

	public MedecinDAO(Connection conn) {
		this.cn=conn;		
	}

	public Medecin findByMatricule(int matricule) throws SQLException {
		Medecin medecin = new Medecin();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM Medecin WHERE id="+matricule);
		while(rs.next()) {
			medecin= new Medecin(matricule, rs.getString("specialite"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs.getString("mail"), rs.getString("age"));
		}
		return medecin;		
	}

	public Medecin findByNom(String nom, String prenom) throws SQLException {
		Medecin medecin = new Medecin();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM Medecin WHERE nom="+nom+"AND prenom="+prenom);
		while(rs.next()) {
			medecin= new Medecin(rs.getInt("matricule"), rs.getString("specialite"), nom, prenom, rs.getString("adresse"), rs.getString("mail"), rs.getString("age"));
		}
		return medecin;		
	}

	public boolean createTABLE() throws SQLException {
		boolean bool=false;
		boolean bool2= false;
		Medecin ledocteur = new Medecin();
		Statement stmt = cn.createStatement();
		if (!bool2) {
			int i = stmt.executeUpdate("CREATE TABLE Medecin (matricule VARCHAR(20) PRIMARY KEY not NULL, specialite VARCHAR(20), nom VARCHAR(20), prenom VARCHAR(20), adresse VARCHAR(20), mail VARCHAR(20), Age VARCHAR(3))");
			bool=true;
		}
		return bool;
	}	

	public boolean insereTUPLE(Medecin m) throws SQLException {
		String s = "INSERT into Medecin values(?,?,?,?,?,?,?)";
		PreparedStatement ps = this.cn.prepareStatement(s);
		ps.setInt(1, m.getIdMatricule());
		ps.setString(2, m.getSpecialite());
		ps.setString(3, m.getNom());
		ps.setString(4, m.getPrenom());
		ps.setString(5, m.getAdresse());
		ps.setString(6, m.getMail());
		ps.setString(7, m.getAge());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean deleteTUPLE(Medecin m) {
		boolean test=false;
		try {
			String req="DELETE FROM Medecin WHERE nom=? AND prenom =? AND matricule=?";
			PreparedStatement ps = cn.prepareStatement(req);
			ps.setString(1, m.getNom());
			ps.setString(2, m.getPrenom());
			ps.setInt(3, m.getIdMatricule());
			boolean bool=ps.execute();
			ps.close();
		}catch(SQLException e) {
			System.out.print("Patient inconnu"); // mettre dans une efenetre
		}
		return test;
	}

	public boolean updateSpecialiteTuple(Medecin m) throws SQLException {
		String s="UPDATE Medecin SET Specialite= ? WHERE matricule= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, m.getSpecialite());
		ps.setInt(2, m.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateNomTuple(Medecin m) throws SQLException {
		String s="UPDATE Medecin SET Nom= ? WHERE matricule= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, m.getNom());
		ps.setInt(2, m.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updatePrenomTuple(Medecin m) throws SQLException {
		String s="UPDATE Medecin SET Prenom= ? WHERE Matricule= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, m.getPrenom());
		ps.setInt(2, m.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateMailTuple(Medecin m) throws SQLException {
		boolean test=false;
		String s="UPDATE Medecin SET Mail=? WHERE Matricule =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, m.getMail());
		ps.setInt(2, m.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateAdresseTuple(Medecin m) throws SQLException {
		boolean test=false;
		String s="UPDATE Medecin SET Adresse=? WHERE Matricule =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, m.getAdresse());
		ps.setInt(2, m.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateAgeTuple(Medecin m) throws SQLException {
		boolean test=false;
		String s="UPDATE Medecin SET Age=? WHERE Matricule =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, m.getAge());
		ps.setInt(2, m.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}	
}
