package model;

import java.sql.DriverManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnexionFactory {
	
	
	private static Connection connectionMySQL;

    // Ouvre une connexion s'il n'en existe pas déja une
    public static Connection getInstance() throws IOException, SQLException {
    	String url = "jdbc:mysql://localhost:8889/projetJEE?relaxAutoCommit=true";
    	String login = "root";
    	String pwd = "root";
        if (connectionMySQL == null) {
            try {

            	Class.forName("com.mysql.jdbc.Driver");
            	System.out.println("Connecting to DB");
            	connectionMySQL = DriverManager.getConnection(url, login, pwd);
            } catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
        }
        return connectionMySQL;
    }

    public void closeConnection() throws SQLException {
        connectionMySQL.close();
    }


	
}
