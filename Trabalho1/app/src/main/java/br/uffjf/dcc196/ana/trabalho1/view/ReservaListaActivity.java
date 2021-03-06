package br.uffjf.dcc196.ana.trabalho1.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import br.uffjf.dcc196.ana.trabalho1.R;
import br.uffjf.dcc196.ana.trabalho1.helper.PessoaHelper;
import br.uffjf.dcc196.ana.trabalho1.model.Livro;
import br.uffjf.dcc196.ana.trabalho1.model.Pessoa;

public class ReservaListaActivity extends AppCompatActivity {
    private ListView lstReservas;
    private Button btnVoltar;
    private TextView txtTitulo;
    private TextView txtAutor;
    private TextView txtEditora;
    private TextView txtAno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_lista);

        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        lstReservas = (ListView) findViewById(R.id.lstReservas);
        txtTitulo = (TextView) findViewById(R.id.txtTitulo);
        txtAutor = (TextView) findViewById(R.id.txtAutor);
        txtEditora = (TextView) findViewById(R.id.txtEditora);
        txtAno = (TextView) findViewById(R.id.txtAno);


        Livro livro = (Livro) getIntent().getSerializableExtra("livro");
        txtTitulo.setText(livro.getTitulo());
        txtAutor.setText(livro.getAutor());
        txtEditora.setText(livro.getEditora());
        txtAno.setText(livro.getAno());

       btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listLivro = new Intent(ReservaListaActivity.this, LivroListaActivity.class);
                startActivity(listLivro);
                finish();
            }
        });

       final ArrayAdapter<Pessoa> adaptador = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                livro.getReservas()
        );

        lstReservas.setAdapter(adaptador);
    }


}
