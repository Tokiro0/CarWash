<%@page import="pe.com.upn.tablas.Producto" %>

<%
    String prd = request.getParameter("producto");
    Producto p = new Producto();
    p = p.ver(prd);
%>

<form action="producto_procesa.jsp" method="post">
    Codigo <br><!-- comment -->
    <input type="text" class="form-control" name="codigo" style="width: 30%" readonly value="<%=p.getCodigo()%>"> <br>
    Nombre <br><!-- comment -->
    <input type="text" class="form-control" name="nombre" style="width: 30%" readonly value="<%=p.getNombre()%>"> <br>
    Descripcion <br><!-- comment -->
    <input type="text" class="form-control" name="descripcion" style="width: 30%" readonly value="<%=p.getDescripcion()%>"> <br>
    Cantidad <br><!-- comment -->
    <input type="text" class="form-control" name="cantidad" style="width: 30%" readonly value="<%=p.getCantidad()%>"> <br><br><!-- comment -->    
    <input type="hidden" name="pagina" value="producto_eliminar">
    <a href="dashProd.jsp?pagina=producto_listar" class="btn btn-danger">Cancelar</a>
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>