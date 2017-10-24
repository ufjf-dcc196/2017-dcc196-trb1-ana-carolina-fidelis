package br.uffjf.dcc196.ana.trabalho1.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.uffjf.dcc196.ana.trabalho1.R;
import br.uffjf.dcc196.ana.trabalho1.helper.LivroHelper;
import br.uffjf.dcc196.ana.trabalho1.model.Livro;

public class LivroListaActivity extends AppCompatActivity {

    private ListView lstLivros;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro_lista);

        lstLivros = (ListView) findViewById(R.id.lstLivros);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        atualizaLivros();

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cadLivro = new Intent(LivroListaActivity.this, LivroActivity.class);
                startActivity(cadLivro);
            }
        });
    }

    public void atualizaLivros(){
        List<Map<String, String>> livros = new ArrayList<>();


        for(Livro l: LivroHelper.getInstance().listar()){
            String info =  "Autor: " + l.getAutor() + "\nEditora: " + l.getEditora()  + " \t\tAno:" + l.getAno();
            Map<String, String> map = new HashMap<>();
            map.put("titulo", l.getTitulo());
            map.put("info", info);
            livros.add(map);
        }

        final SimpleAdapter adapter = new SimpleAdapter(this, livros,
                android.R.layout.simple_list_item_2, new String[] {"titulo", "info"},
                new int[] {android.R.id.text1, android.R.id.text2}
        );
            lstLivros.setAdapter(adapter);

    }
}
