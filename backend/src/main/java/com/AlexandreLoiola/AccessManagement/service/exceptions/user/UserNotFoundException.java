package com.AlexandreLoiola.AccessManagement.service.exceptions.user;

import jakarta.persistence.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String msg) { super(msg); }

    public UserNotFoundException(String msg, Throwable cause) {
        super(msg);
        this.initCause(cause);
    }
}
