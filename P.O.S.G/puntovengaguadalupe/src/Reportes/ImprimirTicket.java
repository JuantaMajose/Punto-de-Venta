/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JTable;

/**
 *
 * @author Administrador
 */
public class ImprimirTicket {
    
    
    
    public void PrintHeader(PrintWriter pw,String NoRecibo,String fecha,String hora){
     pw.println("      *COMERCIAL 'GUADALUPE'              ");
     pw.println("       Cantel, Quetzaltenango               ");
     pw.println("       RECIBO DE CAJA NO. "+NoRecibo+"    ");
     pw.println("       FECHA:  "+fecha+"                  ");
     pw.println("       HORA:  "+hora+"                       ");
     pw.println("------------------------------------------");
     
    }
public void PrintInformacionCliente(PrintWriter pw,String Nit, String NombreC, String apell, String Direcc, String tel){
     pw.println("NIT: "+Nit+""); 
     pw.println("Nombre: "+NombreC+"");
     pw.println("Apellido: "+apell+"");
     pw.println("Direccion: "+Direcc+"");
    /// pw.println("Telefono: "+Direcc+"");
     
}

public void PrintHeaderVenta(PrintWriter pw){
     pw.println("------------------------------------------");
     pw.println("COD                                       ");
     pw.println("PROD      CANT       PREC.        SubTotal");
     pw.println("..........................................");
    
}
public void PrintInformacionVenta(PrintWriter pw, JTable tabla){
    for(int i=0;i<tabla.getRowCount();i++){
     pw.println(tabla.getValueAt(i, 0).toString());
     System.out.println(tabla.getValueAt(i, 0).toString());
     if(tabla.getValueAt(i, 1).toString().length()>9){
       pw.println(tabla.getValueAt(i, 1).toString().substring(0, 8)+"   "+tabla.getValueAt(i, 3).toString()+"         "+tabla.getValueAt(i, 2).toString()+"          "+tabla.getValueAt(i, 4).toString());  
     }else{
      pw.println(tabla.getValueAt(i, 1).toString()+"        "+tabla.getValueAt(i, 3).toString()+"        "+tabla.getValueAt(i, 2).toString()+"          "+tabla.getValueAt(i, 4).toString());
         
     }
 }
    
   
}
public void PrintEndOfPage(PrintWriter pw,String total,String pago, String cambio){
    pw.println("                            TOTAL:"+total+"");
    pw.println("                            Pago:"+pago+"");
    pw.println("                            Cambio:"+cambio+"");
    pw.println();
    pw.println("     ***Es Un Gusto Poder Servirle***     ");
    for(int i=0;i<8;i++){
    pw.print("\r\n");
    }
    
}


}



