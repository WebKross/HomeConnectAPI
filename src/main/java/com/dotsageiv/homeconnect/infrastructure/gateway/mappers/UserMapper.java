package com.dotsageiv.homeconnect.infrastructure.gateway.mappers;

import java.util.HashSet;
import java.util.UUID;

import com.dotsageiv.homeconnect.core.domain.entities.User;
import com.dotsageiv.homeconnect.infrastructure.persistence.entities.UserEntity;

public class UserMapper {
    public User toDomainObj(UserEntity entity) {
        return User.builder()
                .cpf(entity.getCpf())
                .fullName(entity.getFullName())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .build();
    }

    public UserEntity toEntity(User domainObj) {
        return UserEntity.builder()
                .cpf(domainObj.cpf())
                .fullName(domainObj.fullName())
                .username(domainObj.username())
                .password(domainObj.password())
                .contacts(new HashSet<>())
                .addresses(new HashSet<>())
                .build();
    }

    public UserEntity toEntity(UUID userId, User domainObj) {
        return UserEntity.builder()
                .id(userId)
                .cpf(domainObj.cpf())
                .fullName(domainObj.fullName())
                .username(domainObj.username())
                .password(domainObj.password())
                .contacts(new HashSet<>())
                .addresses(new HashSet<>())
                .build();
    }
}