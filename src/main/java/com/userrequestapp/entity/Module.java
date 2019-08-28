/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.userrequestapp.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

/**
 *
 * @author yuu
 */
//@SqlResultSetMapping(name="moduleResultMapping",classes = {@ConstructorResult(targetClass = com.userrequestapp.entity.Module.class,columns = {@ColumnResult(name = "moduleId"),@ColumnResult(name = "moduleName")})})
@Entity
@Table(name = "tbl_module")
public class Module implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(allocationSize=1,initialValue=1,name="module_seq",sequenceName="module_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="module_seq")
    @Column(name="module_id",nullable=false)
    long moduleId;
    
    @Column(name="module_name", length = 100, nullable = false)
    private String moduleName;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "module_order_detail", 
    joinColumns = @JoinColumn(name = "module_id"), 
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roles = new HashSet<Role>();
    
    public Module() {
    }

    public Module(String moduleName,long moduleId) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
    }
    
    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
}
