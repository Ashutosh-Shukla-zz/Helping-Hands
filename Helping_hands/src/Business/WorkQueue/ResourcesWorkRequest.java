/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Resources.Resource;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author shukl
 */
public class ResourcesWorkRequest extends WorkRequest {

    private List<Resource> resourceRequested;

    private String requestDescription;

    private List<Resource> resourcesUtillized;

    //private List<Resource> resourcesPending;
    private Map<String, Integer> resourcesPendingMap;

    private UserAccount raisedByAccount;

    private String network;

    public Map<String, Integer> getResourcesPendingMap() {
        return resourcesPendingMap;
    }

    public void setResourcesPendingMap(Map<String, Integer> resourcesPendingMap) {
        this.resourcesPendingMap = resourcesPendingMap;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public UserAccount getRaisedByAccount() {
        return raisedByAccount;
    }

    public void setRaisedByAccount(UserAccount raisedByAccount) {
        this.raisedByAccount = raisedByAccount;
    }

    public ResourcesWorkRequest() {
        this.resourceRequested = new ArrayList<Resource>();
        this.resourcesUtillized = new ArrayList<Resource>();
        this.resourcesPendingMap = new HashMap<String, Integer>();
        resourcesPendingMap.put("Food", 0);
        resourcesPendingMap.put("Education", 0);
        resourcesPendingMap.put("Health", 0);
        resourcesPendingMap.put("Money", 0);
    }

    public List<Resource> getResourceRequested() {
        return resourceRequested;
    }

    public void setResourceRequested(List<Resource> resourceRequested) {
        this.resourceRequested = resourceRequested;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public void setRequestDescription(String requestDescription) {
        this.requestDescription = requestDescription;
    }

    public List<Resource> getResourcesUtillized() {
        return resourcesUtillized;
    }

    public void setResourcesUtillized(List<Resource> resourcesUtillized) {
        this.resourcesUtillized = resourcesUtillized;
    }

}
