<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	function gravar(){
		document.getElementById("action").value"gravar";
	
	}
	function excluir(){
		document.getElementById("action").value="excluir";
		
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Fornecedor</title>
</head>
<body>
	<div align="center">
		<h1>Cadastro Fornecedor</h1>
	</div>
		<form action="fornecedor" method="post">
			<input type="hidden" id="action" name="action" value=""/>
				<div align="center">
					<label id="id">ID:</label><input id="nome" name="nome"
						type="text" size="5">
			</div>
			<div align="center">
				<label id="nome">Nome:</label><input id="nome" name="nome"
				type="text" size="45">
			</div>	
			<div align="center">
				<label id="endereco">Endereço:</label><input id="endereco" name="endereco"
				type="text" size="45">
		</div>
		<div align="center">
			<label id="email">Email:</label><input id="email" name="email"
				type="text" size="45">
		</div>
		<div align="center">
			<label id="senha">Senha:</label><input id="senha" name="senha"
				type="password" size="15">
		</div>
		<br>
		
			<div align="center">
				<button id="gravar_submit" onclick="gravar();" value="Gravar">Salvar</button>
				
				<button id="excluir_submit" onclick="excluir();" value="Excluir">Excluir</button>
			</div>
			<br>
			
		</form>
		
		

</body>
</html>