package com.serviceannuaire.models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 Exemple d'implémentation du patron Singleton.
 */
public class Connexion {
	private static Connection cnx;
	private static String 	url="jdbc:mysql://localhost/ServiceAnnuaire?user=root&password=root&useSSL=false",
				user = "root", password="root";
        
        private Connexion()
        {
        }
	public static Connection getInstance()
	{
		if (cnx == null)
			try {
				if (user.equals(""))
					cnx = DriverManager.getConnection(url);
				else
					cnx = DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return cnx;
	}
	public static void reinit()
	{
                close();
		cnx = null;
	}
	public static void close()
	{
		try {
			if (cnx!=null)
                        {
				cnx.close();
                                cnx = null;
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

