package br.com.no_country.team23.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "analises_financeiras")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

}
