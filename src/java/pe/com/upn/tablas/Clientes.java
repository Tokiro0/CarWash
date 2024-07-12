
package pe.com.upn.tablas;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import pe.com.upn.tools.Conexion;

public class Clientes {
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    
        public Clientes() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public LinkedList<Clientes> listar() {        
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();            
            String consulta = "Select * from clientes ";
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            LinkedList<Clientes> lista = new LinkedList<>();            
            while(resultado.next()) {
                Clientes usr = new Clientes();
                usr.nombre = resultado.getString("acceso_nombre");
                usr.apellido = resultado.getString("acceso_apellido");
                usr.correo = resultado.getString("acceso_correo");
                usr.telefono = resultado.getString("acceso_telefono");
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
    public Clientes ver(String usr) {        
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();            
            String consulta = "Select * from clientes where acceso_nombre='" + usr + "';";
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Clientes u = new Clientes();
            resultado.next();
            u.nombre = resultado.getString("acceso_nombre");
            u.apellido = resultado.getString("acceso_apellido");
            u.correo = resultado.getString("acceso_correo");
            u.telefono = resultado.getString("acceso_telefono");
            sentencia.close();
            cnx.close();
            return u;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }    
    public void nuevo(String usr, String psw, String email, String fono){
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();            
            String consulta = "insert into clientes values(?,?,?,?);";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setString(1, usr);
            sentencia.setString(2, psw);
            sentencia.setString(3, email);
            sentencia.setString(4, fono);
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
            String consulta = "delete from clientes where acceso_nombre=?;";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setString(1, usr);
            sentencia.executeUpdate();
            sentencia.close();
            cnx.close();            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }  
    public void editar(String usr, String nuevoNombre, String nuevoApellido, String nuevoCorreo, String nuevoTelefono) {
    try {
        Conexion c = new Conexion();
        Connection cnx = c.conecta();
        String consulta = "update clientes set acceso_nombre=?, acceso_apellido=?, acceso_correo=?, acceso_telefono=? where acceso_nombre=?;";
        PreparedStatement sentencia = cnx.prepareStatement(consulta);
        sentencia.setString(1, nuevoNombre);
        sentencia.setString(2, nuevoApellido);
        sentencia.setString(3, nuevoCorreo);
        sentencia.setString(4, nuevoTelefono);
        sentencia.setString(5, usr);
        sentencia.executeUpdate();
        sentencia.close();
        cnx.close();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}
}
