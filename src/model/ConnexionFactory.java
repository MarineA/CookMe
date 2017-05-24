package model;

import java.sql.DriverManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ConnexionFactory {
	
	
	private static Connection connectionMySQL;

    // Ouvre une connexion s'il n'en existe pas déja une
    public static Connection getInstance() throws IOException, SQLException {
        if (connectionMySQL == null) {
            try {
                MysqlDataSource mySQL = new MysqlDataSource();
                mySQL.setUrl("jdbc:mysql://localhost");
                mySQL.setPort(8888);
                mySQL.setDatabaseName("projetJEE");
                mySQL.setUser("root");
                mySQL.setPassword("");
                return (mySQL.getConnection());
            } 
            catch (SQLException e) {
                System.err.println("Erreur lors de la connection : " + e.getMessage());
            }
        }
        return connectionMySQL;
    }

    public void closeConnection() throws SQLException {
        connectionMySQL.close();
    }


	
}
