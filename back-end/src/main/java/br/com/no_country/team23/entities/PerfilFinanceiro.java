package br.com.no_country.team23.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "perfis_financeiros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerfilFinanceiro {
    @Id
    @Column(name = "id_perfil_financeiro", nullable = false, unique = true)
    private String idPerfilFinanceiro;
    @Column(name = "nome_perfil_financeiro", nullable = false)
    private String nomePerfilFinanceiro;
    @Column(name = "descricao_perfil_financeiro", nullable = false)
    private String descricaoPerfilFinanceiro;
}
