package br.uffjf.dcc196.ana.trabalho1.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.uffjf.dcc196.ana.trabalho1.R;
import br.uffjf.dcc196.ana.trabalho1.helper.PessoaHelper;
import br.uffjf.dcc196.ana.trabalho1.model.Pessoa;

public class PrincipalActivity extends AppCompatActivity {
    private Button btnParticipantes;
    private Button btnLivros;
    private Button btnReservas;
    private ListView lstParticipantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnParticipantes = (Button) findViewById(R.id.btnParticipantes);
        btnLivros = (Button) findViewById(R.id.btnLivros);
        btnReservas = (Button)findViewById(R.id.btnReservas);
        lstParticipantes = (ListView) findViewById(R.id.lstParticipantes);

        btnParticipantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cadParticipante = new Intent(PrincipalActivity.this, ParticipantesActivity.class);
                cadParticipante.putExtra("msg", "Informe os dados do participante.");
                startActivity(cadParticipante);

            }
        });

        btnLivros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cadLivro = new Intent(PrincipalActivity.this, LivroActivity.class);
                cadLivro.putExtra("msg", "Informe os dados do livro.");
                startActivity(cadLivro);
            }
        });

        btnReservas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent cadReserva = new Intent(PrincipalActivity.this, ReservaActivity.class);
                cadReserva.putExtra("msg", "Informe os dados da reserva.");
                startActivity(cadReserva);
            }
        });

        atualizaParticipantes();
    }

    private void atualizaParticipantes(){
        //participates na list view
       List<Map<String, String>> data = new ArrayList<>();
        for (Pessoa p: PessoaHelper.getInstance().listar()){
            Map<String, String> map = new HashMap<>(2);
            String info = "Email: " + p.getEmail() + " \nEntada: 00:00" +  "\t\tSaída: 00:00";
            map.put("nome", p.getNome()) ;
            map.put("info", info);
            data.add(map);
        }

       final SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(), data,
                android.R.layout.simple_list_item_2,
                new String[] {"nome", "info"},
                new int[] {android.R.id.text1,
                        android.R.id.text2}
        );
        lstParticipantes.setAdapter(adapter);
    }
}
