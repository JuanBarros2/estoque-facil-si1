package com.ufcg.si1.repository;

import com.ufcg.si1.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    Usuario findFirstByEmail(String email);

}
