/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.util.List;
import javax.swing.JOptionPane;
import Model.*;
import View.*;
import java.sql.Connection;
import javax.swing.plaf.ComboBoxUI;
/**
 *
 * @author Christian Sirait
 */
public class controlerTambah {
    PesanKamar frame;
    intPesan intf;
    Connection connection;
    public controlerTambah(PesanKamar frame) {
        this.frame = frame;
        intf = new ModelPesan(connection);
    }
     public void tambahData(){
        pesan pesanan = new pesan();
        pesanan.setNama(frame.getForm_nama().getText());
        pesanan.setAlamat(frame.getForm_alamat().getText());
        pesanan.setTelepon(frame.getForm_telp().getText());
        pesanan.setPilihan(frame.getjComboBox1().getSelectedItem().toString());
        pesanan.setJumlah_kamar(Integer.parseInt(frame.getForm_jumlah().getText()));
        pesanan.setCek_in(frame.getjDateChooser1().getDate().toString());
        pesanan.setCek_out(frame.getjDateChooser2().getDate().toString());
        intf.insert(pesanan);
        JOptionPane.showMessageDialog(frame, "Berhasil menambahkan data baru");
        kembali();
    }
     public void kembali(){
        frame.dispose();
        new MainMenu().setVisible(true);
    }
}
