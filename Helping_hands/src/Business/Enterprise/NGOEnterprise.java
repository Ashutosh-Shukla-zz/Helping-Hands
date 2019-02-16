/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author MyPC1
 */
public class NGOEnterprise extends Enterprise {
    
    public NGOEnterprise(String name, Map<String, Boolean> resourceTypes){
        super(name,EnterpriseType.NGO, resourceTypes);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
