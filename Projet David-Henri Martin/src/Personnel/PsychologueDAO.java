package Personnel;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PsychologueDAO {

	private String url;
	private String login;
	private String password;
	private Connection cn;

	public PsychologueDAO(Connection conn) {
		this.cn=conn;		
	}

	public Psychologue findByMatricule(int matricule) throws SQLException {
		Psychologue psychologue = new Psychologue();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM Psychologue WHERE id="+matricule);
		while(rs.next()) {
			psychologue= new Psychologue(matricule, rs.getString("Pole"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs.getString("mail"), rs.getString("age"));
		}
		return psychologue;		
	}

	public Psychologue findByNom(String nom, String prenom) throws SQLException {
		Psychologue psychologue = new Psychologue();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM Psychologue WHERE nom="+nom+"AND prenom="+prenom);
		while(rs.next()) {
			psychologue= new Psychologue(rs.getInt("matricule"), rs.getString("Pole"), nom, prenom, rs.getString("adresse"), rs.getString("mail"), rs.getString("age"));
		}
		return psychologue;		
	}

	public boolean createTABLE() throws SQLException {
		boolean bool=false;
		boolean bool2= false;
		Psychologue leFreud = new Psychologue();
		Statement stmt = cn.createStatement();
		if (!bool2) {
			int i = stmt.executeUpdate("CREATE TABLE Psychologue (matricule VARCHAR(20) PRIMARY KEY not NULL, servicePole VARCHAR(20), nom VARCHAR(20), prenom VARCHAR(20), adresse VARCHAR(20), mail VARCHAR(20), Age VARCHAR(3))");
			bool=true;
		}
		return bool;
	}	

	public boolean insereTUPLE(Psychologue psychologue) throws SQLException {
		String s = "INSERT into Psychologue values(?,?,?,?,?,?,?)";
		PreparedStatement ps = this.cn.prepareStatement(s);
		ps.setInt(1, psychologue.getIdMatricule());
		ps.setString(6, psychologue.getPole());
		ps.setString(2, psychologue.getNom());
		ps.setString(3, psychologue.getPrenom());
		ps.setString(4, psychologue.getAdresse());
		ps.setString(5, psychologue.getMail());
		ps.setString(7, psychologue.getAge());

		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean deleteTUPLE(Psychologue psychologue) {
		boolean test=false;
		try {
			String req="DELETE FROM Psychologue WHERE nom=? AND prenom =? AND matricule=?";
			PreparedStatement ps = cn.prepareStatement(req);
			ps.setString(1, psychologue.getNom());
			ps.setString(2, psychologue.getPrenom());
			ps.setInt(3, psychologue.getIdMatricule());
			boolean bool=ps.execute();
			ps.close();
		}catch(SQLException e) {
			System.out.print("Patient inconnu"); // mettre dans une efenetre
		}
		return test;
	}

	public boolean updateServicePoleTuple(Psychologue psychologue) throws SQLException {
		String s="UPDATE Psychologue SET Specialite= ? WHERE matricule= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, psychologue.getPole());
		ps.setInt(2, psychologue.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateNomTuple(Psychologue psychologue) throws SQLException {
		String s="UPDATE Psychologue SET Nom= ? WHERE matricule= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, psychologue.getNom());
		ps.setInt(2, psychologue.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updatePrenomTuple(Psychologue psychologue) throws SQLException {
		String s="UPDATE Psychologue SET Prenom= ? WHERE Matricule= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, psychologue.getPrenom());
		ps.setInt(2, psychologue.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateMailTuple(Psychologue psychologue) throws SQLException {
		boolean test=false;
		String s="UPDATE Psychologue SET Mail=? WHERE Matricule =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, psychologue.getMail());
		ps.setInt(2, psychologue.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateAdresseTuple(Psychologue psychologue) throws SQLException {
		boolean test=false;
		String s="UPDATE Psychologue SET Adresse=? WHERE Matricule =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, psychologue.getAdresse());
		ps.setInt(2, psychologue.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateAgeTuple(Psychologue psychologue) throws SQLException {
		boolean test=false;
		String s="UPDATE Psychologue SET Age? WHERE Matricule =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, psychologue.getAge());
		ps.setInt(2, psychologue.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}
}
