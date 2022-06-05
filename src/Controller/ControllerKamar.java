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
public class ControllerKamar {
    ListKamar frame;
    intKamar kamar;
    Connection connection;
    List<kamar> list_kamar;

    public ControllerKamar(ListKamar frame) {
        this.frame = frame;
        kamar = new ModelKamar(connection);
        list_kamar = kamar.getData();
    }
    
    public void load_table() {
        TabelKamar tbl = new TabelKamar(list_kamar);
        frame.getTableData().setModel(tbl);
    }
    
    
}
