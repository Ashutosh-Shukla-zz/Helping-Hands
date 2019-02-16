/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;
import Business.UserAccount.*;
import java.util.Date;

/**
 *
 * @author raunak
 */
public class WorkQueue {

    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }

    public WorkRequest createWorkRequest(UserAccount user, Date date) {
        RegistrationWorkRequest regWorkRequest = new RegistrationWorkRequest();
        regWorkRequest.setUser(user);
        regWorkRequest.setStatus(user.getStatus());
        regWorkRequest.setMessage(user.getName());
        regWorkRequest.setRequestDate(date);
        regWorkRequest.setResolveDate(date);
        workRequestList.add(regWorkRequest);
        return regWorkRequest;
    }
}
