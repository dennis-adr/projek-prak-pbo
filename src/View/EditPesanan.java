/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.UpdatePesanan;
import Model.ModelPesanan;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import Controller.koneksi;

/**
 *
 * @author Kato
 */
public class EditPesanan extends JFrame{
    koneksi koneksi = new koneksi();
    ModelPesanan pesanan = new ModelPesanan();
    UpdatePesanan edit = new UpdatePesanan();
    
    JFrame window = new JFrame("Edit Pesanan");

    JLabel ljudul = new JLabel("Edit Pesanan");
    JLabel lnama = new JLabel("Nama");
    JLabel lalamat = new JLabel("Alamat");
    JLabel ltelepon = new JLabel("Telepon");
    JLabel lpilihan = new JLabel("Pilihan");
    JLabel ljumlah_kamar = new JLabel("Jumlah Kamar");
    JLabel lcek_in = new JLabel("Cek in");
    JLabel lcek_out = new JLabel("Cek out");
    
    JTextField tfnama = new JTextField();
    JTextField tfalamat = new JTextField();
    JTextField tftelepon = new JTextField();
    JTextField tfpilihan = new JTextField();
    JTextField tfjumlah_kamar = new JTextField();
    JTextField tfcek_in = new JTextField();
    JTextField tfcek_out = new JTextField();
    
    JButton btnSubmit = new JButton("Submit");
    JButton btnReset = new JButton("Reset");
    JButton btnKembali = new JButton("Kembali");
    
    public EditPesanan(ModelPesanan pesanan ){
        System.out.println(pesanan.getId());
        System.out.println(pesanan.getNama());
        System.out.println(pesanan.getAlamat());
        System.out.println(pesanan.getTelepon());
        System.out.println(pesanan.getPilihan());
        System.out.println(pesanan.getJumlah_kamar());
        System.out.println(pesanan.getCek_in());
        System.out.println(pesanan.getCek_out());
        window.setLayout(null);
        window.setSize(450, 360);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE); 

        window.add(ljudul);
        window.add(lnama);
        window.add(tfnama);
        window.add(lalamat);
        window.add(tfalamat);
        window.add(ltelepon);
        window.add(tftelepon);
        window.add(lpilihan);
        window.add(tfpilihan);
        window.add(ljumlah_kamar);
        window.add(tfjumlah_kamar);
        window.add(lcek_in);
        window.add(tfcek_in);
        window.add(lcek_out);
        window.add(tfcek_out);
        window.add(btnSubmit);
        window.add(btnReset);
        window.add(btnKembali);

        ljudul.setBounds(175, 5, 200, 30);
        lnama.setBounds(20, 35, 200, 30);
        lalamat.setBounds(20, 65, 200, 30);
        ltelepon.setBounds(20, 95, 200, 30);
        lpilihan.setBounds(20, 125, 200, 30);
        ljumlah_kamar.setBounds(20, 155, 200, 30);
        lcek_in.setBounds(20, 185, 200, 30);
        lcek_out.setBounds(20, 215, 200, 30);
        
        tfnama.setBounds(150, 35, 270, 30);
        tfalamat.setBounds(150, 65, 270, 30);
        tftelepon.setBounds(150, 95, 270, 30);
        tfpilihan.setBounds(150, 125, 270, 30);
        tfjumlah_kamar.setBounds(150, 155, 270, 30);
        tfcek_in.setBounds(150, 185, 270, 30);
        tfcek_out.setBounds(150, 215, 270, 30);
        
        btnSubmit.setBounds(100, 250, 130, 25);
        btnReset.setBounds(235, 250, 130, 25);
        btnKembali.setBounds(10, 280, 400, 30);
        
        btnReset.setBackground(Color.red);
        btnSubmit.setBackground(Color.green);
        
        String jumlahh=String.valueOf(pesanan.getJumlah_kamar());
        
        tfnama.setText(pesanan.getNama());
        tfalamat.setText(pesanan.getAlamat());
        tftelepon.setText(pesanan.getTelepon());
        tfpilihan.setText(pesanan.getPilihan());
        tfjumlah_kamar.setText(jumlahh);
        tfcek_in.setText(pesanan.getCek_in());
        tfcek_out.setText(pesanan.getCek_out());
        
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String nama = tfnama.getText();
                    String alamat = tfalamat.getText();
                    String telepon = tftelepon.getText();
                    String pilihan = tfpilihan.getText();
                    double jumlah_kamar = Double.parseDouble(tfjumlah_kamar.getText());
                    String cek_in = tfcek_in.getText();
                    String cek_out = tfcek_out.getText();

                    if(jumlah_kamar < 0){
                        throw new ArithmeticException("Bilangan Harus Positif");      
                    }
                    
                    pesanan.setPesanan(nama, alamat, telepon, pilihan, jumlah_kamar, cek_in, cek_out);
                    
                    if(edit.edit(pesanan)){
                        window.dispose();
                        new MenuAdmin();
                        
                        JOptionPane.showMessageDialog(null, "Update Berhasil");
                    }else{
                        JOptionPane.showMessageDialog(null, "Update Gagal");
                    }

                }catch(Exception ex){
                    System.out.print(ex.getMessage());
                    if (tfnama.getText().equals("")||tfalamat.getText().equals("")||tftelepon.getText().equals("")||tfpilihan.getText().equals("")||tfcek_in.getText().equals("")||tfcek_out.getText().equals("")||tfjumlah_kamar.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Harus diisi");
                    }else if ("Bilangan Harus Positif".equals(ex.getMessage())) {
                        JOptionPane.showMessageDialog(null,ex.getMessage()); 
                    }
                    tfnama.setText("");
                    tfalamat.setText("");
                    tftelepon.setText("");
                    tfpilihan.setText("");
                    tfjumlah_kamar.setText("");
                    tfcek_in.setText("");
                    tfcek_out.setText("");
                }
            }
        });
        
        btnReset.addActionListener((ActionEvent arg0) -> {
            tfnama.setText("");
            tfalamat.setText("");
            tftelepon.setText("");
            tfpilihan.setText("");
            tfjumlah_kamar.setText("");
            tfcek_in.setText("");
            tfcek_out.setText("");
        });
        
        btnKembali.addActionListener((ActionEvent arg0) -> {
            window.dispose();
            new MenuAdmin();
        });
    }
}
