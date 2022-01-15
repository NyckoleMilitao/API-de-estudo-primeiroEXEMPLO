package com.teste.primeiroexemplo.services;

import java.util.List;
import java.util.Optional;

import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    //Eu estou criando um atributo privado
    //Eu teria que instanciar, mas como eu já dei essa responsabilidade para o spring
    // Só vou pedir para o spring essa instancia pronta
    //A instancia seria (new ProdutoRepository();)
    // E no spring é só usar o @autowired, que significa que estou invertendo o controle
    // No @repository eu falo pro spring tomar conta, no @autowired eu falo que eu estou tomando conta
   
    @Autowired
    private ProdutoRepository produtoRepository;


    /**
     * Metodo para retornar uma lista de produto
     * @return
     */
    public List<Produto> obterTodos(){
        // Aqui eu peço para o repositorio me devolver a lista de produto
        // do jeito que ele me devolve eu de volvo pra quem tiver chamando
        // Se eu tivesse uma regra eu colocaria antes do return
        return produtoRepository.obterTodos();
    }
    
    /**
     * Metodo que retorna o produto encontrado pelo seu id
     * @param id do produto que será localizado
     * @return Retorna um produto caso seja encontrado
     */
    public Optional <Produto> obterPorId(Integer id){
        // Aqui eu posso colocar uma regra de negocio

    return produtoRepository.obterPorId(id);
    }
   
    /**
     * Metodo para adicionar produto na lista
     * @param produto que será adicionado
     * @return Retorna o produto que foi adcionado na lista.
     */
    public Produto adicionar(Produto produto){
        //poderia ter alguma regra de negocio aqui para validar o produto
       return produtoRepository.adicionar(produto);
    }

     /**
     * Metodo para deletar o produto por id.
     * @param id do produto a ser deletado
     */
    public void deletar(Integer id){
        // Aqui poderia ter alguma logica de validação
       produtoRepository.deletar(id);
    }

      /**
     * Metodo para atualizar o produto na lista
     * @param produto que será atualizado na lista
     * @param id do produto
     * @return Retorna produto que será atualizado na Lista
     */
    public Produto atualizar(Integer id, Produto produto){
         
        // Ter alguma validação no ID.
        produto.setId(id);

        return produtoRepository.atualizar(produto);

    }
}
