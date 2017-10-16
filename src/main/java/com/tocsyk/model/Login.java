package com.tocsyk.model;

import javax.persistence.*;

@Entity
@Table(name = "hLogin")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int ID;
    @Column(name="LoginName")
    private String LoginName;
    @Column(name="PassWord")
    private String passWord;
    @Column(name="Enabled")
    private boolean enabled;
    @Column(name="Email")
    private String email;
    @Column(name="Role")
    private int roleID;

    public Login() {
    }

    public Login(String LoginName, String passWord, boolean enabled, String email, int role) {
        this.LoginName = LoginName;
        this.passWord = passWord;
        this.enabled = enabled;
        this.email = email;
        this.roleID = roleID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLoginName() {
        return LoginName;
    }

    public void setLoginName(String LoginName) {
        this.LoginName = LoginName;
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

    public int getRole() {
        return roleID;
    }

    public void setRole(int role) {
        this.roleID = role;
    }

    @Override
    public String toString() {
        return "Login{" +
                "ID=" + ID +
                ", LoginName='" + LoginName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", enabled=" + enabled +
                ", email='" + email + '\'' +
                ", role=" + roleID +
                '}';
    }
}
