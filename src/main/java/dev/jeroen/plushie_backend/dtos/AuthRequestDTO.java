package dev.jeroen.plushie_backend.dtos;

import dev.jeroen.plushie_backend.exceptions.MissingRequiredVariableException;

public class AuthRequestDTO {

    private String username;
    private String password;

    public AuthRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void validate() {
        if (username.isEmpty()) {
            throw new MissingRequiredVariableException("Name is required");
        }
        if (password.isEmpty()) {
            throw new MissingRequiredVariableException("Password is required");
        }
    }

}
