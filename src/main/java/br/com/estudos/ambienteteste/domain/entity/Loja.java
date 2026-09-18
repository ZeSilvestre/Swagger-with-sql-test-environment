package br.com.estudos.ambienteteste.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity 
@Table (name = "loja")
public class Loja extends EntidadeBase {

    private String nome;

}