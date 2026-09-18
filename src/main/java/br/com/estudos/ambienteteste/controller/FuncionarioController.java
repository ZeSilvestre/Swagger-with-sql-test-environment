package br.com.estudos.ambienteteste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.estudos.ambienteteste.mapper.ClienteMapper;
import br.com.estudos.ambienteteste.models.ClienteModels;
import br.com.estudos.ambienteteste.models.FuncionarioVO;
import br.com.estudos.ambienteteste.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import br.com.estudos.ambienteteste.mapper.FuncionarioMapper;
import br.com.estudos.ambienteteste.service.FuncionarioService;

@RestController
@RequestMapping("/api/v1/funcionarios")
@Tag(name = "Funcionarios", description = "Endpoints para gerenciar funcionarios")
@Validated
public class FuncionarioController {

    private final FuncionarioService funcionarioService;
    private final FuncionarioMapper funcionarioMapper;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService, FuncionarioMapper funcionarioMapper) {
        this.funcionarioService = funcionarioService;
        this.funcionarioMapper = funcionarioMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Salva um funcionário", responses = @ApiResponse(responseCode = "201", description = "Funcionario salvo com sucesso!", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ClienteModels.ClienteResponse.class))))
    public FuncionarioVO save(
            @RequestBody @Valid() final FuncionarioVO vo) {
        return funcionarioMapper.toVO(funcionarioService.save(vo));
    }

}
