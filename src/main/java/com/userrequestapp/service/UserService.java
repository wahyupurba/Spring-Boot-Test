/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.userrequestapp.service;

import com.userrequestapp.entity.Module;
import com.userrequestapp.entity.other.Responses;
import com.userrequestapp.repo.UserRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yuu
 */

@Service("userService")
@Transactional
public class UserService {
    
    @Autowired
    private UserRepo repo;
    
    public List<Object[]> dashboard(Long userId){
        System.out.println("repo userid = "+userId);
        return repo.dashboard(userId);
    }
    
}
