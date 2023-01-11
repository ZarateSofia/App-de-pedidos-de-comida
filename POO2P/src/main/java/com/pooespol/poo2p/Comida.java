
package com.pooespol.poo2p;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class Comida {

    private String descripcion,tipo;
    private double precio;
    public static ArrayList<Comida> menu= new ArrayList<>();

    public Comida(String descripcion, double precio, String tipo) {
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Comida: " + descripcion + ", tipo=" + tipo + ", precio=" + precio;
    }
    
    
    
    
    
    public static ArrayList<Comida> CargarMenu(){
        try(BufferedReader bf=new BufferedReader(new FileReader(App.ruta+"Menu.txt",StandardCharsets.UTF_8))){
        String linea= bf.readLine();
        while(linea!=null){
            String datos[]=linea.strip().split(",");
            Comida comida=new Comida(datos[0],Double.parseDouble(datos[1]),datos[2]);
            menu.add(comida);
            linea=bf.readLine();
        }
        }catch(IOException |RuntimeException e){
                    //System.out.println("Archivo no encontrado "+e.getMessage());
        }
        return menu;
    }
    
    
    
}
