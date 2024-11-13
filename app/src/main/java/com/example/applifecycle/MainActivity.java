package com.example.applifecycle;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String tag ="zdarzenia";
    Button btnRun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            Log.d(tag, "onCreate()");
            btnRun = findViewById(R.id.btnRun);
            btnRun.setOnClickListener(this);

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

    @Override
    public void onClick(View view) {

        final ProgressDialog dialog = new ProgressDialog(this);

        dialog.setCancelable(false);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("Okno postępu");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getBaseContext(),
                                "Kliknąłes OK",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Anuluj",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getBaseContext(),
                                "Kliknales Anuluj",
                        Toast.LENGTH_LONG).show();
                    }
                });
        dialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for( int i=1;i<=10;i++){
                    try{
                        Thread.sleep(1500);
                        dialog.incrementProgressBy(10);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

                dialog.dismiss();
            }
        }).start();

    }
}