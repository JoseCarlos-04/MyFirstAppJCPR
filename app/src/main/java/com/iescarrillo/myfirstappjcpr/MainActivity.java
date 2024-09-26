package com.iescarrillo.myfirstappjcpr;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        Log.i("Ciclo de vida", "Ha entrado en el método onCreate");

        Button btnWriteMsg = findViewById(R.id.btnWriteMessage);
        //Método que hace que al pulsar el botón se inicie la segunda Activity.
        btnWriteMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSecondActivity = new Intent(MainActivity.this, SecondActivity.class);

                startActivity(intentSecondActivity);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();

        Log.i("Ciclo de vida", "Ha entrado en el método onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();

        Log.i("Ciclo de vida", "Ha entrado en el método onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();

        Log.i("Ciclo de vida", "Ha entrado en el método onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();

        Log.i("Ciclo de vida", "Ha entrado en el método onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        Log.i("Ciclo de vida", "Ha entrado en el método onDestroy");
    }
}