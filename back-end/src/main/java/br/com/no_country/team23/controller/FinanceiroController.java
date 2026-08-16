package br.com.no_country.team23.controller;

import br.com.no_country.team23.dto.AnaliseRequestDTO;
import br.com.no_country.team23.dto.AnaliseResponseDTO;
import br.com.no_country.team23.service.FinanceiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class FinanceiroController {

    @Autowired
    private FinanceiroService financeiroService;

    @PostMapping("/analise-financeira")
    public ResponseEntity<AnaliseResponseDTO> realizarAnalise(@RequestBody AnaliseRequestDTO request) {
        if (request == null || request.getTransacoes() == null) {
            return ResponseEntity.badRequest().build();
        }
        AnaliseResponseDTO resposta = financeiroService.processarAnalise(request);
        return ResponseEntity.ok(resposta);
    }
}