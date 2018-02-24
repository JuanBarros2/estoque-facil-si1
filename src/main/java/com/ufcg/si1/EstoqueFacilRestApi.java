package com.ufcg.si1;

import com.ufcg.si1.model.Papel;
import com.ufcg.si1.model.Produto;
import com.ufcg.si1.model.Usuario;
import com.ufcg.si1.repository.ProdutoRepository;
import com.ufcg.si1.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static com.ufcg.si1.model.Papel.Modulo.ADM;


@SpringBootApplication(scanBasePackages={"com.ufcg.si1"})// same as @Configuration @EnableAutoConfiguration @ComponentScan combined
public class EstoqueFacilRestApi {

	public static void main(String[] args) {
		SpringApplication.run(EstoqueFacilRestApi.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
			}
		};
	}

	@Bean
	CommandLineRunner init(UsuarioRepository usuarioRepository, BCryptPasswordEncoder crypt, ProdutoRepository produtoRepository) {
		return (evt) -> {
							Usuario usuario = new Usuario();
							usuario.setEmail("admin");
							usuario.setSenha(crypt.encode("admin"));
							Papel papel = new Papel();
							papel.setNome(ADM);
							usuario.setPapeis(Arrays.asList(papel));
							usuarioRepository.save(usuario);

							AtomicLong counter = new AtomicLong();
							produtoRepository.save(new Produto(counter.incrementAndGet(), "Leite Integral", "87654321-B", "Parmalat", "Mercearia"));
							produtoRepository.save(new Produto(counter.incrementAndGet(), "Arroz Integral", "87654322-B", "Tio Joao", "Perecíveis"));
							produtoRepository.save(new Produto(counter.incrementAndGet(), "Sabao em Po", "87654323-B", "OMO", "Limpeza"));
							produtoRepository.save(new Produto(counter.incrementAndGet(), "Agua Sanitaria", "87654324-C", "Dragao", "limpesa"));
							produtoRepository.save(new Produto(counter.incrementAndGet(), "Creme Dental", "87654325-C", "Colgate", "HIGIENE"));

		};
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
