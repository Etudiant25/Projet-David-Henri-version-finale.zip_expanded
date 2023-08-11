package Entree;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Personnel.AgentDaccueil;

public class AntecedentDAO {

	private String url;
	private String login;
	private String password;
	private Connection cn;


	public AntecedentDAO(Connection conn) {
		this.cn=conn;
	}

	public Antecedents findById(int idDuPatient) throws SQLException {
		Antecedents antecedent = new Antecedents();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM Antecedents WHERE id="+idDuPatient);
		while(rs.next()) {
			antecedent= new Antecedents(idDuPatient, rs.getString("Nom"), rs.getString("Prenom"), rs.getString("Handicap"), rs.getString("Operation"), rs.getString("Addiction"),rs.getString("MaladieChronique"), rs.getString("MaladiePeau"), rs.getString("MaladieOrganique"), rs.getString("MaladieInfectieuse"), rs.getDate("date"));
		}
		return antecedent;		
	}

	public Antecedents findByNom(String nom, String prenom) throws SQLException {
		Antecedents antecedent = new Antecedents();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT idDuPatient FROM Antecedents WHERE nom=? and prenom=?");
		while(rs.next()) {
			antecedent= new Antecedents(rs.getInt("idDuPatient"), nom, prenom, rs.getString("Handicap"), rs.getString("Operation"), rs.getString("Addiction"),rs.getString("MaladieChronique"), rs.getString("MaladiePeau"), rs.getString("MaladieOrganique"), rs.getString("MaladieInfectieuse"), rs.getDate("date"));
		}
		return antecedent;		
	}

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
		Antecedents ante = new Antecedents();
		Statement stmt = cn.createStatement();
		if (!bool2) {
			int i = stmt.executeUpdate("CREATE TABLE Antecedents (idDuPatient INT PRIMARY KEY not NULL, nom VARCHAR(20), prenom VARCHAR(20), Handicap VARCHAR(30), Operation VARCHAR(20), Addiction VARCHAR(20), MaladieChronique VARCHAR(20), MaladiePeau VARCHAR(20), MaladieOrganique VARCHAR(20), MaladieInfectieuse VARCHAR(20), Date DATE)");
			bool=true;
		}
		return bool;
	}		

	public boolean insereTUPLE(Antecedents antecedent) throws SQLException {
		String s = "INSERT into Antecedents values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = this.cn.prepareStatement(s);
		ps.setInt(1, antecedent.getIdDuPatient());
		ps.setString(2, antecedent.getNom());
		ps.setString(3, antecedent.getPrenom());
		ps.setString(4, antecedent.getHandicap());
		ps.setString(5, antecedent.getOperation());
		ps.setString(6, antecedent.getAddiction());
		ps.setString(7, antecedent.getMaladieChronique());
		ps.setString(8, antecedent.getMaladiePeau());
		ps.setString(9, antecedent.getMaladieOrganique());
		ps.setString(10, antecedent.getMaladieInfectieuse());
		ps.setDate(11,  (java.sql.Date) antecedent.getDate());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean deleteTUPLE(Antecedents antecedent) {
		boolean test=false;
		try {
			String req="DELETE FROM Antecedents WHERE IdReal=?";
			PreparedStatement ps = cn.prepareStatement(req);
			ps.setInt(1, antecedent.getIdDuPatient());
			boolean bool=ps.execute();
			ps.close();
		}catch(SQLException e) {
			System.out.print("Patient inconnu");
		}
		return test;
	}

	public boolean updateHandicapTuple(Antecedents antecedent, String nom, String prenom) throws SQLException {
		String s="UPDATE Antecedents SET Handicap= ? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, antecedent.getHandicap());
		ps.setInt(2, antecedent.getIdDuPatient());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateOperationTuple(Antecedents antecedent, String nom, String prenom) throws SQLException {
		String s="UPDATE Antecedents SET Operation= ? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, antecedent.getOperation());
		ps.setInt(2, antecedent.getIdDuPatient());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateAddictionTuple(Antecedents antecedent, String nom, String prenom) throws SQLException {
		String s="UPDATE Antecedents SET Addiction= ? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, antecedent.getAddiction());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateMaladieChroniqueTuple(Antecedents antecedent, String nom, String prenom) throws SQLException {
		boolean test=false;
		String s="UPDATE Antecedents SET MaladieChronique=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, antecedent.getMaladieChronique());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateMaladiePeauTuple(Antecedents antecedent, String nom, String prenom) throws SQLException {
		boolean test=false;
		String s="UPDATE Antecedents SET MaladiePeau=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, antecedent.getMaladiePeau());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateMaladieOrganiqueTuple(Antecedents antecedent, String nom, String prenom) throws SQLException {
		boolean test=false;
		String s="UPDATE Antecedents SET MaladieOrganique=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, antecedent.getMaladieOrganique());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public String afficherAntecedents(String nom, String prenom) throws SQLException {
		String ante="";
		Statement stmt = cn.createStatement();		
		String ante1 = "SELECT Handicap, Operation, Addiction, MaladieChronique, MaladiePeau, MaladieOrganique, MaladieInfectieuse FROM Antecedents WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		ResultSet rs1 = stmt.executeQuery(ante1);
		String newLine = System.getProperty("line.separator");
		while (rs1.next()) { 
			String collone4= rs1.getString(1);	
			String collone5= rs1.getString(2);
			String collone6= rs1.getString(3);	
			String collone7= rs1.getString(4);	
			String collone8= rs1.getString(5);		
			String collone9= rs1.getString(6);		
			String collone10= rs1.getString(7);
			ante="Handicap"+" "+collone4+newLine+"Operation"+" "+collone5+newLine+"Addiction"+" "+collone6+newLine+"Maladie Chronique"+" "+collone7+newLine+"Maladie de Peau"+" "+collone8+newLine+"Maladie Organique"+" "+collone9+newLine+"Maladie Infectieuse"+" "+collone10;
		}
		return ante;
	}
}
