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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import objetos.cliente;
import objetos.producto;

/**
 *
 * @author DEOCCIDENTE
 */
public class TransaccionVentas {
    
    public cliente clientes=null;
      
   public cliente GetInfoCliente(String Codcliente) throws SQLException, ClassNotFoundException{
       clientes=new cliente();
        /*Connection con= null;
        con=conexion.getConexion();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT codCliente, NombreCliente, ApellidoCliente, DireccionCliente, TelefonoCliente FROM tblClientes WHERE codCliente " +Codcliente+"");
        ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
         st = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        clientes.SetNombreCliente(rs.getString("NombreCliente"));
        clientes.SetApellidoCliente(rs.getString("ApellidoCliente"));
        clientes.SetDireccionCliente(rs.getString("DireccionCliente"));
        clientes.SetTelefonoCliente(rs.getString("TelefonoCliente"));
        
        st.close();
        con.close();*/
        ResultSet rs= null;
        Connection con= null;
        Statement stm=null;
        String nombre=null;
        con=conexion.getConexion();
        stm= con.createStatement();
        String comando="SELECT codCliente, NombreCliente, ApellidoCliente, DireccionCliente, TelefonoCliente FROM tblClientes WHERE codCliente='"+Codcliente+"'";
        rs=stm.executeQuery(comando);
        while(rs.next()){
            
            clientes.SetNombreCliente(rs.getString("NombreCliente"));
            clientes.SetApellidoCliente(rs.getString("ApellidoCliente"));
            clientes.SetDireccionCliente(rs.getString("DireccionCliente"));
            clientes.SetTelefonoCliente(rs.getString("TelefonoCliente"));
        }
        rs.close();
        con.close();
        stm.close();
       
       
        return clientes;
   }
   
   public producto GetInfoProducto(String CodProducto) throws SQLException, ClassNotFoundException{
       producto produ= new producto();
       Connection con= null;
        con=conexion.getConexion();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT CodProducto, NombreProducto, PrecioUProducto, PrecioMProducto,Existencias,DescripcionProducto FROM tblProductos WHERE CodProducto like '%" +CodProducto+'%');
        ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
         st = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        produ.SetNombreProducto(rs.getString("NombreProducto").intern());
        produ.SetPrecioUnitario(rs.getFloat("PrecioUProducto"));
        produ.SetPrecioMayorista(rs.getFloat("PrecioMProducto"));
        produ.SetExistencias(rs.getInt("Existencias"));
        produ.SetDescripcion(rs.getString("DescripcionProducto"));
        
        st.close();
        con.close();
        return produ;
       
   }
   
