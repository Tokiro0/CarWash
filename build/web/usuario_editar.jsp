<%@page import="pe.com.upn.tablas.Usuario" %>
<% 
    String usua= request.getParameter("usuario");
    Usuario a = new Usuario();
    a=a.ver(usua);
%>



<form action="ctrlUsuario" method="post">
    <input type="hidden" name="pagina" value="usuario_editar">
    <div class="row">
        <div class="col-sm-4">
            ID <br><!-- comment -->
            <input type="text" class="form-control" name="usuario_id" style="width: 90%" readonly value="<%=a.getUsuario_id()%>"> <br>
            NOMBRE <br><!-- comment -->
            <input type="text" class="form-control" name="usuario_nombre" style="width: 90%" value="<%=a.getUsuario_nombre()%>"> <br>
            APELLIDO<br><!-- comment -->
            <input type="text" class="form-control" name="usuario_apellido" style="width: 90%" value="<%=a.getUsuario_apellido()%>"> <br>    
            CORREO<br><!-- comment -->
            <input type="text" class="form-control" name="usuario_correo" style="width: 90%" value="<%=a.getUsuario_correo()%>"> <br>
        </div>
        <div class="col-sm-4">
              
            TELEFONO<br><!-- comment -->
            <input type="number" class="form-control" name="usuario_telefono" style="width: 90%" value="<%=a.getUsuario_telefono()%>"><br>  
            CONTRASEÑA<br><!-- comment -->
            <input type="text" class="form-control" name="usuario_password" style="width: 90%" value="<%=a.getUsuario_password()%>"><br>  
            ROL<br><!-- comment -->
            <input type="number" class="form-control" name="usuario_rol" style="width: 90%" value="<%=a.getUsuario_rol()%>">
        </div>
        <div class="col-sm-4"></div>
            
    </div>
        <a href="dashboard.jsp?pagina=usuario_listar" class="btn btn-danger">Cancelar</a>
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>