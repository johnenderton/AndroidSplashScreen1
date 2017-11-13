package com.example.user.androidsplashscreen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Activity Created");
    }
    public void onClick_edittext_ID(View view) {
        EditText editText = (EditText) findViewById(R.id.edittext_ID);
        editText.setText(null);
    }
    public void onClick_edittext_password(View view) {
        EditText editText = (EditText)findViewById(R.id.edittext_password);
        editText.setText(null);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Main Activity Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Main Activity Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Main Activity Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Main Activity Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Main Activity Resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Main Activity Restart");
    }

    public void onClick_button_login(View view) {
        EditText editText_ID = (EditText) findViewById(R.id.edittext_ID);
        EditText editText_password = (EditText)findViewById(R.id.edittext_password);
        String id = editText_ID.getText().toString();
        String pass = editText_password.getText().toString();
        if (new String("admin").equals(id) && new String("123").equals(pass)) {
            Toast.makeText(this, "Access Granted", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, Menu.class);
            startActivity(intent);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.warning_message);
            builder.setTitle(R.string.warning);
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}
