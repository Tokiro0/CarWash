package pe.com.upn.tools;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
        
public class Autentica {
    private String usuario;
    private String password;
    private int logueado;

    public Autentica() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }    

    public void setLogueado(int logueado) {
        this.logueado = logueado;
    }
    
    public int getLogueado(String usr, String psw) {
        
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            int contador = 0;
            
            String consulta = "Select usuario_rol from usuario where usuario_correo='"+
                    usr+"' and usuario_password='"+psw+"';";
            
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            
            if(resultado.next()) {
                logueado = resultado.getInt("usuario_rol");
            }
            return logueado;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }
}