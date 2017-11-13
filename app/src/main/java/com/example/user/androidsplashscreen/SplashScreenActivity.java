package com.example.user.androidsplashscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by USER on 10/29/2017.
 */

public class SplashScreenActivity extends Activity {
    private static final String TAG = "Splash Screen Activity";

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Splash Screen Activity Start");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Splash Screen Activity Restart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Splash Screen Activity Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Splash Screen Activity Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Splash Screen Activity Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Splash Screen Activity Destroy");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreenmaker);

        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
        final Animation animation_1 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
        final Animation animation_2 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.antirotate);
        final Animation animation_3 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);

        imageView.startAnimation(animation_2);
        animation_2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }
            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.startAnimation(animation_1);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animation_1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }
            @Override
            public void onAnimationEnd(Animation animation) {
                //imageView.startAnimation(animation_3);
                finish();
                Intent i = new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        Log.i(TAG, "Splash Screen Activity Create");
    }
}
