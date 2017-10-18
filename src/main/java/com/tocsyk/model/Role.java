package com.tocsyk.model;

import com.tocsyk.model.enums.enumRoleType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hRole")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @Column(name="role", length=15, unique=true, nullable=false)
    private String role = enumRoleType.ANONYMOUS.getRole();

    public Role() {
    }

    public Role(int ID,String role) {
        this.ID = ID;
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
