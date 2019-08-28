/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.userrequestapp.controller;

import com.userrequestapp.entity.Module;
import com.userrequestapp.entity.User;
import com.userrequestapp.entity.other.ModuleResponses;
import com.userrequestapp.entity.other.Responses;
import com.userrequestapp.entity.other.ResponsesValue;
import com.userrequestapp.service.ModuleService;
import com.userrequestapp.service.RoleService;
import com.userrequestapp.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yuu
 */

@RestController
@RequestMapping("/api/dashboard")
public class HomeController {
    
    @Autowired
    private UserService userService;
    @RequestMapping(method = RequestMethod.GET,value="/{userId}")
    public ResponseEntity<Responses> home(@PathVariable(value= "userId") Long userId){
//        User user = userService.
        List<ResponsesValue> responsesValues = userService.dashboard(userId);
        
        String order = "1|5|3|2|4";
        String orderArray[] = order.split("|");
        
        ModuleResponses moduleResponses = new ModuleResponses();
        moduleResponses.setModules(responsesValues);
        Responses response = new Responses();
        response.setUserId(userId);
        response.setResponses(moduleResponses);
        return ResponseEntity.ok().body(response);
    }
    
}
