<%@page import="pe.com.upn.tablas.Cita" %>
<%
    String pagina = "";
    String codigo = "";
    String placa = "";
    String fecha = ""; 
    String usuario_id = "";
    Cita c = new Cita();
    
    if (request.getParameter("codigo")!=null) {
        codigo = request.getParameter("codigo");
    }
    if (request.getParameter("placa")!=null) {
        placa = request.getParameter("placa");
    }
    if (request.getParameter("fecha")!=null) {
        fecha = request.getParameter("fecha");
    }
    if (request.getParameter("usuario_id") != null) {
        usuario_id = request.getParameter("usuario_id");
    }
    if (request.getParameter("pagina")!=null) {
        pagina = request.getParameter("pagina");
    }
    
    if (pagina.equals("cita_nuevo")) {
        c.nuevo(codigo, placa, fecha, usuario_id);
        response.sendRedirect("dashCitas.jsp?pagina=cita_listar");
    } else if (pagina.equals("cita_eliminar")) {
        c.eliminar(codigo);
        response.sendRedirect("dashCitas.jsp?pagina=cita_listar");
    }
%>