package br.com.no_country.team23.dto;

import java.util.List;
import java.util.Map;

public class AnaliseResponseDTO {
    private String perfil_financeiro;
    private double probabilidade;
    private Map<String, Double> resumo_gastos;
    private List<String> recomendacoes;

    public AnaliseResponseDTO() {}

    public String getPerfil_financeiro() { return perfil_financeiro; }
    public void setPerfil_financeiro(String perfil_financeiro) { this.perfil_financeiro = perfil_financeiro; }

    public double getProbabilidade() { return probabilidade; }
    public void setProbabilidade(double probabilidade) { this.probabilidade = probabilidade; }

    public Map<String, Double> getResumo_gastos() { return resumo_gastos; }
    public void setResumo_gastos(Map<String, Double> resumo_gastos) { this.resumo_gastos = resumo_gastos; }

    public List<String> getRecomendacoes() { return recomendacoes; }
    public void setRecomendacoes(List<String> recomendacoes) { this.recomendacoes = recomendacoes; }
}