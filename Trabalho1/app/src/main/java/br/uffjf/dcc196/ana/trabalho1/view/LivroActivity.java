package br.uffjf.dcc196.ana.trabalho1.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.uffjf.dcc196.ana.trabalho1.R;
import br.uffjf.dcc196.ana.trabalho1.helper.LivroHelper;
import br.uffjf.dcc196.ana.trabalho1.model.Livro;

public class LivroActivity extends AppCompatActivity {
    private EditText txtTitulo;
    private EditText txtEditora;
    private EditText txtAno;
    private EditText txtAutor;
    private Button btnVoltar;
    private Button btnSalvar;
    private Button btnListar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro);

        txtTitulo = (EditText) findViewById(R.id.txtTitulo);
        txtEditora = (EditText) findViewById(R.id.txtEditora);
        txtAno = (EditText) findViewById(R.id.txtAno);
        txtAutor = (EditText) findViewById(R.id.txtAutor);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnListar = (Button) findViewById(R.id.btnListar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent principal = new Intent(LivroActivity.this, PrincipalActivity.class);
                startActivity(principal);
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = txtTitulo.getText().toString();
                String editora = txtEditora.getText().toString();
                String ano = txtAno.getText().toString();
                String autor = txtAutor.getText().toString();

                if(titulo.equals("")){
                    Toast.makeText(getApplicationContext(), "Informe o título.", Toast.LENGTH_SHORT).show();
                    txtTitulo.requestFocus();
                }else if(editora.equals("")){
                    Toast.makeText(getApplicationContext(), "Informe a editora.", Toast.LENGTH_SHORT).show();
                    txtEditora.requestFocus();
                }else if(ano.equals("")){
                    Toast.makeText(getApplicationContext(), "Informe o ano.", Toast.LENGTH_SHORT).show();
                    txtAno.requestFocus();
                }else{
                    LivroHelper.getInstance().inserir(new Livro(titulo, autor, editora, ano));
                    Toast.makeText(getApplicationContext(), "Livro salvo com sucesso!", Toast.LENGTH_SHORT).show();
                    txtTitulo.setText("");
                    txtEditora.setText("");
                    txtAutor.setText("");
                    txtAno.setText("");
                    txtTitulo.requestFocus();
                }

            }
        });

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listLivro = new Intent(LivroActivity.this, LivroListaActivity.class);
                startActivity(listLivro);
            }
        });
    }


}
