/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.*;
import View.*;
import java.util.List;
import java.sql.Connection;
/**
 *
 * @author Christian Sirait
 */
public class CotrollerListPesanan {
    LihatPesanan frame;
    intPesan pesanan;
    Connection connection;
    List<pesan> list_pesan;

    public CotrollerListPesanan(LihatPesanan frame) {
        this.frame = frame;
        pesanan = new ModelPesan(connection);
        list_pesan = pesanan.getData();
    }
     public void load_table() {
        TabelPesanan tbl = new TabelPesanan(list_pesan);
        frame.getTableData().setModel(tbl);
    }
    public void detail (int row){
        pesan pesan = list_pesan.get(row);
        frame.dispose();
        new DetailPesanan(pesan).setVisible(true);
    }
}
