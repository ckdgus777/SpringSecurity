package com.example.security.dto;

import com.example.security.domain.UserAccount;

import java.time.LocalDateTime;

public record UserAccountDto(
        String userId,
        String userPassword,
        String roles,
        String userName,
        String email,
        String memo,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt,
        Long popularity,
        Long unpopularity
) {

    public static UserAccountDto from(UserAccount entity) {
        return new UserAccountDto(
                entity.getUserId(),
                entity.getUserPassword(),
                entity.getRoles(),
                entity.getUserName(),
                entity.getEmail(),
                entity.getMemo(),
                entity.getCreatedAt(),
                entity.getModifiedAt(),
                entity.getPopularity(),
                entity.getUnpopularity()
        );
    }

}
