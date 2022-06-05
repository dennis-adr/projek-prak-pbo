/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.util.List;
import Model.*;
import View.*;
import java.sql.Connection;
import javax.swing.JOptionPane;
/**
 *
 * @author Christian Sirait
 */
public class controllerDetail {
     DetailPesanan frame;
     intPesan intf;
     Connection connection;
    public controllerDetail(DetailPesanan frame) {
        this.frame = frame;
        intf  = new ModelPesan(connection);
        
    }
      public void tampilkanData(pesan pesan){
        frame.setEdit_nama(pesan.getNama());
        frame.setEdit_alamat(pesan.getAlamat());
        frame.setEdit_telp(pesan.getTelepon());
        frame.setjLabel12(pesan.getPilihan());
        frame.setjLabel13(Integer.toString(pesan.getJumlah_kamar()));
        frame.setjLabel14(pesan.getCek_in());
        frame.setjLabel15(pesan.getCek_out());
    }
       public void simpanEdit(int id){
        pesan edit_pesan = new pesan();
        edit_pesan.setNama(frame.getEdit_nama().getText());
        edit_pesan.setAlamat(frame.getEdit_alamat().getText());
        edit_pesan.setTelepon(frame.getEdit_telp().getText());
        edit_pesan.setId(id);

        intf.update(edit_pesan);
        JOptionPane.showMessageDialog(frame, "Berhasil mengedit data");
         frame.dispose();
        new MainMenu().setVisible(true);
        
    }
       
       public void hapus(int id){
        int opsi = JOptionPane.showConfirmDialog(null, "Benarkah anda ingin menghapus data ini ?", "Penghapusan Data", JOptionPane.YES_NO_OPTION);
        if (opsi == JOptionPane.YES_OPTION){
            pesan edit_pesan = new pesan();
            edit_pesan.setId(id);
            intf.delete(id);
            JOptionPane.showMessageDialog(frame, "Berhasil Menghapus data");
            frame.dispose();
             new MainMenu().setVisible(true);
        }else{
            frame.dispose();
            
        }
       }
       
       
       
}
