package roma.academy.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import roma.academy.model.Impiegato;
import roma.academy.model.Storico;

public class StoricoDao {
	
	private static Properties props;
	
	private static String url;
	private static String user;
	private static String pass;
	private static String driver;
	
public static void insert(Storico storico) throws SQLException {
	System.out.println(storico.toString());
		
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		String insertTableSQL = null;

		try {
			//Add properties file
			props = new Properties();
			props.load(new FileInputStream("D:\\CursosPresenciales\\roma-academy\\roma-workspace\\FirstServletProject\\resources\\dbconfig.properties"));
			//read the properties file
			user = props.getProperty("user");
			pass = props.getProperty("pass");
			url = props.getProperty("url");
			driver = props.getProperty("driver");
						
			Class.forName(driver);
			// Get a connection to database
			dbConnection = DriverManager.getConnection(url, user, pass);
			// Create a statement
			insertTableSQL = "INSERT INTO storico(idimpiegato, idruolo, matricola, datainizio, datafine) VALUES(?,?,?,?,?)";
			cmd = dbConnection.prepareStatement(insertTableSQL);
			// add values
			cmd.setInt(1, storico.getIdImpiegato());
			cmd.setInt(2, storico.getIdRuolo());
			cmd.setInt(3, storico.getMatricola());
			cmd.setDate(4, storico.getDataInizio());
			cmd.setDate(5, storico.getDataFine());
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

	public static void delete(int id) throws SQLException {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		String deleteTableSQL;

		try {
			// Add properties file
			props = new Properties();
			props.load(new FileInputStream("D:\\CursosPresenciales\\roma-academy\\roma-workspace\\FirstServletProject\\resources\\dbconfig.properties"));
			// read the properties file
			user = props.getProperty("user");
			pass = props.getProperty("pass");
			url = props.getProperty("url");
			driver = props.getProperty("driver");

			Class.forName(driver);
			// Get a connection to database
			dbConnection = DriverManager.getConnection(url, user, pass);
			// Create a statement
			deleteTableSQL = "DELETE FROM storico WHERE id = ?";
			cmd = dbConnection.prepareStatement(deleteTableSQL);
			// add values
			cmd.setLong(1, id);
			// execute update SQL statement
			cmd.executeUpdate();
			System.out.println("Record is deleted in DBUSER table!");

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
	
	
	public static void update(Storico storico) throws SQLException {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		String updateTableSQL;

		try {
			//Add properties file
			props = new Properties();
			props.load(new FileInputStream("D:\\CursosPresenciales\\roma-academy\\roma-workspace\\FirstServletProject\\resources\\dbconfig.properties"));
			//read the properties file
			user = props.getProperty("user");
			pass = props.getProperty("pass");
			url = props.getProperty("url");
			driver = props.getProperty("driver");
			
			Class.forName(driver);
			// Get a connection to database
			dbConnection = DriverManager.getConnection(url, user, pass);
			// Create a statement
			updateTableSQL = "UPDATE storico SET idimpiegato = ?, idruolo = ?, matricola = ?, datainizio = ?, datafine = ?   WHERE id = ?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			// add values
			cmd.setInt(1, storico.getIdImpiegato());
			cmd.setInt(2, storico.getIdRuolo());
			cmd.setInt(3, storico.getMatricola());
			cmd.setDate(4, storico.getDataInizio());
			cmd.setDate(5, storico.getDataFine());
			cmd.setInt(6, storico.getId());
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
	
}
