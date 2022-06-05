/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Model.pesan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Christian Sirait
 */
public class ModelPesan implements intPesan{
    Connection connection;
    final String insert = "INSERT INTO pesanan (nama,alamat,telepon,pilihan,jumlah_kamar,cek_in,cek_out) VALUES (?, ?, ?, ?, ?, ?, ?);";
    final String update = "UPDATE pesanan SET nama=?, alamat=?, telepon=? WHERE id=? ;";
    final String delete = "DELETE FROM pesanan WHERE id=? ;";
    final String select = "SELECT * FROM pesanan ORDER BY id DESC;";

    public ModelPesan(Connection connection) {
       this.connection=koneksi.connection();
    }
    
    public void insert(pesan pesan) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, pesan.getNama());
            statement.setString(2, pesan.getAlamat());
            statement.setString(3, pesan.getTelepon());
            statement.setString(4, pesan.getPilihan());
            statement.setInt(5, pesan.getJumlah_kamar());
            statement.setString(6, pesan.getCek_in());
            statement.setString(7, pesan.getCek_out());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } 
    }

    @Override
    public void update(pesan pesan) {
          PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, pesan.getNama());
            statement.setString(2, pesan.getAlamat());
            statement.setString(3, pesan.getTelepon());
            statement.setInt(4, pesan.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } 
        }

    public void delete(int id) {
       PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }  
    }

    public List<pesan> getData() {
         List<pesan> listPesan = null;
        try {
            listPesan = new ArrayList<pesan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                pesan pesan = new pesan();
                pesan.setId(rs.getInt("id"));
                pesan.setNama(rs.getString("nama"));
                pesan.setAlamat(rs.getString("alamat"));
                pesan.setTelepon(rs.getString("telepon"));
                pesan.setPilihan(rs.getString("pilihan"));
                pesan.setJumlah_kamar(rs.getInt("jumlah_kamar"));
                pesan.setCek_in(rs.getString("cek_in"));
                pesan.setCek_out(rs.getString("cek_out"));
                listPesan.add(pesan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelPesan.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listPesan;
    }// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
}
    
