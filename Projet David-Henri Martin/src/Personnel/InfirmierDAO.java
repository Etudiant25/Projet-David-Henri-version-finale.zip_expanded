package Personnel;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InfirmierDAO {

	private String url;
	private String login;
	private String password;
	private Connection cn;


	public InfirmierDAO(Connection conn) {
		this.cn=conn;
	}

	public Infirmier findById(int matricule) throws SQLException {
		Infirmier infirmier = new Infirmier();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM Infirmier WHERE id="+matricule);
		while(rs.next()) {
			infirmier= new Infirmier(matricule, rs.getString("pole"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs.getString("mail"), rs.getString("age"));
		}
		return infirmier;		
	}

	public Infirmier findByNom(String nom, String prenom) throws SQLException {
		Infirmier infirmier = new Infirmier();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM Infirmier WHERE nom="+nom+"AND prenom="+prenom);
		while(rs.next()) {
			infirmier= new Infirmier(rs.getInt("matricule"),rs.getString("pole"), nom, prenom, rs.getString("adresse"), rs.getString("mail"), rs.getString("age"));
		}
		return infirmier;		
	}


	public boolean createTABLE() throws SQLException {
		boolean bool=false;
		boolean bool2= false;
		Infirmier lesInfirmiers = new Infirmier();
		Statement stmt = cn.createStatement();
		if (!bool2) {
			int i = stmt.executeUpdate("CREATE TABLE Infirmier (Matricule INT PRIMARY KEY not NULL, Service VARCHAR(20), Nom VARCHAR(20), Prenom VARCHAR(20), Adresse VARCHAR(20), Mail VARCHAR(20), Age VARCHAR(3))");
			bool=true;
		}
		return bool;
	}	

	public boolean insereTUPLE(Infirmier infirmier) throws SQLException {
		String s = "INSERT into Infirmier values(?,?,?,?,?,?,?)";
		PreparedStatement ps = this.cn.prepareStatement(s);
		ps.setInt(1, infirmier.getIdMatricule());
		ps.setString(2, infirmier.getService());
		ps.setString(3, infirmier.getNom());
		ps.setString(4, infirmier.getPrenom());
		ps.setString(5, infirmier.getAdresse());
		ps.setString(6, infirmier.getMail());
		ps.setString(7, infirmier.getAge());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean deleteTUPLE(Infirmier infirmier) {
		boolean test=false;
		try {
			String req="DELETE FROM Infirmier WHERE nom=? AND prenom =? AND matricule=?";
			PreparedStatement ps = cn.prepareStatement(req);
			ps.setString(1, infirmier.getNom());
			ps.setString(2, infirmier.getPrenom());
			ps.setInt(3, infirmier.getIdMatricule());
			boolean bool=ps.execute();
			ps.close();
		}catch(SQLException e) {
			System.out.print("Personne inconnue"); // mettre dans une efenetre
		}
		return test;
	}

	public boolean updatePoleTuple(Infirmier infirmier) throws SQLException {
		String s="UPDATE Infirmier Poste= ? WHERE Matricule= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, infirmier.getService());
		ps.setInt(2, infirmier.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateNomTuple(Infirmier infirmier) throws SQLException {
		String s="UPDATE Infirmier SET Nom= ? WHERE Matricule= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, infirmier.getNom());
		ps.setInt(2, infirmier.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updatePrenomTuple(Infirmier infirmier) throws SQLException {
		String s="UPDATE Infirmier SET Prenom= ? WHERE Matricule= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, infirmier.getPrenom());
		ps.setInt(2, infirmier.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateMailTuple(Infirmier infirmier) throws SQLException {
		boolean test=false;
		String s="UPDATE Infirmier SET Mail=? WHERE Matricule =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, infirmier.getMail());
		ps.setInt(2, infirmier.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateAdresseTuple(Infirmier infirmier) throws SQLException {
		boolean test=false;
		String s="UPDATE Infirmier SET Adresse=? WHERE Matricule =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, infirmier.getAdresse());
		ps.setInt(2, infirmier.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateAageTuple(Infirmier infirmier) throws SQLException {
		boolean test=false;
		String s="UPDATE Infirmier SET Age=? WHERE Matricule =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, infirmier.getAge());
		ps.setInt(2, infirmier.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}
}
