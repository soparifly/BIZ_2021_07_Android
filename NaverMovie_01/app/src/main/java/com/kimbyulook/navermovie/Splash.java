package com.kimbyulook.navermovie;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

public class Splash extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Handler handler = new Handler();
        handler.postDelayed(new splashhandler(), 3000);

    }

    private class splashhandler implements  Runnable{
        public void run(){
            startActivity(new Intent(getApplication(), MainActivity.class));
            Splash.this.finish();
        }
    }

}
