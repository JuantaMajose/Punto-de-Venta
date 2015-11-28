/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transacciones;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DEOCCIDENTE
 */
public class TransaccionesLogin {
    
    public int verificarExistenUsuarios() throws ClassNotFoundException{
           int valmax = 0;
       try {
            
            ResultSet rs= null;
            Connection con= null;
            Statement stm= null;
            con=conexion.getConexion();
            stm= con.createStatement();
            
            String comando= "SELECT count(*) FROM Usuarios";
            
            rs=stm.executeQuery(comando);
            
            while(rs.next()){
                valmax=rs.getInt(1);
            }
            rs.close();
            con.close();
            stm.close();
            return valmax;
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valmax;
   }
    
   
    public int VerificarLogin(String nom, String pasword) throws ClassNotFoundException{
       String Nombre = null;
       String Pass= null;
       String tipo= null;
        try {
            
            ResultSet rs= null;
            Connection con= null;
            Statement stm= null;
            con=conexion.getConexion();
            stm= con.createStatement();
            
            String comando= "SELECT Nombre, Password,Tipo FROM Usuarios WHERE Nombre='"+nom+"' AND Password='"+pasword+"'";
            
            rs=stm.executeQuery(comando);
            
            while(rs.next()){
                Nombre=rs.getString("Nombre");
                Pass=rs.getString("Password");
                tipo=rs.getString("Tipo");
            }
            rs.close();
            con.close();
            stm.close();
            //1= administrador
            //2= usuario
            //3= no existe
            if(Nombre.equals(nom) && Pass.equals(pasword)  && tipo.equals("1")){
                return 1;
            }else{
                if(Nombre.equals(nom) && Pass.equals(pasword) && tipo.equals("2")){
                    return 2;
                }else{
                    return 3;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionVentas.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return 0;
    }
    
    public void insertarUsuario(String nomb, String pass, String tipo) throws SQLException{
        Connection con= null;
         boolean bandera=false;
         PreparedStatement ps= null;
        try {
            con=conexion.getConexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(transacionClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
         String cadena= "INSERT INTO Usuarios (Nombre,Password,Tipo) VALUES (?,?,?)";
           
             ps= con.prepareStatement(cadena);
            
             ps.setString(1, nomb);
             ps.setString(2, pass);
             ps.setString(3, tipo);
              bandera=ps.executeUpdate()==1;
             ps.close();
             con.close();
    }
    
    public boolean CambiarPass(String NameUser, String OldPass, String NewPass, String RetriPass) throws ClassNotFoundException, SQLException{
        
        boolean test1, test2 = false, test3;
        if(VerificarLogin(NameUser, OldPass)==1 || VerificarLogin(NameUser, OldPass)==2){
            test1= true;
            if(NewPass.equals(RetriPass)){
                test2= true;
                
            }else{
                test2=false;
            }
        }else{
            test1=false;
        }
        
        if(test1== true && test2==true){
            boolean bandera=false;
		Connection con= null;
                con=conexion.getConexion();
		Statement st = con.createStatement();
                String cadena= "UPDATE Usuarios SET " + "Password = '"+NewPass+"'WHERE Nombre = '"+NameUser+"'";
                 int cont = st.executeUpdate(cadena);
       
		con.close();
             return true;
        }else{
           
        return false; 
        }
       
        
    }
    
    
    
    
}
