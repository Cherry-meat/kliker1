package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Integer counter = 0;
    public void onClickButton(View vien) {
        counter++;
        TextView textCounter = findViewById(R.id.textCounter);
        textCounter.setText(counter.toString());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null &&
                savedInstanceState.containsKey("counter")) {
            counter = savedInstanceState.getInt("counter");
        }
        Log.d(TAG, "onRestoreInstanceState");
    }
    @Override
    protected void onSaveInstanceState(Bundle autState){
        super.onSaveInstanceState(autState);
        int count = 0;
        autState.putInt("Нажалось", count);
        Log.d("Instens","onSave");
        Toast.makeText(this, "onSave",Toast.LENGTH_LONG).show();
    }

    @Override
    protected  void onStart(){
        super.onStart();
        Log.d("Instens", "onStart");
        Toast.makeText(this, "onStart", Toast.LENGTH_LONG).show();
    }
    @Override
    protected  void onResume(){
        super.onResume();
        Log.d("Instens", "onResume");
        Toast.makeText(this, "onResume", Toast.LENGTH_LONG).show();
    }
    @Override
    protected  void onPause(){
        super.onPause();
        Log.d("Instens", "onPause");
        Toast.makeText(this, "onPause", Toast.LENGTH_LONG).show();
    }
}
