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
public class FoodResource extends Resource {

    private int numberOfFoodPackets;

    public FoodResource(int numberOfFoodPackets, String name, int id) {
        super(name, id);
        this.numberOfFoodPackets = numberOfFoodPackets;
    }

    public FoodResource() {
        super(Resource.Type.Food.getValue());
    }

    public int getNumberOfFoodPackets() {
        return numberOfFoodPackets;
    }

    public void setNumberOfFoodPackets(int numberOfFoodPackets) {
        this.numberOfFoodPackets = numberOfFoodPackets;
    }

}
