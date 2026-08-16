package br.com.no_country.team23.service;

import br.com.no_country.team23.dto.AnaliseRequestDTO;
import br.com.no_country.team23.dto.AnaliseResponseDTO;
import br.com.no_country.team23.dto.TransacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FinanceiroService {

    @Autowired
    private OciStorageService ociStorageService;

    public AnaliseResponseDTO processarAnalise(AnaliseRequestDTO request) {
        Map<String, Double> resumoGastos = new HashMap<>();
        double totalGastos = 0.0;

        // 1. Classificação automática de despesas
        if (request.getTransacoes() != null) {
            for (TransacaoDTO t : request.getTransacoes()) {
                String cat = classificarCategoria(t.getDescricao());
                t.setCategoria(cat);

                resumoGastos.put(cat, resumoGastos.getOrDefault(cat, 0.0) + t.getValor());
                totalGastos += t.getValor();
            }
        }

        // 2. Classificação de perfil financeiro
        String perfil = "Saudável";
        double probabilidade = 0.90;

        if (totalGastos > request.getRenda_mensal() || request.getNivel_endividamento() > 40) {
            perfil = "Em risco";
            probabilidade = 0.88;
        } else if (totalGastos > (request.getRenda_mensal() * 0.7) || request.getNivel_endividamento() > 20) {
            perfil = "Em observacao";
            probabilidade = 0.82;
        }

        // 3. Geração de recomendações
        List<String> recomendacoes = new ArrayList<>();

        if (totalGastos > request.getRenda_mensal()) {
            recomendacoes.add("Reduzir despesas gerais: seus gastos ultrapassam a renda mensal.");
        }
        if (resumoGastos.containsKey("entretenimento") && resumoGastos.get("entretenimento") > (request.getRenda_mensal() * 0.10)) {
            recomendacoes.add("Monitorar gastos recorrentes de entretenimento.");
        }
        if ("Baixa".equalsIgnoreCase(request.getFrequencia_poupanca()) || "Raramente".equalsIgnoreCase(request.getFrequencia_poupanca()) || "Media".equalsIgnoreCase(request.getFrequencia_poupanca())) {
            recomendacoes.add("Aumentar reserva financeira mensal.");
        }
        if (recomendacoes.isEmpty()) {
            recomendacoes.add("Manter a disciplina orçamentária e continuar aportando na reserva.");
        }

        AnaliseResponseDTO response = new AnaliseResponseDTO();
        response.setPerfil_financeiro(perfil);
        response.setProbabilidade(probabilidade);
        response.setResumo_gastos(resumoGastos);
        response.setRecomendacoes(recomendacoes);

        return response;
    }

    private String classificarCategoria(String descricao) {
        if (descricao == null) return "outros";
        String desc = descricao.toLowerCase();

        if (desc.contains("supermercado") || desc.contains("mercado") || desc.contains("padaria") || desc.contains("restaurante") || desc.contains("ifood")) {
            return "alimentacao";
        } else if (desc.contains("combustivel") || desc.contains("posto") || desc.contains("uber") || desc.contains("onibus") || desc.contains("gasolina")) {
            return "transporte";
        } else if (desc.contains("streaming") || desc.contains("netflix") || desc.contains("spotify") || desc.contains("cinema") || desc.contains("jogos")) {
            return "entretenimento";
        } else if (desc.contains("farmacia") || desc.contains("drogaria") || desc.contains("consulta") || desc.contains("medico") || desc.contains("saude")) {
            return "saude";
        } else if (desc.contains("aluguel") || desc.contains("condominio") || desc.contains("luz") || desc.contains("agua") || desc.contains("internet")) {
            return "moradia";
        }
        return "outros";
    }
}