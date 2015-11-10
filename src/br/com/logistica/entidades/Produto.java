package br.com.logistica.entidades;

import javax.persistence.Id;
import javax.persistence.Table;

@Table
public class Produto {
	
		@Id
		private int id;
		private String nomeProduto;
		private String descricao;
		
		
		/**Get and Set**/
		
		public String getNomeProduto() {
			return nomeProduto;
		}
		public void setNomeProduto(String nomeProduto) {
			this.nomeProduto = nomeProduto;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		
		
		
	
	

}
