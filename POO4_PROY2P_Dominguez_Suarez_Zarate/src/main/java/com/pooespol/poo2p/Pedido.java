/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.poo2p;

import java.io.Serializable;
import java.util.ArrayList;
import modelo.Cliente;

/**
 *Esta clase pretende construir pedidos para ser requeridos por un cliente
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

    /**
     * Constructor de un pedido sin elegir
     * @param descripcion. Es la descripcion del pedido a mostrar
     * @param cantidad. Cantidad de lo que se requiere del pedido
     * @param precio. Precio por cantidad de pedido
     */
    public Pedido(String descripcion, String cantidad, double precio) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    /**
     * Constructor de un pedido elegido por un usario
     * @param ListaP. Son todos los pedidos que el cliente a querido ordenar
     * @param client. El cliente que ordena el pedido
     * @param direccion. Direccion del local
     * @param subtotal. Precio de la orden sin iva
     * @param iva. Impuesto que se agrega al subtotal
     * @param total. El total a pagar por el cliente
     */
    public Pedido(ArrayList<Pedido> ListaP, Cliente client, String direccion, double subtotal, double iva, double total) {
        this.ListaP = ListaP;
        this.client = client;
        this.direccion = direccion;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
    }

    /**
     * 
     * @return Devuelve la descripcion del pedido
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Cambia la descripcion del pedido
     * @param descripcion. Esta sera la nueva descripcion del pedido
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    /**
     * 
     * @return Devuelve la cantidad del pedido
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * Cambia la cantidad del pedido
     * @param cantidad. Esta sera la nueva cantidad del pedido 
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * 
     * @return Devuelve el precio del pedido
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Cambia el precio del pedido
     * @param precio. Este sera el nuevo precio del pedido 
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * 
     * @return Devuelve la lista con todos los pedidos hecho por el cliente
     */
    public ArrayList<Pedido> getListaP() {
        return ListaP;
    }

    /**
     * Cambia la lista de pedidos realizados por el cliente
     * @param ListaP. Esta lista sera la nueva lista de pedidos hechos por el cliente
     */
    public void setListaP(ArrayList<Pedido> ListaP) {
        this.ListaP = ListaP;
    }

    /**
     * 
     * @return Devuelve el cliente que hace los pedidos
     */
    public Cliente getClient() {
        return client;
    }

    /**
     * Cambia el cliente
     * @param client. Este sera el nuevo cliente que realiza los pedidos
     */
    public void setClient(Cliente client) {
        this.client = client;
    }

    /**
     * 
     * @return Devuelve la dirección del local donde se realiza el pedido
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Cambia la dirección del local
     * @param direccion. Esta sera la nueva dirección del local donde se hacen los pedidos
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * 
     * @return Devuelve el precio total de los pedidos pero sin impuestos
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * Cambia el subtotal de un pedido
     * @param subtotal. Este sera el nuevo subtotal del pedido 
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * 
     * @return Devuelve el iva del pedido
     */
    public double getIva() {
        return iva;
    }

    /**
     * Cambia el iva del pedido
     * @param iva. Este sera el nuevo iva del pedido 
     */
    public void setIva(double iva) {
        this.iva = iva;
    }

    /**
     * 
     * @return Devuelve el precio total del pedido
     */
    public double getTotal() {
        return total;
    }

    /**
     * Cambia el precio total del pedido
     * @param total. Este será el nuevo total del pedido 
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
    
   /**
    * Sobreescritura del método toString
    * @return Devuelve los parámetros del pedido pero en String
    */
    @Override
    public String toString() {
        return "Descripcion=" + descripcion + ", cantidad=" + cantidad + ", precio=" + precio;
    }

    /**
     * Sobreescritura del método compareTo
     * @param o. Este es el pedido que sera comparado con otro pedido
     * @return Devuelve un 1 si el pedido que ingresa es menor a del que llama al método, y -1 en el caso contrario
     */
    @Override
    public int compareTo(Pedido o) {
        if((this.precio*Integer.valueOf(this.cantidad))>(o.precio*Integer.valueOf(o.cantidad))){
            return 1;
        }else if((this.precio*Integer.valueOf(this.cantidad))<(o.precio*Integer.valueOf(o.cantidad))){
            return -1;
        }
        return 0;
    }
    
//    public int compareToNombre(Pedido o) {    
//        return this.descripcion.compareToIgnoreCase(o.descripcion);
//    }
    
    
    
    
}
