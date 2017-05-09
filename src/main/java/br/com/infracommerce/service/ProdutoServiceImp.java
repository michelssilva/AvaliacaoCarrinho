package br.com.infracommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infracommerce.model.Produto;
import br.com.infracommerce.repository.ProdutoRepository;

@Service("produtoService")
public class ProdutoServiceImp implements ProdutoService{

	@Autowired
	
	private ProdutoRepository produtoRepo;
	
	public Produto adicionarProduto(Produto produto){
		return produtoRepo.save(produto);
	}
	
	public List<Produto> buscarTodos() {
		List<Produto> produtos = new ArrayList<Produto>();
		for (Produto p : produtoRepo.findAll()) {
			produtos.add(p);
		}
		return produtos;
	}
	
	public List<Produto> buscarPorNome(String nome) {
		List<Produto> produtos = new ArrayList<Produto>();
		for (Produto p : produtoRepo.findByNomeIgnoreCaseContaining(nome)) {
			produtos.add(p);
		}
		return produtos;
	}

	public Produto buscarProduto(Long id) {
		Produto produto = produtoRepo.findById(id);
		return produto;
	}

	public ProdutoRepository getProdutoRepo() {
		return produtoRepo;
	}

	public void setComputadorRepo(ProdutoRepository produtoRepo) {
		this.produtoRepo = produtoRepo;
	}

	
	
	

}
