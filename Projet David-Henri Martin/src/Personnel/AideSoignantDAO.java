package Personnel;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AideSoignantDAO {

	private String url;
	private String login;
	private String password;
	private Connection cn;


	public AideSoignantDAO(Connection conn) {
		this.cn=conn;
	}

	public AideSoignant findById(int matricule) throws SQLException {
		AideSoignant aideS = new AideSoignant();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM AideSoignant WHERE id="+matricule);
		while(rs.next()) {
			aideS= new AideSoignant(matricule, rs.getString("service"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs.getString("mail"), rs.getString("age"));
		}
		return aideS;		
	}

	public AideSoignant findByNom(String nom, String prenom) throws SQLException {
		AideSoignant aideS = new AideSoignant();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM AideSoignant WHERE nom="+nom+"AND prenom="+prenom);
		while(rs.next()) {
			aideS= new AideSoignant(rs.getInt("matricule"),rs.getString("service"), nom, prenom, rs.getString("adresse"), rs.getString("mail"), rs.getString("age"));
		}
		return aideS;		
	}

	public boolean createTABLE() throws SQLException {
		boolean bool=false;
		boolean bool2= false;
		AideSoignant lAS = new AideSoignant();
		Statement stmt = cn.createStatement();
		if (!bool2) {
			int i = stmt.executeUpdate("CREATE TABLE AideSoignant (Matricule INT PRIMARY KEY not NULL,Service VARCHAR(20), Nom VARCHAR(20), Prenom VARCHAR(20), Adresse VARCHAR(20), Mail VARCHAR(20), Age VARCHAR(3))");
			bool=true;
		}
		return bool;
	}	

	public boolean insereTUPLE(AideSoignant aideS) throws SQLException {
		String s = "INSERT into AideSoignant values(?,?,?,?,?,?,?)";
		PreparedStatement ps = this.cn.prepareStatement(s);
		ps.setInt(1, aideS.getIdMatricule());
		ps.setString(2, aideS.getService());
		ps.setString(3, aideS.getNom());
		ps.setString(4, aideS.getPrenom());
		ps.setString(5, aideS.getAdresse());
		ps.setString(6, aideS.getMail());
		ps.setString(7, aideS.getAge());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean deleteTUPLE(AideSoignant aideS) {
		boolean test=false;
		try {
			String req="DELETE FROM AideSoignant WHERE nom=? AND prenom =? AND matricule=?";
			PreparedStatement ps = cn.prepareStatement(req);
			ps.setString(1, aideS.getNom());
			ps.setString(2, aideS.getPrenom());
			ps.setInt(3, aideS.getIdMatricule());
			boolean bool=ps.execute();
			ps.close();
		}catch(SQLException e) {
			System.out.print("Patient inconnu"); // mettre dans une efenetre
		}
		return test;
	}

	public boolean updateServiceTuple(AideSoignant aideS) throws SQLException {
		String s="UPDATE AideSoignant SET Service= ? WHERE Matricule= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, aideS.getService());
		ps.setInt(2, aideS.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateNomTuple(AideSoignant aideS) throws SQLException {
		String s="UPDATE AideSoignant SET Nom= ? WHERE Matricule= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, aideS.getNom());
		ps.setInt(2, aideS.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updatePrenomTuple(AideSoignant aideS) throws SQLException {
		String s="UPDATE AideSoignant SET Prenom= ? WHERE Matricule= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, aideS.getPrenom());
		ps.setInt(2, aideS.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateMailTuple(AideSoignant aideS) throws SQLException {
		boolean test=false;
		String s="UPDATE AideSoignant SET Mail=? WHERE Matricule=?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, aideS.getMail());
		ps.setInt(2, aideS.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateAdresseTuple(AideSoignant aideS) throws SQLException {
		boolean test=false;
		String s="UPDATE AideSoignant SET Adresse=? WHERE Matricule =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, aideS.getAdresse());
		ps.setInt(2, aideS.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}	

	public boolean updateAgeTuple(AideSoignant aideS) throws SQLException {
		boolean test=false;
		String s="UPDATE agentDaccueil SET Age=? WHERE Matricule =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, aideS.getAge());
		ps.setInt(2, aideS.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}	
}
