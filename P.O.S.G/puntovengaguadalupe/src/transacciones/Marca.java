/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transacciones;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juanta
 */
public class Marca {
    private String marca;
    private int id;

    public Marca() {
    }

    public Marca(String marca, int id) {
        this.marca = marca;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return marca; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean nuevaMarca (String Marca) throws SQLException{
        boolean bandera=false;
         Connection con= null;
            PreparedStatement ps= null;
        try {
            con=conexion.getConexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Marca.class.getName()).log(Level.SEVERE, null, ex);
        }
            String cadena= "INSERT INTO tblMarca(idtblMarca,NombreMarca)VALUES (?,?)";
           ps= con.prepareStatement(cadena);
            ps.setInt(1,0);
            ps.setString(2,Marca);
            
            bandera=ps.executeUpdate()==1;
            ps.close();
            con.close();
          
       
        return bandera;

}
    
}
