/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

/**
 *
 * @author DEOCCIDENTE
 */
public class cliente {
    public String codigo;
    public String NombreCliente;
    public String ApellidoCliente;
    public String Direccion;
    public String Telefono;
    
    public cliente(){
        
    }
    public void setCodigoCliente(String codigo){
        this.codigo=codigo;
    }
    public void SetNombreCliente(String nombre){
        this.NombreCliente= nombre;
    }
    public void SetApellidoCliente(String apellido){
        this.ApellidoCliente= apellido;
    }
    public void SetDireccionCliente(String direccion){
        this.Direccion=direccion;
    }
    public void SetTelefonoCliente(String telefono){
        this.Telefono=telefono;
    }
    public String GetNombreCliente(){
        return this.NombreCliente;
    }
    public String GetApellidoCliente(){
        return this.ApellidoCliente;
    }
    public String GetDireccionCliente(){
        return this.Direccion;
    }
    public String GetTelefonoCliente(){
        return this.Telefono;
    }
    public String GetCodigoCliente(){
        return this.codigo;
    }
    
}
