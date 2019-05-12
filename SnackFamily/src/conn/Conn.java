/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conn;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author TRISNA NURDIANA
 */
public class Conn {
    public Connection con;
    public Statement stm;
    
    public Connection connect()
    {
     if(con == null)
        {
            MysqlDataSource db = new MysqlDataSource();
            db.setDatabaseName("familysnack");
            db.setUser("root");
            db.setPassword("");
            try{
                con = db.getConnection();
            }catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,"KONEKSI TIDAK TERHUBUNG");
                System.err.println("DISCONNECT");
                System.exit(0);
            }
        }
     return con;
    }
    
    public void config(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/familysnack", "root", "");
            stm = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "koneksi gagal "+e.getMessage());
        }
    }
    
}
