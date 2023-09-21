package org.example;

import org.example.entidade.Pessoa;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 5-> Função mais encontrada + quantidade (se houver mais de uma com o mesmo valor, apresentar todas) */
public class EncontrarPorFuncao {

    public static void main(String[] args) {
        List<Pessoa> pessoaList = LerArquivoCsv.lerArquivoCsv();
        Map<String, Integer> contagemFuncoes = contarFuncoes(pessoaList);
        int maxFuncoes = Collections.max(contagemFuncoes.values());

        System.out.println("Contagem de funções:");
        for (Map.Entry<String, Integer> entry : contagemFuncoes.entrySet()) {
            if (entry.getValue() == maxFuncoes) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " vezes");
            }
        }

    }
    public static Map<String,Integer> contarFuncoes(List<Pessoa> pessoas){
        Map<String, Integer> contagemFuncoes = new HashMap<>();
        for (Pessoa p : pessoas){
            String funcao = p.getFuncao();
            if (contagemFuncoes.containsKey(funcao)){
                contagemFuncoes.put(funcao, contagemFuncoes.get(funcao) + 1);
            }else {
                contagemFuncoes.put(funcao, 1);
            }
        }
        return contagemFuncoes;
    }
}
