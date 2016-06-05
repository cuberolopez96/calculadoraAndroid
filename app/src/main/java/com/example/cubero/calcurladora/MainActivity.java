package com.example.cubero.calcurladora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button b0;
    private Button punto;
    private Button igual;
    private Button sumar;
    private Button restar;
    private Button multiplicar;
    private Button dividir;
    private Button ac;
    private TextView resultado;
    private TextView operacion;
    private String tipooperacion;
    private String operando1;
    private String operando2;
    private String operacionCompleta;
    private Boolean interruptor;
    private Boolean operacionActiva = false;
    private float resultadooperacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= (Button) findViewById(R.id.id1);
        b2= (Button) findViewById(R.id.id2);
        b3= (Button) findViewById(R.id.id3);
        b4= (Button) findViewById(R.id.id4);
        b5= (Button) findViewById(R.id.id5);
        b6= (Button) findViewById(R.id.id6);
        b7= (Button) findViewById(R.id.id7);
        b8= (Button) findViewById(R.id.id8);
        b9= (Button) findViewById(R.id.id9);
        b0= (Button) findViewById(R.id.id0);
        punto= (Button) findViewById(R.id.idpunto);
        igual= (Button) findViewById(R.id.igual);
        sumar= (Button) findViewById(R.id.sumar);
        restar= (Button) findViewById(R.id.restar);
        dividir= (Button) findViewById(R.id.dividir);
        multiplicar= (Button) findViewById(R.id.multiplicar);
        ac= (Button) findViewById(R.id.ac);
        operando1 = "";
        operando2 = "";
        interruptor = false;
        resultado = (TextView) findViewById(R.id.resultado);
        operacion = (TextView) findViewById(R.id.operacion);
        resultadooperacion = 0;
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                añadirNumero("0");
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                añadirNumero("1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                añadirNumero("2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                añadirNumero("3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                añadirNumero("4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                añadirNumero("5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                añadirNumero("6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                añadirNumero("7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                añadirNumero("8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                añadirNumero("9");
            }
        });
        sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                añadiroperacion("sumar");
            }

        });
        dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                añadiroperacion("dividir");
            }

        });
        multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                añadiroperacion("multiplicar");
            }
        });
        restar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                añadiroperacion("restar");
            }
        });
        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operar(operando1, operando2, tipooperacion);
            }
        });
        punto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                añadirNumero(".");
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });
    }
    public void añadirNumero(String numero){
        if(interruptor == false){
            operando1 += numero;
            operacionCompleta += numero;
            operacion.setText(""+operando1);
        }else{
            operando2 += numero;
            operacionCompleta += numero;
            operacionActiva = true;
            operacion.setText(""+operando2);
        }


    }
    public void añadiroperacion(String tipooperacion){
        this.tipooperacion = tipooperacion;
        interruptor = true;
    }

    private void operar(String operando1, String operando2, String tipooperacion) {
        Float noperando1 = Float.parseFloat(operando1);
        Float noperando2 = Float.parseFloat(operando2);
        switch (tipooperacion){
            case "dividir":
                resultadooperacion = noperando1 /noperando2;
                resultado.setText(""+resultadooperacion);
                break;
            case "sumar":
                resultadooperacion = noperando1  + noperando2;
                resultado.setText(""+resultadooperacion);
                break;
            case "restar":
                resultadooperacion = noperando1 - noperando2;
                resultado.setText(""+resultadooperacion);
                break;
            case "multiplicar":
                resultadooperacion = noperando1 * noperando2;
                resultado.setText(""+resultadooperacion);
                break;
            default:
                break;
        }

    }
    private  void limpiar(){
        operando1 = "";
        operando2 = "";
        resultado.setText("0");
        operacion.setText("0");
        interruptor = false;
    }

}
