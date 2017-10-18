package com.tocsyk.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "hLogin")
public class Login implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    @Column(name="LoginName")
    private String loginName;
    @Column(name="PassWord")
    private String passWord;
    @Column(name="Enabled")
    private boolean enabled;
    @Column(name="Email")
    private String email;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "hLoginRoles",
            joinColumns = { @JoinColumn(name = "Login_ID") },
            inverseJoinColumns = { @JoinColumn(name = "Role_ID") })
    private Set<Role> roles;

    public Login() {
    }

    public Login(String loginName, String passWord, boolean enabled, String email, Set<Role> roles) {
        this.loginName = loginName;
        this.passWord = passWord;
        this.enabled = enabled;
        this.email = email;
        this.roles = roles;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String LoginName) {
        this.loginName = LoginName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean getEnabled() {
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Login{" +
                "ID=" + ID +
                ", LoginName='" + loginName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", enabled=" + enabled +
                ", email='" + email + '\'' +
                ", role=" + roles +
                '}';
    }
}
