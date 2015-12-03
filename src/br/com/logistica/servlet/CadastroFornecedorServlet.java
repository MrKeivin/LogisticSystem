 package br.com.logistica.servlet;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.logistica.dao.CadastroFornecedorDAO;
import br.com.logistica.entidades.CadastroFornecedor;

@WebServlet("/fornecedor")
public class CadastroFornecedorServlet extends HttpServlet {
	
	@SuppressWarnings("null")
	protected void service(HttpServletRequest req,HttpServletResponse resp, ServletRequest request) throws ServletException, java.io.IOException {
	
            
        ServletResponse response = null;
		// Buscar e Escrever
    	PrintWriter out = response.getWriter();
    
    	CadastroFornecedorDAO dao = new CadastroFornecedorDAO();
    	
    	String action = request.getParameter("action");
    	
    	if(action != null && action.equals("gravar")){
    		
    		Integer id = 0;
    		  
			if(request.getParameter("id") != null && !request.getParameter("id").equals("")){
    			id = Integer.parseInt(request.getParameter("id"));
    			
			}
			String nome = request.getParameter("nome");
			String endereço = request.getParameter("endereço");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			CadastroFornecedor fornecedor = new CadastroFornecedor();
			//fornecedor.setId(new Long(id));
			fornecedor.setNome(nome);
			fornecedor.setEndereço(endereço);
			fornecedor.setEmail(email);
			fornecedor.setSenha(senha);
			
			try{
				if(id != null && id>0){
					fornecedor.setId(new Long(id));
					dao.altera(fornecedor);
				}else{
					dao.adiciona(fornecedor);
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher("fornecedor.jsp");
				dispatcher.forward(request, response);
				
			}catch(SQLException e){
				e.printStackTrace();
				
				}
    	}else if(action != null && action.equals("excluir")){
    		
    		Integer id = 0;
    		
    		if(request.getParameter("id") != null && !request.getParameter("id").equals("")){
    			id = Integer.parseInt(request.getParameter("id"));
			}
    		CadastroFornecedor fornecedor = new CadastroFornecedor();
    		
    		fornecedor.setId(new Long(id));
    		
    		try{
    			dao.deleta(fornecedor);
    			RequestDispatcher dispatcher = request.getRequestDispatcher("fornecedor.jsp");
    			dispatcher.forward(request, response);
    			
    		}catch(SQLException e){
    			e.printStackTrace();
    		}
    		
    	}else{
    		
    		RequestDispatcher dispatcher = request.getRequestDispatcher("fornecedor.jsp");
    		dispatcher.forward(request, response);
    		
    
    
    }
    	
	}

}
