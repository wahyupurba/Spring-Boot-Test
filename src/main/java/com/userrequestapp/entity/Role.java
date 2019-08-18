/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.userrequestapp.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author yuu
 */

@Entity
@Table(name = "tbl_role")
public class Role implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "role_seq", sequenceName = "role_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    @Column(name = "role_id", nullable = false)
    long roleId;

    @Column(length = 128, nullable = false, name = "role_name")
    String roleName;
    
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "roles")
    private Set<User> users = new HashSet<User>();
    
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
