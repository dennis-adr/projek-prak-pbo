/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
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

public class ModelKamar implements intKamar{
     Connection connection;    
     final String select = "SELECT * FROM kamar ORDER BY id DESC;";

    public ModelKamar(Connection connection) {
       this.connection=koneksi.connection();
    }

    @Override
    public List<kamar> getData() {
    List<kamar> listkamar = null;
        try {
            listkamar = new ArrayList<kamar>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                kamar kamar = new kamar();
                kamar.setNama(rs.getString("nama"));
                kamar.setJumlah_kasur(rs.getInt("jumlah_kasur"));
                kamar.setHarga(rs.getInt("harga"));
                listkamar.add(kamar);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelKamar.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listkamar;
    }   
  }
