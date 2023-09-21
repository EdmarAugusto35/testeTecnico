package org.example;

import org.example.entidade.Pessoa;

import java.util.List;

public class CalcularPessoasObeas {
    public static void main(String[] args) {
        List<Pessoa> pessoaList = LerArquivoCsv.lerArquivoCsv( );

        System.out.println("Nome e sobrenome de pessoas obesas: ");

        for (Pessoa pessoa : pessoaList){
            double altura = pessoa.getAltura() / 100;
            double peso = pessoa.getPeso();

            double imc = peso / (altura * altura);
            if (imc >= 30 && imc < 39.9){
                System.out.printf(pessoa.getNome() + " " + pessoa.getSobreNome() + ", ");
            }
        }
    }
}
