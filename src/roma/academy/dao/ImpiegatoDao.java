package roma.academy.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import roma.academy.model.Impiegato;

public class ImpiegatoDao {
	
	

	public static int insert(Impiegato impiegato) throws SQLException {
		
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		String insertTableSQL = null;
		int resp = -1;
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:jboss/datasources/MySqlDS");
			dbConnection  = ds.getConnection();
			// Create a statement
			insertTableSQL = "INSERT INTO impiegato(nome, cognome) VALUES(?,?)";
			cmd = dbConnection.prepareStatement(insertTableSQL);
			// add values
			cmd.setString(1, impiegato.getNome());
			cmd.setString(2, impiegato.getCognome());
			// execute update SQL stetement
			resp = cmd.executeUpdate();
			System.out.println("Record is updated to DBUSER table!");
			System.out.println("IMPIEGATO-RESPONSE-EXECUTEUPDATE:   " + resp);

		} catch (Exception e) {

			e.printStackTrace();
		} 
		
		return resp;
	}

	public static void delete(int id) throws SQLException {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		String deleteTableSQL;

		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:jboss/datasources/MySqlDS");
			dbConnection  = ds.getConnection();
			// Create a statement
			deleteTableSQL = "DELETE FROM impiegato WHERE id = ?";
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
	
	public static void update(Impiegato impiegato) throws SQLException {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		String updateTableSQL;

		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:jboss/datasources/MySqlDS");
			dbConnection  = ds.getConnection();
			// Create a statement
			updateTableSQL = "UPDATE impiegato SET nome = ?, cognome = ?  WHERE id = ?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			// add values
			cmd.setString(1, impiegato.getNome());
			cmd.setString(2, impiegato.getCognome());
			cmd.setInt(3, impiegato.getId());
			// execute update SQL stetement
			cmd.executeUpdate();
			System.out.println("Record is updated to DBUSER table!");

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static ArrayList<Impiegato> getList() {
		Connection dbConnection = null;
		Statement cmd = null;

		String updateTableSQL;
		ArrayList <Impiegato> impiegatoList = new ArrayList<Impiegato>();;

		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:jboss/datasources/MySqlDS");
			dbConnection  = ds.getConnection();
			// Create a statement
			updateTableSQL = "SELECT * FROM  impiegato";
			cmd = dbConnection.createStatement();
			// execute update SQL stetement
			ResultSet rSet = cmd.executeQuery(updateTableSQL);
			Impiegato impiegato;
			
			while(rSet.next()) {
				impiegato = new Impiegato();
				impiegato.setId(rSet.getInt("id"));
				impiegato.setNome(rSet.getString("nome"));
				impiegato.setCognome(rSet.getString("cognome"));
				//add object to List
				impiegatoList.add(impiegato);
			}
			System.out.println("IMPIEGATO-DAO-GETLIST");
			for(Impiegato imp: impiegatoList) {
				System.out.println(imp.toString());
			}
			System.out.println("Record is updated to DBUSER table!");
			return impiegatoList;
			

		} catch (Exception e) {
			System.out.println("IMPIEGATO-DAO-GETLIST");
			e.printStackTrace();
		} 
		return impiegatoList;
	}
	
	public static Impiegato getById(int id) {
		Connection dbConnection = null;
		Statement cmd = null;
		String getByIdTableSQL;

		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:jboss/datasources/MySqlDS");
			dbConnection  = ds.getConnection();
			// Create a statement
			getByIdTableSQL = "SELECT * FROM  impiegato WHERE id = " + id;
			cmd = dbConnection.createStatement();
			// execute update SQL stetement
			ResultSet rSet = cmd.executeQuery(getByIdTableSQL);
			Impiegato impiegato = null;
			
			while(rSet.next()) {
				impiegato = new Impiegato();
				impiegato.setId(rSet.getInt("id"));
				impiegato.setNome(rSet.getString("nome"));
				impiegato.setCognome(rSet.getString("cognome"));
			}
			System.out.println("IMPIEGATO-GET-BY-ID");
			System.out.println(impiegato.toString());
			return impiegato;

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	

}
