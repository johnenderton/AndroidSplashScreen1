package com.example.user.androidsplashscreen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
    private static final String TAG = "Calculator Activity";

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Calculator Activity Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Calculator Activity Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Calculator Activity Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Calculator Activity Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Calculator Activity Resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Calculator Activity Restart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_activity);
        Log.i(TAG, "Calculator Activity Create");
    }
    StringBuilder calculateString = new StringBuilder();
    double result;

    boolean IsLastCharNum() {
        Character c = calculateString.charAt(calculateString.length()-1);
        return !(c.equals('+') || c.equals('-') || c.equals('*') || c.equals('/'));
    }
    public void giveWarning() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Wrong Input \n" +
                " Has to be a number");
        builder.setTitle(R.string.warning);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void onClick_btn_0(View view) {
        TextView textView = (TextView)findViewById(R.id.textview_calculate_result);
        calculateString.append('0');
        textView.setText(calculateString);
    }
    public void onClick_btn_1(View view) {
        TextView textView = (TextView)findViewById(R.id.textview_calculate_result);
        calculateString.append('1');
        textView.setText(calculateString);
    }
    public void onClick_btn_2(View view) {
        TextView textView = (TextView)findViewById(R.id.textview_calculate_result);
        calculateString.append('2');
        textView.setText(calculateString);
    }
    public void onClick_btn_3(View view) {
        TextView textView = (TextView)findViewById(R.id.textview_calculate_result);
        calculateString.append('3');
        textView.setText(calculateString);
    }
    public void onClick_btn_4(View view) {
        TextView textView = (TextView)findViewById(R.id.textview_calculate_result);
        calculateString.append('4');
        textView.setText(calculateString);
    }
    public void onClick_btn_5(View view) {
        TextView textView = (TextView)findViewById(R.id.textview_calculate_result);
        calculateString.append('5');
        textView.setText(calculateString);
    }
    public void onClick_btn_6(View view) {
        TextView textView = (TextView)findViewById(R.id.textview_calculate_result);
        calculateString.append('6');
        textView.setText(calculateString);
    }
    public void onClick_btn_7(View view) {
        TextView textView = (TextView)findViewById(R.id.textview_calculate_result);
        calculateString.append('7');
        textView.setText(calculateString);
    }
    public void onClick_btn_8(View view) {
        TextView textView = (TextView)findViewById(R.id.textview_calculate_result);
        calculateString.append('8');
        textView.setText(calculateString);
    }
    public void onClick_btn_9(View view) {
        TextView textView = (TextView)findViewById(R.id.textview_calculate_result);
        calculateString.append('9');
        textView.setText(calculateString);
    }
    public void onClick_btn_add(View view) {
        TextView textView = (TextView)findViewById(R.id.textview_calculate_result);
        if (IsLastCharNum()) {
            calculateString.append('+');
            textView.setText(calculateString);
        } else {
            giveWarning();
        }
    }
    public void onClick_btn_subtract(View view) {
        TextView textView = (TextView)findViewById(R.id.textview_calculate_result);
        if (IsLastCharNum()) {
            calculateString.append('-');
            textView.setText(calculateString);
        } else {
            giveWarning();
        }
    }
    public void onClick_btn_multi(View view) {
        TextView textView = (TextView)findViewById(R.id.textview_calculate_result);
        if (IsLastCharNum()) {
            calculateString.append('*');
            textView.setText(calculateString);
        } else {
            giveWarning();
        }
    }
    public void onClick_btn_div(View view) {
        TextView textView = (TextView)findViewById(R.id.textview_calculate_result);
        if (IsLastCharNum()) {
            calculateString.append('/');
            textView.setText(calculateString);
        } else {
            giveWarning();
        }
    }
    public void onClick_btn_ce(View view) {
        TextView textView = (TextView)findViewById(R.id.textview_calculate_result);
        calculateString.setLength(0);
        textView.setText("0");
    }
    public void onClick_btn_equal(View view) {
        TextView textView = (TextView)findViewById(R.id.textview_calculate_result);
        String cal = calculateString.toString();
        String[] num = cal.split("[-+*/]");
        double[] arr = new double[num.length];
        for (int i = 0; i < num.length; i++) {
            arr[i] = Double.parseDouble(num[i]);
        }
        String calsign = cal.replaceAll("\\d", "");
        char[] sign_char = calsign.toCharArray();
        Character[] sign = new Character[sign_char.length];
        for (int i = 0; i < sign.length; i++) {
            sign[i] = sign_char[i];
        }
        result = arr[0];
        if (arr.length >= 2) {
            // calculate
            for (int i = 0; i < sign.length; i++) {
                if (sign[i].equals('/')) {
                    result /= arr[i+1];
                }if (sign[i].equals('+')) {
                    result += arr[i+1];
                }
                if (sign[i].equals('-')) {
                    result -= arr[i+1];
                }
                if (sign[i].equals('*')) {
                    result *= arr[i+1];
                }
            }
            textView.setText(Double.toString(result));
            calculateString.setLength(0);
            result = 0;
        } else {
            if (calculateString.length() == 0) {
                result = 0;
                textView.setText("0");
            }
            if (arr.length == 1) {
                textView.setText(calculateString);
            }
            if (arr.length == 1 && sign.length == 1) {
                if (sign[0].equals('/')) {
                    result /= arr[0];
                }if (sign[0].equals('+')) {
                    result += arr[0];
                }
                if (sign[0].equals('-')) {
                    result -= arr[0];
                }
                if (sign[0].equals('*')) {
                    result *= arr[0];
                }
                textView.setText(Double.toString(result));
                calculateString.setLength(0);
                result = 0;
            }
        }
    }
}
