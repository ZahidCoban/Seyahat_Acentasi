
package acenta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Zahid
 */
public class seyahatFirmasi {       //çalışıyor
    String adres = "jdbc:mysql://94.73.170.236/acenta";
    String username = "fsm";
    String password = "RRrv34U8";
    
    int id;
    String isim;
    

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    seyahatFirmasi(){}
    
    seyahatFirmasi(String isim) throws SQLException{
    
        Connection con = DriverManager.getConnection(adres, username, password);
       // Statement stat = con.createStatement();
       // Acenta a=new Acenta();
       // int sonId = a.tablodakiVeriSayisi("firma");
        preparedStatement = con.prepareStatement("INSERT INTO acenta.firma("
                //+ "id,"
                + "isim)" 
                + "VALUES (?)");

       // preparedStatement.setInt(1, sonId+1);
        preparedStatement.setString(1, isim);

        preparedStatement.executeUpdate();
        
    }
    
    int getFirmaId(String firmaadi) throws SQLException{
        Connection con = DriverManager.getConnection(adres, username, password);

        Statement stat = con.createStatement();

        ResultSet res = stat.executeQuery("select * from acenta.firma where isim='"+firmaadi+"'");
        res.next();
        return res.getInt("id");
    }
    
    
}
