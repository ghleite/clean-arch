package com.ada.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryPersistence extends JpaRepository<UserEntity, Long> {
}
