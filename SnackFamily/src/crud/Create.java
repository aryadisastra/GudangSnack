/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import conn.Conn;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import model.MBarang;
import model.MSuplier;

/**
 *
 * @author TRISNA NURDIANA
 */
public class Create {
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    Conn con = new Conn();
    Integer urut = 0;
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    PreparedStatement ps;
        
    public void insertSuplier(MSuplier m)
    {
        try
        {
            String sql = "insert into pemasok (nama,alamat,kontak) values(?,?,?)";
            ps = con.connect().prepareStatement(sql);
            ps.setString(1, m.getNama());
            ps.setString(2, m.getAlamat());
            ps.setString(3, m.getKontak());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void insertBarang(MBarang m)
    {
        try
        {
            String sql = "insert into barang values(?,?,?,?,?,?,?,?,?,?)";
            ps = con.connect().prepareStatement(sql);
            ps.setString(1, m.getId());
            ps.setString(2, m.getNama());
            ps.setString(3, m.getDeskripsi());
            ps.setString(4, m.getHargaBeli());
            ps.setString(5, m.getHargaJual());
            ps.setString(6, m.getTglMasuk());
            ps.setString(7, m.getTglEks());
            ps.setString(8, m.getStock());
            ps.setString(9, m.getSatuan());
            ps.setString(10, m.getPemasok());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
