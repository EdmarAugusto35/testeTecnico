package org.example;


import org.example.entidade.Pessoa;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 6-> Utilizando a API ViaCEP (https://viacep.com.br/) e a coluna postal_code (CEP) exibir o nome das cidades e quantas pessoas esta cidade possui cadastrada na base de dados, ex: */

public class ApiViaCep {
    public static void main(String[] args) {
        List<Pessoa> pessoaList = LerArquivoCsv.lerArquivoCsv();

        Map<String, Integer> contagemCidades = contarPessoasPorCidade(pessoaList);

        System.out.println("Quantidade de pessoas por cidade:");
        for (Map.Entry<String, Integer> entry : contagemCidades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " pessoa(s)");
        }
    }

    public static String apiViaCep(String cep) {
        boolean error = false;
        try {
            URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

                BufferedReader buff = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder str = new StringBuilder();
                String line;
                while ((line = buff.readLine()) != null) {
                    str.append(line);
                }
                buff.close();

                // Tratando o problema do erro no json devido ao cep errado
                try{
                JSONObject jsonObject = new JSONObject(str.toString());
                return jsonObject.getString("localidade");

                }catch (JSONException e){
                    error = true;
                }

                 if (error) {
                    System.out.println("Ocorreu um erro ao acessar a chave 'localidade'. " + cep);
                    } else {
                    System.out.println("Operação concluída com sucesso.");
                 }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static Map<String, Integer> contarPessoasPorCidade(List<Pessoa> pessoas) {
        Map<String, Integer> contagemCidades = new HashMap<>();
        for (Pessoa pessoa : pessoas) {
            String cep = pessoa.getCodigoPostal();
            if (pessoa.getCodigoPostal() != null) {
                String cidade = apiViaCep(limparCEP(cep));
                if (cidade != null) {
                    if (contagemCidades.containsKey(cidade)) {
                        contagemCidades.put(cidade, contagemCidades.getOrDefault(cidade, 0) + 1);
                    } else {
                        contagemCidades.put(cidade, 1);
                    }
                }
            }
        }

        return contagemCidades;
    }

    // limpar . e - do código postal
    private static String limparCEP(String cep) {
        if (cep == null) {
            return null;
        }
        return cep.replaceAll("[\\.\\-]", "");
    }
}
