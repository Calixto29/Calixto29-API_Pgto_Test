package br.com.FADESP.pagamentoFadesp.http.controller;

import br.com.FADESP.pagamentoFadesp.entity.Pagamento;
import br.com.FADESP.pagamentoFadesp.entity.StatusPagamento;

import br.com.FADESP.pagamentoFadesp.service.PagamentoService;

import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pagamento salvar(@RequestBody Pagamento pagamento) {
        return pagamentoService.salvar(pagamento);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pagamento> listaPagamento() {
        return pagamentoService.listaPagamento();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pagamento buscarPagamentoPorID(@PathVariable("id") Long id) {
        return pagamentoService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrado."));
    }

    @GetMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public List<Pagamento> buscarPagamentoPorCPF(@PathVariable("cpf") String cpfClient) {
        return pagamentoService.buscarPorCpf(cpfClient);

    }

    @GetMapping("/status/{staus}")
    @ResponseStatus(HttpStatus.OK)
    public List<Pagamento> buscarPagamentoPorStatus(@PathVariable("status") StatusPagamento status) {
        return pagamentoService.buscarPorStatus(status);

    }

    @GetMapping("/codigo/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public List<Pagamento> buscarPagamentoPorCodigo(@PathVariable("codigo") Integer codigo) {
        return pagamentoService.buscarPorCodigoDebito(codigo);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removerPagamento(@PathVariable("id") Long id) {
        pagamentoService.buscarPorId(id)
                .map(pagamento -> {
                    pagamentoService.removerPorId(pagamento.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrado."));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarPagamento(@PathVariable("id") Long id, @RequestBody Pagamento novoPagamento) {

        pagamentoService.buscarPorId(id)
                .map(pagamentoSalvo -> {

                    if (pagamentoSalvo.getStatus() == StatusPagamento.PROCESSADO_SUCESSO) {
                        System.out.println("PAGAMENTO NAO PODE SER ALTERADO!");

                        return Void.TYPE;

                    } else {

                        if (pagamentoSalvo.getStatus() == StatusPagamento.PENDENTE_PROCESSAMENTO) {
                            modelMapper.map(novoPagamento, pagamentoSalvo);
                            return pagamentoService.salvar(novoPagamento);
                        } else {

                            if (pagamentoSalvo.getStatus() == StatusPagamento.PROCESSADO_FALHA
                                    && novoPagamento.getStatus() == StatusPagamento.PENDENTE_PROCESSAMENTO) {
                                modelMapper.map(novoPagamento, pagamentoSalvo);
                                return pagamentoService.salvar(novoPagamento);
                            } else {
                                System.out.println("PAGAMENTO ESTAVA FALHA, NAO PODE SER ALTERADO PARA SUCESSO!");
                                return Void.TYPE;
                            }

                        }

                    }

                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrado."));
    }

}