    public boolean InsertarFactura(String CodCliente,float Preciofac, String fecha, float pago,float cambio,boolean activa) throws SQLException{
        try {
            boolean bandera=false;
            Connection con= null;
            PreparedStatement ps= null;
            con=conexion.getConexion();           
            String cadena= "INSERT INTO tblFactura (tblClientes_codCliente,FechaFactura,Total,PagoFactura,CambioFactura,Activa) VALUES (?,?,?,?,?,?)";
            ps= con.prepareStatement(cadena);
            ps.setString(1, CodCliente);
            ps.setString(2,fecha);
            ps.setFloat(3, Preciofac);
            ps.setFloat(4, pago);
            ps.setFloat(5, cambio);
            ps.setBoolean(6, activa);
            bandera= ps.executeUpdate()==1;
            con.close();
            ps.close();
            return bandera;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TransaccionVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void InsertarDetalleFactura(JTable tabla , int Numerofactura) throws SQLException{
       String codigo;
       float precio,subtotal;
       int cantidad;
        for(int i=0;i<tabla.getRowCount();i++){
          codigo= tabla.getValueAt(i, 0).toString();
           precio= Float.parseFloat(tabla.getValueAt(i, 2).toString());
           cantidad=Integer.parseInt(tabla.getValueAt(i, 3).toString());
           subtotal=Float.parseFloat(tabla.getValueAt(i, 4).toString());
            InsertarDatosDetalle(codigo, Numerofactura,precio,cantidad,subtotal);
        }
    }
    public void InsertarDatosDetalle(String CodigoProducto, int numeroFactura,float precio,int cantidad,float subtotal) throws SQLException{
         try {
            boolean bandera=false;
            Connection con= null;
            PreparedStatement ps= null;
            con=conexion.getConexion();           
            String cadena= "INSERT INTO tblProductos_has_tblFactura (tblProductos_CodProducto,tblFactura_idFactura,Precio,Cantidad,Subtotal) VALUES (?,?,?,?,?)";
            ps= con.prepareStatement(cadena);
            ps.setString(1, CodigoProducto);
            ps.setInt(2, numeroFactura);
            ps.setFloat(3, precio);
            ps.setInt(4, cantidad);
            ps.setFloat(5, subtotal);
            bandera= ps.executeUpdate()==1;
            con.close();
            ps.close();
          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TransaccionVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public int ObtenerNumeroFactura() throws ClassNotFoundException{
       int valmax = 0;
       try {
            
            ResultSet rs= null;
            Connection con= null;
            Statement stm= null;
            con=conexion.getConexion();
            stm= con.createStatement();
            
            String comando= "SELECT MAX(idFactura) FROM tblFactura";
            
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
   
    public int ObtenerNumerVenta() throws ClassNotFoundException{
       int valmax = 0;
       try {
            
            ResultSet rs= null;
            Connection con= null;
            Statement stm= null;
            con=conexion.getConexion();
            stm= con.createStatement();
            
            String comando= "SELECT Count(idFactura) FROM tblFactura";
            
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
    
    public void actualizarInventario(int cantidad, String codigo){
         int existencias=0;
         int NuevasExistencias=0;
        try {
            Connection con= null;
            con=conexion.getConexion();
            Statement st = con.createStatement();
            existencias=GetExistencias(codigo);
            NuevasExistencias= existencias-cantidad;
            String cadena= "UPDATE tblProductos SET Existencias= "+NuevasExistencias+" WHERE CodProducto = '"+codigo+"'";
            int cont = st.executeUpdate(cadena);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionVentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TransaccionVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int GetExistencias(String codigo){
        int existencias = 0;
       try {
            
            ResultSet rs= null;
            Connection con= null;
            Statement stm= null;
            try {
                con=conexion.getConexion();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TransaccionVentas.class.getName()).log(Level.SEVERE, null, ex);
            }
            stm= con.createStatement();
            
            String comando= "SELECT Existencias FROM tblProductos WHERE CodProducto = '"+codigo+"'";
            
            rs=stm.executeQuery(comando);
            
            while(rs.next()){
                existencias=rs.getInt(1);
            }
            rs.close();
            con.close();
            stm.close();
            return existencias;
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existencias;
    }
    
    public void devolucionSobreVentas(JTable tabla){
        
        for(int i=0;i<tabla.getRowCount();i++){
        String codigo=tabla.getValueAt(i, 0).toString();
        int cantidad= Integer.parseInt(tabla.getValueAt(i, 3).toString());
      
            devolucionProductoAInventario(codigo, cantidad);
        }
    }
    public void ActualizarEstadoFacturaFalse(int NoFac){
     
        try {
            Connection con= null;
            con=conexion.getConexion();
            Statement st = con.createStatement();
            
            String cadena= "UPDATE tblFactura SET Activa=False WHERE idFactura = '"+NoFac+"'";
            int cont = st.executeUpdate(cadena);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionVentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TransaccionVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    public void devolucionProductoAInventario(String codigo,int cantidad){
         int existencias=0;
         int NuevasExistencias=0;
        try {
            Connection con= null;
            con=conexion.getConexion();
            Statement st = con.createStatement();
            existencias=GetExistencias(codigo);
            NuevasExistencias= existencias+cantidad;
            String cadena= "UPDATE tblProductos SET Existencias= "+NuevasExistencias+" WHERE CodProducto = '"+codigo+"'";
            int cont = st.executeUpdate(cadena);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionVentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TransaccionVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  }
      
   
