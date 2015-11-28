/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transacciones;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 *
 * @author Juanta
 */
public class pruebas {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
     transaccionProductos productos = new transaccionProductos();
 //    int total = productos.asignarCodigoProducto();
	//Poductos.InsertarProducto("0003","Lino",2.50,1,50,false,"tela Lino",1);
     //productos.BuscarCliente(1111);
       // System.err.println("Correcto ingreso   " );
    //  Marca marca = new Marca();
     // marca.nuevaMarca("ota marca");
     int cod = productos.obtenerCodigo();
     String Codigo = "T-"+cod;
     System.out.println(Codigo);
       
     Calendar fecha = new GregorianCalendar();
     int año = fecha.get(Calendar.YEAR);
     int mes = fecha.get(Calendar.MONTH)+1;
     int dia = fecha.get(Calendar.DAY_OF_MONTH);
     boolean bdia = false;
     boolean bmes = false;
     String ndia,nmes;
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
     Codigo="T"+año+nmes+mes+ndia+dia+"-"+cod; 
     System.out.println(Codigo);

    }
    
}
