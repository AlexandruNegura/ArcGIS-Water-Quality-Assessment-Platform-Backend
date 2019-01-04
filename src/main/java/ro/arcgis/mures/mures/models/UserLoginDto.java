package ro.arcgis.mures.mures.models;

import javax.validation.constraints.NotEmpty;

public class UserLoginDto {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;

    public UserLoginDto() {
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
}
