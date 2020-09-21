package com.example.agendamentomedico;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Tela2 {

    private ListView listaAgendamentos;
    private List<Agenda> agendamentos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_agendamentos);

        lvAgendamentos = findViewById(R.id.listaAgendamentos);
        nomeFiltro = findViewById(R.id.edNomeFiltro);

        AppDatabase appDatabase = RoomDatabaseOpenHelper.getDatabase(new WeakReference<Context>(this));
        AgendaDao agendaDao = appDatabase.agendaDao();

        agendamentos = agendaDao.findAll();

        final WeakReference<Context> weakReference = new WeakReference(this);

        final AgendaAdapter agendaAdapter = new AgendaAdapter(agendamentos, weakReference);
        lvAgendamentos.setAdapter(agendaAdapter);

    }

}
}
