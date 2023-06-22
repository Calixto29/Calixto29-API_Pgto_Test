package br.com.FADESP.pagamentoFadesp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("br.com.FADESP.pagamentoFadesp")
public class PagamentoFadespApplication {

	public static void main(String[] args) {
		SpringApplication.run(PagamentoFadespApplication.class, args);
	}

}
