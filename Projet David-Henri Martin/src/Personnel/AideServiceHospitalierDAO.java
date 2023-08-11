package Personnel;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AideServiceHospitalierDAO {

	private String url;
	private String login;
	private String password;
	private Connection cn;

	public AideServiceHospitalierDAO(Connection conn) {
		this.cn=conn;
	}

	public AideServiceHospitalier findById(int matricule) throws SQLException {
		AideServiceHospitalier ash = new AideServiceHospitalier();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM AideServiceHospitalier WHERE id="+matricule);
		while(rs.next()) {
			ash= new AideServiceHospitalier(matricule, rs.getString("pole"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs.getString("mail"), rs.getString("age"));
		}
		return ash;		
	}

	public AideServiceHospitalier findByNom(String nom, String prenom) throws SQLException {
		AideServiceHospitalier ash = new AideServiceHospitalier();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM AideServiceHospiatlier WHERE nom="+nom+"AND prenom="+prenom);
		while(rs.next()) {
			ash= new AideServiceHospitalier(rs.getInt("matricule"),rs.getString("pole"), nom, prenom, rs.getString("adresse"), rs.getString("mail"), rs.getString("age"));
		}
		return ash;		
	}

	public boolean createTABLE() throws SQLException {
		boolean bool=false;
		boolean bool2= false;
		AideServiceHospitalier femmeDeMenage = new AideServiceHospitalier();
		Statement stmt = cn.createStatement();
		if (!bool2) {
			int i = stmt.executeUpdate("CREATE TABLE AideServiceHospitalier (Matricule INT PRIMARY KEY not NULL, Service VARCHAR(20), Nom VARCHAR(20), Prenom VARCHAR(20), Adresse VARCHAR(20), Mail VARCHAR(20), Age VARCHAR(3))");
			bool=true;
		}
		return bool;
	}	

	public boolean insereTUPLE(AideServiceHospitalier ash) throws SQLException {
		String s = "INSERT into AideServiceHospitalier values(?,?,?,?,?,?,?)";
		PreparedStatement ps = this.cn.prepareStatement(s);
		ps.setInt(1, ash.getIdMatricule());
		ps.setString(2, ash.getService());
		ps.setString(3, ash.getNom());
		ps.setString(4, ash.getPrenom());
		ps.setString(5, ash.getAdresse());
		ps.setString(6, ash.getMail());
		ps.setString(7, ash.getAge());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean deleteTUPLE(AideServiceHospitalier ash) {
		boolean test=false;
		try {
			String req="DELETE FROM AideServiceHospitalier WHERE nom=? AND prenom =? AND matricule=?";
			PreparedStatement ps = cn.prepareStatement(req);
			ps.setString(1, ash.getNom());
			ps.setString(2, ash.getPrenom());
			ps.setInt(3, ash.getIdMatricule());
			boolean bool=ps.execute();
			ps.close();
		}catch(SQLException e) {
			System.out.print("Personne inconnue"); // mettre dans une efenetre
		}
		return test;
	}

	public boolean updatePoleTuple(AideServiceHospitalier ash) throws SQLException {
		String s="UPDATE AideServiceHospitalier Poste= ? WHERE Matricule= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, ash.getService());
		ps.setInt(2, ash.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateNomTuple(AideServiceHospitalier ash) throws SQLException {
		String s="UPDATE AideServiceHospitalier SET Nom= ? WHERE Matricule= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, ash.getNom());
		ps.setInt(2, ash.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updatePrenomTuple(AideServiceHospitalier ash) throws SQLException {
		String s="UPDATE AideServiceHospitalier SET Prenom= ? WHERE Matricule= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, ash.getPrenom());
		ps.setInt(2, ash.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateMailTuple(AideServiceHospitalier ash) throws SQLException {
		boolean test=false;
		String s="UPDATE AideServiceHospitalier SET Mail=? WHERE Matricule =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, ash.getMail());
		ps.setInt(2, ash.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateAdresseTuple(AideServiceHospitalier ash) throws SQLException {
		boolean test=false;
		String s="UPDATE AideServiceHospitalier SET Adresse=? WHERE Matricule =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, ash.getAdresse());
		ps.setInt(2, ash.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateAgeTuple(AideServiceHospitalier ash) throws SQLException {
		boolean test=false;
		String s="UPDATE AideServiceHospitalier SET Age=? WHERE Matricule =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, ash.getAge());
		ps.setInt(2, ash.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}
}
