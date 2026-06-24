/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upsjb.Sesion09F.DAO;

import com.upsjb.Sesion09F.ModeloDT.Bien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BienDAO {

    public void insertar(Bien bien) {

        String sql =
        "INSERT INTO bienes(nombre,cantidad,estado,ubicacion)"
        + " VALUES(?,?,?,?)";

        try (Connection conn = ConexionBD.conexion();
             PreparedStatement ps =
             conn.prepareStatement(sql)) {

            ps.setString(1, bien.getNombre());
            ps.setInt(2, bien.getCantidad());
            ps.setString(3, bien.getEstado());
            ps.setString(4, bien.getUbicacion());

            ps.executeUpdate();

            IO.print("Bien registrado");

        } catch (Exception e) {

            IO.print(e.getMessage());
        }
    }
    // Metodo para eiminar un bien de la base de datos según su ID
    public void eliminar(int id){
        //Consulta SQL que elimina el registro cuyo id_bien coincida con el parámetro
            String sql = "DELETE FROM bienes WHERE id_bien = ?";
            try(//Se establece la conexion a la base de datos
                    Connection conn = ConexionBD.conexion(); 
                    //Se prepara la consulta SQL para ejecutarse de forma segura
                    PreparedStatement ps = conn.prepareStatement(sql)) {
                //Se asigna el ID recibido como pa´rametro en el lugar del signo "?"
                ps.setInt(1, id);
                // Se ejecuta la consulta DELETE en la base de Datos
                ps.executeUpdate();
                // Mensaje de confirmación si el bien fue eliminado exitosamente
                IO.print("Bien eliminado");
            
        } catch (Exception e) {
            //Si ocurre algun error se muestra el emnsaje de la excepcion
            IO.print(e.getMessage());
        }
    }
    // Metodo Listar todos los bienes
    public List<Bien> listar(){
        List<Bien> lista = new ArrayList();
        String sql = "SELECT * FROM bienes";
        try (Connection conn = ConexionBD.conexion(); 
               PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
            // Recorre cada fila del resultado
            while(rs.next()){
                Bien b = new Bien();
                b.setIdBien(rs.getInt("id_bien"));
                b.setNombre(rs.getString("nombre"));
                b.setCantidad(rs.getInt("cantidad"));
                b.setEstado(rs.getString("estado"));
                b.setUbicacion(rs.getString("ubicacion"));
                lista.add(b);
                
            }
            
            
        } catch (Exception e) {
            IO.print(e.getMessage());
        }
        return lista;
    }
}
