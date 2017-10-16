package com.tocsyk.model;

import javax.persistence.*;

@Entity
@Table(name = "hRole")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int ID;
    @Column(name="Role")
    private String role;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "ID=" + ID +
                ", role='" + role + '\'' +
                '}';
    }
}
