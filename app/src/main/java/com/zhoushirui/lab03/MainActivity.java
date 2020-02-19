package com.zhoushirui.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView botright;
    TextView botleft;
    TextView topright;
    TextView topleft;
    SeekBar changeSize;
    int count;
    View.OnClickListener press;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("Counter", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        botright = findViewById(R.id.bottomRight);
        botleft = findViewById(R.id.bottomLeft);
        topright = findViewById(R.id.topRight);
        topleft = findViewById(R.id.topLeft);
        changeSize = findViewById(R.id.seekBar);
        press = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView x = (TextView)v;
                String type = (String)x.getText();
                if(type.equals("Top Right")){
                    count = sharedPreferences.getInt("tr", 0);
                    count++;
                    editor.putInt("tr", count);
                    editor.apply();
                    type += " x " + count;
                }
                else if(type.equals("Top Left")){
                    count = sharedPreferences.getInt("tl", 0);
                    count++;
                    editor.putInt("tl", count);
                    editor.apply();
                    type += " x " + count;
                }
                else if(type.equals("Bottom Right")){
                    count = sharedPreferences.getInt("br", 0);
                    count++;
                    editor.putInt("br", count);
                    editor.apply();
                    type += " x " + count;
                }
                else{
                    count = sharedPreferences.getInt("bl", 0);
                    count++;
                    editor.putInt("bl", count);
                    editor.apply();
                    type += " x " + count;
                }

                Toast.makeText(getApplicationContext(), type,Toast.LENGTH_SHORT).show();
            }
        };
        botright.setOnClickListener(press);
        botleft.setOnClickListener(press);
        topright.setOnClickListener(press);
        topleft.setOnClickListener(press);
        changeSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int size = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                size = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                botright.setTextSize(size);
                topright.setTextSize(size);
                botleft.setTextSize(size);
                topleft.setTextSize(size);
            }
        });
    }
}
