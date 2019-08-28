/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.userrequestapp.entity.other;


/**
 *
 * @author yuu
 */
public class ResponsesValue {
    
    private String moduleName;
    long moduleOrder;
    
//    List<Module> module = new ArrayList<Module>();

    public ResponsesValue(String moduleName, long moduleOrder) {
        this.moduleName = moduleName;
        this.moduleOrder = moduleOrder;
    }
    

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public long getModuleOrder() {
        return moduleOrder;
    }

    public void setModuleOrder(long moduleOrder) {
        this.moduleOrder = moduleOrder;
    }
    
}
