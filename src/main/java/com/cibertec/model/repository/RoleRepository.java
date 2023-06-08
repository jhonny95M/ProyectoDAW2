package com.cibertec.model.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cibertec.model.Role;

@Repository
//@EnableJpaRepositories
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
	/*
	 * @Query(value =
	 * "SELECT rl.id,rl.name FROM roles rl JOIN user_roles u on rl.id= u.role_id WHERE u.user_id = :user_id"
	 * ) Set<Role> findByIdUser(@Param("user_id")Long id);
	 */
    @Query("SELECT r FROM Role r JOIN r.users u WHERE u.id = :user_id")
    Set<Role> findByIdUser(@Param("user_id") Long id);
}