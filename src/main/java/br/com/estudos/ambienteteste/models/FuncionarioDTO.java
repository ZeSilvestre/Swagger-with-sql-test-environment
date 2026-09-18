package br.com.estudos.ambienteteste.models;

import br.com.estudos.ambienteteste.domain.enums.FuncaoProfissionalEnum;

public record FuncionarioDTO(
    String nome,
    FuncaoProfissionalEnum funcao
) {

}
