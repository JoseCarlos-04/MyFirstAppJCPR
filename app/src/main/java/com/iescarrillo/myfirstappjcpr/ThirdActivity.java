package com.iescarrillo.myfirstappjcpr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Instancio todos los textos y el switch en variables que voy a rellenar.
        TextView textResult = findViewById(R.id.textField);
        TextView numberResult = findViewById(R.id.numberField);
        TextView decimalNumberResult = findViewById(R.id.decimalNumberField);
        TextView booleanResult = findViewById(R.id.booleanField);

        //Recoge todo lo que le pase al Intent que inicio la Activity.
        Intent intentSecondActivity = getIntent();

        //Relleno todos los campos con los Strings guardados en el Intent.
        textResult.setText(textResult.getText() + intentSecondActivity.getStringExtra("text"));
        numberResult.setText(numberResult.getText() + intentSecondActivity.getStringExtra("number"));
        decimalNumberResult.setText(decimalNumberResult.getText() + intentSecondActivity.getStringExtra("decimalNum"));
        booleanResult.setText(booleanResult.getText() + intentSecondActivity.getStringExtra("switch"));

        Button btnBackToMain = findViewById(R.id.btnBackMain);
        //Método que hace que al pulsar el botón vuelva a la Activity principal.
        btnBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMainActivity = new Intent(ThirdActivity.this, MainActivity.class);

                startActivity(intentMainActivity);
            }
        });
    }
}