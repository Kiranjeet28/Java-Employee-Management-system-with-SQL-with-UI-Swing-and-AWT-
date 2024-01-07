package db;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
public class Myconnection {
    Statement s;
    public static Connection connection = null;
    static  String url ="jdbc:mysql://localhost:3306/javaproject4";
    static String  user = "root";
    static String password = "iamjeet28";
    public static Connection getConnection(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);
        }
        catch (Exception ex ){
            System.out.println(ex);
        }
        System.out.println("/****************************************************************/******************************************************************************************************************************************************//");

        return connection;
    }

    public  void closeConntection(){
        if(connection != null){
            try{
                connection.close();
            } catch (Exception e ){
                System.out.println("galti hai gya");

            }
        }

    }
}

