package Personnel;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AgentDaccueilDAO {


	private String url;
	private String login;
	private String password;
	private Connection cn;

	public AgentDaccueilDAO(Connection conn) {
		this.cn=conn;
	}

	public AgentDaccueil findById(int matricule) throws SQLException {
		AgentDaccueil agentDaccueil = new AgentDaccueil();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM agentDaccueil WHERE id="+matricule);
		while(rs.next()) {
			agentDaccueil= new AgentDaccueil(matricule, rs.getString("role"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs.getString("mail"), rs.getString("age"));
		}
		return agentDaccueil;		
	}

	public AgentDaccueil findByNom(String nom, String prenom) throws SQLException {
		AgentDaccueil agentDaccueil = new AgentDaccueil();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM agentDaccueil WHERE nom="+nom+"AND prenom="+prenom);
		while(rs.next()) {
			agentDaccueil= new AgentDaccueil(rs.getInt("idMatricule"), rs.getString("role"),  nom, prenom, rs.getString("adresse"), rs.getString("mail"), rs.getString("age"));
		}
		return agentDaccueil;		
	}	

	public boolean createTABLE() throws SQLException {
		boolean bool=false;
		boolean bool2= false;
		AgentDaccueil lagent = new AgentDaccueil();
		Statement stmt = cn.createStatement();
		if (!bool2) {
			int i = stmt.executeUpdate("CREATE TABLE AgentDaccueil (idMatricule INT PRIMARY KEY not NULL, Role VARCHAR(20), Nom VARCHAR(20), Prenom VARCHAR(20), Adresse VARCHAR(30), Mail VARCHAR(20), Age VARCHAR(3))");
			bool=true;
		}
		return bool;
	}	

	public boolean insereTUPLE(AgentDaccueil agent) throws SQLException {
		String s = "INSERT into agentDaccueil values(?,?,?,?,?,?,?)";
		PreparedStatement ps = this.cn.prepareStatement(s);
		ps.setInt(1, agent.getIdMatricule());
		ps.setString(2, agent.getRole());
		ps.setString(3, agent.getNom());
		ps.setString(4, agent.getPrenom());
		ps.setString(5, agent.getAdresse());
		ps.setString(6, agent.getMail());
		ps.setString(7, agent.getAge());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean deleteTUPLE(AgentDaccueil agent) {
		boolean test=false;
		try {
			String req="DELETE FROM agentDaccueil WHERE nom=? AND prenom =? AND matricule=?";
			PreparedStatement ps = cn.prepareStatement(req);
			ps.setString(1, agent.getNom());
			ps.setString(2, agent.getPrenom());
			ps.setInt(3, agent.getIdMatricule());
			boolean bool=ps.execute();
			ps.close();
		}catch(SQLException e) {
			System.out.print("Patient inconnu"); // mettre dans une efenetre
		}
		return test;
	}

	public boolean updateRoleTuple(AgentDaccueil agent) throws SQLException {
		String s="UPDATE agentDaccueil SET Nom= ? WHERE Matricule= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, agent.getRole());
		ps.setInt(2, agent.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateNomTuple(AgentDaccueil agent) throws SQLException {
		String s="UPDATE agentDaccueil SET Nom= ? WHERE Matricule= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, agent.getNom());
		ps.setInt(2, agent.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updatePrenomTuple(AgentDaccueil agent) throws SQLException {
		String s="UPDATE agentDaccueil SET Prenom= ? WHERE Matricule= ?";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setString(1, agent.getPrenom());
		ps.setInt(2, agent.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateMailTuple(AgentDaccueil agent) throws SQLException {
		boolean test=false;
		String s="UPDATE agentDaccueil SET Mail=? WHERE Matricule =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, agent.getMail());
		ps.setInt(2, agent.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateAdresseTuple(AgentDaccueil agent) throws SQLException {
		boolean test=false;
		String s="UPDATE agentDaccueil SET Adresse=? WHERE Matricule =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, agent.getAdresse());
		ps.setInt(2, agent.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateAgeTuple(AgentDaccueil agent) throws SQLException {
		boolean test=false;
		String s="UPDATE agentDaccueil SET Age=? WHERE Matricule =?";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, agent.getAge());
		ps.setInt(2, agent.getIdMatricule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}
}
