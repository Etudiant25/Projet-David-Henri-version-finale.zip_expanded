package Soins;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Personnel.AgentDaccueil;

public class TransmissionsAideSoignantDAO {

	private String url;
	private String login;
	private String password;
	private Connection cn;

	public TransmissionsAideSoignantDAO(Connection conn) {
		this.cn=conn;
	}

	public TransmissionsAideSoignant findById(int idPatient) throws SQLException {
		TransmissionsAideSoignant transmission = new TransmissionsAideSoignant();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM Transmission WHERE id="+idPatient);
		while(rs.next()) {
			transmission= new TransmissionsAideSoignant(rs.getInt ("idTransmission"),idPatient, rs.getString("nom"), rs.getString("Prenom"), rs.getBoolean("SoinsDeBouche"), rs.getBoolean("PrisedeTension"), rs.getBoolean("AideauLever"), rs.getBoolean("ToiletteAuLit"),rs.getBoolean("ToiletteAuLavabo"), rs.getBoolean("Douche"), rs.getBoolean("Escarre"), rs.getString("Observation"), rs.getString("nomdusoignant"), rs.getDate("date"));
		}
		return transmission;		
	}

	public TransmissionsAideSoignant findByNom(String nom, String prenom) throws SQLException {
		TransmissionsAideSoignant transmission = new TransmissionsAideSoignant();
		ResultSet rs = this.cn.createStatement().executeQuery("SELECT * FROM TransmissionAideSoignant WHERE nom='"+nom+"'AND prenom='"+prenom+"'");//"SELECT * FROM Transmission WHERE nom=? AND prenom=?"
		while(rs.next()) {
			transmission= new TransmissionsAideSoignant(rs.getInt ("idTransmission"), rs.getInt("idPatient"), nom, prenom, rs.getBoolean("SoinsDeBouche"), rs.getBoolean("PrisedeTension"), rs.getBoolean("AideauLever"), rs.getBoolean("ToiletteAuLit"),rs.getBoolean("ToiletteAuLavabo"), rs.getBoolean("Douche"), rs.getBoolean("Escarre"), rs.getString("Observation"), rs.getString("nomdusoignant"), rs.getDate("date"));
		}
		return transmission;		
	}	

	public boolean createTABLE() throws SQLException {
		boolean bool=false;
		boolean bool2= false;
		Statement stmt = cn.createStatement();
		if (!bool2) {
			int i = stmt.executeUpdate("CREATE TABLE TransmissionAideSoignant (idTransmission INT PRIMARY KEY not NULL, idPatient INT, Nom VARCHAR(10), Prenom VARCHAR(10), SoinsdeBouche BIT, PrisedeTension BIT, AideauLever BIT, ToiletteAuLit BIT, ToiletteAuLavabo BIT, Douche BIT, Escarre BIT, Observation VARCHAR(2000), NomduSoignant VARCHAR(30), Date DATE)");
			bool=true;
		}
		return bool;
	}	

	public boolean insereTUPLE(TransmissionsAideSoignant transmission) throws SQLException {
		String s = "INSERT into TransmissionAideSoignant values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = this.cn.prepareStatement(s);
		ps.setInt(1, transmission.getIdTransmission());
		ps.setInt(2, transmission.getIdPatient());
		ps.setString(3, transmission.getNom());
		ps.setString(4, transmission.getPrenom());
		ps.setBoolean(5, transmission.isSoinsdebouche());
		ps.setBoolean(6, transmission.isPrisedeTension());
		ps.setBoolean(7, transmission.isAideauLever());
		ps.setBoolean(8, transmission.isToiletteAuLit());
		ps.setBoolean(9, transmission.isToiletteAuLavabo());
		ps.setBoolean(10, transmission.isDouche());
		ps.setBoolean(11, transmission.isEscarreAS());
		ps.setString(12, transmission.getObservation());
		ps.setString(13, transmission.getNomdusoignant());
		ps.setDate(14, (java.sql.Date) transmission.getDate());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean deleteTUPLE(TransmissionsAideSoignant transmission) {
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

	public boolean updateAideAuLeverTuple(TransmissionsAideSoignant transmissions, String nom, String prenom) throws SQLException {

		String s="UPDATE Transmission SET ECG=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setBoolean(1, transmissions.isAideauLever());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updatePriseDeTensionTuple(TransmissionsAideSoignant transmission , String nom, String prenom) throws SQLException {
		String s="UPDATE Transmission SET PrisedeTension=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setBoolean(1, transmission.isPrisedeTension());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateSoinsdeBoucheTuple(TransmissionsAideSoignant transmission, String nom, String prenom) throws SQLException {
		String s="UPDATE Transmission SET Injection=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setBoolean(1, transmission.isSoinsdebouche());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateToiletteAuLitTuple(TransmissionsAideSoignant transmission, String nom, String prenom) throws SQLException {
		String s="UPDATE Transmission SET Pillule=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps= cn.prepareStatement(s);
		ps.setBoolean(1, transmission.isToiletteAuLit());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateToiletteAuLavaboTuple(TransmissionsAideSoignant transmission, String nom, String prenom) throws SQLException {
		boolean test=false;
		String s="UPDATE Transmission SET Pansement=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setBoolean(1, transmission.isToiletteAuLavabo());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateEscarreASTuple(TransmissionsAideSoignant transmission, String nom, String prenom) throws SQLException {
		boolean test=false;
		String s="UPDATE Transmission SET Escarre=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'" ;
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setBoolean(1, transmission.isEscarreAS());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateDoucheTuple(TransmissionsAideSoignant transmission, String nom, String prenom) throws SQLException {
		boolean test=false;
		String s="UPDATE Transmission SET Toilette=? WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
		PreparedStatement ps=cn.prepareStatement(s);
		ps.setBoolean(1, transmission.isDouche());
		boolean bool=ps.execute();
		ps.close();
		return bool;
	}

	public boolean updateObservationTuple(TransmissionsAideSoignant transmission, String nom, String prenom) throws SQLException {
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

	public String afficherTransmissionAS(String nom, String prenom) throws SQLException {
		String transmi="";
		Statement stmt = cn.createStatement();		
		String transmi1= "SELECT SoinsdeBouche, PrisedeTension, AideauLever, ToiletteAuLit, ToiletteAuLavabo, Douche, Escarre, Observation, NomduSoignant FROM TransmissionAideSoignant WHERE nom='"+nom+"'AND prenom = '"+prenom+"'";
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
			transmi="Soins de bouche"+" "+collone4+newLine+"Prise de tension"+" "+collone5+newLine+"Aide au lever"+" "+collone6+newLine+"Toilette au lit"+" "+collone7+newLine+"Toilette au lavabo"+" "+collone8+newLine+"Douche"+" "+collone9+newLine+"Escarre"+" "+collone10+newLine+"Observation"+" "+collone11+newLine+"Nom du soignant"+" "+collone12;
		}
		return transmi;
	}
}
