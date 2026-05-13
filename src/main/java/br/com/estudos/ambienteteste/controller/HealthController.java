package br.com.estudos.ambienteteste.controller;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudos.ambienteteste.exception.ErrorResponse;
import br.com.estudos.ambienteteste.models.HealthResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/${api.version}/health")
@Tag(name = "Health", description = "Endpoint de diagnostico da aplicacao")
public class HealthController {

  @GetMapping
  @Operation(summary = "Verifica se a API esta em execucao")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "API em execucao"),
        @ApiResponse(
            responseCode = "500",
            description = "Erro interno inesperado",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
      })
  public ResponseEntity<HealthResponse> check() {
    return ResponseEntity.ok(new HealthResponse("UP", Instant.now()));
  }
}
