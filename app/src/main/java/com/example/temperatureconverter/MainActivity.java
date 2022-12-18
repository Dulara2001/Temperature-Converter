package com.example.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Button btnCalculate = findViewById(R.id.BtnCalc);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }

    private void calculateAnswer() {
        EditText objInput = findViewById(R.id.TbinpUsr);
        Calculations objCalcs = new Calculations();
        RadioButton objCel = findViewById(R.id.RbCel);
        RadioButton objFah = findViewById(R.id.RbFah);
        TextView objAns = findViewById(R.id.LblAns);

        if(objInput.getText().toString().isEmpty())
            Toast.makeText(this, "Please add a value", Toast.LENGTH_LONG).show();
        else{
            if(objCel.isChecked())
              objAns.setText(String.valueOf(objCalcs.convertCelciusToFahrenheit(Float.valueOf(objInput.getText().toString()))));
            else
                objAns.setText(String.valueOf(objCalcs.convertFahrenheitToCelcius(Float.valueOf(objInput.getText().toString()))));
        }
    }
}