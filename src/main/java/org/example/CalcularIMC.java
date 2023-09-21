package org.example;

import org.example.entidade.Pessoa;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/** 2-> Calcular IMC e exibir quantas existem em cada faixa */
public class CalcularIMC {
    public static void main(String[] args) {
        List<Pessoa> pessoaList = LerArquivoCsv.lerArquivoCsv();

        Map<String, Integer> contagemImc = calcularImc(pessoaList);

        System.out.println("Quantidade de pessoas em cada faixa de IMC: ");
        for (Map.Entry<String, Integer> entry : contagemImc.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue() + " Pessoas");
        }
    }

    public static Map<String,Integer> calcularImc(List<Pessoa> pessoas){
        Map<String, Integer>  calcularImcPorPessoa = new TreeMap<>();

        for (Pessoa p: pessoas){
            // O arquivo dataBase está apresentado a altura por cm / 100 para virar Metros
            double altura = p.getAltura() / 100;
            double peso = p.getPeso();
            double imc = peso / (altura * altura);
            String faixa = determinarImc(imc);

            if (calcularImcPorPessoa.containsKey(faixa)){
                calcularImcPorPessoa.put(faixa, calcularImcPorPessoa.get(faixa) + 1);
            }else {
                calcularImcPorPessoa.put(faixa, 1);
            }
        }
            return  calcularImcPorPessoa;
    }

    /** IMC por peso*/
    public static String determinarImc(double imc){
        if (imc < 18.5){
            return "MAGREZA";
        }else if (imc >= 18.5 && imc < 24.9){
            return "NORMAL";
        } else if(imc >= 25 && imc < 29.9){
            return "SOBREPESO";
        }else if (imc >= 30 && imc < 39.9){
            return "OBESIDADE";
        }else {
            return "OBESIDADE GRAVE";
        }
    }
}
