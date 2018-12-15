package com.ii2.a100345851.calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.IllegalFormatException;

public class Main2Activity extends AppCompatActivity {

    private String operando1, operando2;
    private MainActivity.Operacion operacion;
    private String resultado;
    private String operacionTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = this.getIntent();
        try{
            operando1 = intent.getStringExtra("op1");
            operando2 = intent.getStringExtra("op2");
            operacion = MainActivity.Operacion.valueOf(intent.getStringExtra("op"));
            resultado = intent.getStringExtra("res");
            operacionTxt = intent.getStringExtra("optxt");
        }catch (IllegalFormatException ignored) {
            operando1 = "";
            operando2 = "";
            operacion = MainActivity.Operacion.DEFAULT;
            resultado = "";
            operacionTxt = "";
        }

        Button volverBtn = (Button) findViewById(R.id.volverBtn);

        volverBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent activity = new Intent();
                activity.putExtra("op1", operando1);
                activity.putExtra("op2", operando2);
                activity.putExtra("op", operacion.toString());
                activity.putExtra("res", resultado);
                activity.putExtra("optxt", operacionTxt);
                setResult(MainActivity.RESULT_OK, activity);
                finish();
            }
        });
    }
}
