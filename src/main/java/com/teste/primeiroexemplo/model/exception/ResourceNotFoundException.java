package com.teste.primeiroexemplo.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
//o codigo dessa escencia é um codigo de não encontrado

public class ResourceNotFoundException extends RuntimeException {

    /* O super é pq vai herdar de uma classe já existente no java 
    RuntimeException
    */

    public ResourceNotFoundException(String mensagem){
        super(mensagem);
    }
  
    // Vamos usar um super pq estamos dizendo que ele vai fazer um extends de "RuntimeException"
}
