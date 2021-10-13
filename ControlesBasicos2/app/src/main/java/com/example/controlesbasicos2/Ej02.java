package com.example.controlesbasicos2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ej02 extends AppCompatActivity {

    private EditText eNum1, eNum2, eResul;
    private TextView correctas, incorrectas;
    private Button comprobar;
    private int num1, num2;
    private int numCorrectas, numIncorrectas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej02);

        eNum1 = (EditText) findViewById(R.id.num1);
        eNum2 = (EditText) findViewById(R.id.num2);
        eResul = (EditText) findViewById(R.id.resul);

        correctas = (TextView) findViewById(R.id.correctas);
        incorrectas = (TextView) findViewById(R.id.incorrectas);

        comprobar = (Button) findViewById(R.id.comprobar);

        setNums();

        numCorrectas = 0;
        numIncorrectas = 0;
    }

    private void setNums() {
        num1 = (int) (Math.random()*100);
        num2 = (int) (Math.random()*100);
        eNum1.setText(num1+"");
        eNum2.setText(num2+"");
        eResul.setText("");
    }

    public void comprobarResul(View v){
        if (v.equals(comprobar)){
            int resulUsu = Integer.parseInt(String.valueOf(eResul.getText()));

            Intent intent = new Intent(Ej02.this, Ej02_2.class);
            intent.putExtra("num1", num1);
            intent.putExtra("num2", num2);
            intent.putExtra("resulUsu", resulUsu);
            startActivityForResult(intent,2);
        }
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == RESULT_OK) {
            numCorrectas++;
            correctas.setText(numCorrectas+"");
        } else {
            numIncorrectas++;
            incorrectas.setText(numIncorrectas+"");
        }

        setNums();
    }

}
