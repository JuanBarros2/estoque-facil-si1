package com.ufcg.si1;

import com.ufcg.si1.model.Role;
import com.ufcg.si1.model.Product;
import com.ufcg.si1.model.ProductLot;
import com.ufcg.si1.model.User;
import com.ufcg.si1.repository.ProductLotRepository;
import com.ufcg.si1.repository.UserRepository;
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

import static com.ufcg.si1.model.Role.Module.ADM;


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
	CommandLineRunner init(UserRepository usuarioRepository,
						   BCryptPasswordEncoder crypt,
						   ProductLotRepository productLotRepository) {
		return (evt) -> {
							User user = new User();
							user.setEmail("admin@admin.com");
							user.setPassword(crypt.encode("admin"));
							Role role = new Role();
							role.setNome(ADM);
							user.setRoles(Arrays.asList(role));
							usuarioRepository.save(user);

							ArrayList<ProductLot> productLots = new ArrayList<>();
							productLots.add(new ProductLot(new Product("Leite Integral", 2.99, "87654321-B", "Parmalat", "Mercearia")));
							productLots.add(new ProductLot(new Product("Arroz Integral", 3.80, "87654322-B", "Tio Joao", "Perecíveis")));
							productLots.add(new ProductLot(new Product("Sabao em Po", 7.99, "87654323-B", "OMO", "Limpeza")));
							productLots.add(new ProductLot(new Product( "Agua Sanitaria", 3D, "87654324-C", "Dragao", "limpesa")));
							productLots.add(new ProductLot(new Product("Creme Dental", 2.99, "87654325-C", "Colgate", "HIGIENE")));

							for(ProductLot produto: productLots){
								productLotRepository.save(produto);
							}
		};
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
