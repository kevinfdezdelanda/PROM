package com.example.ej_ud02_dialogos;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

public class PedirKebab extends AppCompatActivity {

    private EditText kebab, durums, pPequeña, pCarne;
    private Button confirmar;
    private TextView msgError, msgExito;
    private NotificationManager notificationManager;
    static final String CANAL_ID ="mi_canal";
    static final int NOTIFICACION_ID =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedir_kebab);

        kebab = (EditText) findViewById(R.id.kebab);
        durums = (EditText) findViewById(R.id.Durum);
        pPequeña = (EditText) findViewById(R.id.pPequeñas);
        pCarne = (EditText) findViewById(R.id.pCarne);

        confirmar = (Button) findViewById(R.id.conrfirmar);

        msgExito = (TextView) findViewById(R.id.msgExito);
        msgError = (TextView) findViewById(R.id.msgError);
    }

    public void confirmar04(View v){
        if(v.equals(confirmar)){
            Intent intent = new Intent(PedirKebab.this, PedirKebab2.class);

            String strKebabs = String.valueOf(kebab.getText());
            String strDurums = String.valueOf(durums.getText());
            String strpPequeñas = String.valueOf(pPequeña.getText());
            String strpCarne = String.valueOf(pCarne.getText());

            if(!strKebabs.equals("")||!strDurums.equals("")||!strpPequeñas.equals("")||!strpCarne.equals("")){
                int numKebabs = 0;
                int numDurums = 0;
                int numpPequeñas = 0;
                int numpCarne = 0;

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
                    numpCarne = Integer.parseInt(strpCarne);
                }catch (NumberFormatException ex){

                }

                intent.putExtra("kebabs", numKebabs);
                intent.putExtra("durums", numDurums);
                intent.putExtra("pPequeñas", numpPequeñas);
                intent.putExtra("pCarne", numpCarne);

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
                    new NotificationCompat.Builder(PedirKebab.this,CANAL_ID)
                            .setSmallIcon(R.drawable.donner_kebab)
                            .setContentTitle("Gracias")
                            .setContentText("Su pedido esta en camino");
            notificationManager.notify(NOTIFICACION_ID, notificacion.build());
        } else {
            msgError.setText("Pedido cancelado");
        }
    }
}
