package pe.edu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import pe.com.upn.tools.Conexion;
import pe.edu.dao.DAO;
import pe.edu.dao.entity.Usuario;

/**
 *
 * @author tokiro
 */
public class UsuarioImpl extends Usuario implements DAO<Usuario> {

    public UsuarioImpl() {
    }
    
    @Override
    public Usuario ver(String id) {
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            String consulta = "Select * from usuario where usuario_id='" + id + "';";
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);            
            resultado.next();
            this.usuario_id = resultado.getString("usuario_id");
            this.usuario_nombre = resultado.getString("usuario_nombre");
            this.usuario_apellido = resultado.getString("usuario_apellido");
            this.usuario_correo = resultado.getString("usuario_correo");
            this.usuario_telefono = resultado.getString("usuario_telefono");
            this.usuario_password = resultado.getString("usuario_password");
            this.usuario_rol = resultado.getString("usuario_rol");
            sentencia.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public LinkedList<Usuario> listar() {
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            String consulta = "Select * from usuario ";
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            LinkedList<Usuario> lista = new LinkedList<>();
            while (resultado.next()) {
                Usuario usr = new Usuario();
                usr.setUsuario_id(resultado.getString("usuario_id"));
                usr.setUsuario_nombre(resultado.getString("usuario_nombre"));
                usr.setUsuario_apellido(resultado.getString("usuario_apellido"));
                usr.setUsuario_correo(resultado.getString("usuario_correo"));
                usr.setUsuario_telefono(resultado.getString("usuario_telefono"));
                usr.setUsuario_password(resultado.getString("usuario_password"));
                usr.setUsuario_rol(resultado.getString("usuario_rol"));                
                lista.add(usr);
            }
            sentencia.close();
            cnx.close();
            return lista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void nuevo(Usuario obj) {
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            //int xd = Integer.parseInt(id);
            String consulta = "insert into usuario values(?,?,?,?,?,?,?);";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setString(1, obj.getUsuario_id());
            sentencia.setString(2, obj.getUsuario_nombre());
            sentencia.setString(3, obj.getUsuario_apellido());
            sentencia.setString(4, obj.getUsuario_correo());
            sentencia.setString(5, obj.getUsuario_telefono());
            sentencia.setString(6, obj.getUsuario_password());
            sentencia.setString(7, obj.getUsuario_rol());
            sentencia.executeUpdate();
            sentencia.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(String id) {
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            int x = Integer.parseInt(id);
            String consulta = "delete from usuario where usuario_id=?;";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setInt(1, x);
            sentencia.executeUpdate();
            sentencia.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void editar(Usuario obj) {
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            String consulta = "update usuario ";
            consulta += "set usuario_nombre=?, usuario_apellido=?, usuario_rol=?,usuario_correo=?,usuario_password=?,  ";
            consulta += "usuario_telefono=? where usuario_id=?";

            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            
            sentencia.setString(1, obj.getUsuario_nombre());
            sentencia.setString(2, obj.getUsuario_apellido());
            sentencia.setString(3, obj.getUsuario_rol());
            sentencia.setString(4, obj.getUsuario_correo());
            sentencia.setString(5, obj.getUsuario_password());
            sentencia.setString(6, obj.getUsuario_telefono());
            sentencia.setString(7, obj.getUsuario_id());
            sentencia.executeUpdate();
            sentencia.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String obtenerUsuarioIdPorCorreo(String correo) {

        String usuarioId = null;
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            String consulta = "SELECT usuario_id FROM usuario WHERE usuario_correo = ?";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setString(1, correo);
            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                usuarioId = resultado.getString("usuario_id");
            }

            sentencia.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return usuarioId;
    }
}
