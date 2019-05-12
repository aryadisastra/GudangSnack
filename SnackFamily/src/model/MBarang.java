/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author TRISNA NURDIANA
 */
public class MBarang {
    private final StringProperty no = new SimpleStringProperty();
    private final StringProperty id = new SimpleStringProperty();
    private final StringProperty nama = new SimpleStringProperty();
    private final StringProperty deskripsi = new SimpleStringProperty();
    private final StringProperty hargaBeli = new SimpleStringProperty();
    private final StringProperty hargaJual = new SimpleStringProperty();
    private final StringProperty stock = new SimpleStringProperty();
    private final StringProperty satuan = new SimpleStringProperty();
    private final StringProperty tglMasuk = new SimpleStringProperty();
    private final StringProperty tglEks = new SimpleStringProperty();   
    private final StringProperty pemasok = new SimpleStringProperty();
    
    public MBarang(){}
    
    public String getNo()
    {
        return no.get();
    }
    public void setNo(String value)
    {
        no.set(value);
    }
    public StringProperty NoPro()
    {
        return no;
    }
    public String getId()
    {
        return id.get();
    }
    public void setId(String value)
    {
        id.set(value);
    }
    public StringProperty IdPro()
    {
        return id;
    }
    public String getNama()
    {
        return nama.get();
    }
    public void setNama(String value)
    {
        nama.set(value);
    }
    public StringProperty NamaPro()
    {
        return nama;
    }
    
    public String getDeskripsi()
    {
        return deskripsi.get();
    }
    public void setDeskripsi(String value)
    {
        deskripsi.set(value);
    }
    public StringProperty DeskripsiPro()
    {
        return deskripsi;
    }
    public String getHargaBeli()
    {
        return hargaBeli.get();
    }
    public void setHargaBeli(String value)
    {
        hargaBeli.set(value);
    }
    public StringProperty HargaBeliPro()
    {
        return hargaBeli;
    }
    public String getHargaJual()
    {
        return hargaJual.get();
    }
    public void setHargaJual(String value)
    {
        hargaJual.set(value);
    }
    public StringProperty HargaJualPro()
    {
        return hargaJual;
    }
    public String getStock()
    {
        return stock.get();
    }
    public void setStock(String value)
    {
        stock.set(value);
    }
    public StringProperty StockPro()
    {
        return stock;
    }
    public String getSatuan()
    {
        return satuan.get();
    }
    public void setSatuan(String value)
    {
        satuan.set(value);
    }
    public StringProperty SatuanPro()
    {
        return satuan;
    }
    public String getTglMasuk()
    {
        return tglMasuk.get();
    }
    public void setTglMasuk(String value)
    {
        tglMasuk.set(value);
    }
    public StringProperty TglMasukPro()
    {
        return tglMasuk;
    }
    public String getTglEks()
    {
        return tglEks.get();
    }
    public void setTglEks(String value)
    {
        tglEks.set(value);
    }
    public StringProperty TglEksPro()
    {
        return tglEks;
    }
    public String getPemasok()
    {
        return pemasok.get();
    }
    public void setPemasok(String value)
    {
        pemasok.set(value);
    }
    public StringProperty PemasokPro()
    {
        return pemasok;
    }
}
