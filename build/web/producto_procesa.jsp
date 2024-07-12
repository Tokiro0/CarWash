<%@page import="pe.com.upn.tablas.Producto" %>
<%
    String pagina = "";    
    String codigo = "";
    String nombre = "";
    String descripcion = "";
    String cantidad = "";
    Producto p = new Producto();
    
    if (request.getParameter("codigo")!=null) {
        codigo = request.getParameter("codigo");
    }
    if (request.getParameter("nombre")!=null) {
        nombre = request.getParameter("nombre");
    } 
    if (request.getParameter("descripcion")!=null) {
        descripcion = request.getParameter("descripcion");
    }
    if (request.getParameter("cantidad")!=null) {
        cantidad = request.getParameter("cantidad");
    } 
    if (request.getParameter("pagina")!=null) {
        pagina = request.getParameter("pagina");
    }
    
    if (pagina.equals("producto_nuevo")) {
        p.nuevo(codigo, nombre,descripcion,cantidad);
        response.sendRedirect("dashProd.jsp?pagina=producto_listar");
    } else if (pagina.equals("producto_eliminar")) {
        p.eliminar(codigo);
        response.sendRedirect("dashProd.jsp?pagina=producto_listar");
    }

%>