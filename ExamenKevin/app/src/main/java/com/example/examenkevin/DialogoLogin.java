package com.example.examenkevin;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoLogin extends DialogFragment {

    private TextView usu, pass;
    private OnDialogoConfirmacionListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        setCancelable(false);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.dialogo_login, null))
                .setPositiveButton("Login",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String txtUsu = String.valueOf(usu.getText());
                                String txtPass = String.valueOf(pass.getText());
                                listener.onPossitiveButtonClick(txtUsu, txtPass);
                            }
                        })
                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                listener.onNegativeButtonClick();
                            }
                        });
        return builder.create();
    }

    @Override
    public void onStart() {
        super.onStart();
        usu = (TextView) getDialog().findViewById(R.id.usu);
        pass = (TextView) getDialog().findViewById(R.id.pass);
    }

    public interface OnDialogoConfirmacionListener{
        void onPossitiveButtonClick(String usu, String pass); //Eventos Botón Positivos
        void onNegativeButtonClick(); //Eventos Botón Negativo
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            listener = (OnDialogoConfirmacionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    " no Implemento OnDialogoConfirmacionListener");
        }
    }
}