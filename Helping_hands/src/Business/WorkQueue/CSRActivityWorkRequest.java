/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author shukl
 */
public class CSRActivityWorkRequest extends WorkRequest {

    private int numberOfVolunteersRequired;

    private long moneyOffered;

    private String description;

    private int numberOfVolunteersAccepted;

    private String enterpriseName;

    private Date projectDate;

    private List<UserAccount> volunteersList;

    public CSRActivityWorkRequest() {
        this.volunteersList = new ArrayList<UserAccount>();
    }
    
    

    public List<UserAccount> getVolunteersList() {
        return volunteersList;
    }

    public void setVolunteersList(List<UserAccount> volunteersList) {
        this.volunteersList = volunteersList;
    }

    public Date getProjectDate() {
        return projectDate;
    }

    public void setProjectDate(Date projectDate) {
        this.projectDate = projectDate;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public int getNumberOfVolunteersAccepted() {
        return numberOfVolunteersAccepted;
    }

    public void setNumberOfVolunteersAccepted(int numberOfVolunteersAccepted) {
        this.numberOfVolunteersAccepted = numberOfVolunteersAccepted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfVolunteersRequired() {
        return numberOfVolunteersRequired;
    }

    public void setNumberOfVolunteersRequired(int numberOfVolunteersRequired) {
        this.numberOfVolunteersRequired = numberOfVolunteersRequired;
    }

    public long getMoneyOffered() {
        return moneyOffered;
    }

    public void setMoneyOffered(long moneyOffered) {
        this.moneyOffered = moneyOffered;
    }

}
