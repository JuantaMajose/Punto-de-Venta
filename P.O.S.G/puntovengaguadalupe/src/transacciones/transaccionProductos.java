/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transacciones;

import com.mysql.jdbc.CallableStatement;
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
public class transaccionProductos {
	
	  public boolean InsertarProducto(String CodProd, String NombreProd, float PrecioUProd,float PrecMProd,int Existencias,boolean Estado, String descripcion, int Marca) throws SQLException{
	     boolean bandera=false;
		Connection con= null;
		PreparedStatement ps= null;
		 try {
			 con=conexion.getConexion();
             String cadena= "INSERT INTO tblProductos (CodProducto, NombreProducto,PrecioUProducto,PrecioMProducto,Existencias,Estado,DescripcionProducto,idtblMarca)VALUES (?,?,?,?,?,?,?,?)";
           
             ps= con.prepareStatement(cadena);
             
             
	     ps.setString(1,CodProd);
             ps.setString(2, NombreProd);
	     ps.setFloat(3,PrecioUProd);
             ps.setFloat(4,PrecMProd);
	     ps.setInt(5,Existencias);
             ps.setBoolean(6, Estado);
	     ps.setString(7,descripcion);
             ps.setInt(8, Marca);
			
			 bandera=ps.executeUpdate()==1;
             ps.close();;
             con.close();
             return bandera;
			  } catch (ClassNotFoundException ex) {
          
        }
          return false;
       
    }
          
          public boolean EditarProducto(String CodProdE,String CodProd, String NombreProd, double PrecioUProd,double PrecMProd,int Existencias,boolean Estado, String descripcion) throws SQLException, ClassNotFoundException{
	     boolean bandera=false;
		Connection con= null;
                con=conexion.getConexion();
		Statement st = con.createStatement();
                String cadena= "UPDATE tblProductos SET " + " CodProducto= '"+CodProd+"',NombreProducto = '"+NombreProd+ "' ,PrecioUProducto= "+PrecioUProd+ ", PrecioMproducto= "+PrecMProd+", Existencias= "+Existencias+",Estado= "+Estado+",DescripcionProducto= '"+descripcion+"' WHERE CodProducto = '"+ CodProdE+ "';";
              int cont = st.executeUpdate(cadena);
       
		con.close();
             return bandera;
    }
          public boolean EditarMarcaProducto(int Marca,String CodProdE) throws SQLException, ClassNotFoundException{
	     boolean bandera=false;
		Connection con= null;
                con=conexion.getConexion();
		Statement st = con.createStatement();
                String cadena= "UPDATE tblProductos SET idtblMarca= "+Marca+" WHERE CodProducto = '"+ CodProdE+ "';";
              int cont = st.executeUpdate(cadena);
       
		con.close();
             return bandera;
    } 
          
          
          
          public void EliminarProducto(String Codigo) throws SQLException, ClassNotFoundException{
             
		Connection con= null;
                con=conexion.getConexion();
		 Statement st = con.createStatement();
                String cadena= "UPDATE tblProductos SET Estado= false WHERE CodProducto = '"+Codigo+"';";
                int cont = st.executeUpdate(cadena);
                con.close();
          }
		
		

    public int obtenerMarca(int id) throws SQLException{
     Connection con= null;
        PreparedStatement ps= null;
        
              try {
                  con=conexion.getConexion();
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(transaccionProductos.class.getName()).log(Level.SEVERE, null, ex);
              }
            Statement st = con.createStatement();
            st = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT idtblMarca FROM tblMarca WHERE idtblMarca= "+ id + "");
            int marca = rs.getInt("idtblMarca");
             ps.close();;
             con.close();
              return marca;
   }
    
    public int obtenerCodigo() throws SQLException, ClassNotFoundException{
        Connection con= null;
        con=conexion.getConexion();
              java.sql.CallableStatement cst = con.prepareCall("CALL total(?);");
              cst.registerOutParameter(1, java.sql.Types.INTEGER);
              cst.execute();
              int total = cst.getInt(1);
              total=total+1;
               con.close();
              return total;
    }
}
