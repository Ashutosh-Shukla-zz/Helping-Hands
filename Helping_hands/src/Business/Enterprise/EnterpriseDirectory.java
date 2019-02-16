/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author MyPC1
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;
   

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public EnterpriseDirectory(){
        enterpriseList=new ArrayList<Enterprise>();
    }
    
    //Create enterprise
    public Enterprise createAndAddEnterprise(String name,Enterprise.EnterpriseType type,  Map<String, Boolean> resourceTypes){
        Enterprise enterprise=null;
        if(type==Enterprise.EnterpriseType.Corporates){
            enterprise=new CorporateEnterprise(name, resourceTypes);
            enterpriseList.add(enterprise);
        }
        else if(type==Enterprise.EnterpriseType.NGO){
            enterprise=new NGOEnterprise(name, resourceTypes);
            enterpriseList.add(enterprise);
        }
       
        return enterprise;
    }
}
