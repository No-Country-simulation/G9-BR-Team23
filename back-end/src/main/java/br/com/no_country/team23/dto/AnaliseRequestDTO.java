package br.com.no_country.team23.dto;

import java.util.List;

public class AnaliseRequestDTO {
    private double renda_mensal;
    private double nivel_endividamento;
    private String frequencia_poupanca;
    private List<TransacaoDTO> transacoes;

    public AnaliseRequestDTO() {}

    public double getRenda_mensal() { return renda_mensal; }
    public void setRenda_mensal(double renda_mensal) { this.renda_mensal = renda_mensal; }

    public double getNivel_endividamento() { return nivel_endividamento; }
    public void setNivel_endividamento(double nivel_endividamento) { this.nivel_endividamento = nivel_endividamento; }

    public String getFrequencia_poupanca() { return frequencia_poupanca; }
    public void setFrequencia_poupanca(String frequencia_poupanca) { this.frequencia_poupanca = frequencia_poupanca; }

    public List<TransacaoDTO> getTransacoes() { return transacoes; }
    public void setTransacoes(List<TransacaoDTO> transacoes) { this.transacoes = transacoes; }
}