package br.com.FADESP.pagamentoFadesp.http.controller;

import br.com.FADESP.pagamentoFadesp.entity.Pagamento;
import br.com.FADESP.pagamentoFadesp.service.PagamentoService;
import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pagamento salvar(@RequestBody Pagamento pagamento){
        return pagamentoService.salvar(pagamento);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pagamento> listaPagamento(){
        return pagamentoService.listaPagamento();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pagamento buscarPagamentoPorID(Long id){
        return pagamentoService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrado."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPagamento(Long id){
        pagamentoService.buscarPorId(id)
                .map(pagamento -> {
                    pagamentoService.remoderPorId(pagamento.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrado."));
    }

}



