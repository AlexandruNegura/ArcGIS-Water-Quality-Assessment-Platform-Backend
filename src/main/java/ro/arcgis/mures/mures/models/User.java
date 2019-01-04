package ro.arcgis.mures.mures.models;

import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "ArcgisUser")
public class User extends Id {
    @NotEmpty
    @Column(unique = true)
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String phone;

    @NotEmpty
    private String mail;

    private String avatar;

    private Boolean alerts;

    public User() {
    }

    public User(String username, String password, String phone, String mail, String avatar, Boolean alerts) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.mail = mail;
        this.avatar = avatar;
        this.alerts = alerts;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getAlerts() {
        return alerts;
    }

    public void setAlerts(Boolean alerts) {
        this.alerts = alerts;
    }
}
