<%@page import="pe.com.upn.tablas.Producto" %>

<% 
    String prod= request.getParameter("producto");
    Producto a = new Producto();
    a=a.ver(prod);
%>
<form action="ctrlProducto" method="post">
    <input type="hidden" name="pagina" value="producto_editar">
    <div class="row">
        <br><br>
        <div class="col-sm-4">            
            Codigo <br><!-- comment -->
            <input type="text" class="form-control" name="codigo" style="width: 90%" readonly value="<%=a.getCodigo()%>"> <br>
            Producto <br><!-- comment -->
            <input type="text" class="form-control" name="nombre" style="width: 90%" value="<%=a.getNombre()%>"><!-- comment -->    
        </div>
        <div class="col-sm-4">
            Descripcion<br><!-- comment -->
            <input type="text" class="form-control" name="descripcion" style="width: 90%" value="<%=a.getDescripcion()%>"> <br><!-- comment -->        
            Cantidad<br><!-- comment -->
            <input type="number" class="form-control" name="cantidad" style="width: 90%" value="<%=a.getCantidad()%>"><br>
        </div>
        <div class="col-sm-4"></div>
    </div>
        <a href="dashProd.jsp?pagina=producto_listar" class="btn btn-danger">Cancelar</a>
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>