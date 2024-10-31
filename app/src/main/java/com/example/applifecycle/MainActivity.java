package com.example.applifecycle;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    String tag ="zdarzenia";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            Log.d(tag, "onCreate()");
            return insets;
        });
    }
    @Override
    public void onStart(){

        super.onStart();
        Log.d(tag,"onStart()");
    }
    @Override
    public void onRestart(){

        super.onRestart();
        Log.d(tag,"onRestart()");
    }
    @Override
    public  void onResume(){

        super.onResume();
        Log.d(tag,"onResume()");

    }
    @Override
    public  void onPause(){

        super.onPause();
        Log.d(tag,"onPause()");
    }
    @Override
    public void onStop(){

        super.onStop();
        Log.d(tag,"onStop()");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(tag,"onDestroy()");
    }
}