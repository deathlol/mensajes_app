
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JOSE-
 */
public class MensajesDAO {
    
    public static void crearMensajeBD(Mensaje mensaje) {
        Conexion db_connect = new Conexion();
        
        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement pe = null;
            
            try {
                String query = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?, ?);";
                pe = conexion.prepareStatement(query);
                pe.setString(1, mensaje.getMensaje());
                pe.setString(2, mensaje.getAutor_mensaje());
                
                pe.executeUpdate();
                
                System.out.println("Mensaje insertado");
            } catch(SQLException ex) {
                System.out.println(ex);
            }
        } catch(SQLException sqlE) {
            System.out.println(sqlE);
        }
        
    }
    
    public static void leerMensajeDB() {
        Conexion db_connect = new Conexion();
        
        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement pe = null;
            ResultSet rs = null;
            
            String query = "SELECT * FROM mensajes;";
            pe = conexion.prepareStatement(query);
            rs = pe.executeQuery();
            
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_mensajes"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor del mensaje: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha del mensaje: " + rs.getDate("fecha_mensaje"));
                System.out.println("");
            }
        } catch(SQLException e) {
            System.out.println("No se pudieron recuperar los mensajes.");
            System.out.println(e);
        }
        
    }
    
    public static void borrarMensajeDB(int id_mensaje) {
        Conexion db_connect = new Conexion();
        
        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement pe = null;
            
            try {
                String query = "DELETE FROM mensajes WHERE id_mensajes = ?;";
                pe = conexion.prepareStatement(query);
                pe.setInt(1, id_mensaje);
                pe.executeUpdate();
                System.out.println("El mensaje ha sido borrado.");
            } catch (SQLException ex) {
                System.out.println(ex);
                System.out.println("No se pudo borrar el mensaje.");
            }
        } catch(SQLException e) {
            System.out.println(e);
        }
        
    }
    
    public static void actualizarMensajeDB(Mensaje mensaje) {
        Conexion db_connect = new Conexion();
        
        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement pe = null;
            
            try {
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensajes = ?;";
                pe = conexion.prepareStatement(query);
                pe.setString(1, mensaje.getMensaje());
                pe.setInt(2, mensaje.getId_mensaje());
                
                pe.executeUpdate();
                
                System.out.println("Mensaje actualizado");
            } catch(SQLException ex) {
                System.out.println(ex);
                System.out.println("No se pudo actualizar el mensaje");
            }
        } catch(SQLException sqlE) {
            System.out.println(sqlE);
        }
    }
    
}
