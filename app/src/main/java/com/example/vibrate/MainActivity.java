package com.example.vibrate;

import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private View.OnClickListener btn_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

        vibrate.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
        Toast.makeText(MainActivity.this,"震動",Toast.LENGTH_SHORT).show();

            } else {

                vibrate.vibrate(200);

            }
}

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitialComponent();
    }

    private void InitialComponent() {
    btn = findViewById(R.id.btn);
    btn.setOnClickListener(btn_click);
    vibrate = (Vibrator) getSystemService(VIBRATOR_SERVICE);
    }

    Vibrator vibrate;
    Button btn;
}
