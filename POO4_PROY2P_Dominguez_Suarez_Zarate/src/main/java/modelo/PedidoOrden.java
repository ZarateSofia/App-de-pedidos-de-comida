
package modelo;

import com.pooespol.poo2p.Pedido;
import java.io.Serializable;
import java.util.ArrayList;


public class PedidoOrden implements Serializable {
    private ArrayList<Pedido> ListaP;
    private Cliente client;
    private String direccion;
    private double subtotal,iva,total;

    public PedidoOrden(ArrayList<Pedido> ListaP, Cliente client, String direccion, Double subtotal, Double iva, Double total) {
        this.ListaP = ListaP;
        this.client = client;
        this.direccion = direccion;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
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
    
    
    
    
    
    
    
    
}
