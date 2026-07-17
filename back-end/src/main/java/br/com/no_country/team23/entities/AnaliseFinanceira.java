package br.com.no_country.team23.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "analises_financeiras")
public class AnaliseFinanceira {
    @Id
    @Column(name = "id_analise_financeira", nullable = false, unique = true)
    private UUID idAnaliseFinanceira;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario")
    private Usuario usuarioId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfil_financeiro_id", referencedColumnName = "id_perfil_financeiro")
    private PerfilFinanceiro perfilFinanceiroId;
    @Column(name = "periodo_comeco", nullable = false)
    private LocalDateTime periodoComeco;
    @Column(name = "periodo_fim", nullable = false)
    private LocalDateTime periodoFim;
    @Column(name = "ia_acerto", nullable = false)
    private boolean iaAcerto;
    @Column(name = "resumo_gastos", nullable = false)
    private String resumoGastos;
    @Column(name = "conselho")
    private String conselho;
    @Column(name = "gerado_em", nullable = false)
    private LocalDateTime geradoEm;

    public AnaliseFinanceira() {
    }

    public AnaliseFinanceira(UUID idAnaliseFinanceira, Usuario usuarioId, PerfilFinanceiro perfilFinanceiroId, LocalDateTime periodoComeco, LocalDateTime periodoFim, boolean iaAcerto, String resumoGastos, String conselho, LocalDateTime geradoEm) {
        this.idAnaliseFinanceira = idAnaliseFinanceira;
        this.usuarioId = usuarioId;
        this.perfilFinanceiroId = perfilFinanceiroId;
        this.periodoComeco = periodoComeco;
        this.periodoFim = periodoFim;
        this.iaAcerto = iaAcerto;
        this.resumoGastos = resumoGastos;
        this.conselho = conselho;
        this.geradoEm = geradoEm;
    }

    public UUID getIdAnaliseFinanceira() {
        return idAnaliseFinanceira;
    }

    public void setIdAnaliseFinanceira(UUID idAnaliseFinanceira) {
        this.idAnaliseFinanceira = idAnaliseFinanceira;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public PerfilFinanceiro getPerfilFinanceiroId() {
        return perfilFinanceiroId;
    }

    public void setPerfilFinanceiroId(PerfilFinanceiro perfilFinanceiroId) {
        this.perfilFinanceiroId = perfilFinanceiroId;
    }

    public LocalDateTime getPeriodoComeco() {
        return periodoComeco;
    }

    public void setPeriodoComeco(LocalDateTime periodoComeco) {
        this.periodoComeco = periodoComeco;
    }

    public LocalDateTime getPeriodoFim() {
        return periodoFim;
    }

    public void setPeriodoFim(LocalDateTime periodoFim) {
        this.periodoFim = periodoFim;
    }

    public boolean isIaAcerto() {
        return iaAcerto;
    }

    public void setIaAcerto(boolean iaAcerto) {
        this.iaAcerto = iaAcerto;
    }

    public String getResumoGastos() {
        return resumoGastos;
    }

    public void setResumoGastos(String resumoGastos) {
        this.resumoGastos = resumoGastos;
    }

    public String getConselho() {
        return conselho;
    }

    public void setConselho(String conselho) {
        this.conselho = conselho;
    }

    public LocalDateTime getGeradoEm() {
        return geradoEm;
    }

    public void setGeradoEm(LocalDateTime geradoEm) {
        this.geradoEm = geradoEm;
    }
}
