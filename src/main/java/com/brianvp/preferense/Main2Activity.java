package com.brianvp.preferense;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView campo1,campo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        campo1 = (TextView) findViewById(R.id.carga1);
        campo2 = (TextView) findViewById(R.id.carga2);
        cargar_preferencias();


    }

    private void cargar_preferencias(){
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String user = preferences.getString("user","No existe Informacion");
        String pass = preferences.getString("pass","No existe Informacion");

        campo1.setText(user);
        campo2.setText(pass);
    }
}
