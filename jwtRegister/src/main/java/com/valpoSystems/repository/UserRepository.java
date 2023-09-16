package com.valpoSystems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.valpoSystems.domain.models.UserModel;
import com.valpoSystems.domain.response.UserResponse;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
	Optional<UserResponse> findUserEntityByEmail(String email);

}
