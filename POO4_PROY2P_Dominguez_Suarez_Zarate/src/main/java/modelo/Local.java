/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.pooespol.poo2p.App;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *Esta clase pretende construir locales
 * @author DELL
 */
public class Local {
    String nombre,horario,direccion;
    double coordenadaX,coordenadaY;

    /**
     * Constructor de local
     * @param nombre. Nombre del local
     * @param horario. Horario de atencion del local
     * @param direccion. Direccion del local
     * @param coordenadaX. Posicion del eje X del local en el mapa
     * @param coordenadaY. Posicion del eje Y del local en el mapa 
     */
    public Local(String nombre, String horario, String direccion, double coordenadaX, double coordenadaY) {
        this.nombre = nombre;
        this.horario = horario;
        this.direccion = direccion;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    /**
     * 
     * @return Devuelve el nombre del local
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre del local
     * @param nombre. Nuevo nombre del local 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return Devuelve el horario de atencion del local
     */
    public String getHorario() {
        return horario;
    }

    /**
     * Cambia el horario de atencion del local
     * @param horario. Nuevo horario del local 
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * 
     * @return Devuelve la direccion del local
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Cambia la direccion del local
     * @param direccio. Nueva direccion del local 
     */
    public void setDireccion(String direccio) {
        this.direccion = direccio;
    }

    /**
     * 
     * @return Devuelve la coordenada x en el mapa 
     */
    public double getCoordenadaX() {
        return coordenadaX;
    }

    /**
     * Cambia la coordenada x en el mapa
     * @param coordenadaX. Nueva coordenada X 
     */
    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    /**
     * 
     * @return Devuelve la corrdenada Y en el mapa 
     */
    public double getCoordenadaY() {
        return coordenadaY;
    }

    /**
     * Cambia la coordenada Y en el mapa
     * @param coordenadaY. Nueva coordenada Y  
     */
    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    /**
     * Sobreescritura del metodo toString
     * @return Devuelve los atriburos de la clase local en String
     */
    @Override
    public String toString() {
        return "Local{" + "nombre=" + nombre + ", horario=" + horario + ", direccio=" + direccion + ", coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + '}';
    }
    
    /**
     * Lee los locales y los devuelve en una lista de locales
     * @return Devuelve una lista de locales
     */
    public static ArrayList<Local> cargarLocales(){
        ArrayList<Local> listaLocales=new ArrayList<>();
        try(BufferedReader bf=new BufferedReader(new FileReader(App.rutaFile+"locales.txt",StandardCharsets.UTF_8))){
            String linea= bf.readLine();
            while((linea=bf.readLine())!=null){
                String datos[]=linea.strip().split(",");
                Local l=new Local(datos[0],datos[1],datos[2],Double.valueOf(datos[3]),Double.valueOf(datos[4]));
                listaLocales.add(l);
            }
        }catch(IOException e){
            System.out.println("Archivo no encontrado");
        }
        return listaLocales;
    }
}
