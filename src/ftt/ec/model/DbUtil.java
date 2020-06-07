package ftt.ec.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

//Reference: https://github.com/danielscarvalho/FTT-PEOPLE-WEB-DB

public class DbUtil {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
            	//Option, use Tomcat db connection pool!
            	
            	Properties prop = new Properties();
            	
            	//Properie file at: WebContent/WEB-INF/classes
                InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("/db.resources");

                String driver, url, user, password;              

				prop.load(inputStream);
     
				driver = prop.getProperty("driver");
	            url = prop.getProperty("url");
	            user = prop.getProperty("user");
	            password = prop.getProperty("password");
	                
	            //Log
				System.out.println(driver + " - " + url + " - " + new Date());
			                        
                Class.forName(driver); //Verifica se o driver do BD esta disponivel (JDBC) - Legado
                
                connection = DriverManager.getConnection(url, user, password);
            
                System.out.println(connection);
                
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            return connection;
        } //if

    } //getConnection
} //DbUtil
