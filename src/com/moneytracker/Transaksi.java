/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moneytracker;

/**
 *
 * @author Administrator
 */
public abstract class Transaksi {
    // Encapsulation
    private String tanggal;
    private double jumlah;
    private String kategori;
    private String deskripsi;

    public Transaksi(String tanggal, double jumlah, String kategori, String deskripsi) {
        this.tanggal = tanggal;
        this.jumlah = jumlah;
        this.kategori = kategori;
        this.deskripsi = deskripsi;
    }

    // Abstract Method (Wajib diisi anak)
    public abstract String getJenis(); 

    // Getter
    public String getTanggal() { return tanggal; }
    public double getJumlah() { return jumlah; }
    public String getKategori() { return kategori; }
    public String getDeskripsi() { return deskripsi; }
}
