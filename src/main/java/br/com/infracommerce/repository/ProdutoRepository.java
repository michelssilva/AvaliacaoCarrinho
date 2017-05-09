package br.com.infracommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.infracommerce.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
	
	public List<Produto> findByNomeIgnoreCaseContaining(String nome);

	public Produto findById(Long id);
	

}
