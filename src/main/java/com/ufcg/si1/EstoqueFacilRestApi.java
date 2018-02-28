package com.ufcg.si1;

import com.ufcg.si1.model.Papel;
import com.ufcg.si1.model.Produto;
import com.ufcg.si1.model.ProdutoLote;
import com.ufcg.si1.model.Usuario;
import com.ufcg.si1.repository.CategoriaRepository;
import com.ufcg.si1.repository.ProdutoLoteRepository;
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
	CommandLineRunner init(UsuarioRepository usuarioRepository,
						   BCryptPasswordEncoder crypt,
						   ProdutoLoteRepository produtoLoteRepository) {
		return (evt) -> {
							Usuario usuario = new Usuario();
							usuario.setEmail("admin@admin.com");
							usuario.setSenha(crypt.encode("admin"));
							Papel papel = new Papel();
							papel.setNome(ADM);
							usuario.setPapeis(Arrays.asList(papel));
							usuarioRepository.save(usuario);

							ArrayList<ProdutoLote> produtoLotes = new ArrayList<>();
							produtoLotes.add(new ProdutoLote(new Produto("Leite Integral", 2.99, "87654321-B", "Parmalat", "Mercearia")));
							produtoLotes.add(new ProdutoLote(new Produto("Arroz Integral", 3.80, "87654322-B", "Tio Joao", "Perecíveis")));
							produtoLotes.add(new ProdutoLote(new Produto("Sabao em Po", 7.99, "87654323-B", "OMO", "Limpeza")));
							produtoLotes.add(new ProdutoLote(new Produto( "Agua Sanitaria", 3D, "87654324-C", "Dragao", "limpesa")));
							produtoLotes.add(new ProdutoLote(new Produto("Creme Dental", 2.99, "87654325-C", "Colgate", "HIGIENE")));

							for(ProdutoLote produto: produtoLotes){
								produtoLoteRepository.save(produto);
							}
		};
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
