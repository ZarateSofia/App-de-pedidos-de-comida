/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.poo2p;

import java.io.Serializable;
import java.util.ArrayList;
import modelo.Cliente;

/**
 *
 * @author DELL
 */
public class Pedido implements Serializable, Comparable<Pedido>{
    
    String descripcion;
    String cantidad;
    double precio;
    
    ArrayList<Pedido> ListaP;
    modelo.Cliente client;
    String direccion;
    double subtotal,iva,total;

    
    public Pedido(String descripcion, String cantidad, double precio) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Pedido(ArrayList<Pedido> ListaP, Cliente client, String direccion, double subtotal, double iva, double total) {
        this.ListaP = ListaP;
        this.client = client;
        this.direccion = direccion;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
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

    public ArrayList<Pedido> getListaP() {
        return ListaP;
    }

    public void setListaP(ArrayList<Pedido> ListaP) {
        this.ListaP = ListaP;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
   

    @Override
    public String toString() {
        return "Descripcion=" + descripcion + ", cantidad=" + cantidad + ", precio=" + precio;
    }

    @Override
    public int compareTo(Pedido o) {
        if(this.precio>o.precio){
            return 1;
        }else if(this.precio<o.precio){
            return -1;
        }
        return 0;
    }
    
    public int compareToNombre(Pedido o) {    
        return this.descripcion.compareToIgnoreCase(o.descripcion);
    }
    
    
    
    
}
