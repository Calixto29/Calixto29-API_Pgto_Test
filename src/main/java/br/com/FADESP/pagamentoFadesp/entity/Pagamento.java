package br.com.FADESP.pagamentoFadesp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Pagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "codigo_debito", nullable = false)
    private Integer codigoDebito;

    @Column(name = "cpf_cnpj_pagador", nullable = false)
    private String cpfCnpjPagador;

    @Column(name = "numero_cartao", nullable = false)
    private String numeroCartao;

    @Column(name = "valor", nullable = false)
    private Double valor;

}


