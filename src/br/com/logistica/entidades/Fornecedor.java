package br.com.logistica.entidades;

import javax.persistence.Id;
import javax.persistence.Table;

@Table
public class Fornecedor {
	
		@Id
		private int cnpj;
		private String nomeFornecedor;
		private String endereco;
		private String categoria;
		
		/**
		 * 
		@OneToMany(targetEntity = Funcionario.class)
		private Funcionario funcionario;
		*/
	
		
		/**Get and Set **/		

		public String getNomeFornecedor() {
			return nomeFornecedor;
		}
		public void setNomeFornecedor(String nomeFornecedor) {
			this.nomeFornecedor = nomeFornecedor;
		}
		public int getCnpj() {
			return cnpj;
		}
		public void setCnpj(int cnpj) {
			this.cnpj = cnpj;
		}
		public String getEndereco() {
			return endereco;
		}
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
		public String getCategoria() {
			return categoria;
		}
		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}
			
		

}
