package br.com.no_country.team23.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import jakarta.annotation.PostConstruct;

@Service
public class OciStorageService {

    @Value("${oci.objectstorage.url:https://objectstorage.sa-saopaulo-1.oraclecloud.com/n/grrff6e3s3vz/b/hackathon-team23-models/o/categorias_financeiras.json}")
    private String ociUrl;

    private String regrasClassificacao;

    @PostConstruct
    public void carregarDadosDoObjectStorage() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            this.regrasClassificacao = restTemplate.getForObject(ociUrl, String.class);
            System.out.println(">>> [OCI Object Storage] Metadados carregados da Oracle Cloud com sucesso.");
        } catch (Exception e) {
            System.out.println(">>> [OCI Info] Conexão remota OCI em modo fallback: regras locais ativadas.");
            this.regrasClassificacao = "{\"status\": \"fallback_local\"}";
        }
    }

    public String getRegrasClassificacao() {
        return regrasClassificacao;
    }
}