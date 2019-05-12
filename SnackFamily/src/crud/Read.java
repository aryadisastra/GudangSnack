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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.MBarang;
import model.MSuplier;
/**
 *
 * @author TRISNA NURDIANA
 */
public class Read {
    Conn con = new Conn();
    Integer urut = 0;
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    PreparedStatement ps;
    
    public ObservableList<MBarang> getAllBarang() {
        con = new Conn();
        ObservableList<MBarang> listData = FXCollections.observableArrayList();
        try{
            String sql ="select * from barang;";
            ResultSet rs = con.connect().createStatement().executeQuery(sql);
            while(rs.next())
            {
                urut = urut + 1;
                String isi = urut.toString();
                MBarang m = new MBarang();
                m.setId(rs.getString("idBarang"));
                m.setNama(rs.getString("namaBarang"));
                m.setDeskripsi(rs.getString("deskripsi"));
                m.setHargaJual(rs.getString("hargaJual"));
                m.setStock(rs.getString("stock")+" "+rs.getString("satuan"));
                m.setTglEks(rs.getString("tglEks"));
                listData.add(m);
            }
            urut = 0;
        }catch(Exception e)
        {e.printStackTrace();}
        return listData;
    }
    
        public ObservableList<MSuplier> getAllSupplier() {
        con = new Conn();
        ObservableList<MSuplier> listData = FXCollections.observableArrayList();
        try{
            String sql ="select * from pemasok";
            ResultSet rs = con.connect().createStatement().executeQuery(sql);
            while(rs.next())
            {
                urut = urut + 1;
                String isi = urut.toString();
                MSuplier m = new MSuplier();
                m.setNo(isi);
                m.setNama(rs.getString("nama"));
                m.setAlamat(rs.getString("alamat"));
                m.setKontak(rs.getString("kontak"));
                m.setid(rs.getString("id_pemasok"));
                /*m.setHargaJual(rs.getString("hargaJual"));
                m.setStock(rs.getString("stock")+" "+rs.getString("satuan"));
                m.setTglEks(rs.getString("tglEks"));*/
                listData.add(m);
            }
            urut = 0;
        }catch(Exception e)
        {e.printStackTrace();}
        return listData;
    }
}
