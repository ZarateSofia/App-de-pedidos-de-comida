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
 *
 * @author DELL
 */
public class Local {
    String nombre,horario,direccion;
    double coordenadaX,coordenadaY;

    public Local(String nombre, String horario, String direccion, double coordenadaX, double coordenadaY) {
        this.nombre = nombre;
        this.horario = horario;
        this.direccion = direccion;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccio) {
        this.direccion = direccio;
    }

    public double getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public double getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    @Override
    public String toString() {
        return "Local{" + "nombre=" + nombre + ", horario=" + horario + ", direccio=" + direccion + ", coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + '}';
    }
    
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
