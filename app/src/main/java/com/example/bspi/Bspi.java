package com.example.bspi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class Bspi extends AppCompatActivity {
    private ProgressBar progressBar;
    private  int progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_bspi);
        progressBar = (ProgressBar) findViewById(R.id.progressBarId);
        getSupportActionBar().hide();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
            }
        });
        thread.start();
    }
    ////Adding ProgressBar
    public void doWork(){
        for (progress = 20;progress<=100;progress=progress+20){
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    ////Adding Intent
    public void startApp(){
        Intent intent = new Intent(Bspi.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

}
