<%@page import="pe.com.upn.tools.Autentica" %>
<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validacion de usuario</title>
    </head>
    <body>
        <%
            Autentica autentica = new Autentica();
            boolean isAuthenticated = false;
            String redirectPage = "noautorizado.jsp";

            // Validación de administrador
            String usr = request.getParameter("usuario");
            String psw = request.getParameter("password");
            if (usr != null && psw != null) {
                isAuthenticated = autentica.getLogueado(usr, psw);
                if (isAuthenticated) {
                    redirectPage = "dashboard.jsp";
                } else {
                    System.out.println("Autenticación fallida para administrador: usuario=" + usr + ", contraseña=" + psw);
                }
            }

            // Validación de cliente
            if (!isAuthenticated) {
                String clie = request.getParameter("nombre");
                String cont = request.getParameter("contraseña");
                if (clie != null && cont != null) {
                    isAuthenticated = autentica.getLogin(clie, cont);
                    if (isAuthenticated) {
                        redirectPage = "dashCliente.jsp";
                    } else {
                        System.out.println("Autenticación fallida para cliente: nombre=" + clie + ", contraseña=" + cont);
                    }
                }
            }

            System.out.println("Redirigiendo a página: " + redirectPage);
            response.sendRedirect(redirectPage);
        %>
    </body>
</html>

