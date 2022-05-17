package dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class PagamentoDTO implements Serializable {

    private String codigoBarras;
    private BigDecimal valor;
    private String descricao;
    private String numeroConta;

    public PagamentoDTO(){}

    public PagamentoDTO(String codigoBarras, BigDecimal valor, String descricao, String numeroConta) {
        this.codigoBarras = codigoBarras;
        this.valor = valor;
        this.descricao = descricao;
        this.numeroConta = numeroConta;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNumeroConta() {
        return numeroConta;
    }
}
