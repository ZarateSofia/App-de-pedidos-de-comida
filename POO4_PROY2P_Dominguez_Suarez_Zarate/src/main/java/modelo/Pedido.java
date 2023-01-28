/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class Pedido implements Serializable{
    String descripcion;
    int cantidad;
    double precio;

    
    public Pedido(String descripcion, int cantidad, double precio) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
    
    public void EscribirArchivoPedido(int idpedido,String nombreCliente, double total){
        try(BufferedWriter bfw=new BufferedWriter(new FileWriter("Pedidos.txt",true))){
            bfw.write(idpedido+","+nombreCliente+","+total);
            
        }catch(IOException ex){
            System.out.println("Error al escribir el archivo");
        }      
    }
    
    public void EscribirArchivoPedidoSerialido(Pedido p,int idPedido){
        try(ObjectOutputStream obj=new ObjectOutputStream(new FileOutputStream("pedido"+idPedido+".bin"))){
                obj.writeObject(p);          
        }catch(IOException e){
            System.out.println("Ocurrio un error durante la serializacion"+e);
        }   
    }
    
}
