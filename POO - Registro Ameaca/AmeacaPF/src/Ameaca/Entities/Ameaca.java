package Ameaca.Entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Ameaca implements Serializable {

    private int id;
    private String cve;
    private String produto;
    private String versao;
    private String tipo;
    private int criticidade;
    private String data;

    private int dia;
    private int mes;
    private int ano;

    private String separador;

    public String getSeparador() {
        return separador;
    }

    public void setSeparador(String separador) {
        this.separador = separador;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCve() {
        return cve;
    }

    public void setCve(String cve) {
        this.cve = cve;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCriticidade() {
        return criticidade;
    }

    public void setCriticidade(int criticidade) {
        this.criticidade = criticidade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void convertData(String data) {
        String[] v = data.split("/");
        dia = Integer.parseInt(v[0]);
        mes = Integer.parseInt(v[1]);
        ano = Integer.parseInt(v[2]);
    }


}
