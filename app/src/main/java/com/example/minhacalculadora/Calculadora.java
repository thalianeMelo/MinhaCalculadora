package com.example.minhacalculadora;

public class Calculadora {

    private Double valor1;
    private Double valor2;
    private String operador;

    public String calcular(String valoresCalcular){
        converterValores(valoresCalcular);
        Double resultado = calcularValores();
        return resultado.toString();
    }

    private void converterValores(String valores){
        this.operador = buscarOperador(valores);
        String valoresOperadorConvertido = valores.replace(operador, "operador");
        String[] valoresSeparados = valoresOperadorConvertido.split("operador");
        this.valor1 = Double.parseDouble(valoresSeparados[0]);
        this.valor2 = Double.parseDouble(valoresSeparados[1]);
    }

    private String buscarOperador(String valores){
        if(valores.contains("+")) {
            return "+";
        } else if(valores.contains("-")){
            return "-";
        } else if(valores.contains("*")){
            return "*";
        } else if(valores.contains("÷")){
            return "÷";
        }
        else{
            return "";
        }
    }

    private Double calcularValores(){
        switch (this.operador){
            case "+":
                return this.valor1 + this.valor2;
            case "-":
                return this.valor1 - this.valor2;
            case "*":
                return this.valor1 * this.valor2;
            case "÷":
                return this.valor1 / this.valor2;
        }
        return 0.0;
    }
}
