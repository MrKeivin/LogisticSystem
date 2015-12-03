package br.com.logistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.logistica.controlador.ConnectionFactory;
import br.com.logistica.controlador.DAO;
import br.com.logistica.entidades.CadastroFornecedor;

public class CadastroFornecedorDAO implements DAO<CadastroFornecedor> {
	
	private Connection con;
	
	public CadastroFornecedorDAO(){
		this.con = new ConnectionFactory().getConnection();
	}

	@Override
	public void adiciona(CadastroFornecedor entidade) throws SQLException {
		String sql = "insert into fornecedor(nome,endereco,email,senha)values(?,?,?,?)";
		PreparedStatement stmt = null;
		try{
			stmt = (PreparedStatement)con.prepareStatement(sql);
			
			stmt.setString(1, entidade.getNome());
			stmt.setString(2, entidade.getEndereço());
			stmt.setString(3, entidade.getEmail());
			stmt.setString(4, entidade.getSenha());
			
			stmt.execute();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			stmt.close();
			con.close();
			
		}
		
	}

	@Override
	public void altera(CadastroFornecedor entidade) throws SQLException {
		String sql = "update fornecedor set";
		int t = 0;
		int count = 1;
		
		if(entidade.getNome() != null && !entidade.getNome().equals("")){
				sql = sql + "nome =?";
				t = 1;
			}
		if(entidade.getEndereço() != null && !entidade.getEndereço().equals("")){
			if(t == 1){
				sql = sql + ",";
			}
			sql = sql + "endereco =?";
			t = 1;
		}
		
		if(entidade.getEmail() != null && !entidade.getEmail().equals("")){
			if(t == 1){
				sql = sql + ",";
			}
			sql = sql + "email =?";
			t = 1;
		}
		
		if(entidade.getSenha() != null && !entidade.getSenha().equals("")){
			if(t == 1){
				sql = sql + ",";
			}
			sql = sql + "senha =?";
			t = 1;
		}
		
		sql = sql + "where id ?";
		
		PreparedStatement stmt = null;
		try{
			stmt = (PreparedStatement)con.prepareStatement(sql);
			if(entidade.getNome() != null && !entidade.getNome().equals("")){
				stmt.setString(count, entidade.getNome());
				count++;
				
			}
			if(entidade.getEndereço() != null && !entidade.getEndereço().equals("")){
				stmt.setString(count, entidade.getEndereço());
				count++;
			}
			if(entidade.getEmail() != null && !entidade.getEmail().equals("")){
				stmt.setString(count, entidade.getEmail());
				count++;
			}
			if(entidade.getSenha() != null && !entidade.getSenha().equals("")){
				stmt.setString(count, entidade.getSenha());
				count++;
				
			}
			stmt.setLong(count, entidade.getId());
			stmt.executeQuery();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			stmt.close();
			con.close();
			
		}
		
	
	}
	@Override
	public void deleta(CadastroFornecedor entidade) throws SQLException {
		PreparedStatement stmt = null;
		try{
			stmt = (PreparedStatement)con.prepareStatement("delete from fornecedor where id =?");
			
			stmt.setLong(1, entidade.getId());
			stmt.executeQuery();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			stmt.close();
			con.close();
			
		}
		
	}

	@Override
	public CadastroFornecedor lista(String pesquisa) throws SQLException {
		CadastroFornecedor entidade  = new CadastroFornecedor();
		String sql = "select * from fornecedor where id =?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			stmt = (PreparedStatement)con.prepareStatement(sql);
			
			stmt.setLong(1, entidade.getId());
			rs = stmt.executeQuery();
			
			if(rs.next()){
				entidade.setId(rs.getLong("id"));
				entidade.setNome(rs.getString("nome"));
				entidade.setEndereço(rs.getString("endereco"));
				entidade.setEmail(rs.getString("email"));
				entidade.setSenha(rs.getString("senha"));
				
			}
				
			}catch(SQLException e){
				throw new RuntimeException (e);
			}finally{
				stmt.close();
				rs.close();
				con.close();
				
		}
		return entidade;
	}

	@Override
	public List<CadastroFornecedor> listaTudo() throws SQLException {
		List<CadastroFornecedor>fornecedores = new ArrayList<CadastroFornecedor>(); 
		String sql = "select * from fornecedor";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			stmt = (PreparedStatement)con.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			CadastroFornecedor entidade = null;
			
			while(rs.next()){
				entidade = new CadastroFornecedor();
				entidade.setId(rs.getLong("id"));
				entidade.setNome(rs.getString("nome"));
				entidade.setEndereço(rs.getString("endereco"));
				entidade.setEmail(rs.getString("email"));
				entidade.setSenha(rs.getString("senha"));
				
				fornecedores.add(entidade);
			}
				
			}catch(SQLException e){
				throw new RuntimeException (e);
			}finally{
				stmt.close();
				rs.close();
				con.close();
				
				
			}
		
		
		return fornecedores;
	}

}
