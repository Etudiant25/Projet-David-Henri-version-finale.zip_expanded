package Personnel;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DirectionDAO {

	private String url;
	private String login;
	private String password;
	private Connection cn;


	public DirectionDAO(Connection conn) {
		this.cn=conn;
	}

	public Direction findById(int matricule) throws SQLException {
		Direction dirigeant = new Direction();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM Direction WHERE id="+matricule);
		while(rs.next()) {
			dirigeant= new Direction(matricule, rs.getString("poste"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs.getString("mail"), rs.getString("age"));
		}
		return dirigeant;		
	}

	public Direction findByNom(String nom, String prenom) throws SQLException {
		Direction dirigeant = new Direction();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM Diection WHERE nom="+nom+"AND prenom="+prenom);
		while(rs.next()) {
			dirigeant= new Direction(rs.getInt("matricule"),rs.getString("poste"), nom, prenom, rs.getString("adresse"), rs.getString("mail"), rs.getString("age"));
		}
		return dirigeant;		
	}

	public boolean createTABLE() throws SQLException {
		boolean bool=false;
		boolean bool2= false;
		Direction LesDirigeants = new Direction();
		Statement stmt = cn.createStatement();
		if (!bool2) {
			int i = stmt.executeUpdate("CREATE TABLE Direction (Matricule INT PRIMARY KEY not NULL, Poste VARCHAR(20), Nom VARCHAR(20), Prenom VARCHAR(20), Adresse VARCHAR(20), Mail VARCHAR(20), Age VARCHAR(3))");
			bool=true;
		}
		return bool;
	}	

	public boolean insereTUPLE(Direction direction) throws SQLException {
		String s = "INSERT into Direction values(?,?,?,?,?,?,?)";
		PreparedStatement ps = this.cn.prepareStatement(s);
		ps.setInt(1, direction.getIdMatricule());
		ps.setString(2, direction.getPoste());
		ps.setString(3, direction.getNom());
		ps.setString(4, direction.getPrenom());
		ps.setString(5, direction.getAdresse());
		ps.setString(6, direction.getMail());
		ps.setString(7, direction.getAge());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean deleteTUPLE(Direction dirigeant) {
		boolean test=false;
		try {
			String req="DELETE FROM Direction WHERE nom=? AND prenom =? AND matricule=?";
			PreparedStatement ps = cn.prepareStatement(req);
			ps.setString(1, dirigeant.getNom());
			ps.setString(2, dirigeant.getPrenom());
			ps.setInt(3, dirigeant.getIdMatricule());
			boolean bool=ps.execute();
			ps.close();
		}catch(SQLException e) {
			System.out.print("Personne inconnue"); // mettre dans une efenetre
		}
		return test;
	}

	public boolean updatePosteTuple(Direction dirigeant) throws SQLException {
		String s="UPDATE Direction Poste= ? WHERE Matricule= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, dirigeant.getPoste());
		ps.setInt(2, dirigeant.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateNomTuple(Direction dirigeant) throws SQLException {
		String s="UPDATE Direction SET Nom= ? WHERE Matricule= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, dirigeant.getNom());
		ps.setInt(2, dirigeant.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updatePrenomTuple(Direction dirigeant) throws SQLException {
		String s="UPDATE Direction SET Prenom= ? WHERE Matricule= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, dirigeant.getPrenom());
		ps.setInt(2, dirigeant.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateMailTuple(Direction dirigeant) throws SQLException {
		boolean test=false;
		String s="UPDATE Direction SET Mail=? WHERE Matricule =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, dirigeant.getMail());
		ps.setInt(2, dirigeant.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateAdresseTuple(Direction dirigeant) throws SQLException {
		boolean test=false;
		String s="UPDATE Direction SET Adresse=? WHERE Matricule =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, dirigeant.getAdresse());
		ps.setInt(2, dirigeant.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateAgeTuple(Direction dirigeant) throws SQLException {
		boolean test=false;
		String s="UPDATE agentDaccueil SET Age=? WHERE Matricule =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, dirigeant.getAge());
		ps.setInt(2, dirigeant.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}	
}
