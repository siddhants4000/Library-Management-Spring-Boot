package com.example.demo.enums;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.demo.enums.UserPermission.*;

public enum UserRole {
    STUDENT(Sets.newHashSet(BOOK_READ)),
    ADMIN(Sets.newHashSet(STUDENT_WRITE, STUDENT_READ, BOOK_READ,BOOK_WRITE));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }
}
