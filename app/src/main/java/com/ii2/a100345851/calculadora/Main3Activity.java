package com.ii2.a100345851.calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.IllegalFormatException;

public class Main3Activity extends AppCompatActivity {

    private String operando1, operando2;
    private MainActivity.Operacion operacion;
    private String resultado;
    private String operacionTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

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

        Button expBtn = (Button) findViewById(R.id.expBtn);
        Button raizBtn = (Button) findViewById(R.id.raizBtn);
        Button raizCubBtn = (Button) findViewById(R.id.raizCubBtn);
        Button senBtn = (Button) findViewById(R.id.senBtn);
        Button cosBtn = (Button) findViewById(R.id.cosBtn);
        Button tanBtn = (Button) findViewById(R.id.tanBtn);
        Button arcSenBtn = (Button) findViewById(R.id.arcSenBtn);
        Button arcCosBtn = (Button) findViewById(R.id.arcCosBtn);
        Button arcTanBtn = (Button) findViewById(R.id.arcTanBtn);
        Button eExpBtn = (Button) findViewById(R.id.eExpBtn);
        Button lnBtn = (Button) findViewById(R.id.lnBtn);
        Button logBtn = (Button) findViewById(R.id.logBtn);

        Button volverBtn = (Button) findViewById(R.id.volverBtn);

        expBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacion = MainActivity.Operacion.EXPONENCIAL;
                operando1 = operacionTxt;
                operacionTxt = "";
                volverMainActivity();
            }
        });
        raizBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacion = MainActivity.Operacion.RAIZ;
                operando1 = operacionTxt;
                operacionTxt = "√" + operando1;
                volverMainActivity();
            }
        });
        raizCubBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacion = MainActivity.Operacion.RAIZCUB;
                operando1 = operacionTxt;
                operacionTxt = "∛" + operando1;
                volverMainActivity();
            }
        });
        senBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacion = MainActivity.Operacion.SENO;
                operando1 = operacionTxt;
                operacionTxt = "sen(" + operando1 + ")";
                volverMainActivity();
            }
        });
        cosBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacion = MainActivity.Operacion.COSENO;
                operando1 = operacionTxt;
                operacionTxt = "cos(" + operando1 + ")";
                volverMainActivity();
            }
        });
        tanBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacion = MainActivity.Operacion.TANGENTE;
                operando1 = operacionTxt;
                operacionTxt = "tan(" + operando1 + ")";
                volverMainActivity();
            }
        });
        arcSenBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacion = MainActivity.Operacion.ARCSENO;
                operando1 = operacionTxt;
                operacionTxt = "asen(" + operando1 + ")";
                volverMainActivity();
            }
        });
        arcCosBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacion = MainActivity.Operacion.ARCCOSENO;
                operando1 = operacionTxt;
                operacionTxt = "acos(" + operando1 + ")";
                volverMainActivity();
            }
        });
        arcTanBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacion = MainActivity.Operacion.ARCTANGENTE;
                operando1 = operacionTxt;
                operacionTxt = "atan(" + operando1 + ")";
                volverMainActivity();
            }
        });
        eExpBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacion = MainActivity.Operacion.EEXP;
                operando1 = operacionTxt;
                operacionTxt = "e^" + operando1;
                volverMainActivity();
            }
        });
        lnBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacion = MainActivity.Operacion.LN;
                operando1 = operacionTxt;
                operacionTxt = "ln(" + operando1 + ")";
                volverMainActivity();
            }
        });
        logBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacion = MainActivity.Operacion.LOG;
                operando1 = operacionTxt;
                operacionTxt = "log(" + operando1 + ")";
                volverMainActivity();
            }
        });

        volverBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                finish();
            }
        });
    }

    // Realiza las acciones necesarias antes de terminar la activity
    private void volverMainActivity(){
        Intent activity = new Intent();
        activity.putExtra("op1", operando1);
        activity.putExtra("op2", operando2);
        activity.putExtra("op", operacion.toString());
        activity.putExtra("res", resultado);
        activity.putExtra("optxt", operacionTxt);
        setResult(MainActivity.RESULT_OK, activity);
        finish();
    }
}
