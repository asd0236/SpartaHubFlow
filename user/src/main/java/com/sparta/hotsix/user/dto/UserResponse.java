package com.sparta.hotsix.user.dto;

import com.sparta.hotsix.user.domain.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;

    private String username;

    private String nickname;

    private String email;

    private String role;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String updatedBy;

    private LocalDateTime deletedAt;

    private String deletedBy;

    private Boolean isDeleted;

    public UserResponse(String username, String nickname, String email, String role, boolean deleted, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, String deletedBy) {

        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.role = role;
        this.isDeleted = deleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.deletedBy = deletedBy;
    }
}
