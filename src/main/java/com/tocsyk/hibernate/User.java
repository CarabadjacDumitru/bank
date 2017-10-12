package com.tocsyk.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "hUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int ID;
    @Column(name="UserName")
    private String userName;
    @Column(name="PassWord")
    private String passWord;
    @Column(name="Enabled")
    private boolean enabled;
    @Column(name="Email")
    private String email;
    @Column(name="Role")
    private Role role;

    public User() {
    }

    public User(String userName, String passWord, boolean enabled, String email, Role role) {
        this.userName = userName;
        this.passWord = passWord;
        this.enabled = enabled;
        this.email = email;
        this.role = role;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", enabled=" + enabled +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
