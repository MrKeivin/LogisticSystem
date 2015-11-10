<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema de Logistica</title>

</head>
<body>
<%

	String usuario_p="admin";
	String senha_p="admin";
	
	String usuario = request.getParameter("usuario");
	String senha = request.getParameter("senha");
	
 		if((usuario.equals(usuario_p)) && (senha.equals(senha_p))) {
 			response.sendRedirect("http://localhost:8081/LogisticSystem/Home.html");
 			
 			//out.println("Senha Correta");
 		}else{
 			out.println("Senha Incorreta");
 			//response.sendRedirect("http://localhost:8081/LogisticSystem/Login.html");
 		}






%>

</body>
</html>