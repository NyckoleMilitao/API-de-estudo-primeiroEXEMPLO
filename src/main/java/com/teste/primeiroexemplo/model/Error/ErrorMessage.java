package com.teste.primeiroexemplo.model.Error;

public class ErrorMessage {
//#region
    private String tituloDoErro;

    private Integer statusDoErro;

    private String Mensagem;

    
//#endregion


    public ErrorMessage(String tituloDoErro, Integer statusDoErro, String mensagem) {
        this.tituloDoErro = tituloDoErro;
        this.statusDoErro = statusDoErro;
        Mensagem = mensagem;
    }



    public String getTitulodoerro() {
        return tituloDoErro;
    }

    public void setTitulodoerro(String tituloDoErro) {
        this.tituloDoErro = tituloDoErro;
    }

    public Integer getStatusDoErro() {
        return statusDoErro;
    }

    public void setStatusDoErro(Integer statusDoErro) {
        this.statusDoErro = statusDoErro;
    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String mensagem) {
        Mensagem = mensagem;
    }
    //#endregion
    
}
