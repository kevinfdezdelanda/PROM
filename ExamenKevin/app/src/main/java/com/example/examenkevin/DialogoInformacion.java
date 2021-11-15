package com.example.examenkevin;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoInformacion extends DialogFragment {
    private String mensaje;
    private boolean cerrar;

    public DialogoInformacion(String mensaje, boolean cerrar){
        this.mensaje = mensaje;
        this.cerrar = cerrar;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());
        builder.setMessage(mensaje)
                .setTitle("Información")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        if(cerrar){android.os.Process.killProcess(android.os.Process.myPid());}
                    }
                });
        return builder.create();
    }
}