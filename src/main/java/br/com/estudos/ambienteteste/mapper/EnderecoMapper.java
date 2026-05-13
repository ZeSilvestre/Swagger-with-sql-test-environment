package br.com.estudos.ambienteteste.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.estudos.ambienteteste.domain.entity.Endereco;
import br.com.estudos.ambienteteste.models.EnderecoModels.EnderecoRequest;
import br.com.estudos.ambienteteste.models.EnderecoModels.EnderecoResponse;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "dataCadastro", ignore = true)
  @Mapping(target = "dataModificacao", ignore = true)
  Endereco toEntity(EnderecoRequest request);

  EnderecoResponse toResponse(Endereco entity);
}
