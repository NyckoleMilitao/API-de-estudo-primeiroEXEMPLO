package com.teste.primeiroexemplo.controller;

import java.util.List;
import java.util.Optional;

import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.services.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController// toda vez que coloco um @RestControler, eu estou dizendo para o meu spring que isso é um controlador
@RequestMapping ("/api/produtos") //Esse mostra qual a rota que ele ouve
//Quando alguém colocar na api eu quero que eleouça   -- /api/produtos

public class ProdutoController {
    
    //primeira coisa que vou fazer é pedir um controle do nosso produto

    @Autowired
    private ProdutoService produtoService;

    @GetMapping// quando alguém for chamar esse metodo quero que use @getMapping
    public  List<Produto> obterTodos(){
        return produtoService.obterTodos();
    }
    
    @GetMapping("/{id}")
    public Optional <Produto> obterPorId(@PathVariable Integer id){
        //O /{id} é o caminho que estou informando para o meu getMapping
        //o @PathVariable me informa o seguinte: Que eu quero transformar o caminho id do getmapping
        // em um inteiro. Pra na hora que eu for chamar, chamar pelo inteiro que está no id
        // pq esse id eu vou obter o id que pedi

        return produtoService.obterPorId(id);
    }

    @PostMapping
    public Produto adicionar(@RequestBody Produto produto){
        // com o @requestBody  eu digo uma coisa:
        //spring faz um favor para mim, pega o que eu coloquei no JSON e faça um binde
        // coloque oq eu digitei no postman e coloque no produto
        return produtoService.adicionar(produto);
        
    }


    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){
       //Ele é bem parecido com obterPorId
       // ele quer tbm o id pra poder deletar 
       //Ele me retorna uma string pra poder entregar a mensagem
       produtoService.deletar(id);
       return "Produto com id " + id + " foi deletado com sucesso!";
    }

    @PutMapping("/{id}")
    public Produto atualizar(@RequestBody Produto produto, @PathVariable Integer id){
        // Eu preciso receber o corpo do produto e tambem o caminho da variavel 
        // pra poder saber o que eu vou atualizar. E para atualizar eu preciso do corpo

        return produtoService.atualizar(id, produto);
    }
}
