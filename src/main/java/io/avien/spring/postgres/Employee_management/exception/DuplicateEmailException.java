package io.avien.spring.postgres.Employee_management.exception;

/**
 * Thrown when attempting to create a user with an email that already exists.
 */
public class DuplicateEmailException extends RuntimeException {

    public DuplicateEmailException(String email) {
        super("A user with email '" + email + "' already exists");
    }
}
