package org.example;

import org.example.entidade.Pessoa;

import java.util.*;

/** 1-> Pessoa com maior peso (se houver mais de uma com o mesmo valor, apresentar todas) */
public class EncontrarMaiorPeso {

    public static void main(String[] args) {
        List<Pessoa> pessoaList = LerArquivoCsv.lerArquivoCsv();

        List<Pessoa> pessoasComMaiorPeso = encontrarPessoasComMaiorPeso(pessoaList);
        System.out.println("Pessoa com maior peso: ");
        for (Pessoa pessoa : pessoasComMaiorPeso){
            System.out.println(pessoa.getNome() + " " + pessoa.getSobreNome() + " - peso: " + pessoa.getPeso());
        }

    }
    public static List<Pessoa> encontrarPessoasComMaiorPeso(List<Pessoa> pessoas) {
        List<Pessoa> pessoasComMaiorPeso = new ArrayList<>();
        double pesoMaximo = 0;

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getPeso() > pesoMaximo) {
                pesoMaximo = pessoa.getPeso();
                pessoasComMaiorPeso.clear(); // Limpa a lista de pessoas com o peso máximo anterior
                pessoasComMaiorPeso.add(pessoa);
            } else if (pessoa.getPeso() == pesoMaximo) {
                pessoasComMaiorPeso.add(pessoa);
            }
        }

        return pessoasComMaiorPeso;
    }
}
