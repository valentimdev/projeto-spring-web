package com.br.demo.model;

public class Produto {
    private Long id;
    private String nome;
    private Double preco;
    private String numeroSerie;

    public Produto() {
    }
    public Produto(Long id, String nome, Double preco, String numeroSerie) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.numeroSerie = numeroSerie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
}
