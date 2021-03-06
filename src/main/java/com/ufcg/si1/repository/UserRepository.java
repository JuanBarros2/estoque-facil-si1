package com.ufcg.si1.repository;

import com.ufcg.si1.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findFirstByEmail(String email);

}
