package br.com.estudos.ambienteteste.domain.enums;
import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.Getter;

@Getter 
public enum FuncaoProfissionalEnum {
    CAIXA(0, "Caixa"),
    VENDEDOR(1, "Vendedor(a)"),
    GERENTE(2, "Gerente"),
    ESTOQUE(3, "Estoque"),
    ;
    
    private final Integer codigo;
    private final String descricao;
  
    FuncaoProfissionalEnum(int codigo, String descricao) {
      this.codigo = codigo;
      this.descricao = descricao;
    }
  
    public static FuncaoProfissionalEnum ofCodigo(Integer codigo) {
      return Arrays.stream(FuncaoProfissionalEnum.values())
          .filter(e -> e.getCodigo().equals(codigo))
          .findFirst()
          .orElseThrow(
              () ->
                  new ResponseStatusException(
                      HttpStatus.BAD_REQUEST, "Estado civil informado é inválido."));
    }  
}
