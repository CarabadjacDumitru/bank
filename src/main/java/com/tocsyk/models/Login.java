package com.tocsyk.models;


public class Login {

    private long id;
    private String userName;
    private String passWord;
    private String email;
    private String role;

    private int enabled;

    public  Login(){
    }

    public Login(String userName, String password, String rols,int  enabled, String email) {
        this.userName = userName;
        this.passWord = password;
        this.email = email;
        this.role = role;
        this.enabled = enabled;

    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String eMail) {
        this.email = eMail;
    }


    public String getUserProfiles() {
        return role;
    }

    public void setUserProfiles(String userProfiles) {
        this.role = userProfiles;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return passWord;
    }

    public void setPassword(String password) {
        this.passWord = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Login))
            return false;
        Login other = (Login) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", eMail='" + email + '\'' +
                ", role`=" + role +
                ", enabled=" + enabled +
                '}';
    }
}
