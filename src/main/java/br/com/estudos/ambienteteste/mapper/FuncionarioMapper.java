package br.com.estudos.ambienteteste.mapper;

import org.mapstruct.Mapper;

import br.com.estudos.ambienteteste.domain.entity.Funcionario;
import br.com.estudos.ambienteteste.models.FuncionarioVO;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {

    FuncionarioVO toVO(Funcionario funcionario);
}