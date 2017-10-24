package br.uffjf.dcc196.ana.trabalho1.helper;

import java.util.ArrayList;
import java.util.List;

import br.uffjf.dcc196.ana.trabalho1.model.Livro;

public class LivroHelper {
    private static LivroHelper instance;
    private static List<Livro> livros;

    public static LivroHelper getInstance(){
        if(instance == null){
            instance = new LivroHelper();
        }
        init();
        return instance;
    }

    private static void init(){
        if(livros == null){
            livros = new ArrayList<>();
        }
    }

    public void inserir(Livro livro){
        livros.add(livro);
    }

    public Livro buscar(String titulo, String editora, int ano){
        Livro livro = null;
        for (Livro l: livros){
            if(l.getTitulo().equals(titulo) && l.getEditora().equals(editora) && l.getAno() == ano){
                livro = l;
            }
        }
        return livro;
    }

    public List<Livro> listar(){
        return livros;
    }
}
