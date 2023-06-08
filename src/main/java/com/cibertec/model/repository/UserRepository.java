package com.cibertec.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cibertec.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    @Query(value = "SELECT u.id,u.username,u.password FROM users u WHERE u.username = :username",nativeQuery = true)
    User findByUsernameWithRoles(@Param("username") String username);
    boolean existsByUsername(String username);
}