package br.com.logistica.entidades;

import javax.persistence.Id;
import javax.persistence.Table;

/**import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
*/
@Table
public class Funcionario {

	@Id
	private int matricula;
	private String nome;
	private String setor;
	private String cargo;
	private String senha;
	
	/**
	 * 
	@ManyToOne(targetEntity = Fornecedor.class, fetch = FetchType)
	private List<Fornecedor> fornecedor;
	
	*/

	/** Get and Set **/

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
