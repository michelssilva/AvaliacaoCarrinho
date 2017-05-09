package br.com.infracommerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.infracommerce.model.Produto;
import br.com.infracommerce.service.ProdutoService;
import br.com.infracommerce.view.View;

@RestController
@RequestMapping(value = "/carrinho")
public class CarrinhoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	
	
	@RequestMapping(value = "/buscar/{id}")
	@JsonView(View.Comum.class)
	public ResponseEntity<Produto> buscarProduto(@PathVariable("id") Long id) {
		return new ResponseEntity<Produto>(produtoService.buscarProduto(id), HttpStatus.OK);
		
	}	
	
	
	
	@RequestMapping(value = "/buscar/todos")
	@JsonView(View.Comum.class)
	public ResponseEntity<List<Produto>> buscarTodos() {
		return new ResponseEntity<List<Produto>>(produtoService.buscarTodos(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getById")
	@JsonView(View.Tudo.class)
	public ResponseEntity<Produto> get(@RequestParam(value = "id", defaultValue = "1") Long id) {
		Produto produto = produtoService.buscarProduto(id);
		if (produto == null) {
			return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/buscar/nome/{nome}")
	@JsonView(View.Comum.class)
	public ResponseEntity<List<Produto>> buscarPorNome(@PathVariable("nome") String nome) {
		return new ResponseEntity<List<Produto>>(produtoService.buscarPorNome(nome), HttpStatus.OK);

	}
	
	
	@RequestMapping(value = "/adicionar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.Tudo.class)
	@ResponseStatus(HttpStatus.CREATED)
	public Produto salvarProduto(@RequestBody Produto produto, HttpServletRequest request,
			HttpServletResponse response) {
		produto = produtoService.adicionarProduto(produto);
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/carrinho/getById?id=" + produto.getId());
		return produto;
	}
	
	public ProdutoService getProdutoService() {
		return produtoService;
	}

	public void setProdutoService(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	

}
