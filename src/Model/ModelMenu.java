/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Christian Sirait
 */
public class ModelMenu implements Model{
    Connection connection;
    final String select = "INSERT INTO user (username,password) VALUES (?, ?);";;

    public ModelMenu() {
        connection=koneksi.connection();
    }
    
    
    @Override
    public void add(menu data) {
         PreparedStatement statement = null;
          try {
            statement = connection.prepareStatement(select);
            statement.setString(1, data.getUsername());
            statement.setString(2, data.getPass());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
  
}
