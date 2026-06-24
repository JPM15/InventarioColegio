package com.upsjb.Sesion09F.DAO;

import com.upsjb.Sesion09F.ModeloDT.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    // Método de registro modificado a VOID y lanzando la excepción
    public void registrar(Usuarios usuario) throws Exception {
        // CORREGIDO: Nombres de columnas según tu SQL Server (Nick, Clave, Estado)
        String sql = "INSERT INTO Usuarios(Nick, Clave, Estado) VALUES(?, ?, ?)";

        // Quitamos el catch interno para que el JFrame capture si SQL Server rechaza el registro
        try (Connection conn = ConexionBD.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // CORREGIDO: Usando los métodos correctos de tu record (.nick())
            ps.setString(1, usuario.nick());
            ps.setString(2, usuario.clave());
            ps.setString(3, usuario.estado()); 

            ps.executeUpdate();
            System.out.println("Usuario registrado exitosamente en la BD");
        }
    }

    // Método para iniciar sesión corregido
    public Usuarios iniciarSesion(String nick, String clave) throws Exception {
        // CORREGIDO: Mapeado idéntico a las columnas de tu BD
        String sql = "SELECT IdUsuario, Nick, Clave, Estado FROM Usuarios WHERE Nick = ? AND Clave = ? AND Estado = 'Activo'";
        Usuarios usuarioLogueado = null;

        try (Connection conn = ConexionBD.conexion(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, nick);
            ps.setString(2, clave);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // CORREGIDO: Se extraen usando los nombres exactos de tu SQL Server
                    usuarioLogueado = new Usuarios(
                        rs.getInt("IdUsuario"),
                        rs.getString("Nick"),
                        rs.getString("Clave"),
                        rs.getString("Estado")
                    );
                }
            }
        }
        return usuarioLogueado; 
    }
}