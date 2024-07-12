
package pe.com.upn.tablas;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import pe.com.upn.tools.Conexion;

public class Usuario {
    private String usuario_id;
    private String usuario_nombre;
    private String usuario_apellido;
    private String usuario_telefono;
    private String usuario_correo;
    private String usuario_password;
    private String usuario_rol;
    
    public Usuario() {
    }

    public String getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    public String getUsuario_apellido() {
        return usuario_apellido;
    }

    public void setUsuario_apellido(String usuario_apellido) {
        this.usuario_apellido = usuario_apellido;
    }

    public String getUsuario_telefono() {
        return usuario_telefono;
    }

    public void setUsuario_telefono(String usuario_telefono) {
        this.usuario_telefono = usuario_telefono;
    }

    public String getUsuario_rol() {
        return usuario_rol;
    }

    public void setUsuario_rol(String usuario_rol) {
        this.usuario_rol = usuario_rol;
    }
    

    public String getUsuario_correo() {
        return usuario_correo;
    }

    public void setUsuario_correo(String usuario_correo) {
        this.usuario_correo = usuario_correo;
    }

    public String getUsuario_password() {
        return usuario_password;
    }

    public void setUsuario_password(String usuario_password) {
        this.usuario_password = usuario_password;
    }
    
    public LinkedList<Usuario> listar() {        
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();            
            String consulta = "Select * from usuario ";
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            LinkedList<Usuario> lista = new LinkedList<>();            
            while(resultado.next()) {
                Usuario usr = new Usuario();
                usr.usuario_correo = resultado.getString("usuario_correo");
                usr.usuario_password = resultado.getString("usuario_password");
                usr.usuario_nombre = resultado.getString("usuario_nombre");
                usr.usuario_apellido = resultado.getString("usuario_apellido");
                usr.usuario_id = resultado.getString("usuario_id");
                usr.usuario_rol= resultado.getString("usuario_rol");
                usr.usuario_telefono=resultado.getString("usuario_telefono");
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
    
    public void nuevo(String id, String nomb ,String ape, String corre,
            String tele, String pass ,String rol ){
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            int xd = Integer.parseInt(id);            
            
            String consulta = "insert into usuario values(?,?,?,?,?,?,?);";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setInt(1, xd);
            sentencia.setString(2, nomb);
            sentencia.setString(3, ape);
            sentencia.setString(4, corre);
            sentencia.setString(5, tele);
            sentencia.setString(6, pass);
            sentencia.setString(7, rol);
            sentencia.executeUpdate();
            sentencia.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Usuario ver(String usr) {        
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();            
            String consulta = "Select * from usuario where usuario_id='" + usr + "';";
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Usuario u = new Usuario();
            resultado.next();
            u.usuario_correo = resultado.getString("usuario_correo");
            u.usuario_password = resultado.getString("usuario_password"); 
            u.usuario_apellido = resultado.getString("usuario_apellido");
            u.usuario_telefono = resultado.getString("usuario_telefono");
            u.usuario_id = resultado.getString("usuario_id");
            u.usuario_nombre = resultado.getString("usuario_nombre");
            u.usuario_rol = resultado.getString("usuario_rol");
            sentencia.close();
            cnx.close();
            return u;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public void editar(String id, String nomb ,String ape, String corre,
            String tele, String contra ,String rol ) {
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            String consulta = "update usuario ";
            consulta += "set usuario_nombre=?, usuario_apellido=?, usuario_rol=?,usuario_correo=?,usuario_password=?,  ";
            consulta += "usuario_telefono=? where usuario_id=?";
         
            
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setString(7, id);
            sentencia.setString(1, nomb);
            sentencia.setString(2, ape);
            sentencia.setString(4, corre);
            sentencia.setString(6, tele);
            sentencia.setString(5, contra);
            sentencia.setString(3, rol);
            sentencia.executeUpdate();
            sentencia.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void eliminar(String usr) {        
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta(); 
            int x =Integer.parseInt(usr);
            String consulta = "delete from usuario where usuario_id=?;";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setInt(1,x);
            sentencia.executeUpdate();
            sentencia.close();
            cnx.close();            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
