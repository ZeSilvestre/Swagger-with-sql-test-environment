package br.com.estudos.ambienteteste.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.estudos.ambienteteste.domain.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE c.cpf = :cpf")
    Optional<Cliente> findByCpf(@Param("cpf") String cpf);

    boolean existsByCpf(String cpf);
}
