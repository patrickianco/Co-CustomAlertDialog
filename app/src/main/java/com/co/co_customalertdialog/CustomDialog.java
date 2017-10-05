package com.co.co_customalertdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Patrick Ian Co on 10/5/2017.
 */

public class CustomDialog extends DialogFragment{
    LayoutInflater inflater;
    View v;
    EditText uname, pass;

    public Dialog onCreateDialog(Bundle savedInstanceState){
        inflater = getActivity().getLayoutInflater();
        v = inflater.inflate(R.layout.custom_dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(v)
                .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        uname = (EditText) v.findViewById(R.id.uname);
                        pass = (EditText) v.findViewById(R.id.pass);
                        String u = uname.getText().toString();
                        String p = pass.getText().toString();
                        String msg = "Username is: " + u + " and password is: " + p;

                        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        return builder.create();

    }
}
