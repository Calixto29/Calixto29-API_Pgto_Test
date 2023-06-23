package br.com.FADESP.pagamentoFadesp.repository;

import br.com.FADESP.pagamentoFadesp.entity.Pagamento;
import br.com.FADESP.pagamentoFadesp.entity.StatusPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long > {

    List<Pagamento> findAllByCodigoDebito(Integer codigoDebito);

    List<Pagamento> findAllByCpfCnpjPagador(String cpfCnpjPagador);

    List<Pagamento> findAllByStatus(StatusPagamento status);
}