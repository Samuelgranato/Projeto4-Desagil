package com.fablab.insper.fablabinsper;

class LendoDados {

    private String img;
    private String titulo;
    private String texto;

    //calendario
    private String nome_sensor;
    private String nome_pessoa;
    private String data_dev;


    //emprestimos
    private String nome_emprestimo;
    private String funcao_emprestimo;
    private String aplicacao_emprestimo;
    private String quantidade_emprestimo;



    public LendoDados(){

    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    //calendario

    public String getNome_pessoa() {
        return nome_pessoa;
    }

    public void setNome_pessoa(String nome_pessoa) {
        this.nome_pessoa = nome_pessoa;
    }

    public String getNome_sensor() {
        return nome_sensor;
    }

    public void setNome_sensor(String nome_sensor) {
        this.nome_sensor = nome_sensor;
    }

    public String getData_dev() {
        return data_dev;
    }

    public void setData_dev(String data_dev) {
        this.data_dev= data_dev;
    }


    //emprestimos
//
    public String getNome_emprestimo() {
        return nome_emprestimo;
    }
    public void setNome_emprestimo(String nome_emprestimo) {
        this.nome_emprestimo= nome_emprestimo;
    }


    public String getFuncao_emprestimo() {
        return funcao_emprestimo;
    }
    public void setFuncao_emprestimo(String funcao_emprestimo) {
        this.funcao_emprestimo= funcao_emprestimo;
    }


    public String getAplicacao_emprestimo() {
        return aplicacao_emprestimo;
    }
    public void setAplicacao_emprestimo(String aplicacao_emprestimo) {
        this.aplicacao_emprestimo= aplicacao_emprestimo;
    }


    public String getQuantidade_emprestimo() {
        return quantidade_emprestimo;
    }
    public void setQuantidade_emprestimo(String quantidade_emprestimo) {
        this.quantidade_emprestimo= quantidade_emprestimo;
    }


}
