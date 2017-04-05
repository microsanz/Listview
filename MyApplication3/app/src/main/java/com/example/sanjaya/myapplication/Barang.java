package com.example.sanjaya.myapplication;

/**
 * Created by sanjaya on 4/4/2017.
 */

public class Barang {
    private String judul, harga, hargaSimbol;
    private int uri;

    public Barang(int uri,String judul,String harga,String hargaSimbol) {
        this.uri = uri;
        this.judul = judul;
        this.harga = harga;
        this.hargaSimbol = hargaSimbol;
    }

    /*public void setUri(String uri) {
        this.uri = uri;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public void setHargaSimbol(String hargaSimbol) {
        this.hargaSimbol = hargaSimbol;
    }*/

    public int getUri() {
        return uri;
    }

    public String getJudul() {
        return judul;
    }

    public String getHarga() {
        return harga;
    }

    public String getHargaSimbol() {
        return hargaSimbol;
    }
}
