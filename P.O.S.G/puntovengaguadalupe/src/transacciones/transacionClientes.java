/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transacciones;

import com.mysql.jdbc.ResultSetMetaData;
import conexion.conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DEOCCIDENTE
 */
public class transacionClientes {
 
    
    public void InsertarCliente(String nit, String Nombre, String Apellido,String Telefono,String direccion) throws SQLException{
         Connection con= null;
         boolean bandera=false;
         PreparedStatement ps= null;
        try {
            con=conexion.getConexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(transacionClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
         String cadena= "INSERT INTO tblClientes (codCliente,NombreCliente,ApellidoCliente,TelefonoCliente,DireccionCliente,EstadoCliente) VALUES (?,?,?,?,?,?)";
           
             ps= con.prepareStatement(cadena);
            
             ps.setString(1, nit);
             ps.setString(2, Nombre);
             ps.setString(3, Apellido);
             ps.setString(4,Telefono);
             ps.setString(5, direccion);
             ps.setBoolean(6, true);
              bandera=ps.executeUpdate()==1;
             ps.close();
             con.close();
       }
    
    public void BuscarCliente(int nit) throws SQLException, ClassNotFoundException{
        Connection con= null;
        con= conexion.getConexion();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT codCliente FROM tblClientes WHERE codCliente = 1111");
        ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
         st = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String  oto= rs.getString("codCliente").intern();
        st.close();
        con.close();
       
    }
    
    
     public void EliminarCliente(String nit) throws SQLException, ClassNotFoundException{
             
		Connection con= null;
                con=conexion.getConexion();
		Statement st = con.createStatement();
                String cadena= "UPDATE tblClientes SET EstadoCliente = false WHERE codCliente = '"+nit+"';";
                int cont = st.executeUpdate(cadena);
                con.close();
            
          }
     
       public boolean EditarCliente(String nit,String nombre, String apellido, String tel,String dir) throws SQLException, ClassNotFoundException{
	     boolean bandera=false;
		Connection con= null;
                con=conexion.getConexion();
		 Statement st = con.createStatement();
                 String cadena= "UPDATE tblClientes SET " + " codCliente= '"+nit+"',NombreCliente = '"+nombre+ "' ,ApellidoCliente= '"+apellido+ "', TelefonoCliente= '"+tel+"', DireccionCliente= '" +dir+ "' WHERE codCliente = '"+ nit+ "';";
             int cont = st.executeUpdate(cadena);
                con.close();
             return bandera;
    }
       public int obtenerCodigoCliente() throws SQLException, ClassNotFoundException{
        Connection con= null;
        con=conexion.getConexion();
              java.sql.CallableStatement cst = con.prepareCall("CALL numCliente(?);");
              cst.registerOutParameter(1, java.sql.Types.INTEGER);
              cst.execute();
              int total = cst.getInt(1);
              total=total+1;
               con.close();
              return total;
    }
       public String GenerarCodigo() throws SQLException, ClassNotFoundException{
           String CodigoC;
            int numero = obtenerCodigoCliente();
           boolean bdia = false;
           boolean bmes = false;
           String ndia,nmes,Codigo;
        
        Calendar fecha = new GregorianCalendar();
            int año = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH)+1;
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
          
            if(dia<=9){
               bdia=true;
            }
            if(mes<=9){
                bmes=true;
            }

            if(bdia==true){
                ndia="0";
            }else{
                ndia="";
            }
            if(bmes==true){
                nmes="0";
              }else{
                nmes="";
            }
        CodigoC="C"+nmes+mes+ndia+dia+"-"+numero;
        return CodigoC;
       }
}
    
