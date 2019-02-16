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
public class HealthResource extends Resource {

    private String medicineName;
    private String medicineType;
    private int numberOfPackets;
    private int numberOfDoctors;

    public HealthResource(String medicineName, String medicineType, int numberOfPackets, int numberOfDoctors, String name, int id) {
        super(name, id);
        this.medicineName = medicineName;
        this.medicineType = medicineType;
        this.numberOfPackets = numberOfPackets;
        this.numberOfDoctors = numberOfDoctors;
    }

    public int getNumberOfDoctors() {
        return numberOfDoctors;
    }

    public void setNumberOfDoctors(int numberOfDoctors) {
        this.numberOfDoctors = numberOfDoctors;
    }

    public HealthResource() {
        super(Resource.Type.Health.getValue());
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(String medicineType) {
        this.medicineType = medicineType;
    }

    public int getNumberOfPackets() {
        return numberOfPackets;
    }

    public void setNumberOfPackets(int numberOfPackets) {
        this.numberOfPackets = numberOfPackets;
    }

}
