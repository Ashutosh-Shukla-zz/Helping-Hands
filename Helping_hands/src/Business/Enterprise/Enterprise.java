 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Resources.EducationResource;
import Business.Resources.FoodResource;
import Business.Resources.HealthResource;
import Business.Resources.MoneyResource;
import Business.Resources.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MyPC1
 */
public abstract class Enterprise extends Organization {

    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
    private Map<String, List<Resource>> resourcesOffered;

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public enum EnterpriseType {

        Corporates("Corporates"), NGO("NGO");

        private String value;

        private EnterpriseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public Enterprise(String name, EnterpriseType type, Map<String, Boolean> resourceTypes) {
        super(name);
        this.enterpriseType = type;
        this.resourcesOffered = new HashMap<String, List<Resource>>();
        for (Map.Entry<String, Boolean> map : resourceTypes.entrySet()) {
            if (map.getValue()) {
                if (map.getKey().equalsIgnoreCase("Food")) {
                    //Resource resource = new FoodResource();
                    ArrayList<Resource> listOfResource = new ArrayList<Resource>();
                    //listOfResource.add(resource);
                    this.resourcesOffered.put(map.getKey(), listOfResource);
                }
                if (map.getKey().equalsIgnoreCase("Education")) {
                    //Resource resource = new EducationResource();
                    ArrayList<Resource> listOfResource = new ArrayList<Resource>();
                    //listOfResource.add(resource);
                    this.resourcesOffered.put(map.getKey(), listOfResource);
                }
                if (map.getKey().equalsIgnoreCase("Health")) {
                    //Resource resource = new HealthResource();
                    ArrayList<Resource> listOfResource = new ArrayList<Resource>();
                    //listOfResource.add(resource);
                    this.resourcesOffered.put(map.getKey(), listOfResource);
                }
                if (map.getKey().equalsIgnoreCase("Money")) {
                    //Resource resource = new MoneyResource();
                    ArrayList<Resource> listOfResource = new ArrayList<Resource>();
                    //listOfResource.add(resource);
                    this.resourcesOffered.put(map.getKey(), listOfResource);
                }
            }
        }
        organizationDirectory = new OrganizationDirectory();
    }

    public Map<String, List<Resource>> getResourcesOffered() {
        return resourcesOffered;
    }

    public void setResourcesOffered(Map<String, List<Resource>> resourcesOffered) {
        this.resourcesOffered = resourcesOffered;
    }

}
