package br.com.estudos.ambienteteste.service;

import org.springframework.stereotype.Service;

import br.com.estudos.ambienteteste.domain.entity.Cliente;
import br.com.estudos.ambienteteste.exception.BusinessException;
import br.com.estudos.ambienteteste.exception.ResourceNotFoundException;
import br.com.estudos.ambienteteste.mapper.ClienteMapper;
import br.com.estudos.ambienteteste.models.ClienteModels.ClienteRequest;
import br.com.estudos.ambienteteste.repository.ClienteRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClienteService {

  private final ClienteRepository clienteRepository;
  private final ClienteMapper clienteMapper;

  public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
    this.clienteRepository = clienteRepository;
    this.clienteMapper = clienteMapper;
  }

  public Cliente save(ClienteRequest request) {
    if (clienteRepository.existsByCpf(request.cpf())) {
      throw new BusinessException("Cliente já cadastrado");
      /*
      Poderia ser usado o ReponseStatus(HttpStatus.BAD_REQUEST, "CPF já cadastrado") para retornar o erro 400 BAD REQUEST coma mensagem
       */
    }
    return clienteRepository.save(clienteMapper.toEntity(request));
  }

  public Cliente findByCpf(String cpf) {
    return clienteRepository
        .findByCpf(cpf)
        .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
  }
}
