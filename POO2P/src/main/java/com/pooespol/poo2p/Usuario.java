
package com.pooespol.poo2p;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Usuario {
    private String usuario,contraseña;
    public static ArrayList<Usuario> listaUsuarios=new ArrayList<>();
    public Usuario(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

//    @Override
//    public String toString() {
//        return  "Usuario=" + usuario + ", contraseña=" + contraseña ;
//    }
    
    public static ArrayList<Usuario> CargarUsuarios() {
        try ( BufferedReader bf = new BufferedReader(new FileReader(App.ruta + "Usuarios.txt"))) {
            String linea = bf.readLine();
            while (linea != null) {
                String datos[] = linea.strip().split(",");
                Usuario usr = new Usuario(datos[0], datos[1]);
                listaUsuarios.add(usr);
                linea = bf.readLine();
            }
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
        return listaUsuarios;

    }
    
    
    
    
    
    
}
