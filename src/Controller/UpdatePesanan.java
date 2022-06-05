/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ModelPesanan;
import static java.lang.Integer.parseInt;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kato
 */
public class UpdatePesanan {
    public boolean edit(ModelPesanan b){
    String query = "UPDATE `pesanan` SET `nama`=?,`alamat`=?,`telepon`=?, `pilihan`=?,`jumlah_kamar`=?,`cek_in`=?,`cek_out`=? WHERE `id`=?";
    PreparedStatement ps;
    System.out.println("idEdit " + b.getId());
    
    try {
      koneksi koneksi = new koneksi();
      ps = koneksi.getConnection().prepareStatement(query);
      ps.setString(1, b.getNama());
      ps.setString(2, b.getAlamat());
      ps.setString(3, b.getTelepon());
      ps.setString(4, b.getPilihan());
      ps.setDouble(5, b.getJumlah_kamar());
      ps.setString(6, b.getCek_in());
      ps.setString(7, b.getCek_out());
      
      int id = parseInt(b.getId());
      
      ps.setInt(8, id);
      
      int i = ps.executeUpdate();

      return i == 1;
      
    } catch (SQLException ex) {
      Logger.getLogger(UpdatePesanan.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
  }
}
