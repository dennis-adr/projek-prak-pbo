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
public class KamarModel {
    private String id, nama;
    private double jumlah_kasur, harga;

    public void getData(String id) {
        koneksi koneksi = new koneksi();
        PreparedStatement ps;
        ResultSet rs;

        String query = "Select * from `kamar` WHERE id=?";

        try {
            ps = koneksi.getConnection().prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                this.id = id;
                this.nama = rs.getString(2);
                this.jumlah_kasur = rs.getDouble(3);
                this.harga = rs.getDouble(4);

                System.out.println(nama);
                System.out.println(jumlah_kasur);
                System.out.println(harga);
            }

        } catch (SQLException ex) {
            System.out.println("Data tidak ditemukan");
            Logger.getLogger(ModelPesanan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
