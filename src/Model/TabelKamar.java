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
public class TabelKamar extends AbstractTableModel{
    List<kamar> kamar;

    public TabelKamar(List<kamar> kamar) {
        this.kamar = kamar;
    }
    
    @Override
    public int getRowCount() {
       return kamar.size();
    }

    @Override
    public int getColumnCount() {
      return 3;
    }
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nama";
            case 1:
                return "Jumlah Kasur";
            case 2:
                return "Harga";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
     switch (columnIndex) {
            case 0:
                return kamar.get(rowIndex).getNama();
            case 1:
                return kamar.get(rowIndex).getJumlah_kasur();
            case 2:
                return kamar.get(rowIndex).getHarga();
            default:
                return null;
        }
    }
}
