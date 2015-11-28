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
public class producto {
    
    public String nombreProducto;
    public float precioProducto;
    public float precioUnitario;
    public float precioMayorista;
    public int existencias;
    public String descripsion;
    public String marca;
    
    public producto(){
    
}
  
    public void SetNombreProducto(String nombre){
        this.nombreProducto= nombre;
    }
    public void SetprecioProducto(float precio){
        this.precioProducto= precio;
    }
    public void SetPrecioUnitario(float precio){
        this.precioProducto= precio;
    }
    public void SetPrecioMayorista(float precio){
        this.precioMayorista= precio;
    }
    public void SetExistencias(int existencias){
        this.existencias= existencias;
    }
    public void SetDescripcion(String descripcion){
        this.descripsion= descripcion;
    }
    public void setMarca(String marca){
        this.marca= marca;
    }
    public String GetNombreProducto(){
        return this.nombreProducto;
    }
    public float GetPrecioProducto(){
        return this.precioProducto;
    }
    public float GetPrecioUnitario(){
        return this.precioUnitario;
    }
    public float GetPrecioMayorista(){
        return this.precioMayorista;
    }
    public int GetExistencias(){
        return this.existencias;
    }
    public String GetDescripcion(){
        return this.descripsion;
    }
    public String GetMarca(){
        return this.marca;
    }
    
}
