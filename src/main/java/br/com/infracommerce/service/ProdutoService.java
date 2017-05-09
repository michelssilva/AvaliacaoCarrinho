package br.com.infracommerce.service;

import java.util.List;

import br.com.infracommerce.model.Produto;

public interface ProdutoService {
	
	public Produto adicionarProduto(Produto produto);
	public List<Produto> buscarTodos();
	public Produto buscarProduto(Long id);
	public List<Produto> buscarPorNome(String nome);
		

}
