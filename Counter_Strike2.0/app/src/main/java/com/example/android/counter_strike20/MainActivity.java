package com.example.android.counter_strike20;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.counter_strike20.R;

public class MainActivity extends AppCompatActivity {

    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void counter(View view){
        String mapa = opcaoMarcado();
        if(mapa.equals("")){
            //esqueceu de marcar
            Toast.makeText(this,"Marque um mapa!",Toast.LENGTH_SHORT).show();
        }
        else{
            //chama o intent
            Intent segundaTela = new Intent(this, Main2Activity.class);
            segundaTela.putExtra("String", mapa);
            segundaTela.putExtra("team", "CT");
            startActivity(segundaTela);
        }
    }

    public void terror(View view){
        String mapa = opcaoMarcado();
        if(mapa.equals("")){
            //esqueceu de marcar
            Toast.makeText(this,"Marque um mapa!",Toast.LENGTH_SHORT).show();
        }else{
            //chama o intent
            Intent segundaTela = new Intent(this, Main2Activity.class);
            segundaTela.putExtra("String", mapa);
            segundaTela.putExtra("team","TR");
            startActivity(segundaTela);
        }
    }
    private String opcaoMarcado(){
        RadioButton dust2 = (RadioButton) findViewById(R.id.thunder);
        RadioButton mirage = (RadioButton) findViewById(R.id.nuke);
        RadioButton inferno = (RadioButton) findViewById(R.id.inferno);

        if(dust2.isChecked()){
            return "Thunder";
        }
        if(mirage.isChecked()){
            return "Nuke";
        }
        if(inferno.isChecked()){
            return "Inferno";
        }
        return "";
    }



}