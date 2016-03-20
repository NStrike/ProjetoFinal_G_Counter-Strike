package com.example.android.counter_strike20;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }



    int scoreCT = 0;
    int scoreTR = 0;
    String team;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent telaDois = getIntent();
        String mapa = telaDois.getStringExtra("String");
        team = telaDois.getStringExtra("team");

        ImageView mapaImage = (ImageView) findViewById(R.id.imagemMapa);

        if(mapa.equals("Nuke")){
            mapaImage.setImageResource(R.drawable.nuke);
        }else if(mapa.equals("Inferno")){
            mapaImage.setImageResource(R.drawable.inferno);
        }else{
            mapaImage.setImageResource(R.drawable.thunder);
        }
    }



    public void addCTPoint(View v) throws InterruptedException {
        scoreCT = scoreCT + 1;
        if(scoreCT>7){
            //chama o
            Intent terceiraTela = new Intent(this, Main3Activity.class);
            terceiraTela.putExtra("Team", team);
            if(team.equals("TR")){
                terceiraTela.putExtra("Pontos", ""+scoreTR);}
            if(team.equals("CT")){
                terceiraTela.putExtra("Pontos", ""+scoreCT);}
            startActivity(terceiraTela);
        }
        if(scoreCT==7&& scoreTR ==7){
            //chama o intent
            Intent terceiraTela = new Intent(this, Main3Activity.class);
            terceiraTela.putExtra("Team", team);
            if(team.equals("TR")){
                terceiraTela.putExtra("Pontos", ""+scoreTR);}
            if(team.equals("CT")){
            terceiraTela.putExtra("Pontos", ""+scoreCT);}
            startActivity(terceiraTela);
        }
        else {
            displayForTeamA(scoreCT);
        }
    }


    public void addTPoint(View v) throws InterruptedException {
        scoreTR = scoreTR + 1;
        if(scoreTR >7){
            //chama o intent
            Intent terceiraTela = new Intent(this, Main3Activity.class);
            terceiraTela.putExtra("Team", team);
            if(team.equals("TR")){
            terceiraTela.putExtra("Pontos", ""+scoreTR);}
            if(team.equals("CT")){
                terceiraTela.putExtra("Pontos", ""+scoreCT);}
            startActivity(terceiraTela);
        }
        if(scoreCT==7&& scoreTR ==7){
            //chama o intent
            Intent terceiraTela = new Intent(this, Main3Activity.class);
            terceiraTela.putExtra("Team", team);
            if(team.equals("TR")){
                terceiraTela.putExtra("Pontos", ""+scoreTR);}
            if(team.equals("CT")){
                terceiraTela.putExtra("Pontos", ""+scoreCT);}
            startActivity(terceiraTela);
        }
        else {
            displayForTeamB(scoreTR);
        }
    }

    public void displayForTeamA(int score)  {
        TextView scoreView = (TextView) findViewById(R.id.ct_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.tr_score);
        scoreView.setText(String.valueOf(score));
    }

}