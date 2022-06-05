/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Model;
import Model.ModelMenu;
import Model.menu;
import View.MenuRegister;
import View.Login;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian Sirait
 */
public class RegisterSystem {
    Model intf;
    MenuRegister reg;

    public RegisterSystem(MenuRegister reg) {
        intf = new ModelMenu();
        this.reg = reg;
    }

    
    public void register(){
        String cek;
        int panjang;
    menu regis = new menu();
    cek = reg.getReg_password().getText();
    panjang = cek.length();
    if (panjang < 8){
    JOptionPane.showMessageDialog(reg, "Password Anda Kurang Panjang");
    reg.dispose();
    new MenuRegister().setVisible(true);
    } 
    else {
        regis.setUsername(reg.getReg_username().getText());
        regis.setPass(reg.getReg_password().getText());
        intf.add(regis);
        JOptionPane.showMessageDialog(reg, "Anda Berhasil Mendaftar");
        kembali();
        }
    }
    public void kembali(){
        reg.dispose();
        new Login().setVisible(true);
    }
}
