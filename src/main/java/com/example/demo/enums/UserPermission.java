package com.example.demo.enums;

public enum UserPermission {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    BOOK_READ("book:read"),
    BOOK_WRITE("book:write");

    private final String permission;

    UserPermission(String permission){
        this.permission=permission;
    }

    public String getPermission() {
        return permission;
    }
}
