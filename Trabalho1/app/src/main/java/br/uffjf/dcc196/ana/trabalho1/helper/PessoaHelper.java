package br.uffjf.dcc196.ana.trabalho1.helper;

import java.util.ArrayList;
import java.util.List;

import br.uffjf.dcc196.ana.trabalho1.model.Pessoa;

public class PessoaHelper {
    private static PessoaHelper instance;
    private static List<Pessoa> pessoas;

    public static PessoaHelper getInstance(){
        if(instance == null){
            instance = new PessoaHelper();
        }
        init();
        return instance;
    }

    private static void init(){
       if(pessoas == null){
           pessoas = new ArrayList<>();
           pessoas.add(new Pessoa("Pedro Henrique", "pedro@net.com.br"));
           pessoas.add(new Pessoa("Ana Maria", "maria@net.com.br"));
           pessoas.add(new Pessoa("Júlio da Silva", "julio@net.com.br"));
           pessoas.add(new Pessoa("Barack Obama", "obama@net.com.br"));
       }
    }

    public void inserir(Pessoa p){
        pessoas.add(p);
    }

    public List<Pessoa> listar(){
        return pessoas;
    }

    public Pessoa buscar(String nome){
        Pessoa pessoa = null;
        for(Pessoa p: pessoas){
            if(p.getNome().equals(nome)){
                pessoa = p;
            }
        }
        return pessoa;
    }

}
