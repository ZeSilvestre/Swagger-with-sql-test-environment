package br.com.estudos.ambienteteste.domain.entity;

import br.com.estudos.ambienteteste.domain.enums.FuncaoProfissionalEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;

@Entity     
@Data 
@Table (name = "funcionarios")
public class Funcionario extends EntidadeBase {

    private String nome;

    @Column (length = 50)
    @Enumerated (EnumType.STRING)
    private FuncaoProfissionalEnum funcao;
}