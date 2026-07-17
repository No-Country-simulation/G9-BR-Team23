package br.com.no_country.team23.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

//TODO: tirar duvida sobre o "checksum" do script sql
@Entity
@Table(name = "arquivos")
public class Arquivo {
    @Id
    @Column(name = "id_arquivo", nullable = false, unique = true)
    private UUID idArquivo;
    @Column(name = "nome_arquivo", nullable = false)
    private String nomeArquivo;
    @Column(name = "caminho", nullable = false)
    private String caminhoArquivo;
    @Column(name = "data_upload", nullable = false)
    private LocalDateTime dataUpload;

    public Arquivo() {
    }

    public Arquivo(UUID idArquivo, String nomeArquivo, String caminhoArquivo, LocalDateTime dataUpload) {
        this.idArquivo = idArquivo;
        this.nomeArquivo = nomeArquivo;
        this.caminhoArquivo = caminhoArquivo;
        this.dataUpload = dataUpload;
    }

    public UUID getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(UUID idArquivo) {
        this.idArquivo = idArquivo;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public LocalDateTime getDataUpload() {
        return dataUpload;
    }

    public void setDataUpload(LocalDateTime dataUpload) {
        this.dataUpload = dataUpload;
    }
}
