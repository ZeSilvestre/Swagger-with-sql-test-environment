package br.com.estudos.ambienteteste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudos.ambienteteste.domain.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
