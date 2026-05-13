package br.com.estudos.ambienteteste.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

public final class EnderecoModels {

  private EnderecoModels() {}

  @Schema(name = "EnderecoResponse", description = "Dados do endereço.")
  public record EnderecoResponse(
      @Schema(description = "Identificador interno.") Long id,
      @Schema(description = "Logradouro.") String logradouro,
      @Schema(description = "Número.") String numero,
      @Schema(description = "Complemento.") String complemento,
      @Schema(description = "Bairro.") String bairro,
      @Schema(description = "Cidade.") String cidade,
      @Schema(description = "Estado.") String estado,
      @Schema(description = "CEP.") String cep) {}

  @Schema(name = "EnderecoRequest", description = "Dados para criação ou atualização do endereço.")
  public record EnderecoRequest(
      @NotBlank @Size(max = 100) @Schema(description = "Logradouro.") String logradouro,
      @Size(max = 10) @Schema(description = "Número.") String numero,
      @Size(max = 100) @Schema(description = "Complemento.") String complemento,
      @Size(max = 100) @Schema(description = "Bairro.") String bairro,
      @Size(max = 100) @Schema(description = "Cidade.") String cidade,
      @Size(max = 20) @Schema(description = "Estado.") String estado,
      @NotBlank @Size(max = 20) @Schema(description = "CEP.") String cep) {}
}
