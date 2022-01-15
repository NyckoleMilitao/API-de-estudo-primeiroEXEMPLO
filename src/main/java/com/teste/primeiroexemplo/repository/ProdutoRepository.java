package com.teste.primeiroexemplo.repository;


import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.model.exception.ResourceNotFoundException;

import org.springframework.stereotype.Repository;

@Repository// com isso a gente esta dizendo pro spring que isso é um repositorio.
//Com isso estamos usando uma injeção de dependencia e inversão de controles
// com essa anotação a gente está dizendo pro spring que ele vai ter controle sobre meu repositorio
public class ProdutoRepository {// Esse repositorio simula um BD


    //Pra simular um banco de dados eu vou precisa de um arraylist de produto
    //que eu vou já vou instanciar (new arraylist<Produto>())
    private List<Produto> produtos = new ArrayList<Produto>();
    // ele vai simular um id do BD. Toda vez que começar uma aplicação ele começa em 0
    // pq não tenho nada dentro da aplicação
    private Integer ultimoId =0;

    /**
     * Metodo para retornar uma lista de produtos
     * Retorna todos os produtos dentro da lista
     * @return Lista de produtos
     */
    public List<Produto> obterTodos(){
        return produtos; 
    }

    /**
     * Metodo que retorna o produto encontrado pelo seu id
     * @param id do produto que será localizado
     * @return Retorna um produto caso seja encontrado
     */
    public Optional <Produto> obterPorId(Integer id){
        return produtos
        .stream()
        .filter(produto -> produto.getId() == id)
        .findFirst();
        //O findFirst me devolve um produto. Se não tiver produto pode dar um erro. 
        // O Optional suluciona isso pra mim, se não tiver produto ele me devolve null ou vazio, algo que não dá erro.
    }

    /**
     * Metodo para adicionar produto na lista
     * @param produto que será adicionado
     * @return Retorna o produto que foi adcionado na lista.
     */
    public Produto adicionar(Produto produto){
        // incremento o id
        ultimoId++;
        
        //pego esse id e passo pro produto 
        produto.setId(ultimoId);
        // passo o produto pra lista
        produtos.add(produto);
       
        return produto;
    }

    /**
     * Metodo para deletar o produto por id.
     * @param id do produto a ser deletado
     */
    public void deletar(Integer id){
        // vou dentro da minha lista de produto pro e passp um removeIf
        // e coloco um filtro
        // para cada produto, pegue o id e compare. se for igual apague.
        // só que ele não sai fora, ele continua até acabar
        // como id é unico, ele só faz sso uma vez
        produtos.removeIf(produto -> produto.getId()== id);
    }

    /**
     * Metodo para atualizar o produto na lista
     * @param produto que será atualizado na lista
     * @return Retorna produto que será atualizado na Lista
     */
    public Produto atualizar(Produto produto){
        
        // antes de deletar eu tenho que encontrar
        // reaproveitar o codigo de encontrar o id
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

        // se produto encontrado for vazio= Empty faça
        if(produtoEncontrado.isEmpty()){
            throw new ResourceNotFoundException("Produto não encontrado");
            //Eu só consigo usar essa exception, pq eu a criei dentro de handler
        }
        
        //Eu tenho que remover o produto antigo da Lista
        deletar(produto.getId());

        // E depois adicionar um produto novo na Lista
        produtos.add(produto);

        return produto;

    }
    
}
