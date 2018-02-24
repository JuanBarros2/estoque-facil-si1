package com.ufcg.si1;

import com.ufcg.si1.model.Papel;
import com.ufcg.si1.model.Usuario;
import com.ufcg.si1.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
	CommandLineRunner init(UsuarioRepository usuarioRepository, BCryptPasswordEncoder crypt) {
		return (evt) -> {
							Usuario usuario = new Usuario();
							usuario.setEmail("admin");
							usuario.setSenha(crypt.encode("admin"));
							Papel papel = new Papel();
							papel.setNome(ADM);
							usuario.setPapeis(Arrays.asList(papel));
							usuarioRepository.save(usuario);
        };
	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
