/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Resources;

/**
 *
 * @author shukl
 */
public class EducationResource extends Resource {

    private int numberOfSupplyMaterial;

    private int numberOfTeachers;

    public EducationResource(int numberOfSupplyMaterial, int numberOfTeachers, String name,int id) {
        super(name,id);
        this.numberOfSupplyMaterial = numberOfSupplyMaterial;
        this.numberOfTeachers = numberOfTeachers;
    }

    public EducationResource() {
        super(Resource.Type.Money.getValue());

    }

    public int getNumberOfSupplyMaterial() {
        return numberOfSupplyMaterial;
    }

    public void setNumberOfSupplyMaterial(int numberOfSupplyMaterial) {
        this.numberOfSupplyMaterial = numberOfSupplyMaterial;
    }

    public int getNumberOfTeachers() {
        return numberOfTeachers;
    }

    public void setNumberOfTeachers(int numberOfTeachers) {
        this.numberOfTeachers = numberOfTeachers;
    }

}
