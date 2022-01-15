package com.teste.primeiroexemplo.handler;



import com.teste.primeiroexemplo.model.Error.ErrorMessage;
import com.teste.primeiroexemplo.model.exception.ResourceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Esse é um manipulador de eventos
@ControllerAdvice // esse vai ser um controlador dentro dessa manipulaçõa
public class RestExceptionHandler {

    //Agora estou criando um metodo um responseentity que vai me retornar qualquer

    @ExceptionHandler(ResourceNotFoundException.class)// Quando eu coloco esse @ estou dizendo que 
    // Toda vez que acontecer uma exception ResourceNotFoundException
    // Ele vai chamar esse metodo aqui
    public ResponseEntity<?> handleResourceNotFoundException (ResourceNotFoundException ex){

        ErrorMessage error = new ErrorMessage("NOT_FOUND", HttpStatus.NOT_FOUND.value(),ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    
}
