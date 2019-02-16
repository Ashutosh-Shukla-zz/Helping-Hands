/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Resources;

import java.util.Date;

/**
 *
 * @author shukl
 */
public abstract class Resource {

    private int resourceId;

    private String name;

    private Date createdDate;

    private Date expiryDate;

    private Boolean isResourceAvailable = Boolean.TRUE;

    public Boolean getIsResourceAvailable() {
        return isResourceAvailable;
    }

    public void setIsResourceAvailable(Boolean isResourceAvailable) {
        this.isResourceAvailable = isResourceAvailable;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public Resource(String name) {
        this.name = name;
    }

    public Resource(String name, int resourceId) {
        this.resourceId = resourceId;
        this.name = name;
    }

    public enum Type {

        Food("Food Resource"), Health("Health Resource"), Education("Education Resource"), Money("Monitary Resource");
        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
