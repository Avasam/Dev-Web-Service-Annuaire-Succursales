package com.succursaleAnnuaire.succursaleAnnuaire.models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 Exemple d'implémentation du patron Singleton.
 */
public class Connexion {
	private static Connection connection;
	private static String 	url="jdbc:mysql://localhost/serviceannuaire?user=root&password=root&useSSL=false",
				user = "root",
                                password="root",
                                pilote="com.mysql.jdbc.Driver";

        private Connexion()
        {
        }
        public static Connection getInstance(){
            if (connection==null) {
                try {
                    Class.forName(pilote);
                    System.out.println("Avant cnx");
                    connection = DriverManager.getConnection(url);
                    if (connection == null)
                        System.out.println("connection est NULLLLLLLLLLLLLLLLLLLLLLL");
                    else {
                        System.out.println("connection est NON NULLLLLLLLLLLLLLLLLLL");
                    }
                }
                catch (ClassNotFoundException | SQLException exp) {
                    exp.printStackTrace();
                }
            }
            return connection;
        }

	public static void reinit()
	{
                close();
		connection = null;
	}
	public static void close()
	{
		try {
			if (connection!=null)
                        {
				connection.close();
                                connection = null;
                        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		Connexion.url = url;
	}
	public static String getUser() {
		return user;
	}
	public static void setUser(String user) {
		Connexion.user = user;
	}
	public static void setPassword(String password) {
		Connexion.password = password;
	}
}

