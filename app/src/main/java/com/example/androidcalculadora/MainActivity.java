package com.example.androidcalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText etNum1 = findViewById(R.id.etNum1);
        etNum1.setGravity(Gravity.CENTER);
        EditText etOp = findViewById(R.id.etOp);
        etOp.setGravity(Gravity.CENTER);
        EditText etNum2 = findViewById(R.id.etNum2);
        etNum2.setGravity(Gravity.CENTER);
        TextView tvResultado = findViewById(R.id.tvResultado);
        tvResultado.setGravity(Gravity.CENTER);
        Button btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(click -> calcular(etNum1, etOp, etNum2, tvResultado));

    }

    private void calcular(EditText etNum1, EditText etOp, EditText etNum2, TextView tvResultado){
        int num;
        if (String.valueOf(etNum1.getText()).equals("") || String.valueOf(etNum2.getText()).equals("")){
            Toast.makeText(this, getString(R.string.vazio), Toast.LENGTH_LONG).show();
        } else {
            int x = Integer.parseInt(String.valueOf(etNum1.getText()));
            int y = Integer.parseInt(String.valueOf(etNum2.getText()));
            switch (etOp.getText().toString()){
                case "+":
                    num = x + y;
                    tvResultado.setText(getString(R.string.resultado)+" "+num);
                    break;
                case "-":
                    num = x - y;
                    tvResultado.setText(getString(R.string.resultado)+" "+num);
                    break;
                case "*":
                    num = x * y;
                    tvResultado.setText(getString(R.string.resultado)+" "+num);
                    break;
                case "/":
                    num = x / y;
                    tvResultado.setText(getString(R.string.resultado)+" "+num);
                    break;
                default:
                    tvResultado.setText("");
                    Toast.makeText(this, getString(R.string.operacao), Toast.LENGTH_LONG).show();
                    break;

            }
        }

     }
}
