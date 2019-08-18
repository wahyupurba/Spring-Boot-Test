/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.userrequestapp.repo;

import com.userrequestapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yuu
 */
public interface RoleRepo extends JpaRepository<Role,Long>{
    
}
