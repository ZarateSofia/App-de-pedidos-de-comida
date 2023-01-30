/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Esta clase construye una excepcion verificada
 * @author DELL
 */
public class ValorInsuficienteException extends Exception{
    
    /**
     * Constructor de excepcion verificada
     * @param msg. Mensaje que se mostrara cuando suceda la excepcion 
     */
    public ValorInsuficienteException(String msg){
        super(msg);
    }    
}
