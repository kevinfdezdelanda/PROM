package com.example.examenkevin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class PerfilCandidato extends AppCompatActivity {

    private Spinner provincias;
    private EditText nombre, dia, mes, anio;
    private RadioButton rbMasculino, rbFemenino;
    private CheckBox chPhp, chJava, chHtml, chCss;
    private Button evaluar, salir;
    private TextView txtCandidatos;
    private int numCandidatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.perfil_candidato);

        provincias = (Spinner) findViewById(R.id.provincia);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.provincias, android.R.layout.simple_spinner_item);
        provincias.setAdapter(adapter);

        nombre = (EditText) findViewById(R.id.nombre);
        dia = (EditText) findViewById(R.id.dia);
        mes = (EditText) findViewById(R.id.mes);
        anio = (EditText) findViewById(R.id.anio);

        rbMasculino = (RadioButton) findViewById(R.id.masculino);
        rbFemenino = (RadioButton) findViewById(R.id.femenino);

        chPhp = (CheckBox) findViewById(R.id.php);
        chJava = (CheckBox) findViewById(R.id.java);
        chHtml = (CheckBox) findViewById(R.id.html);
        chCss = (CheckBox) findViewById(R.id.css);

        txtCandidatos = (TextView) findViewById(R.id.numCandidatos);
        numCandidatos=0;

        evaluar = (Button) findViewById(R.id.evaluar);
        salir = (Button) findViewById(R.id.salirCandidato);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PerfilCandidato.this, MainActivity.class);
                intent.putExtra("sesionIniciada", true);
                startActivity(intent);
            }
        });
        salir.setVisibility(View.INVISIBLE);
    }

    public void evaluarCandidato(View v){
        if(v.equals(evaluar)) {
            String error = comprobar();
            if(error.equals("")) {

                Intent intent = new Intent(PerfilCandidato.this, SeleccionCandidato.class);
                intent.putExtra("nombre", String.valueOf(nombre.getText()));

                intent.putExtra("fecha", String.valueOf(dia.getText()) + "/" + String.valueOf(mes.getText()) + "/" + String.valueOf(anio.getText()));

                intent.putExtra("provincia", provincias.getSelectedItem().toString());

                if (rbMasculino.isChecked()) {
                    intent.putExtra("sexo", "masculino");
                } else {
                    intent.putExtra("sexo", "femenino");
                }
                String conocimientos = "";

                if (chPhp.isChecked()) {
                    conocimientos += "PHP,";
                }

                if (chJava.isChecked()) {
                    conocimientos += "JAVA,";
                }

                if (chHtml.isChecked()) {
                    conocimientos += "HTML,";
                }

                if (chCss.isChecked()) {
                    conocimientos += "CSS,";
                }

                intent.putExtra("conocimientos", conocimientos);

                startActivityForResult(intent, 2);
            }else{
                FragmentManager fragmentManager= getSupportFragmentManager();
                DialogoInformacion dialogoInfo = new DialogoInformacion(error, false);
                dialogoInfo.show(fragmentManager,"tagAlerta");
            }
        }
    }

    public String comprobar(){
        if(String.valueOf(nombre.getText()).equals("") ||
                String.valueOf(dia.getText()).equals("") ||
                String.valueOf(mes.getText()).equals("") ||
                String.valueOf(anio.getText()).equals("")){
            return "Debes rellenar los campos nombre y fecha";
        }else{
            return "";
        }
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == RESULT_OK) {
            numCandidatos++;
            txtCandidatos.setText("Candidatos: "+numCandidatos);

            provincias.setSelection(0);
            nombre.setText("");
            dia.setText("");
            mes.setText("");
            anio.setText("");

            rbMasculino.setChecked(true);

            chCss.setChecked(false);
            chJava.setChecked(false);
            chHtml.setChecked(false);
            chPhp.setChecked(false);

            if(numCandidatos >= 4){
                evaluar.setVisibility(View.INVISIBLE);
                salir.setVisibility(View.VISIBLE);
            }
        }
    }
}