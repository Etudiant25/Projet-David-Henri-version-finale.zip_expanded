package Entree;


import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class PatientDAO {


	private String url;
	private String login;
	private String password;
	private Connection cn;


	public PatientDAO(Connection conn) {
		this.cn=conn;
	}

	public Patient findById(int idPatient) throws SQLException {
		Patient patient = new Patient();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM Patient WHERE id="+idPatient);
		while(rs.next()) {
			patient= new Patient(idPatient, rs.getString("nom"), rs.getString("prenom"), rs.getString("numero"), rs.getString("adresse"), rs.getString("mail"), rs.getString("age"), rs.getDate("date"));
		}
		return patient;		
	}

	public Patient findByNom(String nom, String prenom) throws SQLException {
		Patient patient = new Patient();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM Patient WHERE nom='"+nom+"'AND prenom = '"+prenom+"'");
		while(rs.next()) {
			patient= new Patient(rs.getInt("idPatient"), nom, prenom, rs.getString("numero"), rs.getString("adresse"), rs.getString("mail"), rs.getString("age"), rs.getDate("date"));
		}
		return patient;		
	}

	//TrouverIdDUpatient

	public int TrouverIdDuPatient(String nom, String prenom) throws SQLException{
		int id=0;
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT idPatient FROM Patient WHERE nom='"+nom+"'AND prenom = '"+prenom+"'");
		while (rs.next()) { 
			int id1 = rs.getInt(1);
			id=id1;
		}
		return id;
	}

	public boolean createTABLE() throws SQLException {
		boolean bool=false;
		boolean bool2= false;
		Patient lemegapatient = new Patient();
		Statement stmt = cn.createStatement();
		if (!bool2) {
			int i = stmt.executeUpdate("CREATE TABLE Patient (idPatient INT PRIMARY KEY not NULL, Nom VARCHAR(20), Prenom VARCHAR(20), Numero VARCHAR(20), Adresse VARCHAR(20),Mail VARCHAR(20), Age VARCHAR(3), Date DATE)");
			bool=true;
		}
		return bool;
	}	

	public boolean insereTUPLE(Patient p) throws SQLException {
		String s = "INSERT into Patient values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = this.cn.prepareStatement(s);
		ps.setInt(1, p.getIdPatient());
		ps.setString(2, p.getNom());
		ps.setString(3, p.getPrenom());
		ps.setString(4, p.getNumero());
		ps.setString(5, p.getAdresse());
		ps.setString(6, p.getMail());
		ps.setString(7, p.getAge());
		ps.setDate(8,  (java.sql.Date) p.getDate());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean deleteTUPLE(Patient p) {
		boolean test=false;
		try {
			String req="DELETE FROM Patient WHERE nom=? AND prenom =? AND idPatient=?";
			PreparedStatement ps = cn.prepareStatement(req);
			ps.setString(1, p.getNom());
			ps.setString(2, p.getPrenom());
			ps.setInt(3, p.getIdPatient());
			boolean bool=ps.execute();
			ps.close();
		}catch(SQLException e) {
			System.out.print("Patient inconnu");
		}
		return test;
	}

	public boolean updateNomTuple(Patient p, int id) throws SQLException {
		String s="UPDATE Patient SET Nom= ? WHERE idPatient= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, p.getNom());
		ps.setInt(2, p.getIdPatient());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updatePrenomTuple(Patient p, int id) throws SQLException {
		String s="UPDATE Patient SET Prenom= ? WHERE idPatient= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, p.getPrenom());
		ps.setInt(2, p.getIdPatient());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateNumeroTuple(Patient p, int id) throws SQLException {
		boolean test=false;
		String s="UPDATE Patient SET Numero=? WHERE idPatient =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, p.getNumero());
		ps.setInt(2, p.getIdPatient());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateMailTuple(Patient p, int id) throws SQLException {
		boolean test=false;
		String s="UPDATE Patient SET Mail=? WHERE idPatient =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, p.getMail());
		ps.setInt(2, p.getIdPatient());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateAdresseTuple(Patient p, int id) throws SQLException {
		boolean test=false;
		String s="UPDATE Patient SET Adresse=? WHERE idPatient =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, p.getAdresse());
		ps.setInt(2, p.getIdPatient());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateAgeTuple(Patient p, int id) throws SQLException {
		String s="UPDATE Patient SET Age= ? WHERE idPatient= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, p.getNom());
		ps.setInt(2, p.getIdPatient());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}
}
