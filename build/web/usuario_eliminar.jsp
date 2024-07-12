<%@page import="pe.com.upn.tablas.Usuario"%>

<%
    String usr = request.getParameter("usuario");
    Usuario u = new Usuario();
    u = u.ver(usr);
%>

<form action="ctrlUsuario" method="post">
    Id <br><!-- comment -->
    <input type="text" class="form-control" name="usuario_id" style="width: 30%" readonly value="<%=u.getUsuario_id()%>"> <br>
    Nombre <br><!-- comment -->
    <input type="text" class="form-control" name="usuario_nombre" style="width: 30%" readonly value="<%=u.getUsuario_nombre()%>"> <br>
    Apellido <br><!-- comment -->
    <input type="text" class="form-control" name="usuario_apellido" style="width: 30%" readonly value="<%=u.getUsuario_apellido()%>"> <br>
    Correo <br><!-- comment -->
    <input type="text" class="form-control" name="usuario_correo" style="width: 30%" readonly value="<%=u.getUsuario_correo()%>"> <br>
    Telefono <br><!-- comment -->
    <input type="text" class="form-control" name="usuario_telefono" style="width: 30%" readonly value="<%=u.getUsuario_telefono()%>"> <br><br> 
    Nombre <br><!-- comment -->
    <input type="text" class="form-control" name="usuario_password" style="width: 30%" readonly value="<%=u.getUsuario_password()%>"> <br>
    Nombre <br><!-- comment -->
    <input type="text" class="form-control" name="usuario_rol" style="width: 30%" readonly value="<%=u.getUsuario_rol()%>"> <br>
    
    <input type="hidden" name="pagina" value="usuario_eliminar">
    <a href="dashboard.jsp?pagina=usuario_listar" class="btn btn-danger">Cancelar</a>
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>