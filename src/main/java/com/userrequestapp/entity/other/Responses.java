/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.userrequestapp.entity.other;

import com.userrequestapp.entity.Module;

/**
 *
 * @author yuu
 */
public class Responses {
    
    private long userId;
    private ModuleResponses responses;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
    public ModuleResponses getResponses() {
        return responses;
    }

    public void setResponses(ModuleResponses responses) {
        this.responses = responses;
    }
}
