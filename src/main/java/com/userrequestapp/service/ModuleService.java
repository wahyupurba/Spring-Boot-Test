/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.userrequestapp.service;

import com.userrequestapp.entity.Module;
import com.userrequestapp.entity.other.ResponsesValue;
import com.userrequestapp.repo.ModuleRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yuu
 */

@Service("moduleService")
@Transactional
public class ModuleService {
    
    @Autowired
    private ModuleRepo repo;
    
    public List<Module> dashboard(Long userId){
        return repo.dashboard(userId);
    }
    
}
