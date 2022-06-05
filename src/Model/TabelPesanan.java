/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Christian Sirait
 */
public class TabelPesanan extends AbstractTableModel{
    List<pesan> pesan;

    public TabelPesanan(List<pesan> pesan) {
        this.pesan = pesan;
    }
    
    @Override
    public int getRowCount() {
      return pesan.size();// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getColumnCount() {
        return 7; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nama";
            case 1:
                return "Alamat";
            case 2:
                return "Telepon";
            case 3:
                return "Pilihan Kamar";
            case 4: 
                return "Jumlah Pesanan";
            case 5:
                return "Cek IN";
            case 6: 
                return "Cek Out";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch (columnIndex) {
            case 0:
                return pesan.get(rowIndex).getNama();
            case 1:
                return pesan.get(rowIndex).getAlamat();
            case 2:
                return pesan.get(rowIndex).getTelepon();
            case 3:
                return pesan.get(rowIndex).getPilihan();
            case 4: 
                return pesan.get(rowIndex).getJumlah_kamar();
            case 5:
                return pesan.get(rowIndex).getCek_in();
            case 6: 
                return pesan.get(rowIndex).getCek_out();
            default:
                return null;
        }
    }
    
}
