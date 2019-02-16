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
public class MoneyResource extends Resource {

    private int amount;
    private String currency;

    public MoneyResource(int amount, String currency, String name, int id) {
        super(name,id);
        this.amount = amount;
        this.currency = currency;
    }

    public MoneyResource() {
        super(Resource.Type.Money.getValue());
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
