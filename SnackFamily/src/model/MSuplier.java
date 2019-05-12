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
public class MSuplier {
    private final StringProperty no = new SimpleStringProperty();
    private final StringProperty nama = new SimpleStringProperty();
    private final StringProperty alamat = new SimpleStringProperty();
    private final StringProperty kontak = new SimpleStringProperty();
    private final StringProperty id = new SimpleStringProperty();
    
    public MSuplier(){}
    
    
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
    
    public String getAlamat()
    {
        return alamat.get();
    }
    public void setAlamat(String value)
    {
        alamat.set(value);
    }
    public StringProperty AlamatPro()
    {
        return alamat;
    }
    public String getKontak()
    {
        return kontak.get();
    }
    public void setKontak(String value)
    {
        kontak.set(value);
    }
    public StringProperty KontakPro()
    {
        return kontak;
    }
    public String getid()
    {
        return id.get();
    }
    public void setid(String value)
    {
        id.set(value);
    }
    public StringProperty idPro()
    {
        return id;
    }
}
