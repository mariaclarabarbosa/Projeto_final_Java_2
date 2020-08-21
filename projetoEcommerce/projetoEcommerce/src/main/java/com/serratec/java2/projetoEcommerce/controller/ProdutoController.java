package com.serratec.java2.projetoEcommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serratec.java2.projetoEcommerce.models.Produto;
import com.serratec.java2.projetoEcommerce.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

		//cadastrar/deletar/atualizar produto 
//		consultar/atualizar os preços dos produtos
//		consultar/atualizar o estoque
	
	//consultar produtos cadastrados por funcionario
	
	
	@Autowired
	ProdutoService produtoService;

	@PostMapping
	public ResponseEntity<Void> inserirProduto(@RequestBody Produto produto){
		produtoService.inserirProduto(produto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> listarProdutoPorId(@PathVariable Integer id){
		Produto produto = produtoService.listarProdutoPorId(id); 
		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}
	
	@GetMapping("/estoque/{id}")
	public ResponseEntity<Integer> consultarEstoque(@PathVariable Integer id){
		Integer quantidade = produtoService.consultarEstoque(id);
		return new ResponseEntity<Integer>(quantidade, HttpStatus.OK);
	}
	
	@PutMapping("/estoque/{id}")
	public void atualizarEstoque(@PathVariable Integer id, @RequestBody(required = false) Integer quantidade_estoque) {
		produtoService.atualizarEstoque(id, quantidade_estoque);
	}
	
	
	@GetMapping("/preco/{id}")
	public ResponseEntity<Double> consultarPreco(@PathVariable Integer id){
		Double valor = produtoService.consultarPreco(id);
		return new ResponseEntity<Double>(valor, HttpStatus.OK);
	}
	
	@PutMapping("/estoque/{id}")
	public void atualizarPreco(@PathVariable Integer id, @RequestBody(required = false) Double valor) {
		produtoService.atualizarPreco(id, valor);
	}
	

	@GetMapping
	public ResponseEntity<List<Produto>> listarProdutos(){
		return new ResponseEntity<List<Produto>>(produtoService.listarProdutos(), HttpStatus.OK);
	}
	 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarProduto(@PathVariable Integer id){
		produtoService.deletarProduto(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public void substituir(@PathVariable Integer id, @RequestBody(required = false) Produto produto) {
		produtoService.substituir(id, produto);
	}

}
