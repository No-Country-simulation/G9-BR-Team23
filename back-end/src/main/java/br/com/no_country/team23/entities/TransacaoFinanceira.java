package br.com.no_country.team23.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transacoes_financeiras")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoFinanceira {
    @Column(name = "id_transacao", nullable = false, unique = true)
    @Id
    private UUID idTransacao;
    @Column(name = "usuario_id", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario")
    private Usuario usuarioId;
    @Column(name = "arquivo_id", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arquivo_id", referencedColumnName = "id_arquivo")
    private Arquivo arquivoId;
    @Column(name = "categoria_id", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", referencedColumnName = "id_categoria")
    private Categoria categoriaId;
    @Column(name = "data_transacao", nullable = false)
    private LocalDateTime dataTransacao;
    @Column(name = "valor", nullable = false)
    private double valor;
    @Column(name = "descricao", nullable = false)
    private String descricao;
    @Column(name = "parcelamento_restantes")
    private int parcelamentoRestantes;
}
