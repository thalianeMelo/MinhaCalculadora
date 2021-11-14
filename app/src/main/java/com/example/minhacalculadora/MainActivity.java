package com.example.minhacalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Calculadora calculadora = new Calculadora();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void adicionaNumeroBt(View view){
        Button bt = (Button) view;
        String textValor = bt.getText().toString();
        adicionaNumeroTelaPrincipal(textValor);
    }

    public void limparCampos(View view){
        TextView telaPrincipal = getTelaPrincipal();
        TextView numeroTravado = (TextView) findViewById(R.id.numeroTravado);
        telaPrincipal.setText("0.0");
        numeroTravado.setText("");
    }

    public void adicionaOperacao(View view){
        Button bt = (Button) view;
        String operador = bt.getText().toString();
        adicionaNumeroTravado(operador);
    }

    public void calcular(View view){
        TextView numeroTravado = (TextView) findViewById(R.id.numeroTravado);
        TextView telaPrincipal = getTelaPrincipal();
        String valorNumeroTravado = numeroTravado.getText().toString();
        String valorTelaPrincipal = telaPrincipal.getText().toString();
        String valoresCalcular = valorNumeroTravado+valorTelaPrincipal;
        String resultado = calculadora.calcular(valoresCalcular);
        numeroTravado.setText("");
        telaPrincipal.setText(resultado);
    }

    private TextView getTelaPrincipal(){
        return (TextView) findViewById(R.id.telaPrincipal);
    }

    private void adicionaNumeroTelaPrincipal(String textValor){
        TextView telaPrincipal = getTelaPrincipal();
        if(telaPrincipal.getText().length() >= 11){
            Context context = getApplicationContext();
            String mensagem = "Limite maximo de numeros inseridos";
            Toast aviso = Toast.makeText(context, mensagem,Toast.LENGTH_SHORT);
            aviso.show();
        }
        if(!telaPrincipal.getText().toString().equals("0.0")){
            String valorFinalTela = telaPrincipal.getText().toString()+textValor;
            telaPrincipal.setText(valorFinalTela);
        } else{
            telaPrincipal.setText(textValor);
        }
    }

    private void adicionaNumeroTravado(String operador){
        TextView telaPrincipal = getTelaPrincipal();
        TextView numeroTravado = (TextView) findViewById(R.id.numeroTravado);
        String numeroComOperador = telaPrincipal.getText().toString()+operador;
        numeroTravado.setText(numeroComOperador);
        telaPrincipal.setText("0.0");
    }
}