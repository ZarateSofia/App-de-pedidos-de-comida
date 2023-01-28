/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.poo2p;

/**
 *
 * @author DELL
 */
public class Pedido{
    String descripcion;
    String cantidad;
    double precio;

    
    public Pedido(String descripcion, String cantidad, double precio) {
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

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
   

    @Override
    public String toString() {
        return "Descripcion=" + descripcion + ", cantidad=" + cantidad + ", precio=" + precio;
    }
    
    
    
    
    
}
