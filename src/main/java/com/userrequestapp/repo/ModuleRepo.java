/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.userrequestapp.repo;

import com.userrequestapp.entity.Module;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author yuu
 */
public interface ModuleRepo extends JpaRepository<Module, Long>{
    
    @Query("SELECT m.moduleId, m.moduleName FROM Module m join m.roles r join r.users u where u.userId = :userId order by r.roleId ")
    public List<Module> dashboard(@Param("userId") Long userId);
    
    @Query("SELECT m FROM Module m")
    public List<Module> findAllModule();
    
}
