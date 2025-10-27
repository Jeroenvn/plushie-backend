package dev.jeroen.plushie_backend.dtos;

public class AuthDTO {

    private Long userId;
    private String token;
    private String expiresIn;

    public AuthDTO(Long userId, String token, String expiresIn) {
        this.userId = userId;
        this.token = token;
        this.expiresIn = expiresIn;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long user_id) {
        this.userId = user_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

}
