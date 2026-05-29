package br.com.estudos.ambienteteste.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudos.ambienteteste.mapper.ClienteMapper;
import br.com.estudos.ambienteteste.models.ClienteModels;
import br.com.estudos.ambienteteste.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/clientes")
@Tag(name = "Clientes", description = "Endpoints para gerenciar clientes")
@Validated
public class ClienteController {

  private final ClienteService clienteService;
  private final ClienteMapper clienteMapper;

  @Autowired
  public ClienteController(ClienteService clienteService, ClienteMapper clienteMapper) {
    this.clienteService = clienteService;
    this.clienteMapper = clienteMapper;
  }

  // CRUD completo para cliente

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = "Salva um cliente",
      responses =
          @ApiResponse(
              responseCode = "201",
              description = "Cliente salvo com sucesso!",
              content =
                  @Content(
                      mediaType = MediaType.APPLICATION_JSON_VALUE,
                      schema = @Schema(implementation = ClienteModels.ClienteResponse.class))))
  public ClienteModels.ClienteResponse save(
      @RequestBody @Valid() final ClienteModels.ClienteRequest request) {
    return clienteMapper.toResponse(clienteService.save(request));
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @Operation(
      summary = "Atualiza um cliente",
      responses =
          @ApiResponse(
              responseCode = "200",
              description = "Cliente atualizado com sucesso!",
              content =
                  @Content(
                      mediaType = MediaType.APPLICATION_JSON_VALUE,
                      schema = @Schema(implementation = ClienteModels.ClienteResponse.class))))
  public ClienteModels.ClienteResponse update(
      @PathVariable Long id, @RequestBody @Valid() final ClienteModels.ClienteRequest request) {
    return clienteMapper.toResponse(clienteService.update(id, request));
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(
      summary = "Deleta um cliente",
      responses = @ApiResponse(responseCode = "204", description = "Cliente deletado com sucesso!"))
  public void delete(@PathVariable Long id) {
    clienteService.delete(id);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @Operation(
      summary = "Busca um cliente por ID",
      responses =
          @ApiResponse(
              responseCode = "200",
              description = "Cliente encontrado com sucesso!",
              content =
                  @Content(
                      mediaType = MediaType.APPLICATION_JSON_VALUE,
                      schema = @Schema(implementation = ClienteModels.ClienteResponse.class))))
  public ClienteModels.ClienteResponse findById(@PathVariable Long id) {
    return clienteMapper.toResponse(clienteService.findById(id));
  }
}
