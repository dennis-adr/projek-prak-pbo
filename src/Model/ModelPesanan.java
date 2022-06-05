/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kato
 */
public class ModelPesanan {
    private String nama, id, alamat, telepon, pilihan, cek_in, cek_out;
    private double jumlah_kamar;

    public void setPesanan(String nama, String alamat, String telepon, String pilihan, double jumlah_kamar, String cek_in, String cek_out) {
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
        this.pilihan = pilihan;
        this.cek_in = cek_in;
        this.cek_out = cek_out;
        this.jumlah_kamar = jumlah_kamar;
    }
    
    public String getNama() {
        return nama;
    }

    public String getId() {
        return id;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public String getPilihan() {
        return pilihan;
    }

    public String getCek_in() {
        return cek_in;
    }

    public String getCek_out() {
        return cek_out;
    }

    public double getJumlah_kamar() {
        return jumlah_kamar;
    }
    
    public void getData(String id) {
        koneksi koneksi = new koneksi();
        PreparedStatement ps;
        ResultSet rs;

        String query = "Select * from `pesanan` WHERE id=?";

        try {
            ps = koneksi.getConnection().prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                this.id = id;
                this.nama = rs.getString(2);
                this.alamat = rs.getString(3);
                this.telepon = rs.getString(4);
                this.pilihan = rs.getString(5);
                this.jumlah_kamar = rs.getDouble(6);
                this.cek_in = rs.getString(7);
                this.cek_out = rs.getString(8);

                System.out.println(nama);
                System.out.println(alamat);
                System.out.println(telepon);
                System.out.println(pilihan);
                System.out.println(jumlah_kamar);
                System.out.println(cek_in);
                System.out.println(cek_out);
            }

        } catch (SQLException ex) {
            System.out.println("Data tidak ditemukan");
            Logger.getLogger(ModelPesanan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
