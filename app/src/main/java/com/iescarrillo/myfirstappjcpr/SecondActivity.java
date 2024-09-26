package com.iescarrillo.myfirstappjcpr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Instancio todos los objetos editables y el switch en variables.
        EditText editTxt = findViewById(R.id.editText);
        EditText editNum = findViewById(R.id.editIntegerNumber);
        EditText editDecNum = findViewById(R.id.editDecimalNumber);
        Switch switchOp = findViewById(R.id.switchOption);

        Button btnData = findViewById(R.id.btnSendData);

        /*
        Método que hace que el botón esté en escucha y que dentro compruebo que ninguno de los campos rellenables
        este vacío sino le enseño un mensaje al usuario además haciendo que el botón no le cambie de Activity.
         */
        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTxt.getText().toString().equals("") || editNum.getText().toString().equals("") || editDecNum.getText().toString().equals("")){
                    Toast toastName = new Toast(SecondActivity.this);
                    toastName.setText("Any field can´t be empty");
                    toastName.show();
                }else{
                    Intent intentThirdActivity = new Intent(SecondActivity.this, ThirdActivity.class);

                    intentThirdActivity.putExtra("text", editTxt.getText().toString());
                    intentThirdActivity.putExtra("number", editNum.getText().toString());
                    intentThirdActivity.putExtra("decimalNum", editDecNum.getText().toString());
                    //Compruebo el estado del switch y se lo paso al Intent como String porque es más fácil así para después.
                    if(switchOp.isChecked()){
                        intentThirdActivity.putExtra("switch", "true");
                    }else{
                        intentThirdActivity.putExtra("switch", "false");
                    }


                    startActivity(intentThirdActivity);
                }
            }
        });

        Button btnBack = findViewById(R.id.btnBack);
        //Método que hace que al pulsar el botón vuelva a la Activity principal.
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMainActivity = new Intent(SecondActivity.this, MainActivity.class);

                startActivity(intentMainActivity);
            }
        });
    }
}