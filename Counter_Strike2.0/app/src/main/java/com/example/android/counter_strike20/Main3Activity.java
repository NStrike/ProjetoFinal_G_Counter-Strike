package com.example.android.counter_strike20;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent telaTres = getIntent();
        String team = telaTres.getStringExtra("Team");
        int pontos = Integer.parseInt(telaTres.getStringExtra("Pontos"));

        TextView resultado = (TextView) findViewById(R.id.resultado);

        if(team.equals("CT")){
            resultado.setTextColor(Color.parseColor("#07659e"));
        }

        if(team.equals("TR")) {
            resultado.setTextColor(Color.parseColor("#d68b13"));
        }

        if(pontos>7)
        {
            resultado.setText("VITÓRIA");
        }

        else if(pontos==7)
        {
            resultado.setText("EMPATE");
        }

        else {
            resultado.setText("DERROTA");
        }
    }



    public void again(View v){
        Intent telaInicial = new Intent(this, MainActivity.class);
        telaInicial.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(telaInicial);
    }
}