package br.com.no_country.team23.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transacoes_financeiras")
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

    public TransacaoFinanceira() {
    }

    public TransacaoFinanceira(UUID idTransacao, Usuario usuarioId, Arquivo arquivoId, Categoria categoriaId, LocalDateTime dataTransacao, double valor, String descricao, int parcelamentoRestantes) {
        this.idTransacao = idTransacao;
        this.usuarioId = usuarioId;
        this.arquivoId = arquivoId;
        this.categoriaId = categoriaId;
        this.dataTransacao = dataTransacao;
        this.valor = valor;
        this.descricao = descricao;
        this.parcelamentoRestantes = parcelamentoRestantes;
    }

    public UUID getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(UUID idTransacao) {
        this.idTransacao = idTransacao;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Arquivo getArquivoId() {
        return arquivoId;
    }

    public void setArquivoId(Arquivo arquivoId) {
        this.arquivoId = arquivoId;
    }

    public Categoria getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Categoria categoriaId) {
        this.categoriaId = categoriaId;
    }

    public LocalDateTime getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDateTime dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getParcelamentoRestantes() {
        return parcelamentoRestantes;
    }

    public void setParcelamentoRestantes(int parcelamentoRestantes) {
        this.parcelamentoRestantes = parcelamentoRestantes;
    }
}
