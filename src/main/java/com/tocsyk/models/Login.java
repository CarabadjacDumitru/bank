package com.tocsyk.models;


public class Login {

    private long id;
    private String userName;
    private String passWord;
    private String eMail;
    private String rOle;
    private int eNabled;

    public  Login(){
    }

    public Login(String userName, String password, String role, int  enabled, String email) {
        this.userName = userName;
        this.passWord = password;
        this.eMail = email;
        this.rOle = role;
        this.eNabled = enabled;

    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }


    public String getUserProfiles() {
        return rOle;
    }

    public void setUserProfiles(String userProfiles) {
        this.rOle = userProfiles;
    }

    public int getEnabled() {
        return eNabled;
    }

    public void setEnabled(int enabled) {
        this.eNabled = enabled;
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
        return rOle;
    }

    public void setRole(String role) {
        this.rOle = role;
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
                ", eMail='" + eMail + '\'' +
                ", role`=" + rOle +
                ", enabled=" + eNabled +
                '}';
    }
}
