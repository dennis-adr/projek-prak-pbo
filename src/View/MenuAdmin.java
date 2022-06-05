/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Kato
 */
public class MenuAdmin extends JFrame {
    JFrame window = new JFrame("Menu Admin");
    JLabel ljudul = new JLabel("Menu Admin");
    
    JButton btnPesanan = new JButton("Lihat Pesanan");
    JButton btnKamar = new JButton("Lihat Daftar Kamar");
  
    public MenuAdmin(){
        window.setLayout(null);
        window.setSize(300, 150);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE); 

        window.add(ljudul);
        window.add(btnPesanan);
        window.add(btnKamar);
        ljudul.setBounds(100, 5, 120, 15);

        btnPesanan.setBounds(60, 25, 150, 30);
        btnKamar.setBounds(60, 65, 150, 30);
        
        btnPesanan.addActionListener((ActionEvent arg0) -> {
            window.dispose();
            new AdminLihatPesanan();
        });
        
        btnKamar.addActionListener((ActionEvent arg0) -> {
            window.dispose();
            new ListKamarAdmin().setVisible(true);
        });
    }
}
