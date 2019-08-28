/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.userrequestapp.repo;

import com.userrequestapp.entity.Module;
import com.userrequestapp.entity.User;
import com.userrequestapp.entity.other.ResponsesValue;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author yuu
 */
public interface UserRepo extends JpaRepository<User, Long>{
    
    @Query("SELECT new com.userrequestapp.entity.other.ResponsesValue(m.moduleName,m.moduleId) FROM Module m join m.roles r join r.users u where u.userId = :userId order by r.roleId")
    public List<ResponsesValue> dashboard(@Param("userId") Long userId);
    
}
