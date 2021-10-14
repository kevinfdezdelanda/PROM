package com.example.controlesbasicos2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ej04 extends AppCompatActivity {

    private EditText kebab, durums, pPequeña, pGrande;
    private Button confirmar;
    private TextView msgError, msgExito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej04);

        kebab = (EditText) findViewById(R.id.kebab);
        durums = (EditText) findViewById(R.id.Durum);
        pPequeña = (EditText) findViewById(R.id.pPequeñas);
        pGrande = (EditText) findViewById(R.id.pGrandes);

        confirmar = (Button) findViewById(R.id.conrfirmar);

        msgExito = (TextView) findViewById(R.id.msgExito);
        msgError = (TextView) findViewById(R.id.msgError);
    }

    public void confirmar04(View v){
        if(v.equals(confirmar)){
            Intent intent = new Intent(Ej04.this, Ej04_2.class);

            String strKebabs = String.valueOf(kebab.getText());
            String strDurums = String.valueOf(durums.getText());
            String strpPequeñas = String.valueOf(pPequeña.getText());
            String strpGrandes = String.valueOf(pGrande.getText());

            if(!strKebabs.equals("")||!strDurums.equals("")||!strpPequeñas.equals("")||!strpGrandes.equals("")){
                int numKebabs = 0;
                int numDurums = 0;
                int numpPequeñas = 0;
                int numpGrandes = 0;

                try {
                    numKebabs = Integer.parseInt(strKebabs);
                }catch (NumberFormatException ex){

                }
                try {
                    numDurums = Integer.parseInt(strDurums);
                }catch (NumberFormatException ex){

                }
                try {
                    numpPequeñas = Integer.parseInt(strpPequeñas);
                }catch (NumberFormatException ex){

                }
                try {
                    numpGrandes = Integer.parseInt(strpGrandes);
                }catch (NumberFormatException ex){

                }

                intent.putExtra("kebabs", numKebabs);
                intent.putExtra("durums", numDurums);
                intent.putExtra("pPequeñas", numpPequeñas);
                intent.putExtra("pGrandes", numpGrandes);

                msgError.setText("");

                startActivityForResult(intent,4);
            }else{
                msgError.setText("Debes elegir como minimo un producto");
            }

        }
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4 && resultCode == RESULT_OK) {
            msgExito.setText("Pedido pagado");
        } else {
            msgError.setText("Pedido cancelado");
        }
    }


}
