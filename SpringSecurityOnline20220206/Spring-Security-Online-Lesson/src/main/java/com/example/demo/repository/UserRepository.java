package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

	Optional<UserEntity> findByUsername(String username);


}
