Teste Tecnico Prime

1 = Desenvolver um programa em java para ler o arquivo "database.csv" respondendo (em linha de comando) às necessidades abaixo:

---
Usei `FileReader` para a leitura do arquivo.csv achei mais tranquilo de usar, tinha openCSV mas não usei.

fiz class privada `getField` para evitar de quebrar quando houver valor nullo no arquivo.CSV

coloquei `try{}catch` para tratar as exceções.

---
2-> Pessoa com maior peso (se houver mais de uma com o mesmo valor, apresentar todas)

Usei `List<>` padrão quando ele pegar os dados do arquivo.csv ele preencher a entidade `pessoa` em uma lista.

---
3-> Calcular IMC e exibir quantas pessoas existem em cada uma das faixas abaixo.

Usei `Map<>` e `Entry` por ter aprendido a pouco tempo que testar eles para fixar

fiz um `if{}else` básico para faixa de pesos

---
5-> Exibir em uma linha, separado por vírgulas, o nome e sobrenome de todas as pessoas obesas.

usei `list<>` básico para resolver e trazer as pessoas mais obesas

---
6-> Função mais encontrada + quantidade (se houver mais de uma com o mesmo valor, apresentar todas)

Usei `Map<>` e `Entry` para fixar na cabeça como e usado curto muito como otimiza o trabalho 
ai usei uma contagem básica

---
7-> Utilizando a API ViaCEP (https://viacep.com.br/) e a coluna postal_code (CEP) exibir o nome das cidades e quantas pessoas esta cidade possui cadastrada na base de dados, ex:

Confessar que custei para fazer muita pesquisa nunca tinha feito essa tipo de api, mas acho que consegui trazer bem os dados,
fiz dois `try{}cath` 1 para tratar as exceções da conexão api e o segundo `try{}cath` para resolver a exceção do json devido ao cep com valor invalido

Fiz um método privado para limpar os `. -`

Usei uma lib Json do jar para download:(https://drive.google.com/drive/folders/1Td0yetiycj4Hs4wpiMzEEa0UucPARxQP?usp=drive_link)