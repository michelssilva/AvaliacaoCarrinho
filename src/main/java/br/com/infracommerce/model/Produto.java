package br.com.infracommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.infracommerce.view.View;



@Entity
@Table(name = "PRO_PRODUTO")
public class Produto {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@JsonView({View.Tudo.class})
	@Column(name = "PRO_ID")
	private Long id;
	
	@Column(name = "PRO_NOME", unique = false, length = 30, nullable = false)
	@JsonView({View.Tudo.class, View.Comum.class})
	private String nome;
	
	@Column(name = "PRO_ESPECIFICACAO", unique = false, length = 100, nullable = false)
	@JsonView({View.Tudo.class, View.Comum.class})
	private String especificacao;
	
	@Column(name = "PRO_VALOR", unique = false, length = 30, nullable = false)	
	@JsonView({View.Tudo.class, View.Comum.class})
	private Integer valor;
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id=id;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome=nome;
	}
	
	
	
	public String getEspecificacao() {
		return especificacao;
	}

	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}

	public Integer getValor(){
		return valor;
	}
	
	public void setValor(Integer valor){
		this.valor=valor;
	}

}
