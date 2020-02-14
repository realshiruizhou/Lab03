package com.zhoushirui.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView botright;
    TextView botleft;
    TextView topright;
    TextView topleft;
    View.OnClickListener press;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botright = findViewById(R.id.bottomRight);
        botleft = findViewById(R.id.bottomLeft);
        topright = findViewById(R.id.topRight);
        topleft = findViewById(R.id.topLeft);
        press = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"very cool!",Toast.LENGTH_SHORT).show();
            }
        };
        botright.setOnClickListener(press);
        botleft.setOnClickListener(press);
        topright.setOnClickListener(press);
        topleft.setOnClickListener(press);
    }
}
