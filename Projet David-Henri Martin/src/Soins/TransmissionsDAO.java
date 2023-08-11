package Soins;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Entree.Antecedents;
import Entree.Patient;
import Papier.Ordonnance;
import Personnel.AgentDaccueil;

public class TransmissionsDAO {


	private String url;
	private String login;
	private String password;
	private Connection cn;

	public TransmissionsDAO(Connection conn) {
		this.cn=conn;
	}

	public Transmissions findById(int idPatient) throws SQLException {
		Transmissions transmission = new Transmissions();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM Transmission WHERE id="+idPatient);
		while(rs.next()) {
			transmission= new Transmissions(rs.getInt ("idTransmission"),idPatient, rs.getString("nom"), rs.getString("Prenom"), rs.getBoolean("ECG"), rs.getBoolean("PrisedeTension"), rs.getBoolean("Injection"), rs.getBoolean("Pillule"),rs.getBoolean("Pansement"), rs.getBoolean("Escarre"), rs.getBoolean("Toilette"), rs.getString("Observation"), rs.getString("nomdusoignant"), rs.getDate("date"));
		}
		return transmission;		
	}

	public Transmissions findByNom(String nom, String prenom) throws SQLException {
		Transmissions transmission = new Transmissions();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM Transmission WHERE nom='"+nom+"'AND prenom='"+prenom+"'");//"SELECT * FROM Transmission WHERE nom=? AND prenom=?"
		while(rs.next()) {
			transmission= new Transmissions(rs.getInt ("idTransmission"),rs.getInt("idPatient"), nom, prenom, rs.getBoolean("ECG"), rs.getBoolean("PrisedeTension"), rs.getBoolean("Injection"), rs.getBoolean("Pillule"),rs.getBoolean("Pansement"), rs.getBoolean("Escarre"), rs.getBoolean("Toilette"), rs.getString("Observation"), rs.getString("nomdusoignant"), rs.getDate("date"));
		}
		return transmission;		
	}



	public boolean createTABLE() throws SQLException {
		boolean bool=false;
		boolean bool2= false;
		Statement stmt = cn.createStatement();
		if (!bool2) {
			int i = stmt.executeUpdate("CREATE TABLE Transmission (idTransmission INT PRIMARY KEY not NULL, idPatient INT, Nom VARCHAR(10), Prenom VARCHAR(10), ECG BIT, PrisedeTension BIT, Injection BIT, Pillule BIT, Pansement BIT, Escarre BIT, Toilette BIT, Observation VARCHAR(2000), NomduSoignant VARCHAR(30), Date DATE)");
			bool=true;
		}
		return bool;
	}	

	public boolean insereTUPLE(Transmissions transmission) throws SQLException {
		String s = "INSERT into Transmission values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = this.cn.prepareStatement(s);
		ps.setInt(1, transmission.getIdTransmission());
		ps.setInt(2, transmission.getIdPatient());
		ps.setString(3, transmission.getNom());
		ps.setString(4, transmission.getPrenom());
		ps.setBoolean(5, transmission.isECG());
		ps.setBoolean(6, transmission.isPrisedeTension());
		ps.setBoolean(7, transmission.isInjection());
		ps.setBoolean(8, transmission.isPillule());
		ps.setBoolean(9, transmission.isPansement());
		ps.setBoolean(10, transmission.isEscarre());
		ps.setBoolean(11, transmission.isToilette());
		ps.setString(12, transmission.getObservation());
		ps.setString(13, transmission.getNomdusoignant());
		ps.setDate(14, (java.sql.Date) transmission.getDate());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean deleteTUPLE(Transmissions transmission) {
		boolean test=false;
		try {
			String req="DELETE FROM Transmission WHERE IdPatient=?";
			PreparedStatement ps = cn.prepareStatement(req);
			ps.setInt(1, transmission.getIdPatient());
			boolean bool=ps.execute();
			ps.close();
		}catch(SQLException e) {
			System.out.print("Patient inconnu"); 
		}
		return test;
	}

	public boolean updateECGTuple(Transmissions transmissions, String nom, String prenom) throws SQLException {

		String s="UPDATE Transmission SET ECG=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setBoolean(1, transmissions.isECG());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updatePriseDeTensionTuple(Transmissions transmission , String nom, String prenom) throws SQLException {
		String s="UPDATE Transmission SET PrisedeTension=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setBoolean(1, transmission.isPrisedeTension());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateInjectionTuple(Transmissions transmission, String nom, String prenom) throws SQLException {
		String s="UPDATE Transmission SET Injection=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setBoolean(1, transmission.isInjection());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updatePilluleTuple(Transmissions transmission, String nom, String prenom) throws SQLException {
		String s="UPDATE Transmission SET Pillule=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setBoolean(1, transmission.isPillule());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updatePansementTuple(Transmissions transmission, String nom, String prenom) throws SQLException {
		boolean test=false;
		String s="UPDATE Transmission SET Pansement=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setBoolean(1, transmission.isPansement());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateEscarreTuple(Transmissions transmission, String nom, String prenom) throws SQLException {
		boolean test=false;
		String s="UPDATE Transmission SET Escarre=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'" ;
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setBoolean(1, transmission.isEscarre());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateToiletteTuple(Transmissions transmission, String nom, String prenom) throws SQLException {
		boolean test=false;
		String s="UPDATE Transmission SET Toilette=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setBoolean(1, transmission.isToilette());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateObservationTuple(Transmissions transmission, String nom, String prenom) throws SQLException {
		boolean test=false;
		String s="UPDATE Transmission SET Observation=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setString(1, transmission.getObservation());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public String TransmissionEquipeDavant(String nom, String prenom) throws SQLException {
		String Transmi="";
		Statement stmt = cn.createStatement();		
		String Transmi1 = "SELECT Observation FROM Transmission WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		ResultSet rs1 = stmt.executeQuery(Transmi1);
		while (rs1.next()) { 
			String collone1= rs1.getString(1);
			Transmi="Observation"+": "+collone1;
		}
		return Transmi;
	}

	public String afficherTransmissionInfirmier(String nom, String prenom) throws SQLException {
		String transmi="";
		Statement stmt = cn.createStatement();		
		String transmi1= "SELECT ECG, PrisedeTension, Injection, Pillule, Pansement, Escarre, Toilette, Observation, NomduSoignant FROM Transmission WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		ResultSet rs1 = stmt.executeQuery(transmi1);
		String newLine = System.getProperty("line.separator");
		while (rs1.next()) { 
			boolean collone4= rs1.getBoolean(1);	
			boolean collone5= rs1.getBoolean(2);
			boolean collone6= rs1.getBoolean(3);	
			boolean collone7= rs1.getBoolean(4);	
			boolean collone8= rs1.getBoolean(5);		
			boolean collone9= rs1.getBoolean(6);		
			boolean collone10= rs1.getBoolean(7);
			String collone11= rs1.getString(8);
			String collone12= rs1.getString(9);
			transmi="ECG"+" "+collone4+newLine+"PrisedeTension"+" "+collone5+newLine+"Injection"+" "+collone6+newLine+"Pillule"+" "+collone7+newLine+"Pansement"+" "+collone8+newLine+"Escarre"+" "+collone9+newLine+"Toilette"+" "+collone10+newLine+"Observation"+" "+collone11+newLine+"Nom du soignant"+" "+collone12;
		}
		return transmi;
	}	
}

