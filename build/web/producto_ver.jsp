<%@page import="pe.com.upn.tablas.Producto" %>

<%
    String prd = request.getParameter("producto"); //varia siempre para el tipo de devolucion 
    Producto p = new Producto();
    p = p.ver(prd);
%>

<form action="dashProd.jsp?pagina=producto_listar" method="post">
    Codigo <br><!-- comment -->
    <input type="text" class="form-control" name="codigo" style="width: 30%" readonly value="<%=p.getCodigo()%>"> <br>
    Nombre <br><!-- comment -->
    <input type="text" class="form-control" name="nombre" style="width: 30%" readonly value="<%=p.getNombre()%>"> <br>
    Descripcion <br><!-- comment -->
    <input type="text" class="form-control" name="descripcion" style="width: 30%" readonly value="<%=p.getDescripcion()%>"> <br>
    Cantidad <br><!-- comment -->
    <input type="text" class="form-control" name="cantidad" style="width: 30%" readonly value="<%=p.getCantidad()%>"> <br><br><!-- comment -->    
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>