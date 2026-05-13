package br.com.estudos.ambienteteste.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente extends EntidadeBase {

  @Column(nullable = false, length = 100)
  private String nome;

  @Column(unique = true, nullable = false, length = 11)
  private String cpf;

  @Column(nullable = false, length = 100)
  private String email;

  @Column(nullable = false, length = 15)
  private String telefone;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  @JoinColumn(name = "endereco_id")
  private Endereco endereco;
}
