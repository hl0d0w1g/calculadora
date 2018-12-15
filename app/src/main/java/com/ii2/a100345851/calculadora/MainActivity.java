package com.ii2.a100345851.calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.IllegalFormatException;

public class MainActivity extends AppCompatActivity {

    protected enum Operacion{
        SUMA,
        RESTA,
        MULTIPLICACION,
        DIVISION,
        EXPONENCIAL,
        RAIZ,
        RAIZCUB,
        SENO,
        COSENO,
        TANGENTE,
        ARCSENO,
        ARCCOSENO,
        ARCTANGENTE,
        EEXP,
        LN,
        LOG,
        DEFAULT
    }

    private double operando1, operando2;
    private Operacion operacion;
    private double resultado;

    private TextView operacionTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DecimalFormat df = new DecimalFormat("#.####");

        operacionTxt = (TextView) findViewById(R.id.operacionTxt);
        Button acercaDeBtn = (Button) findViewById(R.id.acercaDeBtn);
        Button moduloCientificoBtn = (Button) findViewById(R.id.moduloCientificoBtn);

        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Button btn5 = (Button) findViewById(R.id.btn5);
        Button btn6 = (Button) findViewById(R.id.btn6);
        Button btn7 = (Button) findViewById(R.id.btn7);
        Button btn8 = (Button) findViewById(R.id.btn8);
        Button btn9 = (Button) findViewById(R.id.btn9);
        Button btn0 = (Button) findViewById(R.id.btn0);

        Button sumaBtn = (Button) findViewById(R.id.sumaBtn);
        Button restaBtn = (Button) findViewById(R.id.restaBtn);
        Button multiplicacionBtn = (Button) findViewById(R.id.multiplicacionBtn);
        Button divisionBtn = (Button) findViewById(R.id.divisionBtn);
        Button puntoBtn = (Button) findViewById(R.id.puntoBtn);
        Button igualBtn = (Button) findViewById(R.id.igualBtn);
        Button borrarBtn = (Button) findViewById(R.id.borrarBtn);
        Button borrarTodoBtn = (Button) findViewById(R.id.borrarTodoBtn);

        iniciarAtr();

        acercaDeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent activity2 = new Intent(MainActivity.this, Main2Activity.class);
                try{
                    activity2.putExtra("op1", operando1 + "");
                    activity2.putExtra("op2", operando2 + "");
                    activity2.putExtra("op", operacion.toString());
                    activity2.putExtra("res", resultado + "");
                    activity2.putExtra("optxt", operacionTxt.getText().toString());
                } catch (IllegalFormatException ignored){}
                startActivityForResult(activity2, 0);
            }
        });
        moduloCientificoBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent activity3 = new Intent(MainActivity.this, Main3Activity.class);
                try{
                    activity3.putExtra("op1", operando1 + "");
                    activity3.putExtra("op2", operando2 + "");
                    activity3.putExtra("op", operacion.toString());
                    activity3.putExtra("res", resultado + "");
                    activity3.putExtra("optxt", operacionTxt.getText().toString());
                } catch (IllegalFormatException ignored){}
                startActivityForResult(activity3, 0);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacionTxt.setText(String.format("%s1", operacionTxt.getText().toString()));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacionTxt.setText(String.format("%s2", operacionTxt.getText().toString()));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacionTxt.setText(String.format("%s3", operacionTxt.getText().toString()));
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacionTxt.setText(String.format("%s4", operacionTxt.getText().toString()));
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacionTxt.setText(String.format("%s5", operacionTxt.getText().toString()));
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacionTxt.setText(String.format("%s6", operacionTxt.getText().toString()));
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacionTxt.setText(String.format("%s7", operacionTxt.getText().toString()));
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacionTxt.setText(String.format("%s8", operacionTxt.getText().toString()));
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacionTxt.setText(String.format("%s9", operacionTxt.getText().toString()));
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacionTxt.setText(String.format("%s0", operacionTxt.getText().toString()));
            }
        });

        sumaBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacion = Operacion.SUMA;
                try{
                    operando1 = Double.parseDouble(operacionTxt.getText().toString());
                } catch (IllegalArgumentException ignored){ operando1 = 0.0; }
                iniciarOperacionTxt();
            }
        });
        restaBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if((operando1 != 0.0) || (!operacionTxt.getText().toString().equals(""))){
                    operacion = Operacion.RESTA;
                    try{
                        operando1 = Double.parseDouble(operacionTxt.getText().toString());
                    } catch (IllegalArgumentException ignored){ operando1 = 0.0; }
                    iniciarOperacionTxt();
                }else {
                    operacionTxt.setText(String.format("%s-", operacionTxt.getText().toString()));
                }
            }
        });
        multiplicacionBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacion = Operacion.MULTIPLICACION;
                try{
                    operando1 = Double.parseDouble(operacionTxt.getText().toString());
                } catch (IllegalArgumentException ignored){ operando1 = 0.0; }
                iniciarOperacionTxt();
            }
        });
        divisionBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacion = Operacion.DIVISION;
                try{
                    operando1 = Double.parseDouble(operacionTxt.getText().toString());
                } catch (IllegalArgumentException ignored){ operando1 = 0.0; }
                iniciarOperacionTxt();
            }
        });

        puntoBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                operacionTxt.setText(String.format("%s.", operacionTxt.getText().toString()));
            }
        });
        igualBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                realizarOperacion();
                if(Double.isNaN(resultado)){
                    operacionTxt.setText("");
                    operacionTxt.setHint("NaN");
                }else{
                    operacionTxt.setHint("0");
                    operacionTxt.setText(df.format(resultado).replace(",", "."));
                }
                iniciarAtr();
            }
        });

        borrarBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if (!operacionTxt.getText().toString().equals("")) {
                    operacionTxt.setText(operacionTxt.getText().subSequence(0, operacionTxt.getText().length() - 1));
                }
                operacionTxt.setHint("0");
            }
        });
        borrarTodoBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                iniciarOperacionTxt();
                iniciarAtr();
            }
        });
    }

    //
    protected void onResume(){
        super.onResume();
        //operacionTxt.setText("ERR");
    }

    // Recoge los resultados de las activities que se lanzan desde esta activity
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(data != null){
            try {
                operando1 = Double.parseDouble(data.getStringExtra("op1"));
                operando2 = Double.parseDouble(data.getStringExtra("op2"));
                operacion = Operacion.valueOf(data.getStringExtra("op"));
                resultado = Double.parseDouble(data.getStringExtra("res"));
                operacionTxt.setText(data.getStringExtra("optxt"));
            }catch (IllegalArgumentException ignored){
                iniciarAtr();
                iniciarOperacionTxt();
            }
        }
    }

    // Inicia los atributos de la calculadora
    private void iniciarAtr(){
        operando1 = 0.0;
        operando2 = 0.0;
        operacion = Operacion.DEFAULT;
        resultado = 0.0;
    }

    // Deja el TextView con sus valores por defecto
    private void iniciarOperacionTxt(){
        operacionTxt.setText("");
        operacionTxt.setHint("0");
    }

    // Realiza cada una de las operaciones de la calculadora
    protected void realizarOperacion(){
        try{
            switch (operacion){
                case SUMA:
                    operando2 = Double.parseDouble(operacionTxt.getText().toString());
                    resultado = operando1 + operando2;
                    break;
                case RESTA:
                    operando2 = Double.parseDouble(operacionTxt.getText().toString());
                    resultado = operando1 - operando2;
                    break;
                case MULTIPLICACION:
                    operando2 = Double.parseDouble(operacionTxt.getText().toString());
                    resultado = operando1 * operando2;
                    break;
                case DIVISION:
                    operando2 = Double.parseDouble(operacionTxt.getText().toString());
                    resultado = operando1 / operando2;
                    break;
                case EXPONENCIAL:
                    operando2 = Double.parseDouble(operacionTxt.getText().toString());
                    resultado = Math.pow(operando1, operando2);
                    break;
                case RAIZ:
                    resultado = Math.sqrt(operando1);
                    break;
                case RAIZCUB:
                    resultado = Math.cbrt(operando1);
                    break;
                case SENO:
                    resultado = Math.sin(operando1);
                    break;
                case COSENO:
                    resultado = Math.cos(operando1);
                    break;
                case TANGENTE:
                    resultado = Math.tan(operando1);
                    break;
                case ARCSENO:
                    resultado = Math.asin(operando1);
                    break;
                case ARCCOSENO:
                    resultado = Math.acos(operando1);
                    break;
                case ARCTANGENTE:
                    resultado = Math.atan(operando1);
                    break;
                case EEXP:
                    resultado = Math.exp(operando1);
                    break;
                case LN:
                    resultado = Math.log(operando1);
                    break;
                case LOG:
                    resultado = Math.log10(operando1);
                    break;
                case DEFAULT:
                    resultado = Double.parseDouble(operacionTxt.getText().toString());
                    break;
            }
        }catch (IllegalArgumentException ignored){ resultado = 0.0; }
    }
}
