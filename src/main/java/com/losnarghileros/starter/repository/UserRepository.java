package com.losnarghileros.starter.repository;

import com.losnarghileros.starter.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "User", path = "user")
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
