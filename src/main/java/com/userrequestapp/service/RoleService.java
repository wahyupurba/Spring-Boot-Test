/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.userrequestapp.service;

import com.userrequestapp.repo.RoleRepo;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yuu
 */

@Service("roleService")
@Transactional
public class RoleService {
    
    @Autowired
    private RoleRepo repo;
    
}
