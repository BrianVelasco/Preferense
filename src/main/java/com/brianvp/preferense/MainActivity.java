package com.brianvp.preferense;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText usuario, pass;
    Button guardar, enviar;
    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        usuario = (EditText) findViewById(R.id.usuario);
        pass = (EditText) findViewById(R.id.pass);

        guardar = (Button) findViewById(R.id.guardar);
        enviar = (Button) findViewById(R.id.enviar);

        t1 =(TextView) findViewById(R.id.texto1);
        t2 =(TextView) findViewById(R.id.texto2);
        cargar_preferencias();
    }
    public void send (View v){
        Intent intent = new Intent(MainActivity.this,Main2Activity.class );
        startActivity(intent);
    }

    private void cargar_preferencias(){
        SharedPreferences preferences = getSharedPreferences("credenciales",Context.MODE_PRIVATE);
        String user = preferences.getString("user","No existe Informacion");
        String pass = preferences.getString("pass","No existe Informacion");

        t1.setText(user);
        t2.setText(pass);
    }

    public void save(View v){
        SharedPreferences preferences = getSharedPreferences("credenciales",Context.MODE_PRIVATE);

        String user = usuario.getText().toString();
        String passw = pass.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("user",user);
        editor.putString("pass",passw);

        t1.setText(user);
        t2.setText(passw);
        editor.commit();
    }


}
