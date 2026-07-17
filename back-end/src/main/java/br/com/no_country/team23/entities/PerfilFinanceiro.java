package br.com.no_country.team23.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "perfis_financeiros")
public class PerfilFinanceiro {
    @Id
    @Column(name = "id_perfil_financeiro", nullable = false, unique = true)
    private String idPerfilFinanceiro;
    @Column(name = "nome_perfil_financeiro", nullable = false)
    private String nomePerfilFinanceiro;
    @Column(name = "descricao_perfil_financeiro", nullable = false)
    private String descricaoPerfilFinanceiro;

    public PerfilFinanceiro() {
    }

    public PerfilFinanceiro(String idPerfilFinanceiro, String nomePerfilFinanceiro, String descricaoPerfilFinanceiro) {
        this.idPerfilFinanceiro = idPerfilFinanceiro;
        this.nomePerfilFinanceiro = nomePerfilFinanceiro;
        this.descricaoPerfilFinanceiro = descricaoPerfilFinanceiro;
    }

    public String getIdPerfilFinanceiro() {
        return idPerfilFinanceiro;
    }

    public void setIdPerfilFinanceiro(String idPerfilFinanceiro) {
        this.idPerfilFinanceiro = idPerfilFinanceiro;
    }

    public String getNomePerfilFinanceiro() {
        return nomePerfilFinanceiro;
    }

    public void setNomePerfilFinanceiro(String nomePerfilFinanceiro) {
        this.nomePerfilFinanceiro = nomePerfilFinanceiro;
    }

    public String getDescricaoPerfilFinanceiro() {
        return descricaoPerfilFinanceiro;
    }

    public void setDescricaoPerfilFinanceiro(String descricaoPerfilFinanceiro) {
        this.descricaoPerfilFinanceiro = descricaoPerfilFinanceiro;
    }
}
