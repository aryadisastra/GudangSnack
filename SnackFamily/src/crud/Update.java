/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import conn.Conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TRISNA NURDIANA
 */
public class Update {
    Conn con = new Conn();
    Integer urut = 0;
    PreparedStatement ps;
    
//    public void updateJum(String id_barang)
//    {
//        try{
//            String sql ="update barang set";
//            
//                ps = con.connect().prepareStatement(sql);
//                ps.setString(1, jml.toString());
//                ps.setString(2, d.getSubHarga());
//                ps.executeUpdate();
//
//                }catch(Exception e)
//            {
//                Logger.getLogger(Implementation.class.getName()).log(Level.SEVERE, null, e);
//            }
//    }
}
