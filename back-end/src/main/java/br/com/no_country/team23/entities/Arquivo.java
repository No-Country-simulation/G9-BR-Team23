package br.com.no_country.team23.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

//TODO: tirar duvida sobre o "checksum" do script sql
@Entity
@Table(name = "arquivos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
