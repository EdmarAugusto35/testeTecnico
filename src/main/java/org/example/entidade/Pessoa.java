package org.example.entidade;

import java.io.Serializable;

public class Pessoa implements Serializable {

    private String nome;

    private String sobreNome;

    private String funcao;

    private String empresa;

    private String veiculo;

    private Double peso;

    private Double altura;

    private String codigoPostal;

    public Pessoa(String nome, String sobreNome, String funcao, String empresa,
                  String veiculo, Double peso, Double altura, String codigoPostal) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.funcao = funcao;
        this.empresa = empresa;
        this.veiculo = veiculo;
        this.peso = peso;
        this.altura = altura;
        this.codigoPostal = codigoPostal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", funcao='" + funcao + '\'' +
                ", empresa='" + empresa + '\'' +
                ", veiculo='" + veiculo + '\'' +
                ", peso='" + peso + '\'' +
                ", altura='" + altura + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                '}';
    }
}
