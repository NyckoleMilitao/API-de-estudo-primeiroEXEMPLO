package com.teste.primeiroexemplo.model.Error;

public class ErrorMessage {
//#region
    private String titulodoerro;

    private Integer statusDoErro;

    private String Mensagem;

    public String getTitulodoerro() {
        return titulodoerro;
    }
//#endregion

//#region
    public void setTitulodoerro(String titulodoerro) {
        this.titulodoerro = titulodoerro;
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
