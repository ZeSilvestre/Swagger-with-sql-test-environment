package br.com.estudos.ambienteteste.service;

import br.com.estudos.ambienteteste.domain.entity.Funcionario;
import br.com.estudos.ambienteteste.mapper.FuncionarioMapper;
import br.com.estudos.ambienteteste.models.FuncionarioVO;
import br.com.estudos.ambienteteste.repository.FuncionarioRepository;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioMapper funcionarioMapper;

  public FuncionarioService( FuncionarioRepository funcionarioRepository, FuncionarioMapper funcionarioMapper) {
    this.funcionarioRepository = funcionarioRepository;
    this.funcionarioMapper = funcionarioMapper;
  }

  public Funcionario save(FuncionarioVO vo){
    Funcionario funcionario = new Funcionario();

    funcionario.setNome(vo.nome());
    funcionario.setFuncao(vo.funcao());

    return funcionarioRepository.save(funcionario);
  }



}
