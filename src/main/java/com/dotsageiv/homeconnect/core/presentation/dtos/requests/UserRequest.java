package com.dotsageiv.homeconnect.core.presentation.dtos.requests;

public record UserRequest(String cpf, String fullName,
                          String username, String password) {}