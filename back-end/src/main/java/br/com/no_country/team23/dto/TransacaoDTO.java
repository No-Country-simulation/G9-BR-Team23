package br.com.no_country.team23.dto;

public class TransacaoDTO {
    private String descricao;
    private double valor;
    private String categoria;

    public TransacaoDTO() {}

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}