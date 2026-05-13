package br.com.estudos.ambienteteste.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "endereco")
public class Endereco extends EntidadeBase {

  @Column(length = 100)
  private String logradouro;

  @Column(length = 10)
  private String numero;

  @Column(length = 100)
  private String complemento;

  @Column(length = 100)
  private String bairro;

  @Column(length = 100)
  private String cidade;

  @Column(length = 20)
  private String estado;

  @Column(nullable = false, length = 20)
  private String cep;
}
