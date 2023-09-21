package org.example;


import org.example.entidade.Pessoa;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class LerArquivoCsv {
    public static List<Pessoa>lerArquivoCsv(){
        String arquivoCsv = System.getProperty("user.home") + "/Desktop/Dev/Prime/Teste_Prime/arquivoCSV/database.csv";
       List<Pessoa> pessoaList = new ArrayList<Pessoa>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCsv))) {
            String line = br.readLine();
            line = br.readLine();
            while (line != null){
                String [] vetor = line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
                Pessoa pessoa = new Pessoa(getField(vetor, 0), getField(vetor, 1),
                        getField(vetor, 2), getField(vetor, 3), getField(vetor, 4),
                        Double.parseDouble(getField(vetor, 5)), Double.parseDouble(getField(vetor, 6)),
                        getField(vetor, 7));
                pessoaList.add(pessoa);
                line = br.readLine();
            }

        }catch (IOException e) {
            System.out.println("O arquivo não foi encontrado: " + e.getMessage());
        }
        return pessoaList;
    }

    /** Método para permitir campos vazios é nulls */
    private static String getField(String[] vetor, int index) {
        if (index >= 0 && index < vetor.length) {
            String field = vetor[index].trim();
            return field.isEmpty() ? null : field;
        }
        return null;
    }
}

