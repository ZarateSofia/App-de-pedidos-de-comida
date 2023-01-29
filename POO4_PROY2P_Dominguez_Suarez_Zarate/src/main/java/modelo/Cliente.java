
package modelo;

import com.pooespol.poo2p.App;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Esta clase pretende construir un cliente que haga pedidos
 * @author Gamer
 */
public class Cliente {
    private String Nombre,Apellido,Usuario,Contraseña,Direccion;
    private String TarjetaCredito;

    /**
     * Constructor de un cliente
     * @param Nombre. Nombre del cliente
     * @param Apellido. Apellido del cliente
     * @param Usuario. Este sera el usuario con el que el cliente ingrese a la plataforma
     * @param Contraseña. Clave que el usuario usa para entrar a la plataforma
     * @param Direccion. Direccion del cliente
     * @param TarjetaCredito. Aqui estará la tarjera de crédito del cliente 
     */
    public Cliente(String Nombre, String Apellido, String Usuario, String Contraseña, String Direccion, String TarjetaCredito) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
        this.Direccion = Direccion;
        this.TarjetaCredito = TarjetaCredito;
    }
    
    /**
     * Construcctor de un cliente con solo usuario y contraseña
     * @param Usuario. Usuario del cliente
     * @param Contraseña. Clave del cliente 
     */
    public Cliente(String Usuario, String Contraseña){
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
    }

    /**
     * 
     * @return Devuelve el nombre del cliente
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * Cambia el nombre del cliente
     * @param Nombre. Nuevo nombre del cliente 
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * 
     * @return Devuelve el apellido del cliente
     */
    public String getApellido() {
        return Apellido;
    }

    /**
     * Cambia el apellido del cliente
     * @param Apellido. Nuevo apellido del cliente 
     */
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    /**
     * 
     * @return Devuelve el usuario del cliente
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     * Cambia el usuario del cliente
     * @param Usuario. Nuevo usuario del cliente 
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    /**
     * 
     * @return Devuelve la contraseña del cliente
     */
    public String getContraseña() {
        return Contraseña;
    }

    /**
     * Cambia la clace del cliente
     * @param Contraseña. Nueva clave del cliente 
     */
    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    /**
     * 
     * @return Devuelve la direccion del cliente
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     * Cambia la direccion del cliente
     * @param Direccion. Nueva direccion del cliente 
     */
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    /**
     * 
     * @return Devuelve la tarjeta de credito del cliente 
     */
    public String getTarjetaCredito() {
        return TarjetaCredito;
    }

    /**
     * Cambia la tarjeta de credito del ciente
     * @param TarjetaCredito. Nueva tarjeta de credito del cliente 
     */
    public void setTarjetaCredito(String TarjetaCredito) {
        this.TarjetaCredito = TarjetaCredito;
    }

    /**
     * Sobreescritura del metodo toString
     * @return Devuelve el usuario y contraseña del cliente en String
     */
    @Override
    public String toString() {
        return  Usuario +" "+ Contraseña;
    }

    /**
     * Lee los clientes y los devuelve en una lista
     * @return Devuelve una lista de clientes
     */
    public static ArrayList<Cliente> CargarClientesCl(){
        ArrayList<Cliente> listaClientescl=new ArrayList<>();
        try(BufferedReader bf=new BufferedReader(new FileReader(App.rutaFile+"Clientes.txt"))){
        String linea= bf.readLine();
            while(linea!=null){
                String datos[]=linea.strip().split(",");
                Cliente cl=new Cliente(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5]);
                listaClientescl.add(cl);
                linea=bf.readLine();
            }
        }catch(IOException e){
            System.out.println("Archivo no encontrado");
        }
        return listaClientescl;
   
    }
    
}
