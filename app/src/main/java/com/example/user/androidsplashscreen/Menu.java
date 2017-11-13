package com.example.user.androidsplashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by USER on 10/30/2017.
 */

public class Menu extends AppCompatActivity {
    private static final String TAG = "Menu Activity";

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Menu Activity Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Menu Activity Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Menu Activity Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Menu Activity Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Menu Activity Resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Menu Activity Restart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        Log.i(TAG, "Menu Activity Create");
    }
    public void onClick_button_draw(View view) {
        Intent intent = new Intent(this, Draw.class);
        startActivity(intent);
    }
    public void onClick_btn_calculator(View view) {
        Intent intent = new Intent(this, Calculator.class);
        startActivity(intent);
    }
}
