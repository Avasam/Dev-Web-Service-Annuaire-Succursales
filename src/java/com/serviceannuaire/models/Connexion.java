/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviceannuaire.models;

/**
 *
 * @author moumene
 */
import java.sql.Connection;
import java.sql.DriverManager   ;
import java.sql.SQLException;

public class Connexion {
	private static Connection cnx;
	private static String url, user = "", password="";
	public static Connection getInstance()
	{
            Connexion.reinit();
            Connexion.setUrl("jdbc:mysql://localhost/site_questionnaire_tp1_javaweb");
            Connexion.setUser("root");
            Connexion.setPassword("root");

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
		cnx = null;
	}
	public static void close()
	{
		try {
			if (cnx!=null)
				cnx.close();
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
