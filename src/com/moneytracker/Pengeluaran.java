/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moneytracker;

/**
 *
 * @author Administrator
 */
public class Pengeluaran extends Transaksi{
    public Pengeluaran(String tanggal, double jumlah, String kategori, String deskripsi) {
        super(tanggal, jumlah, kategori, deskripsi);
    }

    @Override
    public String getJenis() {
        return "Expense";
    }
}
