
package com.mycompany.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author JOSE-
 */
public class MensajesService {
    
    public static void crearMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje: ");
        String mensaje = sc.nextLine();
        
        System.out.println("Escribe tu nombre: ");
        String nombre = sc.nextLine();
        
        Mensaje mensaj = new Mensaje();
        mensaj.setMensaje(mensaje);
        mensaj.setAutor_mensaje(nombre);
        
        MensajesDAO.crearMensajeBD(mensaj);
    }
    
    public static void listarMensajes() {
        MensajesDAO.leerMensajeDB();
    }
    
    public static void borrarMensaje() {
        System.out.println("Seleccione el ID de mensaje que desea borrar: ");
        MensajesDAO.leerMensajeDB();
        Scanner sc = new Scanner(System.in);
        int idOpcion = sc.nextInt();
        
        MensajesDAO.borrarMensajeDB(idOpcion);
    }
    
    public static void editarMensaje() {
        System.out.println("Escoge el ID del mensaje que deseas editar: ");
        MensajesDAO.leerMensajeDB();
        Scanner sc = new Scanner(System.in);
        int id_mensaje = sc.nextInt();
        
        System.out.println("Escribe el contenido del mensaje: ");
        String mensajeActualizado = sc.nextLine();
        
        Mensaje mensaje = new Mensaje();
        mensaje.setId_mensaje(id_mensaje);
        mensaje.setMensaje(mensajeActualizado);
        MensajesDAO.actualizarMensajeDB(mensaje);
    }
    
}
