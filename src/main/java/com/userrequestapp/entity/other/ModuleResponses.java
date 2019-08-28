/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.userrequestapp.entity.other;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yuu
 */
public class ModuleResponses {
    List<ResponsesValue> modules = new ArrayList<ResponsesValue>();

    public List<ResponsesValue> getModules() {
        return modules;
    }

    public void setModules(List<ResponsesValue> modules) {
        this.modules = modules;
    }
    
}
