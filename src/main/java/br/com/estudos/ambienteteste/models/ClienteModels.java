package br.com.estudos.ambienteteste.models;

import java.time.LocalDateTime;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import br.com.estudos.ambienteteste.models.EnderecoModels.EnderecoRequest;
import br.com.estudos.ambienteteste.models.EnderecoModels.EnderecoResponse;

import io.swagger.v3.oas.annotations.media.Schema;

public final class ClienteModels {

  private ClienteModels() {}

  @Schema(name = "ClienteResponse", description = "Dados do cliente.")
  public record ClienteResponse(
      @Schema(description = "Identificador interno.") Long id,
      @Schema(description = "Data de cadastro.") LocalDateTime dataCadastro,
      @Schema(description = "Data de modificação.") LocalDateTime dataModificacao,
      @Schema(description = "Nome do cliente.") String nome,
      @Schema(description = "CPF do cliente.") String cpf,
      @Schema(description = "E-mail do cliente.") String email,
      @Schema(description = "Telefone do cliente.") String telefone,
      @Schema(description = "Endereço do cliente.") EnderecoResponse endereco) {}

  @Schema(name = "ClienteRequest", description = "Dados para criação ou atualização do cliente.")
  public record ClienteRequest(
      @Size(max = 100) @NotBlank(message = "O nome do cliente é obrigatório.") @Schema(description = "Nome do cliente.")
          String nome,
      @Size(max = 11) @NotBlank(message = "O CPF do cliente é obrigatório.") @Schema(description = "CPF do cliente.")
          String cpf,
      @Email @NotBlank(message = "O e-mail do cliente é obrigatório.") @Size(max = 100) @Schema(description = "E-mail do cliente.")
          String email,
      @Size(max = 15) @NotBlank(message = "O telefone do cliente é obrigatório.") @Schema(description = "Telefone do cliente.")
          String telefone,
      @Valid @Schema(description = "Endereço do cliente.") EnderecoRequest endereco) {}
}
