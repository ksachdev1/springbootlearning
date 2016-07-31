package com.ks.repository;

import com.ks.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kasachde on 7/21/2016.
 */
public interface UserRepository extends CrudRepository<User, Long>{
    public User findByUsername(String username);
}
