package br.com.FADESP.pagamentoFadesp.service;

import br.com.FADESP.pagamentoFadesp.entity.Pagamento;
import br.com.FADESP.pagamentoFadesp.repository.PagamentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        return modelMapper;
    }

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento salvar(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }
    public List<Pagamento> listaPagamento() {
        return pagamentoRepository.findAll();
    }
    public Optional<Pagamento> buscarPorId(Long id){
        return pagamentoRepository.findById(id);
    }

    public void removerPorId(Long id){
        pagamentoRepository.deleteById(id);
    }

}