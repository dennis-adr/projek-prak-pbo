/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;
import java.util.List;
/**
 *
 * @author Christian Sirait
 */
public interface intPesan {
     public void insert(pesan pesan);

    public void update(pesan pesan);

    public void delete(int id);

    public List<pesan> getData();
}
