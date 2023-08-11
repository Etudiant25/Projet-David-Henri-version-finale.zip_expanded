package Personnel;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KinesitherapeuteDAO {

	private String url;
	private String login;
	private String password;
	private Connection cn;


	public KinesitherapeuteDAO(Connection conn) {
		this.cn=conn;
	}

	public Kinesitherapeute findById(int matricule) throws SQLException {
		Kinesitherapeute kine = new Kinesitherapeute();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM Kinesitherapeute WHERE id="+matricule);
		while(rs.next()) {
			kine= new Kinesitherapeute(matricule, rs.getString("pole"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs.getString("mail"), rs.getString("age"));
		}
		return kine;		
	}

	public Kinesitherapeute findByNom(String nom, String prenom) throws SQLException {
		Kinesitherapeute kine = new Kinesitherapeute();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM Kinesitherapeute WHERE nom="+nom+"AND prenom="+prenom);
		while(rs.next()) {
			kine= new Kinesitherapeute(rs.getInt("matricule"),rs.getString("pole"), nom, prenom, rs.getString("adresse"), rs.getString("mail"), rs.getString("age"));
		}
		return kine;		
	}

	public boolean createTABLE() throws SQLException {
		boolean bool=false;
		boolean bool2= false;
		Kinesitherapeute lesKines = new Kinesitherapeute();
		Statement stmt = cn.createStatement();
		if (!bool2) {//numerotable a effacer
			int i = stmt.executeUpdate("CREATE TABLE Kinesitherapeute (Matricule INT PRIMARY KEY not NULL, Pole VARCHAR(20), Nom VARCHAR(20), Prenom VARCHAR(20), Adresse VARCHAR(20), Mail VARCHAR(20), Age VARCHAR(3))");
			bool=true;
		}
		return bool;
	}	

	public boolean insereTUPLE(Kinesitherapeute kine) throws SQLException {
		String s = "INSERT into Kinesitherapeute values(?,?,?,?,?,?,?)";
		PreparedStatement ps = this.cn.prepareStatement(s);
		ps.setInt(1, kine.getIdMatricule());
		ps.setString(2, kine.getPole());
		ps.setString(3, kine.getNom());
		ps.setString(4, kine.getPrenom());
		ps.setString(5, kine.getAdresse());
		ps.setString(6, kine.getMail());
		ps.setString(7, kine.getAge());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean deleteTUPLE(Kinesitherapeute kine) {
		boolean test=false;
		try {
			String req="DELETE FROM Kinesitherapeute WHERE nom=? AND prenom =? AND matricule=?";
			PreparedStatement ps = cn.prepareStatement(req);
			ps.setString(1, kine.getNom());
			ps.setString(2, kine.getPrenom());
			ps.setInt(3, kine.getIdMatricule());
			boolean bool=ps.execute();
			ps.close();
		}catch(SQLException e) {
			System.out.print("Personne inconnue");
		}
		return test;
	}

	public boolean updatePoleTuple(Kinesitherapeute kine) throws SQLException {
		String s="UPDATE Kinesitherapeute Poste= ? WHERE Matricule= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, kine.getPole());
		ps.setInt(2, kine.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateNomTuple(Kinesitherapeute kine) throws SQLException {
		String s="UPDATE Kinesitherapeute SET Nom= ? WHERE Matricule= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, kine.getNom());
		ps.setInt(2, kine.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updatePrenomTuple(Kinesitherapeute kine) throws SQLException {
		String s="UPDATE Kinesitherapeute SET Prenom= ? WHERE Matricule= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, kine.getPrenom());
		ps.setInt(2, kine.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateMailTuple(Kinesitherapeute kine) throws SQLException {
		boolean test=false;
		String s="UPDATE Kinesitherapeute SET Mail=? WHERE Matricule =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, kine.getMail());
		ps.setInt(2, kine.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateAdresseTuple(Kinesitherapeute kine) throws SQLException {
		boolean test=false;
		String s="UPDATE Kinesitherapeute SET Adresse=? WHERE Matricule =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, kine.getAdresse());
		ps.setInt(2, kine.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateAgeTuple(Kinesitherapeute kine) throws SQLException {
		boolean test=false;
		String s="UPDATE Kinesitherapeute SET Age=? WHERE Matricule =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, kine.getAge());
		ps.setInt(2, kine.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}
}
