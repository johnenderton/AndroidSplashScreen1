package com.example.user.androidsplashscreen;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.Loader;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class Draw extends AppCompatActivity {
    private DrawingView drawView;
    private ImageButton currPaint, eraseBtn;
    private static final String TAG = "Draw Activity";

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Draw Activity Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Draw Activity Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Draw Activity Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Draw Activity Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Draw Activity Resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Draw Activity Restart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawing_activity);
        drawView = (DrawingView)findViewById(R.id.drawing);
        LinearLayout paintLayout = (LinearLayout)findViewById(R.id.paint_colors);
        currPaint = (ImageButton)paintLayout.getChildAt(0);
        //currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
        currPaint.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.paint_pressed, null));
        Log.i(TAG, "Draw Activity Create");
    }
    public void paintClicked(View view){
        //use chosen color
        if(view!=currPaint){
            //update color
            ImageButton imgView = (ImageButton)view;
            String color = view.getTag().toString();
            drawView.setColor(color);
            //imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
            imgView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.paint_pressed, null));
            //currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
            currPaint.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.paint, null));
            currPaint=(ImageButton)view;
            drawView.setErase(false);
        }
    }
    public void onClick_btn_erase(View view) {
        drawView.setErase(true);
        //drawView.setBrushSize();
    }
    public void onClick_btn_draw(View view) {
        drawView.setErase(false);
    }
    public void onClick_btn_save(final View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Save Drawing");
        final EditText editText = new EditText(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        editText.setLayoutParams(layoutParams);
        builder.setView(editText);
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                drawView.setDrawingCacheEnabled(true);
                String filename = editText.getText().toString();
                String path = Environment.getExternalStorageDirectory().getAbsolutePath();
                File file = new File(path + filename + ".png");
                FileOutputStream fileOutputStream;
                Bitmap bitmap = drawView.getDrawingCache();
//                try {
//                    fileOutputStream = new FileOutputStream(file);
//                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
//                    System.out.println("saving......................................................"+path);
//                    fileOutputStream.close();
//
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                String imgSaved = MediaStore.Images.Media.insertImage(
                        getContentResolver(), drawView.getDrawingCache(),
                        UUID.randomUUID().toString()+".png", "drawing");
                if(imgSaved!=null){
                    Toast savedToast = Toast.makeText(getApplicationContext(),
                            "Drawing saved to Gallery!", Toast.LENGTH_SHORT);
                    savedToast.show();
                }
                else{
                    Toast unsavedToast = Toast.makeText(getApplicationContext(),
                            "Oops! Image could not be saved.", Toast.LENGTH_SHORT);
                    unsavedToast.show();
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
        drawView.destroyDrawingCache();
    }
}
