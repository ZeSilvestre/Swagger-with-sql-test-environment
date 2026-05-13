package br.com.estudos.ambienteteste.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.estudos.ambienteteste.domain.entity.Cliente;
import br.com.estudos.ambienteteste.models.ClienteModels.ClienteRequest;
import br.com.estudos.ambienteteste.models.ClienteModels.ClienteResponse;

@Mapper(componentModel = "spring", uses = EnderecoMapper.class)
public interface ClienteMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "dataCadastro", ignore = true)
  @Mapping(target = "dataModificacao", ignore = true)
  Cliente toEntity(ClienteRequest request);

  ClienteResponse toResponse(Cliente entity);
}
