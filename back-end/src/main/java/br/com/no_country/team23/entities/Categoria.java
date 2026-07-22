package br.com.no_country.team23.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "categorias")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
    @Id
    @Column(name = "id_categoria", nullable = false, unique = true)
    private UUID idCategoria;
    @Column(name = "nome_categoria", nullable = false)
    private String nomeCategoria;
}
