package br.uffjf.dcc196.ana.trabalho1.helper;


import java.util.ArrayList;
import java.util.List;

import br.uffjf.dcc196.ana.trabalho1.model.Reserva;

public class ReservaHelper {
    private static ReservaHelper instance;
    private static List<Reserva> reservas;

    public static ReservaHelper getInstance(){
        if(instance == null){
            instance = new ReservaHelper();
        }

        return  instance;
    }

    private static void init(){
        if(reservas == null){
            reservas = new ArrayList<>();
        }
    }

    public void inserir(Reserva r){
        reservas.add(r);
    }

    public List<Reserva> listar(){
        return reservas;
    }



}
