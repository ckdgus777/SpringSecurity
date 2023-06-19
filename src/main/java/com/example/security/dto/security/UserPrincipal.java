package com.example.security.dto.security;

import com.example.security.dto.UserAccountDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

public record UserPrincipal(
        String userId,
        String userPassword,
        String roles,
        String userName,
        String email,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt
) implements UserDetails {

    public static UserPrincipal of (String userId,
                                    String userPassword,
                                    String roles,
                                    String userName,
                                    String email,
                                    LocalDateTime createdAt,
                                    LocalDateTime modifiedAt
    ) {
        return new UserPrincipal(
                userId,
                userPassword,
                roles,
                userName,
                email,
                createdAt,
                modifiedAt
        );
    }

    public static UserPrincipal from (UserAccountDto dto) {
        return UserPrincipal.of(
                dto.userId(),
                dto.userPassword(),
                dto.roles(),
                dto.userName(),
                dto.email(),
                dto.createdAt(),
                dto.modifiedAt()
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(roles.split(","))
                .map(SimpleGrantedAuthority::new)
                .toList();
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
