package com.br.demo.dto.response;

public class ProdutoResponseDTO {
    private Long id;
    private String nome;
    private Double preco;
    private String numeroSerie;

    public ProdutoResponseDTO() {

    }
    public ProdutoResponseDTO(Long id, String nome, Double preco, String numeroSerie) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.numeroSerie = numeroSerie;
    }
}
