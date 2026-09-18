package br.com.estudos.ambienteteste.models;

import java.io.Serializable;

import br.com.estudos.ambienteteste.domain.enums.FuncaoProfissionalEnum;
import jakarta.validation.constraints.NotBlank;

public record FuncionarioVO(
    @NotBlank
    String nome,
    FuncaoProfissionalEnum funcao

)implements Serializable {

}
