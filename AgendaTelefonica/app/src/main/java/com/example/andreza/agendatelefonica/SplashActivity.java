package com.example.andreza.agendatelefonica;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private GifImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        gifImageView=(GifImageView) findViewById(R.id.gifimageView);

//        converter p kb
        //vamos obter o gif image a partir de ativos e convertê-lo em array de bytes
        //definir recurso gifimageview
        try{
            InputStream inputStream = getAssets().open("buildings_shop.gif");
            byte[]bytes = IOUtils.toByteArray(inputStream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();

        }
        catch (IOException ex){

        }

        //agora vamos pular a atividade por 3 segundos e começar a atividade
        //aguarde segundos e inicie a atividade principal
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SplashActivity.this.startActivity(new Intent(SplashActivity.this,InicialActivity.class));
                SplashActivity.this.finish();
            }
        },9000);//3000 = 3 segundos

     }
//TODO entender pq isso nao funcionou. Consigo fazer com q pessoa toque na splash e pule a splash?


     public void pularASplash(){
        gifImageView.setOnClickListener((View.OnClickListener) findViewById(R.id.gifimageView));
        goToInicial();
     }


    public void goToInicial(){
        Intent intent = new Intent(SplashActivity.this, InicialActivity.class);
        startActivity(intent);
    }



    }







