
package com.pooespol.poo2p;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Cliente {
    private String Nombre,Apellido,Usuario,Contraseña,Direccion;
    private String TarjetaCredito;
    public static ArrayList<Cliente> listaClientescl=new ArrayList<>();
    public static String[] listaClientes=new String[100];

    public Cliente(String Nombre, String Apellido, String Usuario, String Contraseña, String Direccion, String TarjetaCredito) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
        this.Direccion = Direccion;
        this.TarjetaCredito = TarjetaCredito;
    }
    
    public Cliente(String Usuario, String Contraseña){
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTarjetaCredito() {
        return TarjetaCredito;
    }

    public void setTarjetaCredito(String TarjetaCredito) {
        this.TarjetaCredito = TarjetaCredito;
    }

    @Override
    public String toString() {
        return  Usuario +" "+ Contraseña;
    }
    
    
   
    

 
    
    public static ArrayList<Cliente> CargarClientesCl(){
        try(BufferedReader bf=new BufferedReader(new FileReader(App.ruta+"Clientes.txt"))){
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
    
    
    
    
      public static String[] CargarClientes(){
        try(BufferedReader bf=new BufferedReader(new FileReader(App.ruta+"Clientes.txt"))){
        String primeralinea=bf.readLine();
        String linea= bf.readLine();
        for(int i=0; i<listaClientes.length-1;i++){
        while(linea!=null){
            String datos[]=linea.strip().split(",");
            Cliente cl=new Cliente(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5]);
            listaClientes[i]=cl.toString();
            linea=bf.readLine();
            i++;
        } //while
        }//for
        }catch(IOException e){
                    System.out.println("Archivo no encontrado");
        }
        return listaClientes;
   
    }

    


    
    
    
    
}
