
package modelo;

import com.pooespol.poo2p.App;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Esta clase pretende construir comida
 * @author Gamer
 */
public class Comida {

    private String descripcion,tipo;
    private double precio;
    public static ArrayList<Comida> menu= new ArrayList<>();

    /**
     * Constructor de comida
     * @param descripcion. Descripcion de la comida
     * @param precio. Precio de la comida
     * @param tipo. El tipo de comida 
     */
    public Comida(String descripcion, double precio, String tipo) {
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.precio = precio;
    }

    /**
     * 
     * @return Devuelve la descripcion de la comida 
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Cambia la descripcion de la comida
     * @param descripcion. Nueva descripcion de comida 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * 
     * @return Devuelve el tipo de comida
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Cambia el tipo de comida
     * @param tipo. Nuevo tipo de comida 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * 
     * @return Devuelve el tipo de comida 
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Cambia el precio de comida
     * @param precio. Nuevo precio de comida 
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Sobreescritura del metodo toString
     * @return Devuelve los atributos de la clase en String
     */
    @Override
    public String toString() {
        return "Comida: " + descripcion + ", tipo=" + tipo + ", precio=" + precio;
    }
    
    
    /**
     * Lee el menu y los devuelve en una lista de comida
     * @return Devuelve una lista de comida
     */
    public static ArrayList<Comida> CargarMenu(){
        try(BufferedReader bf=new BufferedReader(new FileReader(App.rutaFile+"Menu.txt",StandardCharsets.UTF_8))){
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
