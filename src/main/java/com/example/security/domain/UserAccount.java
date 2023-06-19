package com.example.security.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.Objects;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "userId", unique = true),
        @Index(columnList = "createdAt")
})
@Entity
public class UserAccount extends AuditingFields {

    @Id
    @Column(length = 50)
    private String userId;

    @Setter @Column(nullable = false) private String userPassword;
    @Setter @Column(nullable = false) private String roles;

    @Setter @Column(length = 100) private String email;
    @Setter @Column(length = 100) private String userName;
    @Setter private String memo;

    protected UserAccount() { }

    public UserAccount(String userId, String userPassword, String roles, String email, String userName, String memo) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.roles = roles;
        this.email = email;
        this.userName = userName;
        this.memo = memo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAccount that)) return false;
        return this.getUserId() != null && this.getUserId().equals(that.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getUserId());
    }
}
