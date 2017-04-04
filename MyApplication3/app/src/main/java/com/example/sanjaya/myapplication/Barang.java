package com.example.sanjaya.myapplication;

/**
 * Created by sanjaya on 4/4/2017.
 */

public class Barang {
    private String uri,judul, keterangan;
    public Barang(){
        uri="";
        judul="";
        keterangan="";
    }
    public void setUri(String uri){
        this.uri=uri;
    }
    public void setJudul(String judul){
        this.judul=judul;
    }
    public void setKeterangan(String keterangan){
        this.keterangan=keterangan;
    }
    public String getUri(){
        return uri;
    }
    public String getJudul(){
        return judul;
    }
    public String getKeterangan(){
        return keterangan;
    }
}
