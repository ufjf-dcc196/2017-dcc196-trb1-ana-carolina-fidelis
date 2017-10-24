package br.uffjf.dcc196.ana.trabalho1.model;


public class Reserva {
    private Pessoa pessoa;
    private Livro livro;

    public Reserva() {
    }

    public Reserva(Pessoa pessoa, Livro livro) {
        this.pessoa = pessoa;
        this.livro = livro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
