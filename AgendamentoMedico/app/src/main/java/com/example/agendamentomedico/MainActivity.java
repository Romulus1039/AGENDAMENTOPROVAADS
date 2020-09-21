package com.example.agendamentomedico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity<btnCalcular, txtrendaMensal> extends AppCompatActivity {

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import br.unipar.agendamentos.database.AppDatabase;
import br.unipar.agendamentos.database.RoomDatabaseOpenHelper;

    public class MainActivity extends AppCompatActivity {

        private EditText txtNome;
        private EditText txtDataAgendamento;
        private EditText txtMedico;
        private EditText txtCpf;
        private EditText txtTipoDeConsulta;
        private Button btnAgendar;
        private Button btnLimpar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            txtNome = findViewById(R.id.txtNome);
            txtDataAgendamento = findViewById(R.id.txtDataAgendamento);
            txtMedico = findViewById(R.id.txtMedico);
            txtCpf = findViewById(R.id.txtCpf);
            txtTipoDeConsulta = findViewById(R.id.editTextTipodeConsulta);
            btnAgendar = findViewById(R.id.btnAgendar);

            btnAgendar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (isEmpty()){
                        Toast.makeText(MainActivity.this, "Todos os campos devem ser preenchidos", Toast.LENGTH_LONG).show();
                        return;
                    }

                    Agenda agenda = new Agenda();

                    agenda.setNomePaciente(txtNome.getText().toString());
                    agenda.setDataAgendamento(txtDataAgendamento.getText().toString());
                    agenda.setTipoDeConsulta(txtMedico.getText().toString());
                    agenda.setCpf(txtCpf.getText().toString());

                    agendaDao.insert(agenda);

                    goToNewActivity();
                }
            });

        }

        private boolean isEmpty() {

            String nome = txtNome.getText().toString();
            String data = txtDataAgendamento.getText().toString();
            String medico = txtMedico.getText().toString();
            String celular = txtCpf.getText().toString();
            String email = txtTipoDeConsulta.getText().toString();

            if (TextUtils.isEmpty(nome) ||
                    TextUtils.isEmpty(data) ||
                    TextUtils.isEmpty(medico) ||
                    TextUtils.isEmpty(cpf) ||
                    TextUtils.isEmpty(tipoDeConsulta)) {
                return true;
            }

            return false;
        }

        private void goToNewActivity() {
            Intent intent = new Intent(MainActivity.this, lista_agendamentos.class);

            startActivity(intent);
            finish();
        }

    }