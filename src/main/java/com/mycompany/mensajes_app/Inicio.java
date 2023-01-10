
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author JOSE-
 */
public class Inicio {
    
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        
        do {
            System.out.println("---------------------------");
            System.out.println("Aplicación de mensajes");
            System.out.println("1.-Crear mensaje");
            System.out.println("2.-Listar mensajes");
            System.out.println("3.-Editar mensaje");
            System.out.println("4.-Eliminar mensaje");
            System.out.println("5.-Salir");
            
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                    MensajesService.crearMensaje();
                    break; 
                case 2:
                    MensajesService.listarMensajes();
                    break;
                case 3:
                    MensajesService.editarMensaje();
                    break;
                case 4:
                    MensajesService.borrarMensaje();
                    break;
                default:
                    System.out.println("Escoja una opción válida");
                    break;
            }
            
        } while(opcion !=5);
    }
}
