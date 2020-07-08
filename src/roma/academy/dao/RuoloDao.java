package roma.academy.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import roma.academy.model.Impiegato;
import roma.academy.model.Ruolo;

public class RuoloDao {
	
	
	public static void insert(Ruolo ruolo) throws SQLException {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		String insertTableSQL = null;
		
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:jboss/datasources/MySqlDS");
			dbConnection  = ds.getConnection();
			// Create a statement
			insertTableSQL = "INSERT INTO ruolo(descrizione, stipendio) VALUES(?,?)";
			cmd = dbConnection.prepareStatement(insertTableSQL);
			// add values
			cmd.setString(1, ruolo.getDescrizione());
			cmd.setInt(2, ruolo.getStipendio());
			// execute update SQL stetement
			cmd.executeUpdate();
			System.out.println("Record is updated to DBUSER table!");

		} catch (Exception e) {

			e.printStackTrace();
		} 
	}
	
	
	public static void delete(int id) throws SQLException {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		String deleteTableSQL;

		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:jboss/datasources/MySqlDS");
			dbConnection  = ds.getConnection();
			// Create a statement
			deleteTableSQL = "DELETE FROM ruolo WHERE id = ?";
			cmd = dbConnection.prepareStatement(deleteTableSQL);
			// add values
			cmd.setLong(1, id);
			// execute update SQL statement
			cmd.executeUpdate();
			System.out.println("Record is deleted in DBUSER table!");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	
	public static void update(Ruolo ruolo) throws SQLException {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		String updateTableSQL;

		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:jboss/datasources/MySqlDS");
			dbConnection  = ds.getConnection();
			// Create a statement
			updateTableSQL = "UPDATE ruolo SET descrizione = ?, stipendio = ?  WHERE id = ?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			// add values
			cmd.setString(1, ruolo.getDescrizione());
			cmd.setInt(2, ruolo.getStipendio());
			cmd.setInt(3, ruolo.getId());
			// execute update SQL stetement
			cmd.executeUpdate();
			System.out.println("Record is updated to DBUSER table!");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (cmd != null) {
				cmd.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
	}
	
	public static ArrayList<Ruolo> getList() {
		Connection dbConnection = null;
		Statement cmd = null;

		String updateTableSQL;
		ArrayList <Ruolo> ruoloList = new ArrayList<Ruolo>();;

		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:jboss/datasources/MySqlDS");
			dbConnection  = ds.getConnection();
			// Create a statement
			updateTableSQL = "SELECT * FROM  ruolo";
			cmd = dbConnection.createStatement();
			// execute update SQL stetement
			ResultSet rSet = cmd.executeQuery(updateTableSQL);
			Ruolo ruolo;
			
			while(rSet.next()) {
				ruolo = new Ruolo();
				ruolo.setId(rSet.getInt("id"));
				ruolo.setDescrizione(rSet.getString("descrizione"));
				ruolo.setStipendio(rSet.getInt("stipendio"));
				//add object to List
				ruoloList.add(ruolo);
			}
			System.out.println("RUOLO-DAO-GETLIST");
			for(Ruolo imp: ruoloList) {
				System.out.println(imp.toString());
			}
			System.out.println("Record is updated to DBUSER table!");
			return ruoloList;
			

		} catch (Exception e) {
			System.out.println("RUOLO-DAO-GETLIST");
			e.printStackTrace();
		} 
		return ruoloList;
	}
	
	public static Ruolo getById(int id) {
		Connection dbConnection = null;
		Statement cmd = null;
		String getByIdTableSQL;

		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:jboss/datasources/MySqlDS");
			dbConnection  = ds.getConnection();
			// Create a statement
			getByIdTableSQL = "SELECT * FROM  ruolo WHERE id = " + id;
			cmd = dbConnection.createStatement();
			// execute update SQL stetement
			ResultSet rSet = cmd.executeQuery(getByIdTableSQL);
			Ruolo ruolo = null;
			
			while(rSet.next()) {
				ruolo = new Ruolo();
				ruolo.setId(rSet.getInt("id"));
				ruolo.setDescrizione(rSet.getString("descrizione"));
				ruolo.setStipendio(Integer.parseInt(rSet.getString("stipendio")));
			}
			System.out.println("RUOLO-GET-BY-ID");
			System.out.println(ruolo.toString());
			return ruolo;

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
}
