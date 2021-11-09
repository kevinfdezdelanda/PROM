package com.example.actividad_notificaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtNum1, txtNum2, txtOperador, txtNumAciertos;

    private NotificationManager notificationManager;
    static final String CANAL_ID ="mi_canal";
    static final int NOTIFICACION_ID =1;

    private Button comprobar;

    private EditText txtResul;

    private static int num1, num2, numAciertos, operador;
    private static String[] operadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numAciertos = 0;

        operadores = new String[]{"+", "-", "*", "/"};

        txtNum1 = (TextView) findViewById(R.id.num1);
        txtNum2 = (TextView) findViewById(R.id.num2);
        txtOperador = (TextView) findViewById(R.id.operador);
        txtNumAciertos = (TextView) findViewById(R.id.numAciertos);

        comprobar = (Button) findViewById(R.id.comprobar);

        txtResul = (EditText) findViewById(R.id.resul);

        nuevaOperacion();
    }

    private void nuevaOperacion() {
        num1 = (int) (Math.random()*99)+1;
        num2 = (int) (Math.random()*99)+1;

        operador = (int) (Math.random()*4);

        txtNum1.setText(num1+"");
        txtNum2.setText(num2+"");
        txtOperador.setText(operadores[operador]);
        txtResul.setText("");
    }

    public void comprobarResul(View v){
        if(v.equals(comprobar)){
            int resul = 0;
            switch (operadores[operador]) {
                case "+":
                    resul = num1 + num2;
                    break;
                case "-":
                    resul = num1 - num2;
                    break;
                case "*":
                    resul = num1 * num2;
                    break;
                case "/":
                    resul = num1 / num2;
                    break;
            }

            int resulUsu = 0;
            try{
                resulUsu = Integer.parseInt(String.valueOf(txtResul.getText()));
                if(resul == resulUsu){
                    numAciertos += 1;
                    txtNumAciertos.setText("Preguntas acertadas: "+numAciertos);
                }
            }catch (Exception e){

            }

            nuevaOperacion();

            if(numAciertos >= 10){
                notificationManager = (NotificationManager) getSystemService(
                        NOTIFICATION_SERVICE);
                //Creamos el canal. SOLO puede hacerse en dispositivos con ver. 8 o más.
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel notificationChannel = new NotificationChannel(
                            CANAL_ID, "Mis notificaciones",
                            NotificationManager.IMPORTANCE_DEFAULT);
                    notificationChannel.setDescription("Descripción del canal");
                    notificationManager.createNotificationChannel(notificationChannel);
                }
                NotificationCompat.Builder notificacion =
                        new NotificationCompat.Builder(MainActivity.this,CANAL_ID)
                                .setSmallIcon(R.drawable.ic_launcher_foreground)
                                .setContentTitle("\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25Muy Bien\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25")
                                .setContentText("has acertado \uD83D\uDD25\uD83D\uDD25\uD83D\uDD25 10 \uD83D\uDD25\uD83D\uDD25\uD83D\uDD25 preguntas");
                notificationManager.notify(NOTIFICACION_ID, notificacion.build());
            }
        }
    }
}